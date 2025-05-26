--TO DO: BIGSERIAL se incrementeaza automat => nu trebuie sa oferim si id ca parametru cand adaugam elemente

CREATE TABLE IF NOT EXISTS graphics_cards (
    id BIGSERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    price FLOAT(30) NOT NULL,
    power integer,
    vRam integer
);

CREATE TABLE IF NOT EXISTS processors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price FLOAT(30) NOT NULL,
    power integer,
    core_number integer,
    frequency FLOAT(20),
    socket VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS storages (
    id BIGSERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    price FLOAT(30) NOT NULL,
    power integer,
    storage integer
);

CREATE TABLE IF NOT EXISTS rams (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price FLOAT(30) NOT NULL,
    power integer,
    memory integer,
    frequency FLOAT(20),
    technology VARCHAR(30)
);

