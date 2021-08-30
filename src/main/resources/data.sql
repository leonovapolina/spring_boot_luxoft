drop table if exists country;

create table country(
    id identity,
    name varchar (255),
    code_name varchar (255)
);

insert into country (name, code_name) values
    ('Australia', 'AU'),
    ('Canada', 'CA'),
    ('France', 'FR'),
    ('Hong Kong', 'HK'),
    ('Iceland', 'IC'),
    ('Japan', 'JP'),
    ('Nepal', 'NP'),
    ('Russian Federation', 'RU'),
    ('Sweden', 'SE'),
    ('Switzerland', 'CH'),
    ('United Kingdom', 'GB'),
    ('United States', 'US');
