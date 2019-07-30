create table employee (
    id serial primary key,
    first string not null,
    last string not null,
    email string not null,
    password string not null
);

create table status (
    id serial primary key,
    status string not null
);

create table parent (
    id serial primary key,
    first string not null,
    last string not null,
    email string not null,
    password string not null,
    phone string
);

create table child (
    id serial primary key,
    first string not null,
    last string not null,
    age int not null,
    sunday boolean,
    monday boolean,
    tuesday boolean,
    wednesday boolean,
    thursday boolean,
    friday boolean,
    saturday boolean,
    statusid int references status(id),
    photo string
);

create table parentmap (
  id serial primary key,
  cid int references child(id),
  pid int references parent(id)
);

create table daycare (
    id serial primary key,
    daycare string not null
);

create table daycareMap (
    id serial primary key,
    cid int references child(id),
    did int references daycare(id)
);

create table personality (
    id serial primary key,
    personality string not null
);

create table personalityMap (
    id serial primary key,
    cid int references child(id),
    persid int references personality(id)
);

create table allergy (
    id serial primary key,
    allergy string not null
);

create table allergyMap (
    id serial primary key,
    cid int references child(id),
    aid int references allergy(id)
);
