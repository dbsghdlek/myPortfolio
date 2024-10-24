-- MySQL Script generated by MySQL Workbench
-- Wed Mar  8 23:19:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`PortfolioMenu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PortfolioMenu` (
  `MenuId` INT NOT NULL,
  `MenuName` VARCHAR(45) NOT NULL,
  `CreateDate` VARCHAR(45) NULL,
  `DeleteDate` VARCHAR(45) NULL,
  PRIMARY KEY (`MenuId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Singer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Singer` (
  `SingerID` INT NOT NULL,
  `SingerName` VARCHAR(45) NOT NULL,
  `CreateDate` DATE NULL,
  `DeleteDate` DATE NULL,
  PRIMARY KEY (`SingerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Music`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Music` (
  `MusicID` INT NOT NULL,
  `MusicName` VARCHAR(45) NOT NULL,
  `CreateDate` DATE NULL,
  `DeleteDate` DATE NULL,
  `Musiccol` VARCHAR(45) NULL,
  `Singer_SingerID` INT NOT NULL,
  PRIMARY KEY (`MusicID`, `Singer_SingerID`),
  INDEX `fk_Music_Singer_idx` (`Singer_SingerID` ASC) VISIBLE,
  CONSTRAINT `fk_Music_Singer`
    FOREIGN KEY (`Singer_SingerID`)
    REFERENCES `mydb`.`Singer` (`SingerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`Puppy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Puppy` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Travel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Travel` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SkillStack`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SkillStack` (
  `SkillID` INT NOT NULL,
  `SkillName` VARCHAR(45) NOT NULL,
  `SkillImage` VARCHAR(45) NULL,
  PRIMARY KEY (`SkillID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Hobby` (
  `HobbyID` INT NOT NULL,
  `HobbyName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`HobbyID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
