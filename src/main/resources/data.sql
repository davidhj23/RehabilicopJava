INSERT INTO tipo_documento (id_tipo_documento, nombre) VALUES (1, 'Cedula');

INSERT INTO usuario (identificacion, nombres, apellidos, username, password, email, direccion, telefono, celular, ultimo_acceso, id_tipo_documento, enabled) 
VALUES (72346450, 'David', 'Henriquez', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'david.heriquez.23@gmail.com', 'Calle 51 # 21 - 31', '3142798', '3014413292', NOW(), 1, 1);

INSERT INTO rol (id_rol, nombre) VALUES (1, 'admin global');

INSERT INTO usuario_rol (identificacion, id_rol) VALUES (72346450, 1);

INSERT INTO permiso (id_permiso, nombre) VALUES (1, 'ROLE_layout');
INSERT INTO permiso (id_permiso, nombre) VALUES (2, 'ROLE_seguridad');
INSERT INTO permiso (id_permiso, nombre) VALUES (3, 'ROLE_roles');

INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 1);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 2);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 3);
