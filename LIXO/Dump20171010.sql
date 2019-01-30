CREATE DATABASE  IF NOT EXISTS `teste` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `teste`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: teste
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `animais`
--

DROP TABLE IF EXISTS `animais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animais` (
  `cod_animal` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_animal` varchar(50) NOT NULL,
  `cod_raca` smallint(6) NOT NULL,
  `cor_animal` varchar(25) NOT NULL,
  `nasc_animal` varchar(10) NOT NULL,
  `foto_animal` varchar(100) DEFAULT NULL,
  `cod_sexo_animal` enum('M','F') NOT NULL,
  `obs_animal` varchar(100) DEFAULT NULL,
  `cod_especie` enum('C','F') NOT NULL,
  PRIMARY KEY (`cod_animal`),
  KEY `fk2_animais` (`cod_sexo_animal`),
  KEY `fk1_animais` (`cod_raca`),
  KEY `fk3_animais` (`cod_especie`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animais`
--

LOCK TABLES `animais` WRITE;
/*!40000 ALTER TABLE `animais` DISABLE KEYS */;
INSERT INTO `animais` VALUES (1,'SAIDI',1,'','0',NULL,'M',NULL,'C'),(2,'BOB',2,'','0',NULL,'M',NULL,'C');
/*!40000 ALTER TABLE `animais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `cod_cliente` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(50) NOT NULL,
  `cod_animal` smallint(6) NOT NULL,
  `cod_dependente` smallint(6) NOT NULL,
  `cod_cep` varchar(10) NOT NULL,
  `num_resid` int(4) NOT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  `cod_rg` varchar(12) NOT NULL,
  `cod_sexo` enum('M','F') NOT NULL,
  `tpo_cliente` enum('COMUM','FREGUÊS') NOT NULL,
  `foto_cliente` varchar(100) DEFAULT NULL,
  `tel_cliente` varchar(14) NOT NULL,
  `cel_cliente` varchar(15) NOT NULL,
  `email_cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `fk1_clientes` (`cod_animal`),
  KEY `fk2_clientes` (`cod_dependente`),
  KEY `fk3_clientes` (`cod_cep`),
  KEY `fk4_clientes` (`cod_cpf`),
  KEY `fk5_clientes` (`cod_rg`),
  KEY `fk6_clientes` (`cod_sexo`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'EVA',1,1,'07132020',207,'02747614832','12345678','M','FREGUÊS','NADA','(11) 4307-5040','(11) 96663-2902','eva.fmaced@gmail'),(2,'DÉ',2,2,'12345678',9001,'12345678911','87654321','M','COMUM','NADA','(11) 1234-1234','(11) 91234-1234','de.sa@gmail');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpf`
--

DROP TABLE IF EXISTS `cpf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cpf` (
  `tipo_cpf` enum('P.FÍSICA','P.JURÍDICA') DEFAULT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`cod_cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpf`
--

LOCK TABLES `cpf` WRITE;
/*!40000 ALTER TABLE `cpf` DISABLE KEYS */;
/*!40000 ALTER TABLE `cpf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependentes`
--

DROP TABLE IF EXISTS `dependentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependentes` (
  `cod_dependente` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_dependente` varchar(50) NOT NULL,
  `cod_sexo` enum('M','F') NOT NULL,
  `cod_cep` varchar(10) NOT NULL,
  `cod_rg` varchar(12) NOT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  `cel_dependente` varchar(15) NOT NULL,
  `email_dependente` varchar(45) NOT NULL,
  `foto_dependente` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_dependente`),
  KEY `fk1_dependentes` (`cod_sexo`),
  KEY `fk2_dependentes` (`cod_cep`),
  KEY `fk3_dependentes` (`cod_rg`),
  KEY `fk4_dependentes` (`cod_cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependentes`
--

LOCK TABLES `dependentes` WRITE;
/*!40000 ALTER TABLE `dependentes` DISABLE KEYS */;
INSERT INTO `dependentes` VALUES (1,'AUGUSTA','F','07132020','222223333','1111133333','','',NULL),(2,'LUIZ','M','12345678','33334444','222244444','','',NULL);
/*!40000 ALTER TABLE `dependentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecos` (
  `cod_cep` varchar(10) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_cep`)
) ENGINE=MyISAM AUTO_INCREMENT=12345679 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` VALUES ('07132-020','RUA SÃO JERONIMO DA SERRA','GUARULHOS','SÃO PAULO','JARDIM JOVAIA'),('12345-678','RUA DE ITAQUA QUALQUER','ITAQUAQUECETUBA','SÃO PAULO','JARDIM ARACÍLIA');
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especies`
--

DROP TABLE IF EXISTS `especies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especies` (
  `cod_especie` enum('C','F') NOT NULL,
  `desc_especie` enum('CANINA','FELINA') DEFAULT NULL,
  PRIMARY KEY (`cod_especie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especies`
--

LOCK TABLES `especies` WRITE;
/*!40000 ALTER TABLE `especies` DISABLE KEYS */;
INSERT INTO `especies` VALUES ('C','CANINA'),('F','FELINA');
/*!40000 ALTER TABLE `especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `racas`
--

DROP TABLE IF EXISTS `racas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `racas` (
  `cod_raca` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_raca` varchar(50) NOT NULL,
  `porte_raca` enum('PEQUENO','MÉDIO','GRANDE') NOT NULL,
  `desc_raca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_raca`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racas`
--

LOCK TABLES `racas` WRITE;
/*!40000 ALTER TABLE `racas` DISABLE KEYS */;
INSERT INTO `racas` VALUES (1,'XITSU','PEQUENO',NULL),(2,'ROTTWAILLER','GRANDE',NULL);
/*!40000 ALTER TABLE `racas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rg`
--

DROP TABLE IF EXISTS `rg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rg` (
  `cod_rg` varchar(12) NOT NULL,
  PRIMARY KEY (`cod_rg`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rg`
--

LOCK TABLES `rg` WRITE;
/*!40000 ALTER TABLE `rg` DISABLE KEYS */;
INSERT INTO `rg` VALUES ('12345678'),('87654321');
/*!40000 ALTER TABLE `rg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexo` (
  `cod_sexo` enum('M','F') NOT NULL,
  `desc_sexo` enum('MASCULINO','FEMININO') NOT NULL,
  PRIMARY KEY (`cod_sexo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo_animal`
--

DROP TABLE IF EXISTS `sexo_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexo_animal` (
  `cod_sexo_animal` enum('M','F') NOT NULL,
  `desc_sexo_animal` enum('MACHO','FÊMEA') NOT NULL,
  PRIMARY KEY (`cod_sexo_animal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo_animal`
--

LOCK TABLES `sexo_animal` WRITE;
/*!40000 ALTER TABLE `sexo_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sexo_animal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-10 14:02:58
