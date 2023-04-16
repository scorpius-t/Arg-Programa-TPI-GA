use TPI_ArgProg_GA

create table pronosticos(
numeroApuesta int primary key,
apostador varchar(50) not null,
equipoL varchar(50) not null,
golesL varchar(3) not null,
equipoV varchar(50) not null,
golesV varchar(3) not null,
)
go

insert into pronosticos (numeroApuesta,apostador,equipoL,golesL,equipoV,golesV) 
values
(1,'Mariana','Argentina',2,'ArabiaSaudita',0),
(2,'Mariana','Polonia',1,'Mexico',1),
(3,'Mariana','Argentina',1,'Mexico',0),
(4,'Mariana','ArabiaSaudita',0,'Polonia',2),
(5,'Pedro','Argentina',0,'ArabiaSaudita',2),
(6,'Pedro','Polonia',1,'Mexico',2),
(7,'Pedro','Argentina',4,'Mexico',0),
(8,'Pedro','ArabiaSaudita',3,'Polonia',2),
(9,'Juancho','Platense',3,'Barcelona',2),
(10,'Juanita','Argentina',1,'ArabiaSaudita',2),
(11,'Juanita','Polonia',0,'Mexico',0),
(12,'Juanita','Argentina',2,'Mexico',0),
(13,'Juanita','ArabiaSaudita',0,'Polonia',2)
go

select * from pronosticos


insert into pronosticos (numeroApuesta,apostador,equipoL,golesL,equipoV,golesV) 
values
(14,'Alberto','Argentina',2,'ArabiaSaudita',0)

insert into pronosticos (numeroApuesta,apostador,equipoL,golesL,equipoV,golesV) 
values
(15,'Juanita','Alemania',1,'Japon',2),
(16,'Juanita','España',7,'CostaRica',0),
(17,'Juanita','Japon',0,'CostaRica',1),
(18,'Juanita','España',1,'Alemania',1),
(19,'Mariana','Alemania',3,'Japon',1),
(20,'Mariana','España',3,'CostaRica',0),
(21,'Mariana','Japon',3,'CostaRica',1),
(22,'Mariana','España',1,'Alemania',4),
(23,'Pedro','Alemania',2,'Japon',2),
(24,'Pedro','España',1,'CostaRica',1),
(25,'Pedro','Japon',0,'CostaRica',1),
(26,'Pedro','España',0,'Alemania',0)
go