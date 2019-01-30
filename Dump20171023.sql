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
  `obs_animal` varchar(100) DEFAULT NULL,
  `cod_especie` enum('C','F') NOT NULL,
  `sexo_animal` enum('MACHO','FÊMEA') NOT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`cod_animal`),
  KEY `fk1_animais` (`cod_raca`),
  KEY `fk3_animais` (`cod_especie`),
  KEY `´fk2_animais´` (`cod_cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animais`
--

LOCK TABLES `animais` WRITE;
/*!40000 ALTER TABLE `animais` DISABLE KEYS */;
INSERT INTO `animais` VALUES (1,'SAIDI',1,'','0',NULL,NULL,'C','MACHO','111.113.333.33'),(2,'BOB',2,'','0',NULL,NULL,'C','MACHO','222.244.444.44'),(19,'JÉSSICA',4,'CHOCOLATE','11/11/2222','null','GATA','F','FÊMEA','111.111.111.11'),(20,'GOIABA',3,'BRANCA','20/10/2017',NULL,'TESTE','F','MACHO','111.111.111.11');
/*!40000 ALTER TABLE `animais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidades` (
  `cidade` varchar(45) NOT NULL,
  PRIMARY KEY (`cidade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES ('COPACABANA'),('GUARULHOS'),('IPANEMA'),('ITAQUAQUECETUBA');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
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
  `cod_cep` varchar(9) NOT NULL,
  `num_resid` int(4) NOT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  `cod_rg` varchar(12) NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `tpo_cliente` enum('COMUM','FREGUÊS') NOT NULL,
  `foto_cliente` varchar(100) DEFAULT NULL,
  `tel_cliente` varchar(15) NOT NULL,
  `cel_cliente` varchar(16) NOT NULL,
  `email_cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `fk1_clientes` (`cod_animal`),
  KEY `fk2_clientes` (`cod_dependente`),
  KEY `fk3_clientes` (`cod_cep`),
  KEY `fk4_clientes` (`cod_cpf`),
  KEY `fk5_clientes` (`cod_rg`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'EVA',1,1,'07132-020',207,'027.476.148.32','12.345.678-9','FEMININO','FREGUÊS','NADA','(11) 4307-5040','(11) 96663-2902','eva.fmaced@gmail'),(2,'DÉ',2,2,'12345-678',9001,'123.456.789.11','87.654.321-6','FEMININO','COMUM','NADA','(11) 1234-1234','(11) 91234-1234','de.sa@gmail'),(3,'CLIENTE',19,6,'11111-111',1111,'111.111.111.11','11.111.111-1','MASCULINO','FREGUÊS','null','(11) 1111-1111','(11) 1 1111-1111','EMAIL@CLIENTE');
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
INSERT INTO `cpf` VALUES ('P.FÍSICA','027.476.148.32'),('P.FÍSICA','123.456.789.11'),('P.FÍSICA','111.113.333.33'),('P.FÍSICA','222.244.444.44'),('P.FÍSICA','222.222.222.22'),('P.JURÍDICA','111.111.111.11');
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
  `cod_cep` varchar(9) NOT NULL,
  `cod_rg` varchar(12) NOT NULL,
  `cod_cpf` varchar(14) NOT NULL,
  `cel_dependente` varchar(16) NOT NULL,
  `email_dependente` varchar(45) NOT NULL,
  `foto_dependente` varchar(100) DEFAULT NULL,
  `num_resid` int(4) NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  PRIMARY KEY (`cod_dependente`),
  KEY `fk2_dependentes` (`cod_cep`),
  KEY `fk3_dependentes` (`cod_rg`),
  KEY `fk4_dependentes` (`cod_cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependentes`
--

LOCK TABLES `dependentes` WRITE;
/*!40000 ALTER TABLE `dependentes` DISABLE KEYS */;
INSERT INTO `dependentes` VALUES (1,'AUGUSTA','07132-020','22.222.333-3','111.113.333.33','','',NULL,0,'FEMININO'),(2,'LUIZ','12345-678','33.334.444-4','222.244.444.44','','',NULL,0,'MASCULINO'),(6,'DEPENDENTE','22222-222','22.222.222-2','222.222.222.22','(11) 1 1111-1111','EMAIL@CLIENTE','null',2222,'FEMININO');
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
  PRIMARY KEY (`cod_cep`),
  KEY `fk1_endereco` (`cidade`),
  KEY `fk2_endereco` (`estado`)
) ENGINE=MyISAM AUTO_INCREMENT=12345679 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` VALUES ('07132-020','RUA SÃO JERONIMO DA SERRA','GUARULHOS','SÃO PAULO','JARDIM JOVAIA'),('12345-678','RUA DE ITAQUA QUALQUER','ITAQUAQUECETUBA','SÃO PAULO','JARDIM ARACÍLIA'),('22070-011','Avenida Nossa Senhora de Copacabana ','COPACABANA','RIO DE JANEIRO','PRAIA'),('22080-046','Rua Francisco Otaviano','IPANEMA','RIO DE JANEIRO','CONDOMINIO'),('11111-111','RUA CLIENTE','COPACABANA','RIO DE JANEIRO','BAIRRO'),('22222-222','RUA DEPENDENTE','IPANEMA','RIO DE JANEIRO','BAIRRO');
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
-- Temporary view structure for view `lista_cliente`
--

DROP TABLE IF EXISTS `lista_cliente`;
/*!50001 DROP VIEW IF EXISTS `lista_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `lista_cliente` AS SELECT 
 1 AS `cod_cliente`,
 1 AS `tpo_cliente`,
 1 AS `nome_cliente`,
 1 AS `sexo`,
 1 AS `cod_rg`,
 1 AS `cod_cpf`,
 1 AS `cod_cep`,
 1 AS `endereco`,
 1 AS `num_resid`,
 1 AS `tel_cliente`,
 1 AS `cel_cliente`,
 1 AS `email_cliente`*/;
