-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 03/10/2017 às 00h31min
-- Versão do Servidor: 5.5.20
-- Versão do PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `bdpetshop`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animais`
--

CREATE TABLE IF NOT EXISTS `animais` (
  `cod_animal` smallint(2) NOT NULL,
  `nome_animal` varchar(25) NOT NULL,
  `cod_raca` smallint(2) NOT NULL,
  `cod_sexo_animal` varchar(1) NOT NULL,
  `idade_animal` smallint(2) NOT NULL,
  `cod_cliente` smallint(2) NOT NULL,
  `cod_dependente` smallint(2) NOT NULL,
  `foto_animal` varchar(30) DEFAULT NULL,
  `cor_animal` varchar(20) DEFAULT NULL,
  `cod_especie` smallint(1) NOT NULL,
  PRIMARY KEY (`cod_animal`),
  KEY `fk1_animais_idx` (`cod_raca`),
  KEY `fk2_animais_idx` (`cod_especie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animais`
--

INSERT INTO `animais` (`cod_animal`, `nome_animal`, `cod_raca`, `cod_sexo_animal`, `idade_animal`, `cod_cliente`, `cod_dependente`, `foto_animal`, `cor_animal`, `cod_especie`) VALUES
(1, 'SAIDI', 2, 'M', 6, 1, 1, 'NADA', 'PRETA', 1),
(2, 'BOB', 1, 'M', 10, 2, 2, 'NADA', 'CARAMELO', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidades`
--

