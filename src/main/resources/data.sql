INSERT INTO tipo_documento (id_tipo_documento, nombre) VALUES (1, 'Cedula');

INSERT INTO usuario (identificacion, nombres, apellidos, username, password, email, direccion, telefono, celular, ultimo_acceso, id_tipo_documento, enabled) 
VALUES (72346450, 'David', 'Henriquez', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'david.heriquez.23@gmail.com', 'Calle 51 # 21 - 31', '3142798', '3014413292', NOW(), 1, 1);

INSERT INTO rol (id_rol, nombre) VALUES (1, 'admin global');

INSERT INTO rol (id_rol, nombre) VALUES (2, 'Psiquiatria');
INSERT INTO rol (id_rol, nombre) VALUES (3, 'Psiquiatria Infantil');
INSERT INTO rol (id_rol, nombre) VALUES (4, 'Medicina general');
INSERT INTO rol (id_rol, nombre) VALUES (5, 'Jefe enfermeria');
INSERT INTO rol (id_rol, nombre) VALUES (6, 'Enfermeria');
INSERT INTO rol (id_rol, nombre) VALUES (7, 'Psicologia');
INSERT INTO rol (id_rol, nombre) VALUES (8, 'Fisioterapeuta');
INSERT INTO rol (id_rol, nombre) VALUES (9, 'Trabajo social');
INSERT INTO rol (id_rol, nombre) VALUES (10, 'Facilitador terapeutico');
INSERT INTO rol (id_rol, nombre) VALUES (11, 'Terapeuta ocupacional');
INSERT INTO rol (id_rol, nombre) VALUES (12, 'Fonoaudiologia');
INSERT INTO rol (id_rol, nombre) VALUES (13, 'NeuroPsicologia');
INSERT INTO rol (id_rol, nombre) VALUES (14, 'Educacion Especial');
INSERT INTO rol (id_rol, nombre) VALUES (15, 'Auxiliares Administrativos');
INSERT INTO rol (id_rol, nombre) VALUES (16, 'Paciente');

INSERT INTO usuario_rol (identificacion, id_rol) VALUES (72346450, 1);

INSERT INTO permiso (id_permiso, nombre) VALUES (1, 'ROLE_layout');
INSERT INTO permiso (id_permiso, nombre) VALUES (2, 'ROLE_seguridad');
INSERT INTO permiso (id_permiso, nombre) VALUES (3, 'ROLE_roles');
INSERT INTO permiso (id_permiso, nombre) VALUES (4, 'ROLE_consultar rol');
INSERT INTO permiso (id_permiso, nombre) VALUES (5, 'ROLE_crear rol');
INSERT INTO permiso (id_permiso, nombre) VALUES (6, 'ROLE_editar rol');
INSERT INTO permiso (id_permiso, nombre) VALUES (7, 'ROLE_eliminar rol');

INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 1);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 2);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 3);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 4);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 5);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 6);
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 7);
