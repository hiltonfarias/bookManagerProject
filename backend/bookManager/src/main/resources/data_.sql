insert into users (login, password, full_name, email, birth_date, user_active, user_permission) values ('hilton', '$2a$10$d3r71jSFOUT67CvBndNwtONvamAPauDbK4DWkEasp.4Wb8GtSDy7S', 'Hilton Farias da Silva', 'hilton@email.com', '1988-01-01', true, 'ADMIN');








--insert into client (login, password, full_name, email, birth_date, permission_type, is_active) values ('silas','$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam','Silas Candiolli','silas@email.com','1982-01-01','ADMIN',0);
--insert into client (login, password, full_name, email, birth_date, permission_type, is_active) values ('bruna','$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam','Bruna Candiolli','bruna@email.com','1988-01-01','USER',0);
--
--insert into group_client (id, name, description) values (1, 'ANALISTA', 'GROUP de analistas');
--insert into group_client (id, name, description) values (2, 'SUPERVISOR', 'GROUP de supervisores');
--
--insert into permission (id, name) values (1, 'ADMIN');
--insert into permission (id, name) values (2, 'USER');
--
--insert into client_groups (users_id, groups_id) values (1, 1);
--insert into client_groups (users_id, groups_id) values (2, 2);
--
--insert into group_client_permissions (groups_id, permissions_id) values (2, 1);
--insert into group_client_permissions (groups_id, permissions_id) values (2, 2);
--insert into group_client_permissions (groups_id, permissions_id) values (1, 2);