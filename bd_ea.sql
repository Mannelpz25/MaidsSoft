-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2021 a las 07:57:56
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ea`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_comisiones`
--

CREATE TABLE `tbl_comisiones` (
  `id_comision` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `nombre_trabajador` varchar(50) NOT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `tiempo_trabajado` int(11) NOT NULL,
  `comision_obtenida` int(11) NOT NULL,
  `descuentos_realizados` int(11) NOT NULL,
  `sueldototal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_comisiones`
--
ALTER TABLE `tbl_comisiones`
  ADD PRIMARY KEY (`id_comision`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_comisiones`
--
ALTER TABLE `tbl_comisiones`
  MODIFY `id_comision` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
