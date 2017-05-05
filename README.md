//# t05veebirakendus

SpringBoot abil loodud loodud näitlik temaatiline veebirakendus

Võimalusel kasutada eraldi klasse teemade grupeerimiseks ning andmebaasiühendust.

TABEL:

CREATE TABLE menyy(id NOT NULL PRIMARY KEY AUTO INCREMENT, toidu_nimetus VARCHAR(50) NOT NULL, toidu_tyyp VARCHAR(30) NOT NULL, hind Double NOT NULL );
INSERT INTO menyy VALUES ('Seapraad', 'praad', '3.20');
INSERT INTO menyy VALUES ('Kanasupp', 'supp', '1.8');
