-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2022 at 01:12 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kaddem`
--

--
-- Dumping data for table `contrat`
--

INSERT INTO `contrat` (`id_contrat`, `archive`, `date_debut_contrat`, `date_fin_contrat`, `specialite`, `etudiant_id_etudiant`) VALUES
(3, b'1', '2022-05-01', '2022-06-01', 'IA', 2),
(2, b'0', '2022-05-01', '2022-06-01', 'IA', 4);

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`id_departement`, `nom_departement`) VALUES
(1, 'Informatique');

--
-- Dumping data for table `detail_equipe`
--

INSERT INTO `detail_equipe` (`id_detail_equipe`, `salle`, `thematique`) VALUES
(1, 3, 'IT'),
(7, 3, 'TIC');

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`id_equipe`, `niveau`, `nom_equipe`, `detail_equipe_id_detail_equipe`) VALUES
(1, 'EXPERT', 'newbies', 1),
(3, 'JUNIOR', 'test', 7);

--
-- Dumping data for table `equipe_etudiants`
--

INSERT INTO `equipe_etudiants` (`equips_id_equipe`, `etudiants_id_etudiant`) VALUES
(1, 1),
(1, 4);

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `nom_etudiant`, `option`, `prenom_etudiant`, `departement_id_departement`) VALUES
(1, 'test', 'TWIN', 'test', 1),
(3, 'test', 'Gamix', 'test', 1),
(4, 'test', 'Gamix', 'test', 1);

--
-- Dumping data for table `universite`
--

INSERT INTO `universite` (`id_universite`, `nom_universite`) VALUES
(1, 'ESPRIT');

--
-- Dumping data for table `universite_departements`
--

INSERT INTO `universite_departements` (`universite_id_universite`, `departements_id_departement`) VALUES
(1, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
