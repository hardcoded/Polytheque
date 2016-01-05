/* Création de la BDD */
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
  nb_joueurs_max INTEGER,
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

/* Insertion adhérents */
INSERT INTO ADHERENT (nom, prenom, date_naissance, rue, code_postal, ville, mail, telephone, pseudo, mdp, admin, liste_noire, droits, nb_retards, nb_non_recup) VALUES ("Brunet","Johan","1995-08-23","rue","00000","ville","mail","0000000000","johan","brunet",true,false,true,0,0);
INSERT INTO ADHERENT (nom, prenom, date_naissance, rue, code_postal, ville, mail, telephone, pseudo, mdp, admin, liste_noire, droits, nb_retards, nb_non_recup) VALUES ("Agbodjogbe","Yves-Alain","1995-08-23","rue","00000","ville","mail","0000000000","blackhole","cacao",true,false,true,0,0);
INSERT INTO ADHERENT (nom, prenom, date_naissance, rue, code_postal, ville, mail, telephone, pseudo, mdp, admin, liste_noire, droits, nb_retards, nb_non_recup) VALUES ("Roussel","Godefroi","1995-08-23","rue","00000","ville","mail","0000000000","godefroi","roussel",true,false,true,0,0);
INSERT INTO ADHERENT (nom, prenom, date_naissance, rue, code_postal, ville, mail, telephone, pseudo, mdp, admin, liste_noire, droits, nb_retards, nb_non_recup) VALUES ("Marchal","Laure","1995-08-23","rue","00000","ville","mail","0000000000","laure","marchal",false,false,true,0,0);
INSERT INTO ADHERENT (nom, prenom, date_naissance, rue, code_postal, ville, mail, telephone, pseudo, mdp, admin, liste_noire, droits, nb_retards, nb_non_recup) VALUES ("Lee","San Wei","1995-08-23","rue","00000","ville","mail","0000000000","sanwei","lee",false,false,true,0,0);

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

