CREATE TABLE `tb_username` (
  `username` varchar(40) NOT NULL,
  `userEmail` varchar(40) DEFAULT NULL,
  `endEmail` varchar(40) DEFAULT NULL,
  `ordered` varchar(120) DEFAULT NULL,
  `ordering` varchar(40) DEFAULT NULL,
  `orderedDate` date DEFAULT NULL,
  `orderingDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 PACK_KEYS=0;

