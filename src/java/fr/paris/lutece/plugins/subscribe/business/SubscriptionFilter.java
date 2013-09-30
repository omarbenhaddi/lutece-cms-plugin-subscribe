/*
 * Copyright (c) 2002-2013, Mairie de Paris
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

/**
 * This is the filter class for Subscription
 */
public class SubscriptionFilter
{
    private int _nIdSubscriber;
    private String _strSubscriptionProvider;
    private String _strActionKey;
    private String _strIdSubscribedResource;

    /**
     * Get the id of the subscriber
     * @return The id of the subscriber
     */
    public int getIdSubscriber( )
    {
        return _nIdSubscriber;
    }

    /**
     * Get the id of the subscriber
     * @param strIdSubscriber The id of the subscriber
     */
    public void setIdSubscriber( int strIdSubscriber )
    {
        this._nIdSubscriber = strIdSubscriber;
    }

    /**
     * Returns the provider of the subscription
     * @return The provider of the subscription
     */
    public String getSubscriptionProvider( )
    {
        return _strSubscriptionProvider;
    }

    /**
     * Sets the SubscriptionProvider
     * @param strSubscriptionProvider The SubscriptionProvider
     */
    public void setSubscriptionProvider( String strSubscriptionProvider )
    {
        _strSubscriptionProvider = strSubscriptionProvider;
    }

    /**
     * Returns the ActionKey
     * @return The ActionKey
     */
    public String getSubscriptionKey( )
    {
        return _strActionKey;
    }

    /**
     * Sets the ActionKey
     * @param strActionKey The ActionKey
     */
    public void setSubscriptionKey( String strActionKey )
    {
        _strActionKey = strActionKey;
    }

    /**
     * Returns the IdSubscribedResource
     * @return The IdSubscribedResource
     */
    public String getIdSubscribedResource( )
    {
        return _strIdSubscribedResource;
    }

    /**
     * Sets the IdSubscribedResource
     * @param strIdSubscribedResource The IdSubscribedResource
     */
    public void setIdSubscribedResource( String strIdSubscribedResource )
    {
        _strIdSubscribedResource = strIdSubscribedResource;
    }
}