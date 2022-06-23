CREATE DATABASE  IF NOT EXISTS `hiberex1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hiberex1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hiberex1
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `urun`
--

DROP TABLE IF EXISTS `urun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urun` (
  `id` bigint(20) NOT NULL,
  `ADI` varchar(100) DEFAULT NULL,
  `FIYAT` decimal(15,2) DEFAULT NULL,
  `SON_KULLANMA_TARIHI` date DEFAULT NULL,
  `STOK_BIRIMI` varchar(30) DEFAULT NULL,
  `STOK_MIKTARI` bigint(20) DEFAULT NULL,
  `ID_URUN_TURU` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IX_URUN_URUN_TURU` (`ID_URUN_TURU`),
  CONSTRAINT `FK_URUN_URUN_TURU` FOREIGN KEY (`ID_URUN_TURU`) REFERENCES `urun_turu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urun`
--

LOCK TABLES `urun` WRITE;
/*!40000 ALTER TABLE `urun` DISABLE KEYS */;
INSERT INTO `urun` VALUES (1,'Ekmek',1.00,'2019-11-30','ADET',100,1),(2,'Biskuvi',1.50,'2020-08-30','ADET',250,1),(3,'Domates',4.75,'2018-11-01','KILO',20,1),(4,'Kola',5.00,'2019-11-30','ADET',200,2),(5,'Su',0.50,'2020-08-30','LITRE',1000,2),(6,'Ayran',1.00,'2018-11-01','ADET',100,2),(7,'Pantolon',120.00,'2030-01-01','ADET',30,3),(8,'Gomlek',75.00,'2030-01-01','ADET',30,3),(9,'Kazak',100.00,'2030-01-01','ADET',100,3),(10,'Komur',10.00,'2030-01-01','PAKET',3000,4),(11,'Dogalgaz',23.18,'2030-01-01','LITRE',30000,4),(12,'Odun',4.87,'2030-01-01','KILO',1000,4),(13,'Kalem',10.00,'2030-01-01','ADET',200,5),(14,'A4 Kagit',18.99,'2030-01-01','PAKET',320,5),(15,'Defter',4.87,'2030-01-01','ADET',150,5);
/*!40000 ALTER TABLE `urun` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-05 11:07:01
