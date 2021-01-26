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
-- Table structure for table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quotation` (
  `quotationID` varchar(45) NOT NULL,
  `vendorID` varchar(45) NOT NULL,
  `companyID` varchar(45) NOT NULL,
  `rfqID` varchar(45) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `validity` date DEFAULT NULL,
  `date` date DEFAULT NULL,
  `delivery` double DEFAULT NULL,
  PRIMARY KEY (`quotationID`),
  KEY `vendor_id_idx` (`vendorID`),
  KEY `company_id_idx` (`companyID`),
  KEY `rfq_id_idx` (`rfqID`),
  CONSTRAINT `Company-ID` FOREIGN KEY (`companyID`) REFERENCES `company` (`companyid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rfq-id` FOREIGN KEY (`rfqID`) REFERENCES `rfq` (`rfqid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vendor-id` FOREIGN KEY (`vendorID`) REFERENCES `vendor` (`vendorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
INSERT INTO `quotation` VALUES ('QT1000','VN0001','C0001','RFQ1000',1900,'2019-07-01','2019-06-01',50),('QT1001','VN0001','C0001','RFQ1001',950,'2019-12-12','2019-05-18',50),('QT1002','VN0001','C0001','RFQ1003',72,'2019-08-09','2019-05-18',15),('QT1003','VN0001','C0001','RFQ1002',200,'2019-03-20','2019-05-20',50),('QT1004','VN0001','C0001','RFQ1004',100,'2019-02-12','2019-05-20',50),('QT1005','VN0001','C0001','RFQ1005',1299.97,'2019-12-12','2019-05-20',99.99),('QT1006','VN0001','C0001','RFQ1007',120,'2019-12-30','2019-05-20',20);
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
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
