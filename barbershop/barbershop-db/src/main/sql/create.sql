CREATE TABLE credential (
  id       SERIAL PRIMARY KEY,
  login    VARCHAR(32) UNIQUE NOT NULL,
  password VARCHAR(32)        NOT NULL,
  role     VARCHAR(16)        NOT NULL,
  CONSTRAINT check_role CHECK (role IN ('ROLE_ADMIN', 'ROLE_CLIENT', 'ROLE_BARBER'))
);

CREATE TABLE admin (
  id            SERIAL PRIMARY KEY,
  credential_id INTEGER     NOT NULL REFERENCES credential (id),
  first_name    VARCHAR(32) NOT NULL,
  last_name     VARCHAR(32) NOT NULL
);

CREATE TABLE barber (
  id            SERIAL PRIMARY KEY,
  credential_id INTEGER     NOT NULL REFERENCES credential (id),
  first_name    VARCHAR(32) NOT NULL,
  last_name     VARCHAR(32) NOT NULL,
  gender        CHAR CHECK (gender IN ('M', 'F')),
  bdate         DATE        NOT NULL
);

CREATE TABLE client (
  id            SERIAL PRIMARY KEY,
  credential_id INTEGER     NOT NULL REFERENCES credential (id),
  first_name    VARCHAR(32) NOT NULL,
  last_name     VARCHAR(32) NOT NULL,
  gender        CHAR CHECK (gender IN ('M', 'F')),
  bdate         DATE        NOT NULL
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
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(32) UNIQUE NOT NULL,
  price VARCHAR(8)         NOT NULL
);

CREATE TABLE record (
  id            SERIAL PRIMARY KEY,
  client_id     INTEGER NOT NULL REFERENCES client (id),
  barber_id     INTEGER NOT NULL REFERENCES barber (id),
  attendance_id INTEGER NOT NULL REFERENCES attendance (id),
  rdate         DATE    NOT NULL,
  hour          INTEGER NOT NULL
);

