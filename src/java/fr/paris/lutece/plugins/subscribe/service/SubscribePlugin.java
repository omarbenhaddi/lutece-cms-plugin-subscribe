package fr.paris.lutece.plugins.subscribe.service;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginDefaultImplementation;
import fr.paris.lutece.portal.service.plugin.PluginService;


/**
 * Plugin subscribe implementation
 */
public class SubscribePlugin extends PluginDefaultImplementation
{
    private static final String PLUGIN_NAME = "subscribe";

    private static volatile Plugin _plugin;

    /**
     * Get the subscribe plugin
     * @return The subscribe plugin
     */
    public static Plugin getPlugin( )
    {
        if ( _plugin == null )
        {
            synchronized ( SubscribePlugin.class )
            {
                _plugin = PluginService.getPlugin( PLUGIN_NAME );
            }
        }
        return _plugin;
    }
}
