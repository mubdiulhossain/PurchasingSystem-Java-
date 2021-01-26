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
-- Table structure for table `invoicet`
--

DROP TABLE IF EXISTS `invoicet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invoicet` (
  `InvoiceId` varchar(255) NOT NULL,
  `Date` date DEFAULT NULL,
  `SubTotal` decimal(10,2) DEFAULT NULL,
  `DeliveryCost` decimal(10,2) DEFAULT NULL,
  `Total` decimal(10,2) DEFAULT NULL,
  `vendorID` varchar(255) NOT NULL,
  `deliveryID` varchar(255) DEFAULT NULL,
  `staffID` varchar(255) DEFAULT NULL,
  `Payment_Status` varchar(255) NOT NULL,
  PRIMARY KEY (`InvoiceId`),
  UNIQUE KEY `InvoiceId_UNIQUE` (`InvoiceId`),
  KEY `VendorId_idx` (`vendorID`),
  KEY `staffID_idx` (`staffID`),
  KEY `d2_idx` (`deliveryID`),
  CONSTRAINT `doi` FOREIGN KEY (`deliveryID`) REFERENCES `delivery_order` (`do_id`),
  CONSTRAINT `s` FOREIGN KEY (`staffID`) REFERENCES `finance_staff` (`finance_staffid`),
  CONSTRAINT `v` FOREIGN KEY (`vendorID`) REFERENCES `vendor` (`vendorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoicet`
--

LOCK TABLES `invoicet` WRITE;
/*!40000 ALTER TABLE `invoicet` DISABLE KEYS */;
INSERT INTO `invoicet` VALUES ('IN1001','2019-05-20',150.00,30.00,180.00,'VN0001','DO0001','FS0001','Paid');
/*!40000 ALTER TABLE `invoicet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 21:16:16