SET character_set_client = @saved_cs_client;

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
  `desc_raca` tinytext,
  `cod_especie` enum('C','F') NOT NULL,
  PRIMARY KEY (`cod_raca`),
  KEY `fk1_racas` (`cod_especie`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racas`
--

LOCK TABLES `racas` WRITE;
/*!40000 ALTER TABLE `racas` DISABLE KEYS */;
INSERT INTO `racas` VALUES (1,'XITSU','PEQUENO',NULL,'C'),(2,'ROTTWAILLER','GRANDE',NULL,'C'),(3,'PERSA','MÉDIO','Persa é uma raça de gato doméstico originária do Irã, antiga Pérsia. É conhecido por sua aparência chamativa, de pelagem longa e focinho achatado','F'),(4,'SIAMÊS','MÉDIO','Gato siamês é uma raça de gato oriental, caracterizada por um corpo elegante e esguio e uma cabeça marcadamente triangular. Pode ser confundido com a raça de gatos Thai que tem origem na raça siamesa mas apresenta uma morfologia bem distinta.','F');
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
INSERT INTO `rg` VALUES ('11.111.111-1'),('12.345.678-9'),('22.222.222-2'),('22.222.333-3'),('33.334.444-4'),('87.654.321-6');
/*!40000 ALTER TABLE `rg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `selecionar_cliente`
--

DROP TABLE IF EXISTS `selecionar_cliente`;
/*!50001 DROP VIEW IF EXISTS `selecionar_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `selecionar_cliente` AS SELECT 
 1 AS `cod_cpf`,
 1 AS `tipo_cpf`,
 1 AS `cod_rg`,
 1 AS `nome_cliente`,
 1 AS `tpo_cliente`,
 1 AS `sexo`,
 1 AS `cod_cep`,
 1 AS `estado`,
 1 AS `cidade`,
 1 AS `endereco`,
 1 AS `bairro`,
 1 AS `num_resid`,
 1 AS `email_cliente`,
 1 AS `tel_cliente`,
 1 AS `cel_cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `uf`
--

DROP TABLE IF EXISTS `uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uf` (
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`estado`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uf`
--

LOCK TABLES `uf` WRITE;
/*!40000 ALTER TABLE `uf` DISABLE KEYS */;
INSERT INTO `uf` VALUES ('RIO DE JANEIRO'),('SÃO PAULO');
/*!40000 ALTER TABLE `uf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `lista_cliente`
--

/*!50001 DROP VIEW IF EXISTS `lista_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lista_cliente` AS select `c`.`cod_cliente` AS `cod_cliente`,`c`.`tpo_cliente` AS `tpo_cliente`,`c`.`nome_cliente` AS `nome_cliente`,`c`.`sexo` AS `sexo`,`c`.`cod_rg` AS `cod_rg`,`c`.`cod_cpf` AS `cod_cpf`,`c`.`cod_cep` AS `cod_cep`,`e`.`endereco` AS `endereco`,`c`.`num_resid` AS `num_resid`,`c`.`tel_cliente` AS `tel_cliente`,`c`.`cel_cliente` AS `cel_cliente`,`c`.`email_cliente` AS `email_cliente` from (`clientes` `c` join `enderecos` `e` on((`c`.`cod_cep` = `e`.`cod_cep`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `selecionar_cliente`
--

/*!50001 DROP VIEW IF EXISTS `selecionar_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `selecionar_cliente` AS select `c`.`cod_cpf` AS `cod_cpf`,`p`.`tipo_cpf` AS `tipo_cpf`,`c`.`cod_rg` AS `cod_rg`,`c`.`nome_cliente` AS `nome_cliente`,`c`.`tpo_cliente` AS `tpo_cliente`,`c`.`sexo` AS `sexo`,`c`.`cod_cep` AS `cod_cep`,`e`.`estado` AS `estado`,`e`.`cidade` AS `cidade`,`e`.`endereco` AS `endereco`,`e`.`bairro` AS `bairro`,`c`.`num_resid` AS `num_resid`,`c`.`email_cliente` AS `email_cliente`,`c`.`tel_cliente` AS `tel_cliente`,`c`.`cel_cliente` AS `cel_cliente` from ((`clientes` `c` join `cpf` `p` on((`c`.`cod_cpf` = `p`.`cod_cpf`))) join `enderecos` `e` on((`c`.`cod_cep` = `e`.`cod_cep`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-23 14:56:04
