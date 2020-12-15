--drop table Angestellte

CREATE table Angestellte(
id bigint primary key not null auto_increment,
name varchar(35) not null,
grundgehalt dec(10,2),
zulage dec(10,2)
);

commit;
