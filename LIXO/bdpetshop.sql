-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Set-2017 às 20:28
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdpetshop`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animais`
--

CREATE TABLE `animais` (
  `cod_animal` smallint(2) PRIMARY KEY AUTO_INCREMENT,
  `nome_animal` varchar(25) NOT NULL,
  `cod_raca` smallint(2) NOT NULL,
  `cod_sexo_animal` varchar(1) NOT NULL,
  `idade_animal` smallint(2) NOT NULL,
  `cod_cliente` smallint(2) NOT NULL,
  `cod_dependentes` smallint(2) NOT NULL,
  `foto_animal` varchar(30) DEFAULT NULL,
  `cor_animal` varchar(20) DEFAULT NULL,
  `cod_especie` smallint(1) DEFAULT NULL,
	FOREIGN KEY (cod_animal) REFERENCES clientes(cod_animal),
	FOREIGN KEY (cod_animal) REFERENCES dependentes(cod_animal)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidades`
--

CREATE TABLE `cidades` (
  `cod_cidade` smallint(2) PRIMARY KEY AUTO_INCREMENT,
  `nome_cidade` varchar(20) NOT NULL,
  `desc_cidade` text NOT NULL,
	FOREIGN KEY (cod_cidade) REFERENCES enderecos(cod_cidade)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidades`
--

INSERT INTO `cidades` (`cod_cidade`, `nome_cidade`, `desc_cidade`) VALUES
(0, 'Guarulhos', 'Guarulhos é um município da Região Metropolitana de São Paulo, no estado de São Paulo, no Brasil. É a segunda cidade mais populosa do estado, a 13ª mais populosa do Brasil e a 53ª mais populosa do continente americano.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `cod_cliente` smallint(2) PRIMARY KEY AUTO_INCREMENT,
  `cod_tipo` smallint(1) NOT NULL,
  `nome_cliente` varchar(25) NOT NULL,
  `cod_sexo` varchar(1) NOT NULL,
  `foto_cliente` varchar(30) DEFAULT NULL,
  `cod_rg` varchar(10) NOT NULL,
  `cod_cpf` varchar(11) NOT NULL,
  `cod_cep` varchar(9) NOT NULL,
  `num_resid` smallint(4) NOT NULL,
  `tel_cliente` varchar(11) NOT NULL,
  `cel_cliente` varchar(12) NOT NULL,
  `cod_animal` smallint(2) NOT NULL,
  `cod_dependente` smallint(2) NOT NULL,
  `email_cliente` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `codigo_pessoa_fisica`
--

CREATE TABLE `codigo_pessoa_fisica` (
  `cod_cpf` varchar(11) NOT NULL PRIMARY KEY,
  `tipo_cpf` enum('P.FÍSICA','P.JURÍDICA') NOT NULL,
	FOREIGN KEY (cod_cpf) REFERENCES clientes(cod_cpf),
	FOREIGN KEY (cod_cpf) REFERENCES dependentes(cod_cpf)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `dependentes`
--

CREATE TABLE `dependentes` (
  `cod_dependente` smallint(2) PRIMARY KEY AUTO_INCREMENT,
  `nome_dependente` varchar(30) NOT NULL,
  `cod_cpf` varchar(11) NOT NULL,
  `cod_rg` int(10) NOT NULL,
  `cod_cep` int(8) NOT NULL,
  `cod_sexo` varchar(2) NOT NULL,
  `num_resid` int(4) NOT NULL,
  `obs_dependente` varchar(100) NOT NULL,
  `cel_dependente` int(11) DEFAULT NULL,
  `email_dependente` varchar(50) DEFAULT NULL,
  `cod_cliente` smallint(2) DEFAULT NULL,
  `cod_animal` smallint(2) DEFAULT NULL,
FOREIGN KEY (cod_dependente) REFERENCES clientes(cod_dependnete)

) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dependentes`
--

INSERT INTO `dependentes` (`cod_dependente`, `nome_dependente`, `cod_cpf`, `cod_rg`, `cod_cep`, `cod_sexo`, `num_resid`, `obs_dependente`, `cel_dependente`, `email_dependente`, `cod_cliente`, `cod_animal`) VALUES
(3, 'Eva', '02747614832', 411238723, 1881104, 'F', 207, 'Meu filha', 60981655, 'eva@net', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecos`
--

CREATE TABLE `enderecos` (
  `cod_cep` int(8) NOT NULL PRIMARY KEY,
  `endereco` varchar(30) NOT NULL,
  `cod_uf` varchar(2) NOT NULL,
  `cod_cidade` smallint(2) NOT NULL,
  `bairro` varchar(30) DEFAULT NULL,
	FOREIGN KEY (cod_cep) REFERENCES clientes(cod_cep),
	FOREIGN KEY (cod_cep) REFERENCES dependentes(cod_cep)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `especies`
--

CREATE TABLE `especies` (
  `cod_especie` smallint(1) NOT NULL PRIMARY KEY,
  `desc_especie` enum('CANINA','FELINA') NOT NULL,
	FOREIGN KEY (cod_especie) REFERENCES animais(cod_especie)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `racas`
--

CREATE TABLE `racas` (
  `cod_raca` smallint(2) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome_raca` varchar(20) NOT NULL,
  `desc_raca` varchar(50) NOT NULL,
  `porte_raca` enum('PEQUENO','MÉDIO','GRANDE') DEFAULT NULL,
	FOREIGN KEY (cod_raca) REFERENCES animais(cod_raca)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `registro_geral`
--

CREATE TABLE `registro_geral` (
  `cod_rg` int(10) NOT NULL PRIMARY KEY,
  `cod_uf` varchar(2) NOT NULL,
	FOREIGN KEY (cod_rg) REFERENCES clientes(cod_rg),
	FOREIGN KEY (cod_rg) REFERENCES dependentes(cod_rg)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo`
--

CREATE TABLE `sexo` (
  `cod_sexo` varchar(2) NOT NULL PRIMARY KEY,
  `desc_sexo` enum('MASCULINO','FEMININO') NOT NULL,
	FOREIGN KEY (cod_sexo) REFERENCES clientes(cod_sexo),
	FOREIGN KEY (cod_sexo) REFERENCES dependentes(cod_sexo)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo_animal`
--

CREATE TABLE `sexo_animal` (
  `cod_sexo_animal` varchar(2) NOT NULL PRIMARY KEY,
  `desc_sexo` enum('MACHO','FÊMEA') NOT NULL,
	FOREIGN KEY (cod_sexo_animal) REFERENCES animais(cod_sexo_animal)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipos_de_clientes`
--

CREATE TABLE `tipos_de_clientes` (
  `cod_tipo` enum('C','F') NOT NULL PRIMARY KEY,
  `desc_tipo` enum('COMUM','FRÊGUES') NOT NULL,
	FOREIGN KEY (cod_tipo) REFERENCES clientes(cod_tipo)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidades_federais`
--

CREATE TABLE `unidades_federais` (
  `cod_uf` varchar(2) NOT NULL PRIMARY KEY,
  `nome_uf` varchar(20) NOT NULL,
  `desc_uf` text NOT NULL,
	FOREIGN KEY (cod_UF) REFERENCES enderecos(cod_uf),
	FOREIGN KEY (cod_UF) REFERENCES registro_geral(cod_uf)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `unidades_federais`
--

INSERT INTO `unidades_federais` (`cod_uf`, `nome_uf`, `desc_uf`) VALUES
('SP', 'São Paulo', 'Fundada em 1554 por padres jesuítas, a cidade é mundialmente conhecida e exerce significativa influência nacional e internacional, seja do ponto de vista cultural, econômico ou político.');

