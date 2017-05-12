package ksenbelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mangud2")
public class mangudenimekiri{
    @Id
    public String title;
    public int year;
	public int cost;
}

/*

CREATE TABLE mangud2(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50),
	year INT,
	cost INT
);

INSERT INTO mangud2 VALUES ('','The Sims 4', '2014', '40');
INSERT INTO mangud2 VALUES ('','The Sims 3', '2009', '20');
INSERT INTO mangud2 VALUES ('','Batlefield 1', '2016', '60');

+----+--------------+------+------+
| id | title        | year | cost |
+----+--------------+------+------+
|  1 | The Sims 4   | 2014 |   40 |
|  2 | The Sims 3   | 2009 |   20 |
|  3 | Batlefield 1 | 2016 |   60 |
+----+--------------+------+------+


mysql -uif16 -pifikad16 if16_ksenbelo_4
*/