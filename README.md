# t05veebirakendus

SpringBoot abil loodud loodud näitlik temaatiline veebirakendus

Võimalusel kasutada eraldi klasse teemade grupeerimiseks ning andmebaasiühendust.


CREATE TABLE rattad(
	model VARCHAR(50) NOT NULL PRIMARY KEY,
	brand VARCHAR(30) NOT NULL,
	price INT NOT NULL
);
INSERT INTO rattad VALUES ('WTP', 'Justyce', '420');
INSERT INTO rattad VALUES ('Shadow', 'Raptor', '500');
INSERT INTO rattad VALUES ('Eclat', 'Mirage', '540');
