CREATE TABLE `administrator` (
  `username` varchar(40) NOT NULL,
  `password` varchar(240) NOT NULL,
  `workcode` int(120) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginDate` date NOT NULL,
  `workAddress` varchar(120) NOT NULL,
  `position` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 PACK_KEYS=0;

