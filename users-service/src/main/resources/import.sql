--all passwords are 12345 bcrypted

insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('admin','$2a$10$s06TjDDEHCqI9tEt2l.q7.Z0rX4mCotMCzlNSviqjk4rXYtTDIqgm', 'Admin', 'sysadmin', 1, 'admin@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('markzuck','$2a$10$Fm6IfCuY8THCVHvZ4G0IB.H5W/6xjWLKWkchkrl0WG/.zW6798s3W', 'Mark', 'Zuck', 1, 'mzuck@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('lisasmith','$2a$10$Vt9FP.IYTMyIrWlWouaoAuVk54Uj8aZUnwvhQAlM/xziFpbVbD6si', 'Lisa', 'Smith', 1, 'lisa@test.com');
insert into users (user_name, password, first_name, last_name, enabled, email) VALUES ('georgedoe','$2a$10$il9pKJ1MY/orLsygS/xn/OgygxyGDGybK5xdjV6atzEegtAe2J1DG', 'George', 'Doe', 1, 'george@test.com');


insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_USER');

insert into users_roles (user_id, role_id) values (1,1);
insert into users_roles (user_id, role_id) values (1,2);
insert into users_roles (user_id, role_id) values (2,2);
insert into users_roles (user_id, role_id) values (3,2);
insert into users_roles (user_id, role_id) values (4,2);