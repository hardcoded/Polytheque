CREATE DATABASE IF NOT EXISTS polytheque CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE polytheque;

CREATE TABLE IF NOT EXISTS adherent (
  id_adherent INTEGER NOT NULL PRIMARY KEY,
  nom varchar(30) NOT NULL,
  prenom varchar(30) NOT NULL,
  rue varchar(50) NOT NULL,
  code_postal char(5) NOT NULL,
  ville varchar(50) NOT NULL,
  mail varchar(50) NOT NULL,
  telephone char(10) NOT NULL,
  pseudo varchar(15) NOT NULL,
  mdp varchar(10) NOT NULL,
  admin BOOLEAN NULL,
  liste_noire BOOLEAN NULL,
  droits BOOLEAN NULL,
  nb_retards INTEGER NULL,
  nb_non_recup INTEGER NULL,
  UNIQUE (pseudo),
  UNIQUE (mdp)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS jeu (
  id_jeu INTEGER NOT NULL PRIMARY KEY,
  nom varchar(30) NOT NULL,
  description varchar(300) NULL,
  annee_parution char(4) NULL,
  statut varchar(20) NOT NULL,
  nb_exemplaires INTEGER NULL,
  nb_reserves INTEGER NULL,
  age_mini INTEGER NOT NULL,
  nombre_joueurs INTEGER NULL,
  FOREIGN KEY (id_categorie) REFERENCES categorie_jeu (id_categorie) ON DELETE CASCADE ON UPDATE CASCADE
  FOREIGN KEY (id_editeur) REFERENCES editeur_jeu (id_editeur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS categorie_jeu (
  id_categorie INT NOT NULL PRIMARY KEY,
  nom_categorie varchar(30) NOT NULL
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS editeur_jeu (
  id_editeur INT NOT NULL PRIMARY KEY,
  nom_editeur varchar(30) NOT NULL
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS extension (
  id_extension INTEGER NOT NULL PRIMARY KEY,
  nom varchar(30) NOT NULL,
  description varchar(300) NULL,
  statut varchar(20) NOT NULL,
  nb_exemplaires INTEGER NULL,
  nb_reserves INTEGER NULL,
  id_jeu INTEGER NOT NULL,
  FOREIGN KEY (id_jeu) REFERENCES jeu (id_jeu) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS reservation (
  id_reservation INTEGER NOT NULL PRIMARY KEY,
  DATE_reservation DATE NULL,
  id_adherent INTEGER NOT NULL,
  FOREIGN KEY (id_adherent) REFERENCES adherent (id_adherent) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS emprunt (
  id_emprunt INTEGER NOT NULL PRIMARY KEY,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  date_rendu DATE NOT NULL,
  id_reservation INTEGER NOT NULL,
  FOREIGN KEY (id_reservation) REFERENCES reservation (id_reservation) ON DELETE CASCADE ON UPDATE CASCADE;
) ENGINE=InnoDB CHARSET=utf8;
