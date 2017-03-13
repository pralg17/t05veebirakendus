Tegu on autoomanike andmebaasiga:
Veebirakendus näitab, mis auto on kasutajal.
Kirjutades aadressireale
http://localhost:5555/uuring?knimi=Mati
kuvatakse omanik, auto mark, mudel, aasta väljalase, võimsus, läbisõit
Mati auto: Volvo S40 2007a. 120kW 356029km

Saab ka läbisõitu uuendada, kirjutades aadressireale http://localhost:5555/lisamine?knimi=Mati&teekond=100
Mati auto: Volvo S40 2007a. 120kW 356129km



CREATE TABLE autod(
omanik VARCHAR(50) NOT NULL PRIMARY KEY,
mark VARCHAR(50) NOT NULL,
mudel VARCHAR(50) NOT NULL,
aasta INT NOT NULL,
voimsus INT NOT NULL,
);

INSERT INTO autod VALUES ('Mati', 'Volvo', 'S40', '2007', '120kW');
INSERT INTO autod VALUES ('Kalle', 'Ford', 'Focus', '2002', '81kW');


ALTER TABLE autod
ADD labisoit INT NOT NULL;

INSERT INTO autod VALUES ('Juhan', 'BMW', 'X6', '2013', '320kW', '65892');
