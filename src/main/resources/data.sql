
INSERT INTO tipo_documento (id_tipo_documento, nombre) VALUES (1, 'Cedula');

INSERT INTO usuario (id_usuario, identificacion, nombres, apellidos, username, password, email, direccion, telefono, celular, ultimo_acceso, id_tipo_documento, enabled) VALUES (1, 1234, 'admin', 'admin', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin@admin.com', 'Calle 1 # 1 - 1', '1234', '1234', NOW(), 1, 1);

INSERT INTO rol (id_rol, nombre) VALUES (1, 'admin global');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);

INSERT INTO permiso (id_permiso, nombre) VALUES (1, 'ROLE_home');

INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (1, 1);
