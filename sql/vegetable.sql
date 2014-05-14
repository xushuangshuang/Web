CREATE TABLE `vegetable` (
  `vegetable_name` varchar(120) NOT NULL,
  `value` int(40) NOT NULL,
  `describe` text,
  `picture` varchar(240) NOT NULL,
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `evalute` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 PACK_KEYS=0;

