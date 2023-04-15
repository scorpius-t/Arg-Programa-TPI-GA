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