CREATE DATABASE IF NOT EXISTS polytheque;
USE polytheque;

CREATE TABLE IF NOT EXISTS adherent (
  id_adherent INTEGER NOT NULL AUTO_INCREMENT,
  nom varchar(30) NOT NULL,
  prenom varchar(30) NOT NULL,
  date_naissance DATE NOT NULL,
  rue varchar(50) NOT NULL,
  code_postal char(5) NOT NULL,
  ville varchar(50) NOT NULL,
  mail varchar(50) NOT NULL,
  telephone char(10) NOT NULL,
  pseudo varchar(15) NOT NULL,
  mdp varchar(10) NOT NULL,
  admin BOOLEAN NOT NULL,
  liste_noire BOOLEAN NOT NULL,
  droits BOOLEAN NOT NULL,
  nb_retards INTEGER NOT NULL,
  nb_non_recup INTEGER NOT NULL,
  UNIQUE (pseudo),
  UNIQUE (mdp),
  PRIMARY KEY(id_adherent)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS categorie (
  id_categorie INTEGER NOT NULL AUTO_INCREMENT,
  nom_categorie varchar(30) NOT NULL,
  PRIMARY KEY(id_categorie)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS editeur (
  id_editeur INTEGER NOT NULL AUTO_INCREMENT,
  nom_editeur varchar(30) NOT NULL,
  PRIMARY KEY(id_editeur)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS jeu (
  id_jeu INTEGER NOT NULL AUTO_INCREMENT,
  nom varchar(30) NOT NULL,
  description varchar(300),
  annee_parution char(4),
  statut varchar(20) NOT NULL,
  nb_exemplaires INTEGER,
  nb_reserves INTEGER,
  age_mini INTEGER,
  nb_joueurs_min INTEGER,
  nbjoueurs_max INTEGER,
  id_categorie INTEGER,
  id_editeur INTEGER,
  PRIMARY KEY(id_jeu),
  FOREIGN KEY (id_categorie) REFERENCES categorie (id_categorie) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_editeur) REFERENCES editeur (id_editeur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS extension (
  id_extension INTEGER NOT NULL AUTO_INCREMENT,
  nom varchar(30) NOT NULL,
  description varchar(300),
  statut varchar(20) NOT NULL,
  nb_exemplaires INTEGER,
  nb_reserves INTEGER,
  id_jeu INTEGER NOT NULL,
  PRIMARY KEY(id_extension),
  FOREIGN KEY (id_jeu) REFERENCES jeu (id_jeu) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS reservation (
  id_reservation INTEGER NOT NULL AUTO_INCREMENT,
  date_reservation DATE NOT NULL,
  id_adherent INTEGER NOT NULL,
  id_jeu INTEGER,
  id_extension INTEGER,
  PRIMARY KEY(id_reservation),
  FOREIGN KEY (id_adherent) REFERENCES adherent (id_adherent) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_jeu) REFERENCES jeu (id_jeu) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_extension) REFERENCES extension (id_extension) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS emprunt (
  id_emprunt INTEGER NOT NULL AUTO_INCREMENT,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  date_rendu DATE NOT NULL,
  id_reservation INTEGER,
  id_adherent INTEGER NOT NULL,
  id_jeu INTEGER,
  id_extension INTEGER,
  PRIMARY KEY(id_emprunt),
  FOREIGN KEY (id_reservation) REFERENCES reservation (id_reservation) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_adherent) REFERENCES adherent (id_adherent) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_jeu) REFERENCES jeu (id_jeu) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_extension) REFERENCES extension (id_extension) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

/* Instertion des éditeurs */
INSERT INTO EDITEUR (nom_editeur) VALUES ('AEG');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ajax Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Amigo');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ankama Products');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Argentum Verlag');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Asmodee');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Asynchron');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Avalon Hill');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Black Book Edition');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Blue Orange');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Bombyx');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Cocktail Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Czech board games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Days of wonder');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Devil Pig');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Dujardin');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Eagle Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Edge entertainment');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Euro Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ferti');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Filosofia');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Games Workshop');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Gameworks');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Geek Attitude Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Gigamic');
INSERT INTO EDITEUR (nom_editeur) VALUES ('GMT games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Goliath');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Guillotine Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Hans im Glück');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Hasbro');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Hutch & friends');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Iello');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Indie Board & Game');
INSERT INTO EDITEUR (nom_editeur) VALUES ('International team');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Intrafin');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Irongames');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Jeux Descartes');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Kosmos');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Krok Nik Douil');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Lauring Verlag');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Libellud');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ludically');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ludodélire');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ludonaute');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Lui-même');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Marabunta');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Matagot');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Mattel');
INSERT INTO EDITEUR (nom_editeur) VALUES ('MB');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Miro');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Morning Players');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Paizo Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Parker');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Pearl Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Queen Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Quined Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Rallyman');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ravensburger');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Repos Prod');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Runes Edition');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Schmidt international');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Sit-down');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Smart Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('SpaceCowboy');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Steve Jackson Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Super Meeple');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Tilsit');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Treefrog Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('White Goblin Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Winning Moves');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Wizkids/Intrafin');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Ystari Games');
INSERT INTO EDITEUR (nom_editeur) VALUES ('Zman Games');

/* Insertion des catégories */

