-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 5style
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `5style` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `5style` DEFAULT CHARACTER SET utf8 ;
USE `5style` ;

-- -----------------------------------------------------
-- Table `mydb`.`Roupa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `5style`.`Roupa` (
  `idRoupa` INT NOT NULL AUTO_INCREMENT,
  `tamanho` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(45) NOT NULL,
  `imagem` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRoupa`, `tamanho`, `cor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `5style`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `5style`.`Compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `valorTotal` DECIMAL(45) NOT NULL,
  `quantidade` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_Compra_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Compra_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Quantidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `5style`.`Quantidade` (
  `quantidade` INT NOT NULL,
  `Roupa_idRoupa` INT NOT NULL,
  `Roupa_tamanho` VARCHAR(45) NOT NULL,
  `Roupa_cor` VARCHAR(45) NOT NULL,
  INDEX `fk_Quantidade_Roupa_idx` (`Roupa_idRoupa` ASC, `Roupa_tamanho` ASC, `Roupa_cor` ASC) VISIBLE,
  CONSTRAINT `fk_Quantidade_Roupa`
    FOREIGN KEY (`Roupa_idRoupa` , `Roupa_tamanho` , `Roupa_cor`)
    REFERENCES `mydb`.`Roupa` (`idRoupa` , `tamanho` , `cor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RoupaCompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `5style`.`RoupaCompra` (
  `Roupa_idRoupa` INT NOT NULL,
  `Roupa_tamanho` VARCHAR(45) NOT NULL,
  `Roupa_cor` VARCHAR(45) NOT NULL,
  `Compra_idCompra` INT NOT NULL,
  PRIMARY KEY (`Roupa_idRoupa`, `Roupa_tamanho`, `Roupa_cor`, `Compra_idCompra`),
  INDEX `fk_Roupa_has_Compra_Compra1_idx` (`Compra_idCompra` ASC) VISIBLE,
  INDEX `fk_Roupa_has_Compra_Roupa1_idx` (`Roupa_idRoupa` ASC, `Roupa_tamanho` ASC, `Roupa_cor` ASC) VISIBLE,
  CONSTRAINT `fk_Roupa_has_Compra_Roupa1`
    FOREIGN KEY (`Roupa_idRoupa` , `Roupa_tamanho` , `Roupa_cor`)
    REFERENCES `mydb`.`Roupa` (`idRoupa` , `tamanho` , `cor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Roupa_has_Compra_Compra1`
    FOREIGN KEY (`Compra_idCompra`)
    REFERENCES `mydb`.`Compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
