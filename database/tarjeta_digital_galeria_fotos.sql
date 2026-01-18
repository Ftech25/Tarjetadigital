-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tarjeta_digital
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `galeria_fotos`
--

DROP TABLE IF EXISTS `galeria_fotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `galeria_fotos` (
  `id_foto` int NOT NULL AUTO_INCREMENT,
  `id_evento` int DEFAULT NULL,
  `id_invitado` int DEFAULT NULL,
  `tipo` enum('OFICIAL','INVITADO') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url_imagen` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `orden` int DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_foto`),
  KEY `id_evento` (`id_evento`),
  KEY `id_invitado` (`id_invitado`),
  CONSTRAINT `galeria_fotos_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`),
  CONSTRAINT `galeria_fotos_ibfk_2` FOREIGN KEY (`id_invitado`) REFERENCES `invitados` (`id_invitado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `galeria_fotos`
--

LOCK TABLES `galeria_fotos` WRITE;
/*!40000 ALTER TABLE `galeria_fotos` DISABLE KEYS */;
/*!40000 ALTER TABLE `galeria_fotos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-17 23:07:52
