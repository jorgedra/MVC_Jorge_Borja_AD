-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema empresa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa` ;
USE `empresa` ;

-- -----------------------------------------------------
-- Table `empresa`.`departamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`departamentos` (
  `idDepartamento` INT NOT NULL,
  `d_nombre` VARCHAR(15) COLLATE 'utf8mb3_spanish2_ci' NOT NULL,
  `d_localizacion` VARCHAR(15) CHARACTER SET 'utf8mb3' NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa`.`empleados` (
  `idEmpleado` INT NOT NULL,
  `nombre` VARCHAR(10) COLLATE 'utf8mb3_spanish2_ci' NOT NULL,
  `apellido` VARCHAR(10) COLLATE 'utf8mb3_spanish2_ci' NOT NULL,
  `cargo` VARCHAR(25) COLLATE 'utf8mb3_spanish2_ci' NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `salario` DECIMAL(8,2) NOT NULL,
  `idDepartamento` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_empleados_departamentos_idx` (`idDepartamento` ASC) VISIBLE,
  CONSTRAINT `fk_empleados_departamentos`
    FOREIGN KEY (`idDepartamento`)
    REFERENCES `empresa`.`departamentos` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
