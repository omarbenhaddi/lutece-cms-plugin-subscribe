
--
-- Structure for table subscribe_subscription
--

DROP TABLE IF EXISTS subscribe_subscription;
CREATE TABLE subscribe_subscription (		
	id_subscription int default '0' NOT NULL,
	id_user varchar(255) default '0' NOT NULL,
	subscription_provider varchar(255) NULL ,
	subscription_key varchar(255) default '' NOT NULL,
	id_subscribed_resource varchar(255) default '' NOT NULL,
	PRIMARY KEY (id_subscription)
);
