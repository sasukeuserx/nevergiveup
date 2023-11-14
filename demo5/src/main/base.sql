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
drop table modulewifi cascade;

create table typebatterie(
    id serial not null,
    valeur int not null,
    primary key(id)
);

insert into typebatterie(valeur) values (12);
insert into typebatterie(valeur) values (24);

create table module(
    id serial not null,
    qrcode varchar(100) not null default 'qrcode',
    nommodule varchar(100) not null default 'module1',
    idbatterie int not null default 1,
    ssidESP varchar(100) not null,
    passwordESP varchar(100) not null,
    ssid varchar(100) not null default 'null',
    password varchar(100) not null default 'null',
    state boolean not null default false,
    primary key(id),
    foreign key(idbatterie) references typebatterie(id)
);

insert into module(qrcode,nommodule,idbatterie,ssidESP,passwordESP) values ('qrcode','module1',1,'Module1','mdp1');

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
    idmodule int not null,
    primary key(id),
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

create or replace view vclientmodule as
select m.id idmodule,m.qrcode,m.nommodule,m.idbatterie,m.ssidESP,m.passwordESP,m.ssid,m.password,c.id idclient from client c
join module m on c.idmodule = m.id;

insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps)
values (1,1,1,1,1,1,1,'2023-11-14 12:00:00');
insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps)
values (1,1,1,1,1,1,1,'2023-11-14 13:00:00');
insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps)
values (1,1,1,1,1,1,1,'2023-11-14 14:00:00');
insert into donnees(idmodule,voltagepanneau,voltageoutput,voltagebatterie,production,consommation,valeurbatterie,temps)
values (1,1,1,1,1,1,1,'2023-11-13 12:00:00');

create or replace view vdatatodaydate as
SELECT *
FROM donnees
WHERE DATE(temps) = CURRENT_DATE;