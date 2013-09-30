package fr.paris.lutece.plugins.subscribe.service;

import fr.paris.lutece.portal.service.cache.AbstractCacheableService;


/**
 * Cache for subscription service
 */
public final class SubscriptionCacheService extends AbstractCacheableService
{
    private static final String CACHE_SERVICE_NAME = "SubscriptionCacheService";

    private static volatile SubscriptionCacheService _instance = new SubscriptionCacheService( );

    /**
     * Private constructor
     */
    private SubscriptionCacheService( )
    {
        this.initCache( );
    }

    /**
     * Get the instance of the cache service
     * @return The instance of the cache service
     */
    public static SubscriptionCacheService getInstance( )
    {
        return _instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName( )
    {
        return CACHE_SERVICE_NAME;
    }

}
