CREATE TABLE IF NOT EXISTS bank_clients (
        id BIGSERIAL PRIMARY KEY,
        name varchar(50) NOT NULL,
        address varchar(100) NOT NULL,
        active_status boolean NOT NULL
);

CREATE TABLE bank_accounts (
       id BIGSERIAL PRIMARY KEY,
       name VARCHAR(100),
       balance FLOAT(30),
       active_status BOOLEAN,
       client_id BIGINT,
       FOREIGN KEY (client_id) REFERENCES bank_clients(id)
);
