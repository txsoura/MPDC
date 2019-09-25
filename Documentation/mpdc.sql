-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2019 at 08:30 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mpdc`
--

-- --------------------------------------------------------

--
-- Table structure for table `autoridade`
--

CREATE TABLE `autoridade` (
  `nup` int(11) NOT NULL,
  `nome` mediumtext NOT NULL,
  `telefone` bigint(25) NOT NULL,
  `email` mediumtext NOT NULL,
  `endereco` mediumtext NOT NULL,
  `cargo` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autoridade`
--

INSERT INTO `autoridade` (`nup`, `nome`, `telefone`, `email`, `endereco`, `cargo`) VALUES
(4, 'Victor Tesoura', 844916247, 'vtsegundanhe@gmail.com', 'alto-mae', 'Administrador'),
(6, 'teste', 8568765, 'teste@g', 'beira', 'Alfandegas');

-- --------------------------------------------------------

--
-- Table structure for table `camiao`
--

CREATE TABLE `camiao` (
  `matricula` mediumtext NOT NULL,
  `empresa` mediumtext NOT NULL,
  `telefone` bigint(25) NOT NULL,
  `email` mediumtext,
  `tipo` mediumtext NOT NULL,
  `pais` mediumtext NOT NULL,
  `nup` int(11) NOT NULL,
  `passageiros` int(11) NOT NULL,
  `chegada` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `camiao`
--

INSERT INTO `camiao` (`matricula`, `empresa`, `telefone`, `email`, `tipo`, `pais`, `nup`, `passageiros`, `chegada`) VALUES
('txf', 'tx', 868, 'tx@g.co', 'BaÃº', 'Gambia', 2, 0, NULL),
('aab 567 mp', 'lalgy', 236546865, 'lalgy', 'misto', 'mocambique', 5, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `comboio`
--

CREATE TABLE `comboio` (
  `matricula` mediumtext NOT NULL,
  `empresa` mediumtext NOT NULL,
  `telefone` bigint(25) NOT NULL,
  `email` mediumtext,
  `tipo` mediumtext NOT NULL,
  `pais` mediumtext NOT NULL,
  `nup` int(11) NOT NULL,
  `passageiros` int(11) NOT NULL,
  `chegada` date DEFAULT NULL,
  `partida` date DEFAULT NULL,
  `preco` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comboio`
--

INSERT INTO `comboio` (`matricula`, `empresa`, `telefone`, `email`, `tipo`, `pais`, `nup`, `passageiros`, `chegada`, `partida`, `preco`) VALUES
('785bbvh', 'cfm', 21876896, 'infO@cfm.co.mz', 'misto', 'mocambique', 3, 0, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `controle`
--

CREATE TABLE `controle` (
  `nup` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `controle`
--

INSERT INTO `controle` (`nup`, `data`) VALUES
(1, '2018-06-22 15:15:36'),
(2, '2018-06-22 15:16:34'),
(2, '2018-06-22 15:18:14'),
(3, '2018-06-22 15:18:48'),
(1, '2018-06-22 15:20:17'),
(2, '2018-06-22 16:51:22'),
(3, '2018-06-22 17:04:48'),
(1, '2018-07-17 15:13:17'),
(1, '2018-07-17 15:43:40'),
(1, '2018-07-17 15:46:02'),
(1, '2018-07-17 15:46:24'),
(1, '2018-07-17 16:08:19'),
(1, '2018-07-17 16:09:18'),
(1, '2018-07-17 16:09:29'),
(2, '2018-07-17 16:53:15'),
(3, '2018-07-17 17:42:13'),
(2, '2018-07-22 17:47:22'),
(1, '2018-07-30 08:54:25'),
(2, '2018-07-30 08:55:00'),
(1, '2018-08-23 17:58:17'),
(4, '2018-08-26 12:54:19'),
(4, '2018-08-26 15:38:26'),
(6, '2018-08-26 17:11:25'),
(4, '2018-08-26 20:33:19'),
(6, '2018-08-26 21:21:43'),
(7, '2018-08-26 21:53:27'),
(6, '2018-08-26 21:53:40'),
(6, '2018-08-27 06:21:37'),
(6, '2018-08-28 16:39:02'),
(7, '2018-08-28 17:13:48'),
(7, '2018-08-28 18:14:44'),
(6, '2018-08-28 18:16:37'),
(7, '2018-08-28 18:17:23'),
(6, '2018-08-28 19:05:08'),
(7, '2018-08-28 19:08:34'),
(1, '2018-08-28 19:20:14'),
(6, '2018-08-28 20:31:30'),
(6, '2018-09-01 10:08:50'),
(6, '2018-09-04 09:33:22'),
(4, '2018-09-04 13:38:04'),
(1, '2018-09-28 11:33:11'),
(1, '2018-09-29 08:50:12'),
(8, '2018-09-29 08:50:59'),
(8, '2018-09-29 09:34:23'),
(1, '2018-09-29 09:34:42'),
(2, '2018-09-29 09:35:47'),
(5, '2018-09-29 09:45:18'),
(1, '2018-09-29 09:45:46'),
(3, '2018-09-29 09:46:50'),
(7, '2018-09-29 10:07:09'),
(4, '2018-09-29 10:14:56'),
(6, '2018-09-29 12:28:38'),
(4, '2018-09-29 12:29:34'),
(4, '2018-09-29 12:37:36'),
(1, '2018-09-29 12:38:41'),
(7, '2018-10-01 11:38:51'),
(1, '2018-10-01 11:39:25'),
(4, '2018-10-01 11:40:37'),
(6, '2018-10-01 11:41:16'),
(1, '2018-10-01 14:04:34'),
(7, '2018-10-01 14:07:50'),
(6, '2018-10-01 14:09:11'),
(1, '2018-10-01 14:11:02'),
(7, '2018-10-01 14:11:43'),
(1, '2019-04-05 10:45:24');

-- --------------------------------------------------------

--
-- Table structure for table `mercadoria`
--

CREATE TABLE `mercadoria` (
  `codigo` int(11) NOT NULL,
  `navio` int(11) NOT NULL,
  `situacao` mediumtext NOT NULL,
  `tipo` mediumtext NOT NULL,
  `quantidade` int(11) NOT NULL,
  `responsavel` int(11) NOT NULL,
  `disponivel` int(1) NOT NULL DEFAULT '0',
  `chegada` date DEFAULT NULL,
  `partida` date DEFAULT NULL,
  `preco` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mercadoria`
--

INSERT INTO `mercadoria` (`codigo`, `navio`, `situacao`, `tipo`, `quantidade`, `responsavel`, `disponivel`, `chegada`, `partida`, `preco`) VALUES
(1, 0, 'importacao', 'gases liquefeitos', 0, 1, 0, NULL, NULL, 0),
(8, 5, 'importacao', 'multi porpose', 0, 1, 3, '2017-11-04', '2017-11-04', 0),
(9, 5, 'importacao', 'multi porpose', 1, 1, 2, '2017-11-04', NULL, 0),
(10, 5, 'importacao', 'multi porpose', 1, 1, 1, NULL, NULL, 0),
(11, 5, 'importacao', 'multi porpose', 200, 1, 1, NULL, NULL, 0),
(12, 5, 'importacao', 'multi porpose', 1, 1, 1, NULL, NULL, 0),
(13, 5, 'importacao', 'petroleiros', 20, 1, 0, NULL, NULL, 0),
(14, 6, 'transito', 'heavy lift', 1, 1, 3, '2017-11-01', '2017-11-01', 0),
(15, 7, 'transito', 'box type', 5, 1, 1, NULL, NULL, 0),
(16, 7, 'transito', 'ro-ro', 10, 1, 4, '2017-11-15', NULL, 0),
(17, 5, 'transito', 'porta-barcacas', 1, 1, 0, NULL, NULL, 0),
(18, 1, 'importacao', 'porta-barcacas', 1, 7, 2, '2018-10-01', NULL, 0),
(19, 1, 'importacao', 'multi porpose', 7, 7, 1, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `navio`
--

CREATE TABLE `navio` (
  `matricula` mediumtext NOT NULL,
  `nome` mediumtext NOT NULL,
  `telefone` bigint(25) NOT NULL,
  `email` mediumtext,
  `tipo` mediumtext NOT NULL,
  `pais` mediumtext NOT NULL,
  `nup` int(11) NOT NULL,
  `passageiros` int(11) NOT NULL,
  `chegada` date DEFAULT NULL,
  `partida` date DEFAULT NULL,
  `preco` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `navio`
--

INSERT INTO `navio` (`matricula`, `nome`, `telefone`, `email`, `tipo`, `pais`, `nup`, `passageiros`, `chegada`, `partida`, `preco`) VALUES
('tx', 'txh', 844916247, 'tx@g.co', 'Balsas', 'Macedonia', 1, 1, '2018-10-01', '2018-12-01', 61041.666666667),
('hjvugygh', 'ailton', 876657654, 'ailton@hfygf', 'Semi-SubmersÃ­veis', 'Bielorrussia', 8, 1, '2018-10-01', '2018-10-29', 28041.666666667),
('frank x', 'frank', 7567567657, 'frank@jmhnhfv.jhgjyf', 'Balsas', 'Barem', 9, 0, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `noticia`
--

CREATE TABLE `noticia` (
  `codigo` int(11) NOT NULL,
  `titulo` mediumtext NOT NULL,
  `descricao` mediumtext NOT NULL,
  `escritor` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `noticia`
--

INSERT INTO `noticia` (`codigo`, `titulo`, `descricao`, `escritor`) VALUES
(1, 'A maior ponte do mundo está prestes a ser inaugurada', 'A ponte, que vai ligar Hong Kong, Macau e Zhuahi , está prestes a ser inaugurada. Começou a ser construída em 2009 e tem um comprimento de 55 quilómetros.', 'MPDC'),
(2, 'teste', 'teste autoridade', 'Victor Tesoura'),
(3, 'Novo sistema dos CFM', 'Esta em fase de conclusao o novo e mais moderno sistema de gestao portuaria dos portos e caminhos de ferro de mocambique', 'MPDC'),
(4, 'MPDC', 'A concessioaria do porto de Maputo (MPDC), confirmou a aquisicao do novo Sistema de gestao portuaria.', 'Victor Tesoura');

-- --------------------------------------------------------

--
-- Table structure for table `responsavel`
--

CREATE TABLE `responsavel` (
  `nup` int(11) NOT NULL,
  `nome` mediumtext NOT NULL,
  `telefone` bigint(25) NOT NULL,
  `email` mediumtext,
  `endereco` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `responsavel`
--

INSERT INTO `responsavel` (`nup`, `nome`, `telefone`, `email`, `endereco`) VALUES
(7, 'teste', 778576476, 'tx@g.co', 'kjvjhvv,mv,nv');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `nup` int(11) NOT NULL,
  `senha` tinytext NOT NULL,
  `tipo` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`nup`, `senha`, `tipo`) VALUES
(1, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'nv'),
(2, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'cm'),
(3, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'cb'),
(4, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'at'),
(5, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'cm'),
(6, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'at'),
(7, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'rs'),
(8, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'nv'),
(9, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'nv');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autoridade`
--
ALTER TABLE `autoridade`
  ADD PRIMARY KEY (`nup`);

--
-- Indexes for table `camiao`
--
ALTER TABLE `camiao`
  ADD PRIMARY KEY (`nup`);

--
-- Indexes for table `comboio`
--
ALTER TABLE `comboio`
  ADD PRIMARY KEY (`nup`);

--
-- Indexes for table `mercadoria`
--
ALTER TABLE `mercadoria`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `navio`
--
ALTER TABLE `navio`
  ADD PRIMARY KEY (`nup`);

--
-- Indexes for table `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `responsavel`
--
ALTER TABLE `responsavel`
  ADD PRIMARY KEY (`nup`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mercadoria`
--
ALTER TABLE `mercadoria`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `noticia`
--
ALTER TABLE `noticia`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `nup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
