package fr.paris.lutece.plugins.subscribe.service;

import fr.paris.lutece.plugins.subscribe.business.ISubscriptionDAO;
import fr.paris.lutece.plugins.subscribe.business.Subscription;
import fr.paris.lutece.plugins.subscribe.business.SubscriptionFilter;
import fr.paris.lutece.portal.service.security.LuteceUser;
import fr.paris.lutece.portal.service.security.LuteceUserService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


/**
 * Service to manage subscriptions
 */
public final class SubscriptionService
{
    private static SubscriptionService _instance = new SubscriptionService( );
    private ISubscriptionDAO _dao = SpringContextService.getBean( "subscribe.subscriptionDAO" );

    /**
     * Private constructor
     */
    private SubscriptionService( )
    {
        // Do nothing
    }

    /**
     * Get the instance of the subscription service
     * @return The instance of the subscription service
     */
    public static SubscriptionService getInstance( )
    {
        return _instance;
    }

    /**
     * Create a new subscription for the given user
     * @param subscription The subscription to create
     * @param user The user to associate the subscription to
     */
    public void createSubscription( Subscription subscription, LuteceUser user )
    {
        subscription.setUserId( user.getName( ) );
        createSubscription( subscription );
    }

    /**
     * Create a new subscription. The subscriber id of the subscription must
     * have been filled
     * @param subscription The subscription to create
     */
    public void createSubscription( Subscription subscription )
    {
        _dao.insert( subscription, SubscribePlugin.getPlugin( ) );
    }

    /**
     * Get a subscription from its id
     * @param nIdSubscription The id of the subscription
     * @return The subscription, or null if no subscription has the given id
     */
    public Subscription findBySubscriptionId( int nIdSubscription )
    {
        return _dao.load( nIdSubscription, SubscribePlugin.getPlugin( ) );
    }

    /**
     * Find subscriptions that match a given filter
     * @param filter The filter
     * @return The list of subscriptions that match the given filter
     */
    public List<Subscription> findByFilter( SubscriptionFilter filter )
    {
        return _dao.findByFilter( filter );
    }

    /**
     * Remove a subscription from its id
     * @param nIdSubscription The id of the subscription to remove
     * @param bNotifySubscriptionProvider True to notify the provider of the
     *            subscription that it has been removed, false otherwise
     */
    public void removeSubscription( int nIdSubscription, boolean bNotifySubscriptionProvider )
    {
        if ( bNotifySubscriptionProvider )
        {
            removeSubscription( findBySubscriptionId( nIdSubscription ), bNotifySubscriptionProvider );
        }
        else
        {
            _dao.delete( nIdSubscription, SubscribePlugin.getPlugin( ) );
        }
    }

    /**
     * Remove a subscription
     * @param subscription The subscription to remove
     * @param bNotifySubscriptionProvider True to notify the provider of the
     *            subscription that it has been removed, false otherwise
     */
    public void removeSubscription( Subscription subscription, boolean bNotifySubscriptionProvider )
    {
        if ( bNotifySubscriptionProvider )
        {
            List<ISubscriptionProviderService> listProviders = SpringContextService
                    .getBeansOfType( ISubscriptionProviderService.class );
            for ( ISubscriptionProviderService provider : listProviders )
            {
                if ( StringUtils.equals( subscription.getSubscriptionProvider( ), provider.getProviderName( ) ) )
                {
                    provider.notifySubscriptionRemoval( subscription );
                }
            }
        }
        _dao.delete( subscription.getIdSubscription( ), SubscribePlugin.getPlugin( ) );
    }

    /**
     * Get a lutece user associated to a subscription
     * @param subscription The subscription
     * @return The lutece user, or null if no lutece user was found
     */
    public LuteceUser getLuteceUserFromSubscription( Subscription subscription )
    {
        return LuteceUserService.getLuteceUserFromName( subscription.getUserId( ) );
    }

    /**
     * Get the collection of users that subscribed to a given resource with the
     * given key
     * @param strSubscriptionProvider The subscription provider of subscribers
     *            to get
     * @param strSubscriptionKey The subscription key of subscribers to get
     * @param strIdSubscribedResource The id of the subscribed resource
     * @return The collection of users that subscribed to the given resource
     *         with the given key. Returns an empty collection if no users was
     *         found
     */
    public Collection<LuteceUser> getSubscriberList( String strSubscriptionProvider, String strSubscriptionKey,
            String strIdSubscribedResource )
    {
        SubscriptionFilter filter = new SubscriptionFilter( );
        filter.setSubscriptionProvider( strSubscriptionProvider );
        filter.setSubscriptionKey( strSubscriptionKey );
        filter.setIdSubscribedResource( strIdSubscribedResource );
        List<Subscription> listSubscription = findByFilter( filter );
        Set<LuteceUser> usersFound = new HashSet<LuteceUser>( );
        for ( Subscription subscription : listSubscription )
        {
            LuteceUser user = LuteceUserService.getLuteceUserFromName( subscription.getUserId( ) );
            if ( user != null )
            {
                usersFound.add( user );
            }
        }
        return usersFound;
    }

    /**
     * Get a provider service from its name
     * @param strProvider The name of the provider service to get
     * @return The provider service, or null if no provider service has the
     *         given name
     */
    public ISubscriptionProviderService getProviderService( String strProvider )
    {
        List<ISubscriptionProviderService> listProviderServices = SpringContextService
                .getBeansOfType( ISubscriptionProviderService.class );
        for ( ISubscriptionProviderService provider : listProviderServices )
        {
            if ( StringUtils.equals( strProvider, provider.getProviderName( ) ) )
            {
                return provider;
            }
        }
        return null;
    }
}
