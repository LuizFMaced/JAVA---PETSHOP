-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Set-2017 às 21:03
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
  `cod_dependentes` smallint(2) NOT NULL,
  `foto_animal` varchar(30) DEFAULT NULL,
  `cor_animal` varchar(20) DEFAULT NULL,
  `cod_especie` smallint(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animais`
--

INSERT INTO `animais` (`cod_animal`, `nome_animal`, `cod_raca`, `cod_sexo_animal`, `idade_animal`, `cod_cliente`, `cod_dependentes`, `foto_animal`, `cor_animal`, `cod_especie`) VALUES
(1, 'CACHORRO', 1, 'M', 4, 1, 1, 'NADA', 'PRETA', 1);

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
(0, 'Guarulhos', 'Guarulhos é um município da Região Metropolitana de São Paulo, no estado de São Paulo, no Brasil. É a segunda cidade mais populosa do estado, a 13ª mais populosa do Brasil e a 53ª mais populosa do continente americano.');

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `codigo_pessoa_fisica`
--

CREATE TABLE `codigo_pessoa_fisica` (
  `cod_cpf` varchar(11) NOT NULL,
  `tipo_cpf` enum('P.FÍSICA','P.JURÍDICA') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `cod_cliente` smallint(2) DEFAULT NULL,
  `cod_animal` smallint(2) DEFAULT NULL
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
  `cod_cep` int(8) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `cod_uf` varchar(2) NOT NULL,
  `cod_cidade` smallint(2) NOT NULL,
  `bairro` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`cod_animal`);

--
-- Indexes for table `cidades`
--
ALTER TABLE `cidades`
  ADD PRIMARY KEY (`cod_cidade`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cod_cliente`);

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
  ADD PRIMARY KEY (`cod_cep`);

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
  ADD PRIMARY KEY (`cod_rg`);

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
-- AUTO_INCREMENT for table `animais`
--
ALTER TABLE `animais`
  MODIFY `cod_animal` smallint(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cidades`
--
ALTER TABLE `cidades`
  MODIFY `cod_cidade` smallint(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `cod_cliente` smallint(2) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dependentes`
--
ALTER TABLE `dependentes`
  MODIFY `cod_dependente` smallint(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `racas`
--
ALTER TABLE `racas`
  MODIFY `cod_raca` smallint(2) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
