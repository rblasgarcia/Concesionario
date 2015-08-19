CREATE TABLE car_colours (
    id serial PRIMARY KEY NOT NULL,
    colour character varying(20) UNIQUE NOT NULL
);


CREATE TABLE cars (
    id serial PRIMARY KEY NOT NULL,
    brand character varying(20) NOT NULL,
    model character varying(20) NOT NULL,
    year integer  NOT NULL,
    power integer NOT NULL,
    colour character varying(20) NOT NULL,
    price numeric NOT NULL
);