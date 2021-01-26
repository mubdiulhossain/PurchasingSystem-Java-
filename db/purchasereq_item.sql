-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: purchasereq
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `itemID` varchar(10) NOT NULL,
  `price` double NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('IT1000',35.5,'usb'),('IT1001',401,'monitor'),('IT1002',32,'mouse'),('IT1003',256,'Camera'),('IT1004',5001,'MSI Laptop'),('IT1005',455.894,'msi keyboard'),('IT1006',999.99,'HD_camera'),('IT1007',78.95,'msi mouse'),('IT1008',2500,'switch'),('IT1009',55.55,'dell monitor'),('IT1011',9500.99,'HD TV'),('IT1012',2500,'ps4'),('IT1013',250,'ps4 controller'),('IT1014',350,'ps4 camera'),('IT1015',900.99,'ps4 monitor'),('IT1016',4000,'ps4 red'),('IT1017',5000,'ps4 gold'),('IT1018',9999,'ps4 pink'),('IT1019',300,'switch joycon'),('IT1020',15000,'iphone'),('IT1021',15000,'iphone gold'),('IT1023',2,'powerbank'),('IT1024',500,'powerbank 10k'),('IT1025',200,'powebank 5k'),('IT1026',50,'powerbank 2k'),('IT1027',25,'powerbank 1k'),('IT1028',50.5,'mouse'),('IT1029',400.21,'Webcam'),('IT1030',65000,'iphone 6'),('IT1031',3500,'iphone 6 gold'),('IT1032',3150,'iphone 4'),('IT1033',35.73,'keboard'),('IT1034',35.75,'keyboard'),('IT1035',50.5,'iphone 5'),('IT1036',50,'toy');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 21:16:20
