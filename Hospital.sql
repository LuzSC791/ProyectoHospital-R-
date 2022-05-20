create database prueba;
use prueba;

create table hospital
(
	id_hospital int primary key auto_increment,
    numero_hospital int,
    nombre_hospital varchar(50),
    direccion_hospital text,
    telefono_hospital varchar(12),
    tipo_hospital varchar(10)
);

create table area
(
	id_area int primary key auto_increment,
    nombre_area varchar(50),
    telefono_area varchar(12)
);

create table historial 
(
	id_historial int primary key auto_increment,
    tipo_enfermedad varchar(50),
    descripcion text,
    entrada datetime,
    salida datetime
);

create table paciente
(
	id_paciente int primary key auto_increment,
    nombre_paciente varchar(25),
	aPaterno_paciente varchar(25),
    aMaterno_paciente varchar(25),
    sexo_paciente varchar(1),
    edad_paciente int,
    telefono_paciente varchar(12),
    direccion_paciente text,
    id_hospital int,
    id_historial int,
    foreign key(id_hospital) references hospital (id_hospital) on update cascade on delete cascade,
    foreign key(id_historial) references historial (id_historial) on update cascade on delete cascade
);

create table doctor
(
	id_doctor int primary key auto_increment,
	nombre_doctor varchar(25),
	aPaterno_doctor varchar(25),
	aMaterno_doctor varchar(25),
    sexo_doctor varchar(1),
    edad_doctor int,
	telefono_doctor varchar(12),
	direccion_doctor text,
	correo_doctor varchar(35),
	sueldo double,
    id_hospital int,
    id_area int,
    foreign key(id_hospital) references hospital (id_hospital) on update cascade on delete cascade,
    foreign key(id_area) references area (id_area) on update cascade on delete cascade
);

create table enfermero
(
	id_enfermero int primary key auto_increment,
    nombre_enfermero varchar(25),
	aPaterno_enfermero varchar(25),
    aMaterno_enfermero varchar(25),
    sexo_enfermero varchar(1),
    edad_enfermero int,
    telefono_enfermero varchar(12),
    direccion_enfermero text,
    correo_enfermero varchar(35),
    tipo_enfermero varchar(25),
    sueldo double,
    id_hospital int,
    id_area int,
    foreign key(id_hospital) references hospital (id_hospital) on update cascade on delete cascade,
    foreign key(id_area) references area (id_area) on update cascade on delete cascade
);

drop table paciente;

drop database hospital;

use hospital;
show tables;
select * from doctor;
select * from enfermero;
select * from area;
select * from paciente;
select * from hospital;
select * from historial;

insert into historial values (1,'Cancer','Presenta dolor de cabeza','01/01/21','12/02/21');
insert into hospital values (1,180,'Guadalupana','av.solidaridad cp.56616, estado de mexico','5520134978','Publico');
insert into paciente values (1,'Faustino','Hernadez','Perez','M',2,'5561352465','av.lopez mateos cp.56616, estado de mexico',1,1);
insert into area values(1,'Cancerología','5520760312');
insert into doctor values (1,'Federico','Carranza','Ramirez','M',30,'5561122465','av.Cuahutemoc cp.56615, estado de mexico','fede_96@gmail.com',17000,1,1);
insert into enfermero values (1,'Petra','Castro','Dominguez','F',25,'5512352465','av.Del mazo cp.56615, estado de mexico','petrita5000@hotmail.com','General',9000,1,1);

create database prueba;
use prueba;

create table areas
(
	idArea int primary key auto_increment,
    nombreArea varchar(50),
    telefonoArea varchar(12)
);

create table historiales
(
	idHistorial int primary key auto_increment,
    tipoEnfermedad varchar(50),
    descripcion text,
    entrada datetime,
    salida datetime
);

create table hospitales
(
	idHospital int primary key auto_increment,
    numeroHospital int,
    nombrHospital varchar(50),
    direccionHospital text,
    telefonoHospital varchar(12),
    tipoHospital varchar(10)
);

create table pacientes
(
	idPaciente int primary key auto_increment,
    nombrePaciente varchar(25),
	aPaternoPaciente varchar(25),
    aMaternoPaciente varchar(25),
    sexoPaciente varchar(1),
    edadPaciente int,
    telefonoaciente varchar(12),
    direccionPaciente text,
    idHospital int,
    idHistorial int,
    foreign key(idHospital) references hospitales (idHospital) on update cascade on delete cascade,
    foreign key(idHistorial) references historiales (idHistorial) on update cascade on delete cascade
);

create table doctores
(
	idDoctor int primary key auto_increment,
	nombreDoctor varchar(25),
	aPaternoDoctor varchar(25),
	aMaternoDoctor varchar(25),
    sexoDoctor varchar(1),
    edadDoctor int,
	telefonoDoctor varchar(12),
	direccionDoctor text,
	correoDoctor varchar(35),
	sueldoDoctor double,
    idHospital int,
    idArea int,
    foreign key(idHospital) references hospitales (idHospital) on update cascade on delete cascade,
    foreign key(idArea) references areas (idArea) on update cascade on delete cascade
);

create table enfermeros
(
	idEnfermero int primary key auto_increment,
    nombreEnfermero varchar(25),
	aPaternoEnfermero varchar(25),
    aMaternoEnfermero varchar(25),
    sexoEnfermero varchar(1),
    edadEnfermero int,
    telefonoEnfermero varchar(12),
    direccionEnfermero text,
    correoEnfermero varchar(35),
    tipoEnfermero varchar(25),
    sueldoEnfermero double,
    idHospital int,
    idArea int,
    foreign key(idHospital) references hospitales (idHospital) on update cascade on delete cascade,
    foreign key(idArea) references areas (idArea) on update cascade on delete cascade
);

    


