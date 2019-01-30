-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Out-2017 às 20:39
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
  `cod_animal` smallint(2) NOT NULL,
  `nome_animal` varchar(25) NOT NULL,
  `cod_raca` smallint(2) NOT NULL,
  `cod_sexo_animal` varchar(1) NOT NULL,
  `idade_animal` smallint(2) NOT NULL,
  `cod_cliente` smallint(2) NOT NULL,
  `cod_dependente` smallint(2) NOT NULL,
  `foto_animal` varchar(30) DEFAULT NULL,
  `cor_animal` varchar(20) DEFAULT NULL,
  `cod_especie` smallint(1) DEFAULT NULL
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

CREATE TABLE `cidades` (
  `cod_cidade` smallint(2) NOT NULL,
  `nome_cidade` varchar(20) NOT NULL,
  `desc_cidade` text NOT NULL
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

CREATE TABLE `clientes` (
  `cod_cliente` smallint(2) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`cod_cliente`, `cod_tipo`, `nome_cliente`, `cod_sexo`, `foto_cliente`, `cod_rg`, `cod_cpf`, `cod_cep`, `num_resid`, `tel_cliente`, `cel_cliente`, `cod_animal`, `cod_dependente`, `email_cliente`) VALUES
(1, 2, 'EVA', 'F', 'NADA', '263541267', '02747614832', '07132020', 207, '43075040', '966632902', 1, 1, 'EVA.SMACED@GMAIL.COM'),
(2, 2, 'DÉ', 'F', 'NADA', '123456', '1234567', '1234567', 123, '1234567', '1234456', 2, 2, 'DE@NET.COM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `codigo_pessoa_fisica`
--

CREATE TABLE `codigo_pessoa_fisica` (
  `cod_cpf` varchar(11) NOT NULL,
  `tipo_cpf` enum('P.FÍSICA','P.JURÍDICA') NOT NULL
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

CREATE TABLE `dependentes` (
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
  `cod_animal` smallint(2) NOT NULL
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

CREATE TABLE `enderecos` (
  `cod_cep` int(8) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `cod_uf` varchar(2) NOT NULL,
  `cod_cidade` smallint(2) NOT NULL,
  `bairro` varchar(30) DEFAULT NULL
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

CREATE TABLE `especies` (
  `cod_especie` smallint(1) NOT NULL,
  `desc_especie` enum('CANINA','FELINA') NOT NULL
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

CREATE TABLE `racas` (
  `cod_raca` smallint(2) NOT NULL,
  `nome_raca` varchar(20) NOT NULL,
  `desc_raca` varchar(50) NOT NULL,
  `porte_raca` enum('PEQUENO','MÉDIO','GRANDE') DEFAULT NULL
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

CREATE TABLE `registro_geral` (
  `cod_rg` int(10) NOT NULL,
  `cod_uf` varchar(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexo`
--

CREATE TABLE `sexo` (
  `cod_sexo` enum('M','F') NOT NULL,
  `desc_sexo` enum('MASCULINO','FEMININO') NOT NULL
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

CREATE TABLE `sexo_animal` (
  `cod_sexo_animal` enum('M','F') NOT NULL,
  `desc_sexo` enum('MACHO','FÊMEA') NOT NULL
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

CREATE TABLE `tipos_de_clientes` (
  `cod_tipo` enum('C','F') NOT NULL,
  `desc_tipo` enum('COMUM','FRÊGUES') NOT NULL
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

CREATE TABLE `unidades_federais` (
  `cod_uf` varchar(2) NOT NULL,
  `nome_uf` varchar(20) NOT NULL,
  `desc_uf` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `unidades_federais`
--

INSERT INTO `unidades_federais` (`cod_uf`, `nome_uf`, `desc_uf`) VALUES
('SP', 'São Paulo', 'Fundada em 1554 por padres jesuítas, a cidade é mundialmente conhecida e exerce significativa influência nacional e internacional, seja do ponto de vista cultural, econômico ou político.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animais`
--
ALTER TABLE `animais`
  ADD PRIMARY KEY (`cod_animal`),
  ADD CONSTRAINT `fk1_animais` FOREIGN KEY (`cod_raca`)
	REFERENCES `racas` (`cod_raca`),
  ADD CONSTRAINT `fk2_animais` FOREIGN KEY (`cod_especie`)
	REFERENCES `especies` (`cod_especie`);

--
-- Indexes for table `cidades`
--
ALTER TABLE `cidades`
  ADD PRIMARY KEY (`cod_cidade`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cod_cliente`),
  ADD CONSTRAINT `fk1_clientes` FOREIGN KEY (`cod_animal`)
	REFERENCES `animais` (`cod_animal`),
  ADD CONSTRAINT `fk2_clientes` FOREIGN KEY (`cod_dependente`)
	REFERENCES `dependentes` (`cod_dependente`),
  ADD CONSTRAINT `fk3_clientes` FOREIGN KEY (`cod_cep`)
	REFERENCES `enderecos` (`cod_cep`),
  ADD CONSTRAINT `fk4_clientes` FOREIGN KEY (`cod_tipo`)
	REFERENCES `tipos_de_clientes` (`cod_tipo`),
  ADD CONSTRAINT `fk5_clientes` FOREIGN KEY (`cod_sexo`)
	REFERENCES `sexos` (`cod_sexo`),
  ADD CONSTRAINT `fk6_clientes` FOREIGN KEY (`cod_cpf`)
	REFERENCES `codigo_pessoa_fisica` (`cod_cpf`),
  ADD CONSTRAINT `fk7_clientes` FOREIGN KEY (`cod_rg`)
	REFERENCES `registro_geral` (`cod_rg`);
--
-- Indexes for table `codigo_pessoa_fisica`
--
ALTER TABLE `codigo_pessoa_fisica`
  ADD PRIMARY KEY (`cod_cpf`);

--
-- Indexes for table `dependentes`
--
ALTER TABLE `dependentes`
  ADD PRIMARY KEY (`cod_dependente`);

--
-- Indexes for table `enderecos`
--
ALTER TABLE `enderecos`
  ADD PRIMARY KEY (`cod_cep`),
  ADD CONSTRAINT `fk1_enderecos` FOREIGN KEY (`cod_cidade`) 	REFERENCES `cidades` (`cod_cidade`),
 ADD CONSTRAINT `fk2_enderecos` FOREIGN KEY (`cod_uf`) REFERENCES `unidades_federais` (`cod_uf`);
	
 
--
-- Indexes for table `especies`
--
ALTER TABLE `especies`
  ADD PRIMARY KEY (`cod_especie`);

--
-- Indexes for table `racas`
--
ALTER TABLE `racas`
  ADD PRIMARY KEY (`cod_raca`);

--
-- Indexes for table `registro_geral`
--
ALTER TABLE `registro_geral`
  ADD PRIMARY KEY (`cod_rg`),
  ADD CONSTRAINT `fk1_rg` FOREIGN KEY (`cod_uf`)
	REFERENCES `unidades_federais` (`cod_uf`);

--
-- Indexes for table `sexo`
--
ALTER TABLE `sexo`
  ADD PRIMARY KEY (`cod_sexo`);

--
-- Indexes for table `sexo_animal`
--
ALTER TABLE `sexo_animal`
  ADD PRIMARY KEY (`cod_sexo_animal`);

--
-- Indexes for table `tipos_de_clientes`
--
ALTER TABLE `tipos_de_clientes`
  ADD PRIMARY KEY (`cod_tipo`);

--
-- Indexes for table `unidades_federais`
--
ALTER TABLE `unidades_federais`
  ADD PRIMARY KEY (`cod_uf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cidades`
--
ALTER TABLE `cidades`
  MODIFY `cod_cidade` smallint(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `racas`
--
ALTER TABLE `racas`
  MODIFY `cod_raca` smallint(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
