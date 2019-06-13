DROP DATABASE moviestore;
CREATE DATABASE moviestore;

create table if not exists person
(
	identification varchar(20) not null,
	type_identification varchar(2) not null,
	first_name varchar(60) not null,
	last_name varchar(60) not null,
	phone varchar(12) not null,
	years integer not null,
	address varchar(100),
	email varchar(300),
	constraint pk_person_identification_type
		primary key (identification, type_identification)
);


create table if not exists rol
(
	id integer  auto_increment not null primary key,
	name varchar(15) not null,
	description varchar(300),
	state smallint
);


create table if not exists account
(
	id integer  auto_increment not null primary key,
	username varchar(15) not null,
	password varchar(15) not null,
	avatar text,
	state smallint,
	person_id varchar(20) not null,
	person_type varchar(2) not null,
	rol integer references rol(id),
	constraint account_person_id_fkey
		foreign key (person_id, person_type) references person(identification, type_identification)
);



create table if not exists movie
(
	id integer  auto_increment not null primary key,
	name varchar(100) not null,
	description varchar(1000) not null,
	gender varchar(60) not null,
	director varchar(300) not null,
	stars smallint not null,
	time integer not null,
	avatar text not null,
	background text not null,
	price bigint not null
);



create table if not exists stock
(
id integer  auto_increment not null primary key,
	movie integer not null references movie(id),
	state smallint,
	creation_date timestamp default now()
);


create table if not exists rental
(
id integer  auto_increment not null primary key,
	stock integer references stock(id),
	init_date timestamp default now(),
	end_date timestamp not null,
	delivery_date timestamp,
	price bigint not null,
	account integer references account(id)
);


create table if not exists arrear
(
	id integer  auto_increment not null primary key,
	rental integer references rental(id),
	date timestamp default now(),
	value bigint not null,
	state smallint not null
);

