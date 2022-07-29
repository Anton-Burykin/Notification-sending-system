create sequence hibernate_sequence start 1 increment 1;
create table if not exists contact_info
(
    id                 int8         not null,
    email              varchar(255) not null,
    number             int8         not null,
    telegram_name      varchar(255) not null,
    primary key (id)
);
create table if not exists message_info
(
    id         int8         not null,
    date       int8         not null,
    status     boolean      not null,
    zone_id    varchar(255) not null,
    pattern_id int8,
    person_id  int8,
    primary key (id)
);
create table if not exists message_pattern
(
    id       int8         not null,
    template varchar(255) not null,
    primary key (id)
);
create table if not exists person
(
    id              int8         not null,
    name            varchar(255) not null,
    contact_info_id int8,
    primary key (id)
);
create table if not exists statistic
(
    id        int8         not null,
    date      int8         not null,
    email     boolean,
    message   varchar(255) not null,
    number    int8         not null,
    telegram  boolean,
    person_id int8,
    primary key (id)
);
alter table if exists message_info
    add constraint FKtohi29antqa2iw7x1wfbjuwst foreign key (pattern_id) references message_pattern;
alter table if exists message_info
    add constraint FKnjj07rrca6hhmsu4okgkbt581 foreign key (person_id) references person;
alter table if exists person
    add constraint FK7f78y6pi0sg1h0830tqxa0rmh foreign key (contact_info_id) references contact_info;
alter table if exists statistic
    add constraint FKbge5atoxomn0sk373sqjcwahf foreign key (person_id) references person