/* Insertion des jeux */
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("1000 Bornes","1954","OK",0,0,8,2,6,16);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("1775, la Révolution Américaine !","2013","OK",0,0,12,14,14,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("6 qui prend !","2009","OK",0,0,10,2,10,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("7 Wonders","2010","OK",0,0,14,2,10,59);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("A Few Acres of Snow","2011","OK",0,0,13,2,2,68);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Abalone","1989","OK",0,0,null,null,null,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Abyss","2014","OK",0,0,14,2,4,11);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Advanced Heroquest","1989","OK",0,0,14,1,5,22);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Agricola","2008","OK",0,0,12,1,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Agricola Terres d'élevage","2012","OK",0,0,12,2,2,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Amytis","2007","OK",0,0,10,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Anaconda","2009","OK",0,0,7,1,1,63);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Anti-virus","2009","OK",0,0,7,1,1,63);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Armada","1986","OK",0,0,10,2,4,37);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Art Moderne","2009","OK",0,0,8,3,5,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Assyria","2009","OK",0,0,12,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Automobile","2010","OK",0,0,12,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Ave Caesar","1989","OK",0,0,12,3,6,58);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Awele",null,"OK",0,0,2,2,null,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Backgammon",null,"OK",0,0,2,2,null,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Barony","2015","OK",0,0,14,2,4,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Bazaar","1967","OK",0,0,12,2,6,61);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Boomerang","2010","OK",0,0,8,3,5,45);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Brass","2007","OK",0,0,13,3,4,69);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Bruxelles 1893","2013","OK",0,0,14,2,5,54);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cacao","2015","OK",0,0,8,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cant Stop!","2006","OK",0,0,7,2,4,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Capital Power","1981","OK",0,0,13,3,4,34);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Carcassonne - Die Jäger und Sammler","2002","OK",0,0,8,2,5,29);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cargo Noir","2011","OK",0,0,8,2,5,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Carrom",null,"OK",0,0,2,2,null,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Carson City","2009","OK",0,0,12,2,5,69);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Caverna","2013","OK",0,0,12,1,7,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Caylus","2012","OK",0,0,12,2,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Chinatown","2008","OK",0,0,12,3,5,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Citadelles","2000","OK",0,0,14,3,7,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Civilization","1982","OK",0,0,12,2,7,8);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Clash of Cultures","2012","OK",0,0,12,2,4,73);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Claustrophobia","2009","OK",0,0,14,2,2,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cluedo","1974","OK",0,0,8,2,6,53);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("CoH: Le Réveil de l'Ours","2012","OK",0,0,14,2,2,7);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Colt Express","2014","OK",0,0,10,2,6,44);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Concept","2013","OK",0,0,10,4,12,59);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Conquest of the Empire","2005","OK",0,0,10,2,6,17);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Contrario","2001","OK",0,0,12,3,10,12);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cry Havoc","1981","OK",0,0,12,2,2,19);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Cyclades","2012","OK",0,0,10,2,5,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("De Vulgari Eloquentia","2010","OK",0,0,14,2,5,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Descendance","2011","OK",0,0,12,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Descent : voyage dans les ténèbres","2006","OK",0,0,null,null,null,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Descent : Voyages dans les Ténèbres ! (Seconde Edition)","2012","OK",0,0,null,null,null,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Desperado of Dice Town","2014","OK",0,0,8,2,4,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Deus","2014","OK",0,0,12,2,4,54);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Diplomatie","1976","OK",0,0,12,4,7,50);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Discoveries","2015","OK",0,0,14,2,4,44);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dobble","2010","OK",0,0,6,2,8,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dominant Species","2012","OK",0,0,12,2,6,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dominion","2008","OK",0,0,8,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dominion l'Intrigue","2009","OK",0,0,8,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dune","1979","OK",0,0,12,2,6,8);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Dungeon Lords","2010","OK",0,0,12,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Earth Reborn","2010","OK",0,0,10,2,4,42);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Eclipse","2011","OK",0,0,12,2,6,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Endeavor","2009","OK",0,0,12,3,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Essen the game","2014","OK",0,0,10,2,4,24);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Euphoria","2014","OK",0,0,13,2,6,51);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Evo","2011","OK",0,0,14,2,5,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Fief","1983","OK",0,0,10,2,6,34);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Fief (nouvelle édition)","2011","OK",0,0,12,3,6,7);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Five Tribes","2014","OK",0,0,13,2,4,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Formule Dé","1991","OK",0,0,12,2,10,43);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Fresco","2010","OK",0,0,10,2,4,55);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Galaxy Trucker : édition anniversaire","2013","OK",0,0,10,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Gear of war","2011","OK",0,0,13,1,4,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Ghost Stories","2008","OK",0,0,10,1,4,59);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Goa","2010","OK",0,0,12,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Gueules noires","2013","OK",0,0,10,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Heroes of Normandie","2014","OK",0,0,10,2,2,15);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Himalaya","2004","OK",0,0,12,3,4,67);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Hyperborea","2014","OK",0,0,12,2,6,46);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Identik","2009","OK",0,0,8,3,null,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Infarkt","2011","OK",0,0,10,2,5,13);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Jeu des cochons","1977","OK",0,0,7,2,6,70);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Jungle Speed","1997","OK",0,0,7,3,7,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Junta","1979","OK",0,0,14,2,7,37);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Kahuna","1998","OK",0,0,10,2,2,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Kezako","2007","OK",0,0,10,4,8,12);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("King and Assassins","2013","OK",0,0,10,2,2,60);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("King of TOKyo","2011","OK",0,0,8,2,6,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Krosmaster Arena","2012","OK",0,0,12,2,4,4);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("L'Aventurier","2012","OK",0,0,7,1,1,63);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("L'Île interdite","2010","OK",0,0,10,2,4,12);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("La bataille des cinq armées","2014","OK",0,0,13,2,2,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("La Gloire de Rome","2011","OK",0,0,12,2,5,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("La Granja","2015","OK",0,0,12,1,4,54);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("La Guerre de l'Anneau","2004","OK",0,0,10,2,4,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("La Vallée des Mammouths","1991","OK",0,0,12,2,6,43);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("L'Âge de Pierre","2008","OK",0,0,10,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Lancaster","2011","OK",0,0,10,2,5,55);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Le Lièvre et la Tortue","2000","OK",0,0,8,2,6,58);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Le Seigneur des Anneaux JCE","2011","OK",0,0,13,1,4,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Le Tapis Volant","1987","OK",0,0,10,3,6,58);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Lemming Mafia","2010","OK",0,0,8,3,6,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les aventuriers du Rail : 10th anniversary","2014","OK",0,0,8,2,5,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Bâtisseurs","2013","OK",0,0,10,2,4,11);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Chevaliers de la Table Ronde","2005","OK",0,0,10,3,7,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Colons de Catane","1997","OK",0,0,10,3,4,19);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Colons de Catane - Le Jeu de Cartes","1999","OK",0,0,12,2,2,38);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Demeures de l'épouvante","2011","OK",0,0,12,2,5,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Loups-Garous de Thiercelieux","2001","OK",0,0,8,8,18,45);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Pingouins Patineurs","2011","OK",0,0,6,1,1,63);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Les Princes de Florence","2007","OK",0,0,12,2,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Lewis & Clark","2013","OK",0,0,14,1,5,44);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Long Horn","2013","OK",0,0,8,2,2,10);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Loony quest","2014","OK",0,0,8,2,5,41);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Lords of Xidit","2014","OK",0,0,14,3,5,41);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mémoire 44","2004","OK",0,0,8,2,2,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mafia de Cuba","2015","OK",0,0,10,6,12,45);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mage Knight","2011","OK",0,0,14,1,4,71);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Maka Bana","2003","OK",0,0,10,2,5,67);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Marble Monster","2012","OK",0,0,6,1,1,31);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Marrakech","2007","OK",0,0,6,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mars Attacks","2014","OK",0,0,14,2,2,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Massillia","2014","OK",0,0,12,2,4,56);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Medina","2001","OK",0,0,10,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Megawatts","2008","OK",0,0,14,2,6,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Megawatts : Les Premières étincelles","2012","OK",0,0,14,2,6,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mexica","2014","OK",0,0,14,2,4,66);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Monopoly","1935","OK",0,0,8,2,8,53);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Munchkin","2004","OK",0,0,10,3,6,65);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Myrmes","2012","OK",0,0,12,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mystérami - Jack L'éventreur","2010","OK",0,0,8,2,4,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Mysterium","2015","OK",0,0,10,2,7,41);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Niagara","2004","OK",0,0,8,3,5,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Norenberc","2010","OK",0,0,12,2,5,69);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Olympos","2011","OK",0,0,10,2,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Onirim","2011","OK",0,0,8,1,2,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Opération Commando: Pegasus Bridge","2014","OK",0,0,10,2,2,2);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pandémie","2008","OK",0,0,10,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pandémie contagion","2014","OK",0,0,14,2,5,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pathfinder","2010","OK",0,0,null,null,null,52);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pathfinder le jeu de carte","2014","OK",0,0,null,null,null,9);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Peloponnes","2009","OK",0,0,10,1,5,36);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pergamon","2011","OK",0,0,10,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Perplexus","2009","OK",0,0,6,1,1,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Perplexus Epic","2011","OK",0,0,6,1,1,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Perudo","2003","OK",0,0,8,2,6,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pictionary","1993","OK",0,0,8,3,16,49);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pique Plume","1998","OK",0,0,4,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Pix","2012","OK",0,0,8,4,9,23);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Planet Steam","2014","OK",0,0,14,2,5,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Puerto Rico","2002","OK",0,0,null,null,null,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Quarriors","2013","OK",0,0,14,2,4,35);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Quarto!","1991","OK",0,0,8,2,2,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Qui est-ce ?","2005","OK",0,0,6,2,2,30);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Quoridor","1997","OK",0,0,6,2,4,null);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Rallyman : Dirt","2011","OK",0,0,9,1,4,57);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Rallyman Asphalte et Neige","2009","OK",0,0,9,1,4,57);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Rasende Roboter","1999","OK",0,0,10,2,10,29);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Ringgeister","1993","OK",0,0,10,2,4,40);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Risk Napoléon","2000","OK",0,0,12,2,5,53);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("River Dragons","2012","OK",0,0,8,2,6,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Roborally","2006","OK",0,0,12,2,8,8);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Rockwell","2013","OK",0,0,14,2,4,62);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Rummikub Chiffres","1980","OK",0,0,8,2,4,49);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Russian Railroads","2013","OK",0,0,12,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Saboteur : Les mineurs contre-attaquent !","2011","OK",0,0,8,3,10,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Saint Petersburg","2004","OK",0,0,13,2,5,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("San Juan","2008","OK",0,0,10,2,4,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Scrabble","1931","OK",0,0,10,2,4,48);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Seasons","2012","OK",0,0,10,2,4,41);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Serenissima","2013","OK",0,0,13,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Sherlock Holmes - Détective Conseil","2011","OK",0,0,12,1,null,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Siege","1983","OK",0,0,14,2,2,19);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Skull & Roses","2011","OK",0,0,10,3,6,45);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Small world","2009","OK",0,0,8,2,5,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Small world underground","2011","OK",0,0,8,2,5,14);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Smash Up","2012","OK",0,0,12,2,4,1);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Snowdonia","2013","OK",0,0,10,1,5,33);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Splendor","2014","OK",0,0,10,2,4,64);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Spyrium","2013","OK",0,0,13,2,5,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Star Wars : X-Wing ","2012","OK",0,0,12,2,2,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Star Wars : X-Wing Le réveil de la force","2015","OK",0,0,12,2,2,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Star Wars: Assaut sur l'Empire","2015","OK",0,0,12,2,5,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Steam","2009","OK",0,0,12,3,6,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Sushi Bar","2008","OK",0,0,8,3,5,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Sylla","2008","OK",0,0,12,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Taken","2011","OK",0,0,8,2,4,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Taluva","2006","OK",0,0,10,2,4,29);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Targui","2013","OK",0,0,12,2,2,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Tempête sur l'échiquier","1991","OK",0,0,8,2,2,43);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Terra Mystica","2013","OK",0,0,12,2,5,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("The City","2012","OK",0,0,10,2,5,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("The Island","2012","OK",0,0,8,2,4,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("The Manhattan Project","2014","OK",0,0,14,2,5,46);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Through the Ages","2008","OK",0,0,12,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Thunderstone","2011","OK",0,0,12,2,5,18);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Tigre et Euphrate","2009","OK",0,0,12,2,4,47);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Tikal","2005","OK",0,0,12,2,4,67);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Time's Up ! - édition verte","2011","OK",0,0,12,4,12,59);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Timeline","2010","OK",0,0,8,2,8,6);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Titanic","2008","OK",0,0,8,1,1,63);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Tournay","2011","OK",0,0,12,2,4,54);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Trifouilli","2013","OK",0,0,5,2,4,25);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Triominos de Luxe","1990","OK",0,0,6,1,4,27);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Twilight Struggle","2005","OK",0,0,14,2,2,26);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Twin It !","2011","OK",0,0,5,1,1,12);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Tzolk'in","2012","OK",0,0,13,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Union Pacific","1998","OK",0,0,10,2,6,3);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Uno","1992","OK",0,0,7,2,10,48);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Vanuatu","2011","OK",0,0,12,2,5,39);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Vendredi","2011","OK",0,0,10,1,1,21);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Vinci","1999","OK",0,0,14,2,6,37);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Yggdrasil","2011","OK",0,0,13,1,6,44);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Yokai No Mori","2013","OK",0,0,7,2,2,20);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Ys","2008","OK",0,0,12,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Yspahan","2006","OK",0,0,8,2,4,72);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Yunnan","2012","OK",0,0,12,2,5,5);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Zargo's Lords","1981","OK",0,0,15,2,4,34);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Zombicide","2012","OK",0,0,13,1,6,28);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Zombie 15'","2014","OK",0,0,14,2,4,32);
INSERT INTO JEU (nom, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nb_joueurs_min, nb_joueurs_max, id_editeur) VALUES ("Zombie Dice","2012","OK",0,0,14,2,8,65);
