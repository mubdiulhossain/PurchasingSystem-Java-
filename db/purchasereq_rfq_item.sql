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
-- Table structure for table `rfq_item`
--

DROP TABLE IF EXISTS `rfq_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rfq_item` (
  `rfqID` varchar(45) NOT NULL,
  `itemID` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`rfqID`,`itemID`),
  KEY `item_id_idx` (`itemID`),
  CONSTRAINT `item_id` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rfq_id` FOREIGN KEY (`rfqID`) REFERENCES `rfq` (`rfqid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rfq_item`
--

LOCK TABLES `rfq_item` WRITE;
/*!40000 ALTER TABLE `rfq_item` DISABLE KEYS */;
INSERT INTO `rfq_item` VALUES ('RFQ1000','IT1001',5),('RFQ1000','IT1002',3),('RFQ1000','IT1005',4),('RFQ1001','IT1004',2),('RFQ1001','IT1007',20),('RFQ1002','IT1005',19),('RFQ1003','IT1000',2),('RFQ1004','IT1000',2),('RFQ1004','IT1002',4),('RFQ1004','IT1006',6),('RFQ1005','IT1029',3),('RFQ1005','IT1035',2),('RFQ1006','IT1000',3),('RFQ1007','IT1036',3);
/*!40000 ALTER TABLE `rfq_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 21:16:15