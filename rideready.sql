CREATE DATABASE  IF NOT EXISTS `rideready` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rideready`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: rideready
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `automobile`
--

DROP TABLE IF EXISTS `automobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automobile` (
  `id` int NOT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modello` varchar(255) DEFAULT NULL,
  `prezzo_acquisto` double DEFAULT NULL,
  `prezzo_noleggio_giornaliero` double DEFAULT NULL,
  `disponibile` tinyint(1) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `cavalli` int DEFAULT NULL,
  `cilindrata` double DEFAULT NULL,
  `posti_a_sedere` int DEFAULT NULL,
  `carburante` varchar(255) DEFAULT NULL,
  `targa` varchar(255) DEFAULT NULL,
  `tipo_di_destinazione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobile`
--

LOCK TABLES `automobile` WRITE;
/*!40000 ALTER TABLE `automobile` DISABLE KEYS */;
INSERT INTO `automobile` VALUES (13,'Subaro','Impreza',0,150,1,4,600,2500,5,'benzina','SU-123-IM','noleggio'),(202,'Honda','Civic',15000,0,0,1,150,1600,2,'benzina','NA-123-DA','acquisto'),(203,'Honda','s2000',18000,0,1,2,235,1300,2,'benzina','HS-200-TR','acquisto'),(402,'Fiat','Uno Turbo ie',30000,0,1,2,700,2400,2,'benzina','BD-700-DP','acquisto');
/*!40000 ALTER TABLE `automobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `id` int NOT NULL,
  `id_prenotazione` int NOT NULL,
  `id_utente` varchar(16) NOT NULL,
  `id_automobile` int NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `data_acquisto_automobile` date DEFAULT NULL,
  `data_noleggio_inizio` date DEFAULT NULL,
  `data_noleggio_fine` date DEFAULT NULL,
  `prezzo_acquisto_auto_ordine` double DEFAULT NULL,
  `prezzo_noleggio_giornaliero_ordine` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Ordine_id_prenotazione_Prenotazione_id` (`id_prenotazione`),
  KEY `Ordine_id_utente_utente_codicefiscale` (`id_utente`),
  KEY `Ordine_id_automobile_Automobile_id` (`id_automobile`),
  CONSTRAINT `Ordine_id_automobile_Automobile_id` FOREIGN KEY (`id_automobile`) REFERENCES `automobile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Ordine_id_prenotazione_Prenotazione_id` FOREIGN KEY (`id_prenotazione`) REFERENCES `prenotazione` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Ordine_id_utente_utente_codicefiscale` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`codicefiscale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (252,233,'DMTNTN00D04I676F',402,'acquisto','2024-07-02',NULL,NULL,29000,0),(302,352,'CRCNNA67T45B554I',13,'noleggio',NULL,'2024-07-02','2024-07-07',0,150);
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `id` int NOT NULL,
  `id_automobile` int NOT NULL,
  `id_utente` varchar(16) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `data_prenotazione` date NOT NULL,
  `stato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Prenotazione_id_automobile_Automobile_id` (`id_automobile`),
  KEY `Prenotazione_id_utente_utente_codicefiscale` (`id_utente`),
  CONSTRAINT `Prenotazione_id_automobile_Automobile_id` FOREIGN KEY (`id_automobile`) REFERENCES `automobile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Prenotazione_id_utente_utente_codicefiscale` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`codicefiscale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (233,402,'DMTNTN00D04I676F','acquisto','2024-07-01','accettata'),(252,13,'DMTNTN00D04I676F','noleggio','2024-06-29','in attesa'),(352,13,'CRCNNA67T45B554I','noleggio','2024-06-30','accettata');
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id` int NOT NULL,
  `codicefiscale` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codicefiscale` (`codicefiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (402,'CRCNNA67T45B554I'),(352,'DMTNTN00D04I676F');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-10 17:09:02
