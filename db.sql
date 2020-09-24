/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.0.27-community-nt-log : Database - db_faktur
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_faktur` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_faktur`;

/*Table structure for table `notelp` */

DROP TABLE IF EXISTS `notelp`;

CREATE TABLE `notelp` (
  `notelp` varchar(16) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `notelp` */

insert  into `notelp`(`notelp`) values ('123');

/*Table structure for table `tbl_detilmasuk` */

DROP TABLE IF EXISTS `tbl_detilmasuk`;

CREATE TABLE `tbl_detilmasuk` (
  `KodeTransaksi` char(15) default NULL,
  `KodeBarang` char(15) default NULL,
  `Qty` int(14) default NULL,
  `harga` int(14) default NULL,
  `sub` int(14) default NULL,
  KEY `FK_tbl_detilmasuk2` (`KodeBarang`),
  KEY `FK_tbl_detilmasuk` (`KodeTransaksi`),
  CONSTRAINT `FK_tbl_detilmasuk` FOREIGN KEY (`KodeTransaksi`) REFERENCES `tbl_masuk` (`KodeTransaksi`) ON DELETE CASCADE,
  CONSTRAINT `FK_tbl_detilmasuk2` FOREIGN KEY (`KodeBarang`) REFERENCES `tblbarang` (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_detilmasuk` */

/*Table structure for table `tbl_detilpenjualan` */

DROP TABLE IF EXISTS `tbl_detilpenjualan`;

CREATE TABLE `tbl_detilpenjualan` (
  `Nofaktur` char(15) default NULL,
  `KodeBarang` char(15) default NULL,
  `qty` int(14) default NULL,
  `harga` int(14) default NULL,
  `subtotal` int(14) default NULL,
  `Diskon` int(14) default NULL,
  `Bonus` varchar(14) default NULL,
  KEY `FK_tbl_detilpenjualan2` (`KodeBarang`),
  KEY `FK_tbl_detilpenjualan` (`Nofaktur`),
  CONSTRAINT `FK_tbl_detilpenjualan` FOREIGN KEY (`Nofaktur`) REFERENCES `tbl_penjualan` (`NoFaktur`) ON DELETE CASCADE,
  CONSTRAINT `FK_tbl_detilpenjualan2` FOREIGN KEY (`KodeBarang`) REFERENCES `tblbarang` (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_detilpenjualan` */

insert  into `tbl_detilpenjualan`(`Nofaktur`,`KodeBarang`,`qty`,`harga`,`subtotal`,`Diskon`,`Bonus`) values ('0001/11/18','BR-0001',1,11500,11500,0,'');

/*Table structure for table `tbl_masuk` */

DROP TABLE IF EXISTS `tbl_masuk`;

CREATE TABLE `tbl_masuk` (
  `KodeTransaksi` char(15) NOT NULL,
  `Tanggal` date default NULL,
  `total` int(14) default NULL,
  PRIMARY KEY  (`KodeTransaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_masuk` */

/*Table structure for table `tbl_otlet` */

DROP TABLE IF EXISTS `tbl_otlet`;

CREATE TABLE `tbl_otlet` (
  `Kode` char(15) NOT NULL,
  `Nama` varchar(50) default NULL,
  `Alamat` varchar(300) default NULL,
  `No_Telp` char(16) default NULL,
  `Email` varchar(30) default NULL,
  PRIMARY KEY  (`Kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_otlet` */

insert  into `tbl_otlet`(`Kode`,`Nama`,`Alamat`,`No_Telp`,`Email`) values ('OT-0001','APT Surya Kencana','Jl. Sultan Si ago ago No 7 Kedaton Bandar Lampung','085211161919','-'),('OT-0002','ABC','FGJHBKJN','-','-');

/*Table structure for table `tbl_penjualan` */

DROP TABLE IF EXISTS `tbl_penjualan`;

CREATE TABLE `tbl_penjualan` (
  `NoFaktur` char(15) NOT NULL,
  `Tanggal` date default NULL,
  `Tempo` date default NULL,
  `KodeOtlet` char(15) default NULL,
  `Total` int(15) default NULL,
  PRIMARY KEY  (`NoFaktur`),
  KEY `FK_tbl_penjualan` (`KodeOtlet`),
  CONSTRAINT `FK_tbl_penjualan` FOREIGN KEY (`KodeOtlet`) REFERENCES `tbl_otlet` (`Kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_penjualan` */

insert  into `tbl_penjualan`(`NoFaktur`,`Tanggal`,`Tempo`,`KodeOtlet`,`Total`) values ('0001/11/18','2018-11-15','2018-11-22','OT-0001',11500);

/*Table structure for table `tblbarang` */

DROP TABLE IF EXISTS `tblbarang`;

CREATE TABLE `tblbarang` (
  `kode` char(15) NOT NULL,
  `Nama` varchar(50) default NULL,
  `satuan` varchar(30) default NULL,
  `HargaModal` int(10) default NULL,
  `HargaJual` int(10) default NULL,
  `qty` int(10) default NULL,
  `status` varchar(30) default NULL,
  PRIMARY KEY  (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tblbarang` */

insert  into `tblbarang`(`kode`,`Nama`,`satuan`,`HargaModal`,`HargaJual`,`qty`,`status`) values ('BR-0001','MINYAK TELON','box',10000,11500,216,'normal'),('BR-0002','Minyak Kayu Putih ','btl',7000,7900,213,'normal'),('BR-0003','minyak vco','btl',7000,7500,144,'normal'),('BR-0004','indomilk','box',5000,6000,24,'normal'),('BR-0005','baby Jonson','btl',9000,9500,25,'normal'),('BR-0006','aqua','btl',1500,2000,24,'normal'),('BR-0007','grand','btl',1400,2000,9,'normal'),('BR-0008','Ultra Flu','pcs',5000,5500,1,'normal'),('BR-0009','Komik','pcs',20000,22000,27,'normal'),('BR-0010','antangin','box',6500,7000,27,'normal'),('BR-0011','tolak angin','box',7000,8000,173,'normal'),('BR-0012','Bodrek','box',5000,5500,176,'normal'),('BR-0013','paramex','pcs',3000,3500,181,'normal'),('BR-0014','konidin','box',4000,4500,1,'normal'),('BR-0015','biskuit regal','pcs',5000,6500,1,'normal'),('BR-0016','sampurna','slop',18000,20000,1,'normal'),('BR-0017','BUKU','PACK',12000,12500,50,'normal'),('MKP-01','KAYU PUTIH 15','PCS',5000,5500,29,'normal'),('MKP-02','DAS','ASDA',1111,1111,10,'normal');

/*Table structure for table `tema` */

DROP TABLE IF EXISTS `tema`;

CREATE TABLE `tema` (
  `tema` varchar(50) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `tema` */

insert  into `tema`(`tema`) values ('com.jtattoo.plaf.aero.AeroLookAndFeel');

/*Table structure for table `ubahharga` */

DROP TABLE IF EXISTS `ubahharga`;

CREATE TABLE `ubahharga` (
  `kode` char(15) default NULL,
  `harga` int(14) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `ubahharga` */

/* Trigger structure for table `tbl_detilmasuk` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `BarangMasuk` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `BarangMasuk` AFTER INSERT ON `tbl_detilmasuk` FOR EACH ROW BEGIN
update db_faktur.tblbarang 
	set
	
	qty = qty+new.Qty
	
	where
	kode = new.KodeBarang ;
    END */$$


DELIMITER ;

/* Trigger structure for table `tbl_detilpenjualan` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `penjualan` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `penjualan` AFTER INSERT ON `tbl_detilpenjualan` FOR EACH ROW BEGIN
update db_faktur.tblbarang 
	set
	
	qty = qty-new.qty
	
	where
	kode = new.KodeBarang ;
    END */$$


DELIMITER ;

/* Trigger structure for table `ubahharga` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `status` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `status` AFTER INSERT ON `ubahharga` FOR EACH ROW BEGIN
update db_faktur.tblbarang 
	set
	
	status='berubah'
	
	where
	kode = new.kode ;
    END */$$


DELIMITER ;

/* Trigger structure for table `ubahharga` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `statusnormal` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `statusnormal` AFTER DELETE ON `ubahharga` FOR EACH ROW BEGIN
update db_faktur.tblbarang 
	set
	
	status='normal'
	
	where
	kode = old.kode ;
    END */$$


DELIMITER ;

/*Table structure for table `vbeli` */

DROP TABLE IF EXISTS `vbeli`;

/*!50001 DROP VIEW IF EXISTS `vbeli` */;
/*!50001 DROP TABLE IF EXISTS `vbeli` */;

/*!50001 CREATE TABLE `vbeli` (
  `KodeTransaksi` char(15) NOT NULL,
  `Tanggal` date default NULL,
  `KodeBarang` char(15) default NULL,
  `Nama` varchar(50) default NULL,
  `satuan` varchar(30) default NULL,
  `Qty` int(14) default NULL,
  `harga` int(14) default NULL,
  `sub` int(14) default NULL,
  `status` varchar(30) default NULL,
  `total` int(14) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 */;

/*Table structure for table `vcetak` */

DROP TABLE IF EXISTS `vcetak`;

/*!50001 DROP VIEW IF EXISTS `vcetak` */;
/*!50001 DROP TABLE IF EXISTS `vcetak` */;

/*!50001 CREATE TABLE `vcetak` (
  `Nofaktur` char(15) default NULL,
  `Tanggal` date default NULL,
  `Tempo` date default NULL,
  `KodeOtlet` char(15) default NULL,
  `namaOtlet` varchar(50) default NULL,
  `Alamat` varchar(300) default NULL,
  `No_Telp` char(16) default NULL,
  `Email` varchar(30) default NULL,
  `KodeBarang` char(15) default NULL,
  `NamaBarang` varchar(50) default NULL,
  `satuan` varchar(30) default NULL,
  `qty` int(14) default NULL,
  `harga` int(14) default NULL,
  `subtotal` int(14) default NULL,
  `Diskon` int(14) default NULL,
  `Bonus` varchar(14) default NULL,
  `Total` int(15) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 */;

/*Table structure for table `vpenjualan` */

DROP TABLE IF EXISTS `vpenjualan`;

/*!50001 DROP VIEW IF EXISTS `vpenjualan` */;
/*!50001 DROP TABLE IF EXISTS `vpenjualan` */;

/*!50001 CREATE TABLE `vpenjualan` (
  `NoFaktur` char(15) NOT NULL,
  `Tanggal` date default NULL,
  `Tempo` date default NULL,
  `KodeOtlet` char(15) default NULL,
  `namaOtlet` varchar(50) default NULL,
  `KodeBarang` char(15) default NULL,
  `NamaBarang` varchar(50) default NULL,
  `qty` int(14) default NULL,
  `harga` int(14) default NULL,
  `subtotal` int(14) default NULL,
  `Diskon` int(14) default NULL,
  `Bonus` varchar(14) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 */;

/*View structure for view vbeli */

/*!50001 DROP TABLE IF EXISTS `vbeli` */;
/*!50001 DROP VIEW IF EXISTS `vbeli` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vbeli` AS (select `tbl_masuk`.`KodeTransaksi` AS `KodeTransaksi`,`tbl_masuk`.`Tanggal` AS `Tanggal`,`tbl_detilmasuk`.`KodeBarang` AS `KodeBarang`,`tblbarang`.`Nama` AS `Nama`,`tblbarang`.`satuan` AS `satuan`,`tbl_detilmasuk`.`Qty` AS `Qty`,`tbl_detilmasuk`.`harga` AS `harga`,`tbl_detilmasuk`.`sub` AS `sub`,`tblbarang`.`status` AS `status`,`tbl_masuk`.`total` AS `total` from ((`tbl_detilmasuk` join `tblbarang` on((`tbl_detilmasuk`.`KodeBarang` = `tblbarang`.`kode`))) join `tbl_masuk` on((`tbl_detilmasuk`.`KodeTransaksi` = `tbl_masuk`.`KodeTransaksi`)))) */;

/*View structure for view vcetak */

/*!50001 DROP TABLE IF EXISTS `vcetak` */;
/*!50001 DROP VIEW IF EXISTS `vcetak` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vcetak` AS (select `tbl_detilpenjualan`.`Nofaktur` AS `Nofaktur`,`tbl_penjualan`.`Tanggal` AS `Tanggal`,`tbl_penjualan`.`Tempo` AS `Tempo`,`tbl_penjualan`.`KodeOtlet` AS `KodeOtlet`,`tbl_otlet`.`Nama` AS `namaOtlet`,`tbl_otlet`.`Alamat` AS `Alamat`,`tbl_otlet`.`No_Telp` AS `No_Telp`,`tbl_otlet`.`Email` AS `Email`,`tbl_detilpenjualan`.`KodeBarang` AS `KodeBarang`,`tblbarang`.`Nama` AS `NamaBarang`,`tblbarang`.`satuan` AS `satuan`,`tbl_detilpenjualan`.`qty` AS `qty`,`tbl_detilpenjualan`.`harga` AS `harga`,`tbl_detilpenjualan`.`subtotal` AS `subtotal`,`tbl_detilpenjualan`.`Diskon` AS `Diskon`,`tbl_detilpenjualan`.`Bonus` AS `Bonus`,`tbl_penjualan`.`Total` AS `Total` from (((`tbl_detilpenjualan` join `tblbarang` on((`tbl_detilpenjualan`.`KodeBarang` = `tblbarang`.`kode`))) join `tbl_penjualan` on((`tbl_detilpenjualan`.`Nofaktur` = `tbl_penjualan`.`NoFaktur`))) join `tbl_otlet` on((`tbl_penjualan`.`KodeOtlet` = `tbl_otlet`.`Kode`)))) */;

/*View structure for view vpenjualan */

/*!50001 DROP TABLE IF EXISTS `vpenjualan` */;
/*!50001 DROP VIEW IF EXISTS `vpenjualan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpenjualan` AS (select `tbl_penjualan`.`NoFaktur` AS `NoFaktur`,`tbl_penjualan`.`Tanggal` AS `Tanggal`,`tbl_penjualan`.`Tempo` AS `Tempo`,`tbl_penjualan`.`KodeOtlet` AS `KodeOtlet`,`tbl_otlet`.`Nama` AS `namaOtlet`,`tbl_detilpenjualan`.`KodeBarang` AS `KodeBarang`,`tblbarang`.`Nama` AS `NamaBarang`,`tbl_detilpenjualan`.`qty` AS `qty`,`tbl_detilpenjualan`.`harga` AS `harga`,`tbl_detilpenjualan`.`subtotal` AS `subtotal`,`tbl_detilpenjualan`.`Diskon` AS `Diskon`,`tbl_detilpenjualan`.`Bonus` AS `Bonus` from (((`tbl_detilpenjualan` join `tbl_penjualan` on((`tbl_detilpenjualan`.`Nofaktur` = `tbl_penjualan`.`NoFaktur`))) join `tblbarang` on((`tbl_detilpenjualan`.`KodeBarang` = `tblbarang`.`kode`))) join `tbl_otlet` on((`tbl_penjualan`.`KodeOtlet` = `tbl_otlet`.`Kode`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
