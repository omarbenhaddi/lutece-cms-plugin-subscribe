package fr.paris.lutece.plugins.subscribe.service;

import fr.paris.lutece.plugins.subscribe.business.Subscription;
import fr.paris.lutece.portal.service.security.LuteceUser;


/**
 * Interface of services that provide subscriptions to resources
 */
public interface ISubscriptionProviderService
{
    /**
     * Get the name of the subscription provider.
     * @return The name of the subscription provider
     */
    String getProviderName( );

    /**
     * Get the description of a subscription by its action key and the resource
     * id associated with it
     * @param user The user
     * @param strSubscriptionKey The key of the subscription
     * @param strIdSubscribedResource The id of the subscribed resource
     * @return An HTML string that describes the subscription
     */
    String getSubscriptionHtmlDescription( LuteceUser user, String strSubscriptionKey, String strIdSubscribedResource );

    /**
     * Check if a subscription can be automatically removed. If the subscription
     * is removed, the method {@link #notifySubscriptionRemoval(Subscription)}
     * of the provider of the subscription will be called
     * @param user The user
     * @param strSubscriptionKey The subscription key
     * @param strIdSubscribedResource The id of the subscribed resource
     * @return True if the subscription can be removed, false otherwise
     */
    boolean isSubscriptionRemovable( LuteceUser user, String strSubscriptionKey, String strIdSubscribedResource );

    /**
     * Get the URL to modify the subscription
     * @param user The user
     * @param strSubscriptionKey The key of the subscription
     * @param strIdSubscribedResource The id of the subscribed resource
     * @return The URL to modify the subscription, or null if the subscription
     *         can not be modified
     */
    String getUrlModifySubscription( LuteceUser user, String strSubscriptionKey, String strIdSubscribedResource );

    /**
     * Notify the provider that a subscription associated with it has been
     * removed
     * @param subscription The removed subscription
     */
    void notifySubscriptionRemoval( Subscription subscription );
}
