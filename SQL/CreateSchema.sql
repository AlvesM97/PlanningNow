-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema planningnow
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema planningnow
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `planningnow` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `planningnow` ;

-- -----------------------------------------------------
-- Table `planningnow`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planningnow`.`usuario` (
  `ra` INT NOT NULL,
  `senha` VARCHAR(30) NOT NULL,
  `tipo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `planningnow`.`monitoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planningnow`.`monitoria` (
  `idMonitoria` INT NOT NULL AUTO_INCREMENT,
  `Usuario_ra` INT NOT NULL,
  `data` VARCHAR(20) NOT NULL,
  `hora` VARCHAR(20) NOT NULL,
  `disciplina` VARCHAR(45) NOT NULL,
  `sala` VARCHAR(20) NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idMonitoria`),
  INDEX `fk_Monitoria_Usuario1_idx` (`Usuario_ra` ASC) INVISIBLE,
  CONSTRAINT `fk_Monitoria_Usuario1`
    FOREIGN KEY (`Usuario_ra`)
    REFERENCES `planningnow`.`usuario` (`ra`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `planningnow`.`agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planningnow`.`agenda` (
  `idAgenda` INT NOT NULL AUTO_INCREMENT,
  `Usuario_ra` INT NOT NULL,
  `monitoria_idMonitoria` INT NOT NULL,
  PRIMARY KEY (`idAgenda`),
  INDEX `fk_Agenda_Usuario1_idx` (`Usuario_ra` ASC) VISIBLE,
  INDEX `fk_agenda_monitoria1_idx` (`monitoria_idMonitoria` ASC) VISIBLE,
  CONSTRAINT `fk_agenda_monitoria1`
    FOREIGN KEY (`monitoria_idMonitoria`)
    REFERENCES `planningnow`.`monitoria` (`idMonitoria`),
  CONSTRAINT `fk_Agenda_Usuario1`
    FOREIGN KEY (`Usuario_ra`)
    REFERENCES `planningnow`.`usuario` (`ra`))
ENGINE = InnoDB
AUTO_INCREMENT = 63
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `planningnow`.`publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planningnow`.`publicacao` (
  `idPublicacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `data` VARCHAR(45) NOT NULL,
  `Usuario_ra` INT NOT NULL,
  PRIMARY KEY (`idPublicacao`),
  UNIQUE INDEX `idPublicacao_UNIQUE` (`idPublicacao` ASC) VISIBLE,
  INDEX `fk_Publicacao_Usuario1_idx` (`Usuario_ra` ASC) VISIBLE,
  CONSTRAINT `fk_Publicacao_Usuario1`
    FOREIGN KEY (`Usuario_ra`)
    REFERENCES `planningnow`.`usuario` (`ra`))
ENGINE = InnoDB
AUTO_INCREMENT = 228
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
