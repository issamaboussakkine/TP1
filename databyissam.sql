-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 fév. 2026 à 23:03
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `databyissam`
--

-- --------------------------------------------------------

--
-- Structure de la table `issam_devdata`
--

CREATE TABLE `issam_devdata` (
  `Developpeurs` varchar(32) NOT NULL,
  `Jour` varchar(16) NOT NULL,
  `NbScripts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `issam_devdata`
--

INSERT INTO `issam_devdata` (`Developpeurs`, `Jour`, `NbScripts`) VALUES
('ISSAM', 'Lundi', 5),
('ACHRAF', 'Lundi', 2),
('MEHDI', 'Mardi', 9),
('ISSAM', 'Mardi', 3),
('ACHRAF', 'Mercredi', 4),
('MEHDI', 'Mercredi', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
