-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ip_aero
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ip_aero
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ip_aero` DEFAULT CHARACTER SET utf8 ;
USE `ip_aero` ;

-- -----------------------------------------------------
-- Table `ip_aero`.`ADMIN_USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`ADMIN_USER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Firstname` VARCHAR(100) NOT NULL,
  `Lastname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`ACCESS_NUMBER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`ACCESS_NUMBER` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Date` VARCHAR(50) NOT NULL,
  `Number` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`USER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(100) NOT NULL,
  `Firstname` VARCHAR(100) NOT NULL,
  `Lastname` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `Country` VARCHAR(100) NOT NULL,
  `Username` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`LOCATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`LOCATION` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Country` VARCHAR(100) NOT NULL,
  `ISO2` VARCHAR(50) NULL,
  `ISO3` VARCHAR(50) NULL,
  `City` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`FLIGHT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`FLIGHT` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `Seats_number` INT NOT NULL,
  `Cargo_description` VARCHAR(150) NULL,
  `Specification_file` VARCHAR(100) NULL,
  `Type` VARCHAR(50) NOT NULL,
  `Status` VARCHAR(50) NOT NULL,
  `START_LOCATION_ID` INT NOT NULL,
  `END_LOCATION_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_FLIGHT_LOCATION1_idx` (`START_LOCATION_ID` ASC) VISIBLE,
  INDEX `fk_FLIGHT_LOCATION2_idx` (`END_LOCATION_ID` ASC) VISIBLE,
  CONSTRAINT `fk_FLIGHT_LOCATION1`
    FOREIGN KEY (`START_LOCATION_ID`)
    REFERENCES `ip_aero`.`LOCATION` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FLIGHT_LOCATION2`
    FOREIGN KEY (`END_LOCATION_ID`)
    REFERENCES `ip_aero`.`LOCATION` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`RESERVATION` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `FLIGHT_ID` BIGINT NOT NULL,
  `Status` VARCHAR(50) NOT NULL,
  `Date_creation` VARCHAR(50) NOT NULL,
  `Reason` VARCHAR(200) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_USER_has_FLIGHT_FLIGHT1_idx` (`FLIGHT_ID` ASC) VISIBLE,
  INDEX `fk_USER_has_FLIGHT_USER_idx` (`USER_ID` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  CONSTRAINT `fk_USER_has_FLIGHT_USER`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `ip_aero`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_FLIGHT_FLIGHT1`
    FOREIGN KEY (`FLIGHT_ID`)
    REFERENCES `ip_aero`.`FLIGHT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`EMPLOYER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`EMPLOYER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Firstname` VARCHAR(100) NOT NULL,
  `Lastname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`SCHEDULE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`SCHEDULE` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `Date` VARCHAR(50) NOT NULL,
  `Day` VARCHAR(50) NOT NULL,
  `Hour` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`FLIGHT_SCHEDULE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`FLIGHT_SCHEDULE` (
  `SCHEDULE_ID` BIGINT NOT NULL,
  `FLIGHT_ID` BIGINT NOT NULL,
  INDEX `fk_SCHEDULE_has_FLIGHT_FLIGHT1_idx` (`FLIGHT_ID` ASC) VISIBLE,
  INDEX `fk_SCHEDULE_has_FLIGHT_SCHEDULE1_idx` (`SCHEDULE_ID` ASC) VISIBLE,
  PRIMARY KEY (`SCHEDULE_ID`, `FLIGHT_ID`),
  CONSTRAINT `fk_SCHEDULE_has_FLIGHT_SCHEDULE1`
    FOREIGN KEY (`SCHEDULE_ID`)
    REFERENCES `ip_aero`.`SCHEDULE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SCHEDULE_has_FLIGHT_FLIGHT1`
    FOREIGN KEY (`FLIGHT_ID`)
    REFERENCES `ip_aero`.`FLIGHT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ip_aero`.`MESSAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ip_aero`.`MESSAGE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Subject` VARCHAR(200) NOT NULL,
  `Content` VARCHAR(1000) NOT NULL,
  `Status` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
