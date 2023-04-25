
--
-- Update table subscribe_subscription
--

ALTER TABLE subscribe_subscription
ADD COLUMN subscription_order int default '1' NOT NULL;