insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('admin','12345', 'Admin', 'sysadmin', 1, 'admin@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('markzuck','12345', 'Mark', 'Zuck', 1, 'mzuck@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('lisasmith','12345', 'Lisa', 'Smith', 1, 'lisa@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('georgedoe','12345', 'George', 'Doe', 1, 'george@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('johngo','12345', 'John', 'Goodman', 1, 'john@test.com');


insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_USER');

insert into users_roles (user_id, role_id) values (1,1);
insert into users_roles (user_id, role_id) values (1,2);
insert into users_roles (user_id, role_id) values (2,2);
insert into users_roles (user_id, role_id) values (3,2);
insert into users_roles (user_id, role_id) values (4,2);
insert into users_roles (user_id, role_id) values (5,2);