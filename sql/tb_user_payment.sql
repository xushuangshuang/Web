CREATE TABLE `tb_user_payment` (
  `username` varchar(20) DEFAULT NULL,
  `VIP` char(20) DEFAULT NULL,
  `accounted` varchar(20) DEFAULT NULL,
  `payment` varchar(20) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