CREATE TABLE IF NOT EXISTS `cidades` (
  `cod_cidade` smallint(2) NOT NULL,
  `nome_cidade` varchar(20) NOT NULL,
  `desc_cidade` text NOT NULL,
  PRIMARY KEY (`cod_cidade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidades`
--

INSERT INTO `cidades` (`cod_cidade`, `nome_cidade`, `desc_cidade`) VALUES
(1, 'Guarulhos', 'Guarulhos é um município da Região Metropolitana de São Paulo, no estado de São Paulo, no Brasil. É a segunda cidade mais populosa do estado, a 13ª mais populosa do Brasil e a 53ª mais populosa do continente americano.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `cod_cliente` smallint(2) NOT NULL,
  `cod_tipo` enum('C','F') NOT NULL,
  `nome_cliente` varchar(25) NOT NULL,
  `cod_sexo` enum('M','F') NOT NULL,
  `foto_cliente` varchar(30) DEFAULT NULL,
  `cod_rg` int(10) NOT NULL,
  `cod_cpf` varchar(11) NOT NULL,
  `cod_cep` int(8) NOT NULL,
  `num_resid` smallint(4) NOT NULL,
  `tel_cliente` varchar(11) NOT NULL,
  `cel_cliente` varchar(12) NOT NULL,
  `cod_animal` smallint(2) NOT NULL,
  `cod_dependente` smallint(2) NOT NULL,
  `email_cliente` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `fk1_clientes_idx` (`cod_animal`),
  KEY `fk2_clientes_idx` (`cod_dependente`),
  KEY `fk3_clientes_idx` (`cod_cpf`),
  KEY `fk4_clientes_idx` (`cod_rg`),
  KEY `fk5_clientes_idx` (`cod_cep`),
  KEY `fk6_clientes_idx` (`cod_sexo`),
  KEY `fk7_cliente_idx` (`cod_tipo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`cod_cliente`, `cod_tipo`, `nome_cliente`, `cod_sexo`, `foto_cliente`, `cod_rg`, `cod_cpf`, `cod_cep`, `num_resid`, `tel_cliente`, `cel_cliente`, `cod_animal`, `cod_dependente`, `email_cliente`) VALUES
(1, 'F', 'EVA', 'F', 'NADA', 263541267, '02747614832', 7132020, 207, '43075040', '966632902', 1, 1, 'EVA.SMACED@GMAIL.COM'),
(2, 'F', 'DÉ', 'F', 'NADA', 123456, '1234567', 1234567, 123, '1234567', '1234456', 2, 2, 'DE@NET.COM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `codigo_pessoa_fisica`
--

CREATE TABLE IF NOT EXISTS `codigo_pessoa_fisica` (
  `cod_cpf` varchar(11) NOT NULL,
  `tipo_cpf` enum('P.FÍSICA','P.JURÍDICA') NOT NULL,
  PRIMARY KEY (`cod_cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `codigo_pessoa_fisica`
--

INSERT INTO `codigo_pessoa_fisica` (`cod_cpf`, `tipo_cpf`) VALUES
('44004287880', 'P.FÍSICA'),
('02747614832', 'P.FÍSICA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dependentes`
--

CREATE TABLE IF NOT EXISTS `dependentes` (
  `cod_dependente` smallint(2) NOT NULL,
  `nome_dependente` varchar(30) NOT NULL,
  `cod_cpf` varchar(11) NOT NULL,
  `cod_rg` int(10) NOT NULL,
  `cod_cep` int(8) NOT NULL,
  `cod_sexo` varchar(2) NOT NULL,
  `num_resid` int(4) NOT NULL,
  `obs_dependente` varchar(100) NOT NULL,
  `cel_dependente` int(11) DEFAULT NULL,
  `email_dependente` varchar(50) DEFAULT NULL,
  `cod_cliente` smallint(2) NOT NULL,
  `cod_animal` smallint(2) NOT NULL,
  PRIMARY KEY (`cod_dependente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dependentes`
--

INSERT INTO `dependentes` (`cod_dependente`, `nome_dependente`, `cod_cpf`, `cod_rg`, `cod_cep`, `cod_sexo`, `num_resid`, `obs_dependente`, `cel_dependente`, `email_dependente`, `cod_cliente`, `cod_animal`) VALUES
(4, 'LUIZ', '44004287880', 411238723, 7132020, 'M', 207, 'MEU FILHO', 960981655, 'LUIZ.FMACED@GMAIL.COM', 1, 1),
(5, 'AUGUSTA', '222322222', 223423423, 1234567, 'F', 123, 'MINHA VÓ', 23423423, 'AUGUSTA@GMAIL.COM', 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecos`
--

CREATE TABLE IF NOT EXISTS `enderecos` (
  `cod_cep` int(8) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `cod_uf` varchar(2) NOT NULL,
  `cod_cidade` smallint(2) NOT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cod_cep`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `enderecos`
--

INSERT INTO `enderecos` (`cod_cep`, `endereco`, `cod_uf`, `cod_cidade`, `bairro`) VALUES
(7132020, 'RUA SÃO JERONIMO DA SERRA', 'SP', 1, 'JARDIM JOVAIA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `especies`
--

CREATE TABLE IF NOT EXISTS `especies` (
  `cod_especie` smallint(1) NOT NULL,
  `desc_especie` enum('CANINA','FELINA') NOT NULL,
  PRIMARY KEY (`cod_especie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `especies`
--

INSERT INTO `especies` (`cod_especie`, `desc_especie`) VALUES
(1, 'CANINA'),
(2, 'FELINA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `racas`
--

CREATE TABLE IF NOT EXISTS `racas` (
  `cod_raca` smallint(2) NOT NULL,
  `nome_raca` varchar(20) NOT NULL,
  `desc_raca` varchar(50) NOT NULL,
  `porte_raca` enum('PEQUENO','MÉDIO','GRANDE') DEFAULT NULL,
  PRIMARY KEY (`cod_raca`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `racas`
--

INSERT INTO `racas` (`cod_raca`, `nome_raca`, `desc_raca`, `porte_raca`) VALUES
(1, 'ROTTWALLER', 'CÃO DE GUARDA DE ORIGEM ALEMÃ', 'GRANDE'),
(2, 'XITSU', 'CÃO DE COMPANHIA DE ORIGEM CHINESA', 'PEQUENO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `registro_geral`
--

CREATE TABLE IF NOT EXISTS `registro_geral` (
  `cod_rg` int(10) NOT NULL,
  `cod_uf` varchar(2) NOT NULL,
  PRIMARY KEY (`cod_rg`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo`
--

CREATE TABLE IF NOT EXISTS `sexo` (
  `cod_sexo` enum('M','F') NOT NULL,
  `desc_sexo` enum('MASCULINO','FEMININO') NOT NULL,
  PRIMARY KEY (`cod_sexo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sexo`
--

INSERT INTO `sexo` (`cod_sexo`, `desc_sexo`) VALUES
('M', 'MASCULINO'),
('F', 'FEMININO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo_animal`
--

CREATE TABLE IF NOT EXISTS `sexo_animal` (
  `cod_sexo_animal` enum('M','F') NOT NULL,
  `desc_sexo` enum('MACHO','FÊMEA') NOT NULL,
  PRIMARY KEY (`cod_sexo_animal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sexo_animal`
--

INSERT INTO `sexo_animal` (`cod_sexo_animal`, `desc_sexo`) VALUES
('M', 'MACHO'),
('F', 'FÊMEA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipos_de_clientes`
--

CREATE TABLE IF NOT EXISTS `tipos_de_clientes` (
  `cod_tipo` enum('C','F') NOT NULL,
  `desc_tipo` enum('COMUM','FRÊGUES') NOT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipos_de_clientes`
--

INSERT INTO `tipos_de_clientes` (`cod_tipo`, `desc_tipo`) VALUES
('C', 'COMUM'),
('F', 'FRÊGUES');

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidades_federais`
--

CREATE TABLE IF NOT EXISTS `unidades_federais` (
  `cod_uf` varchar(2) NOT NULL,
  `nome_uf` varchar(20) NOT NULL,
  `desc_uf` text NOT NULL,
  PRIMARY KEY (`cod_uf`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `unidades_federais`
--

INSERT INTO `unidades_federais` (`cod_uf`, `nome_uf`, `desc_uf`) VALUES
('SP', 'São Paulo', 'Fundada em 1554 por padres jesuítas, a cidade é mundialmente conhecida e exerce significativa influência nacional e internacional, seja do ponto de vista cultural, econômico ou político.');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
