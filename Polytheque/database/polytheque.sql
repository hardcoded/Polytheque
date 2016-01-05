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
  age_mini INTEGER NOT NULL,
  nombre_joueurs INTEGER,
  id_categorie INTEGER NOT NULL,
  id_editeur INTEGER NOT NULL,
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
