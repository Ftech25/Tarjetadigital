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
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `id_evento` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `titulo` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipo_evento` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  `hora_evento` time DEFAULT NULL,
  `slug` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modelo` enum('ESTANDAR','PREMIUM','PREMIUM_PLUS') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mensaje_bienvenida` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mapas_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_evento`),
  UNIQUE KEY `slug` (`slug`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,1,'Boda Ana & Juan','BODA','2026-03-20','19:00:00','boda-ana-juan','PREMIUM',NULL,NULL,NULL,'2026-01-17 18:09:54'),(2,1,'Boda Facu y Ana','BODA','2026-05-20','20:30:00','boda-facu-ana','PREMIUM','¡Te esperamos para celebrar con nosotros!','Salón Los Robles','https://maps.google.com/?q=salon','2026-01-17 20:06:33');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-17 23:07:53
