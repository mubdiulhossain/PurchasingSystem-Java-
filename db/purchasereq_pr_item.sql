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
-- Table structure for table `pr_item`
--

DROP TABLE IF EXISTS `pr_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pr_item` (
  `prID` varchar(10) NOT NULL,
  `itemID` varchar(10) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  PRIMARY KEY (`prID`,`itemID`),
  KEY `itemID_idx` (`itemID`),
  CONSTRAINT `itemID` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemid`),
  CONSTRAINT `prID` FOREIGN KEY (`prID`) REFERENCES `pr` (`prid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_item`
--

LOCK TABLES `pr_item` WRITE;
/*!40000 ALTER TABLE `pr_item` DISABLE KEYS */;
INSERT INTO `pr_item` VALUES ('PR1000','IT1000','5'),('PR1000','IT1001','3'),('PR1000','IT1002','7'),('PR1001','IT1005','19'),('PR1006','IT1000','2'),('PR1006','IT1003','3'),('PR1006','IT1007','1'),('PR1007','IT1000','2'),('PR1007','IT1002','4'),('PR1007','IT1006','6'),('PR1008','IT1000','2'),('PR1008','IT1007','3'),('PR1009','IT1015','3'),('PR1009','IT1018','2'),('PR1010','IT1017','2'),('PR1011','IT1000','2'),('PR1011','IT1005','3'),('PR1011','IT1020','2'),('PR1012','IT1000','3'),('PR1012','IT1004','1'),('PR1013','IT1000','3'),('PR1013','IT1002','2'),('PR1014','IT1000','5'),('PR1015','IT1000','4'),('PR1015','IT1002','100'),('PR1015','IT1007','10'),('PR1015','IT1029','1'),('PR1016','IT1002','999'),('PR1017','IT1000','321'),('PR1018','IT1002','11'),('PR1019','IT1000','2'),('PR1019','IT1004','5'),('PR1020','IT1000','2'),('PR1021','IT1000','1'),('PR1022','IT1030','2'),('PR1022','IT1031','2'),('PR1023','IT1000','3'),('PR1024','IT1000','5'),('PR1024','IT1004','3'),('PR1024','IT1007','1'),('PR1025','IT1000','3'),('PR1026','IT1029','3'),('PR1026','IT1035','2'),('PR1027','IT1036','3');
/*!40000 ALTER TABLE `pr_item` ENABLE KEYS */;
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