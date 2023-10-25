drop database solar;
create database solar;
\c solar

drop table client cascade;
drop table module cascade;
drop table modulebatterie cascade;
drop table clientmodule cascade;
drop table typebatterie cascade;
drop table donnees cascade;
drop table panneau cascade;
drop table modulepanneau cascade;
drop table donneemodulebatterie cascade;
drop table donneemodulepanneau cascade;

create table client(
    id serial not null,
    nom varchar(100) not null,
    prenom varchar(100) not null,
    email varchar(100) not null,
    pass varchar(100) not null,
    adresse varchar(100) not null,
    codepostal varchar(100) not null,
    lienimage oid not null,
    haveqr boolean not null default true,
    primary key(id)
);

create table typebatterie(
    id serial not null,
    valeur int not null,
    primary key(id)
);

create table module(
    id serial not null,
    qrcode varchar(100) not null,
    primary key(id)
);

create table clientmodule(
    id serial not null,
    idclient int not null,
    idmodule int not null,
    primary key(id),
    foreign key(idclient) references client(id),
    foreign key(idmodule) references module(id)
);

create table modulebatterie(
    id serial not null,
    idmodule int not null,
    numerobatterie varchar(10) not null,
    idbatterie int not null,
    voltagebatterie real not null,
    valeurbatterie real not null,
    temps timestamp not null,
    primary key(id),
    foreign key(idmodule) references module(id),
    foreign key(idbatterie) references typebatterie(id)
);

create table modulepanneau(
    id serial not null,
    idmodule int not null,
    numeropanneau varchar(10) not null,
    production real not null,
    temps timestamp not null,
    primary key(id),
    foreign key(idmodule) references module(id)
);

create table donnees(
    id serial not null,
    idmodule int not null,
    voltagepanneau real not null,
    voltageoutput real not null,
    voltagebatterie real not null,
    production real not null,
    consommation real not null,
    valeurbatterie real not null,
    temps timestamp not null,
    primary key(id),
    foreign key(idmodule) references module(id)
);