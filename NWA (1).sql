
CREATE TABLE wizard (
	WIZname 			varchar(60) NOT NULL,
	WIZlevel			int(1),
	WIZspellset			varchar(16),
	WIZhealth			int(3),
	WIZatk				int(6),
	WIZdef				int(6),
	WIZpet				int(6),
	WIZguild			int(6),
	PRIMARY KEY (WIZname),
 	FOREIGN KEY (WIZguild) REFERENCES guild (gID) ON DELETE CASCADE	
);
CREATE TABLE guild (
	'GUILDname'			varchar(20) NOT NULL,
	'GUILDid'			int(6),
	'GUILDwins'			int(6) DEFAULT 0,
	'GUILDlosses'		int(6) DEFAULT 0,
	 FOREIGN KEY ('GUILDid') REFERENCES 'wizard' ('WIZguild') ON DELETE CASCADE,
	 FOREIGN KEY ('GUILDid') REFERENCES 'territory' ('GUILDid') ON DELETE CASCADE,
	 FOREIGN KEY ('GUILDid') REFERENCES 'war' ('WARagressor') ON DELETE CASCADE,
	 FOREIGN KEY ('GUILDid') REFERENCES 'war' ('WARdeffender') ON DELETE CASCADE
);
CREATE TABLE territory (
	'TERRITORYlocation'			varchar(16) NOT NULL,
	'TERRITORYguildowner'		int(6),
	FOREIGN KEY ('TERRITORYguildowner') REFERENCES 'guild' ('GUILDid') ON DELETE CASCADE,
	FOREIGN KEY ('TERRITORYlocation') REFERENCES 'war' ('WARlocation') ON DELETE CASCADE
);
CREATE TABLE war (
	'WARloser'		int(6), 
	'WARwinner'		int(6),
	'WARagressor'	int(6),
	'WARdeffender'	int(6),
	'WARlocation'	varchar(16),
	FOREIGN KEY ('WARlocation') REFERENCES 'territory' ('TERRITORYlocation') ON DELETE CASCADE,
	FOREIGN KEY ('WARagressor') REFERENCES 'guild' ('GUILDid') ON DELETE CASCADE,
	FOREIGN KEY ('WARdeffender') REFERENCES 'guild' ('GUILDid') ON DELETE CASCADE
);
CREATE TABLE pet (
	'PETid' 	int(6) NOT NULL,
    'PETtype' 	varchar(45) DEFAULT NULL,
    'PETname' 	varchar(45) DEFAULT NULL,
    PRIMARY KEY ('PETid'),
    FOREIGN KEY ('PETid') REFERENCES 'wizard' ('WIZpet') ON DELETE CASCADE
);

INSERT INTO wizard VALUES ('Ilmare Tintalle', 				1,		'Fire',			100,	12,		13,		029456,		100001);
INSERT INTO wizard VALUES ('Salmar, Lord of the Valar', 	2,		'Frost',		100,	33,		25,		029457,		100001);
INSERT INTO wizard VALUES ('Pallando Tintalle',			2,		'Electric',		100,	23,		30,			029458,		100001);
INSERT INTO wizard VALUES ('Olorin Tintalle',			3,		'Fire',			100,	46,		40,			029459,		100001);
INSERT INTO wizard VALUES ('Pallando, Lord of the West',	4,		'Frost',		100,	99,		84,		029472,		100002);
INSERT INTO wizard VALUES ('Curunir Stormcrow',			5,		'Fire',			100,	100,	97,			029473,		100002);
INSERT INTO wizard VALUES ('Tharkun Gilthoniel',			4,		'Fire',			100,	100,	100,	029486,		100003);
INSERT INTO wizard VALUES ('Alatar Kementari',			5,		'Electric',		100,	100,	100,		029487,		100003);
INSERT INTO wizard VALUES ('Curumo the Dark Power',		4,		'Fire',			100,	78,		90,			029495,		100004);
INSERT INTO wizard VALUES ('Sharkey, Grey Wanderer',		5,		'Fire',			100,	99,		95,		029496,		100004);
INSERT INTO wizard VALUES ('John Wall',					5,		'Basketball',	100,	100,	100,		029497,		100005);
INSERT INTO wizard VALUES ('Bradley Beal',				4,		'Basketball',	100,	100,	100,		029498,		100005);

INSERT INTO guild VALUES ('Lucky Magicians',		100001,	12,		10);
INSERT INTO guild VALUES ('Raging Warlocks',		100002,	45,		30);
INSERT INTO guild VALUES ('Smilin Killas',		100003,	30,		5);
INSERT INTO guild VALUES ('Respected Bandits',	100004,	12,		25);
INSERT INTO guild VALUES ('Washington Wizards',	100005,	1100,	0);

INSERT INTO pet VALUES (029496, 'Dog', 'Winslow');
INSERT INTO pet VALUES (029473, 'Rat', 'Scabies');

INSERT INTO territory VALUES ('Canada', 100005);
INSERT INTO territory VALUES ('Mexico', 100003);
INSERT INTO territory VALUES ('United States', 100002);

INSERT INTO war VALUES (100002, 100003, 100003, 100002, "Canada");
INSERT INTO war VALUES (100003, 100001, 100001, 100003, "Mexico");
