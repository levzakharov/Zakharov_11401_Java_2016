CREATE TABLE barber (
  id         SERIAL PRIMARY KEY,
  first_name VARCHAR(32)        NOT NULL,
  last_name  VARCHAR(32)        NOT NULL,
  email      VARCHAR(32) UNIQUE NOT NULL,
  password   VARCHAR(32)        NOT NULL,
  gender     CHAR CHECK (gender IN ('M', 'F')),
  bdate      DATE               NOT NULL
);

CREATE TABLE barbershop (
  id      SERIAL PRIMARY KEY,
  address VARCHAR(128) UNIQUE NOT NULL,
  phone   VARCHAR(16) UNIQUE  NOT NULL
);

CREATE TABLE barber_barbershop (
  barber_id     INTEGER NOT NULL REFERENCES barber (id),
  barbershop_id INTEGER NOT NULL REFERENCES barbershop (id),
  PRIMARY KEY (barber_id, barbershop_id)
);

CREATE TABLE attendance (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(32) UNIQUE NOT NULL,
  price       VARCHAR(8) NOT NULL
);

