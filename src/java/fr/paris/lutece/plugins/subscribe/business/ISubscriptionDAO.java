/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.subscribe.business;

import fr.paris.lutece.portal.service.plugin.Plugin;

import java.util.Collection;
import java.util.List;

/**
 * Interface for subscriber DAO
 */

public interface ISubscriptionDAO
{
    /**
     * Insert a new record in the table.
     * 
     * @param subscription
     *            instance of the Subscription object to insert
     * @param plugin
     *            the Plugin
     */
    void insert( Subscription subscription, Plugin plugin );

    /**
     * Update the record in the table
     * 
     * @param subscription
     *            the reference of the Subscription
     * @param plugin
     *            the Plugin
     */
    void store( Subscription subscription, Plugin plugin );

    /**
     * Delete a record from the table
     * 
     * @param nIdSubscription
     *            int identifier of the Subscription to delete
     * @param plugin
     *            the Plugin
     */
    void delete( int nIdSubscription, Plugin plugin );

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the data from the table
     * 
     * @param nKey
     *            The identifier of the subscription
     * @param plugin
     *            the plugin
     * @return The instance of the subscription
     */
    Subscription load( int nKey, Plugin plugin );

    /**
     * Load the data of all the subscription objects and returns them as a collection
     * 
     * @param plugin
     *            the plugin
     * @return The collection which contains the data of all the subscription objects
     */
    Collection<Subscription> selectSubscriptionsList( Plugin plugin );

    /**
     * Find a list of subscriptions from a filter
     * 
     * @param filter
     *            The filter
     * @return The list of subscriptions that matches the given filter
     */
    List<Subscription> findByFilter( SubscriptionFilter filter );

}
