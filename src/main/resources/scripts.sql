USE rehabilicop;

select * from historia;
select * from patologico; 
select * from antecedente;
select * from traumatico; 
select * from farmacologico; 
select * from toxico; 
select * from gineco_obstetricio;
select * from examen_fisico;
select * from examen_fisico2;
select * from examen_fisico3;
select * from examen_fisico4;
select * from examen_fisico5;
select * from examen_fisico6;

USE Rehabilicop;

DELETE FROM patologico;
DELETE FROM antecedente;
DELETE FROM traumatico;
DELETE FROM farmacologico;
DELETE FROM toxico;
DELETE FROM gineco_obstetricio;
DELETE FROM examen_fisico;
DELETE FROM examen_fisico2;
DELETE FROM examen_fisico3;
DELETE FROM examen_fisico4;
DELETE FROM examen_fisico5;
DELETE FROM examen_fisico6;
DELETE FROM evolucion;
DELETE FROM historia;

USE Rehabilicop;
ALTER TABLE evolucion DROP COLUMN descripion;
ALTER TABLE parametrizacion_evolucion DROP COLUMN mes;
ALTER TABLE parametrizacion_evolucion DROP COLUMN dia;

USE rehabilicop;
select * from examen_fisico4;
select * from examen_fisico5;
select * from examen_fisico6;

USE Rehabilicop;
call UUIDGenerator(290);

USE Rehabilicop;
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('F1796B98CCF911E8808B40167EB4F57C'), 'ROLE_parametrizacion');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('19C466C4CCFA11E8808B40167EB4F57C'), 'ROLE_parametrizacion evolucion');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('F1796B98CCF911E8808B40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('19C466C4CCFA11E8808B40167EB4F57C'));

INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28660F1CF1011E8A4DF40167EB4F57C'), 'MEDICINA GENERAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AA892CF1011E8A4DF40167EB4F57C'), 'TERAPIA OCUPACIONAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AAC30CF1011E8A4DF40167EB4F57C'), 'ACONDICIONAMIENTO FISICO');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AAFD6CF1011E8A4DF40167EB4F57C'), 'FACILITADOR');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AB2B2CF1011E8A4DF40167EB4F57C'), 'NEUROPSICOLOGIA');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AB5AFCF1011E8A4DF40167EB4F57C'), 'PSICOLOGIA - GRUPAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AB8E2CF1011E8A4DF40167EB4F57C'), 'PSICOLOGIA - INDIVIDUAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28ABCB1CF1011E8A4DF40167EB4F57C'), 'PSIQUIATRIA FAMILIAR');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28ABF92CF1011E8A4DF40167EB4F57C'), 'PSIQUIATRIA INDIVIDUAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'), 'REUNION DE EQUIPO');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AC579CF1011E8A4DF40167EB4F57C'), 'TRABAJO SOCIAL - GRUPAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28AC855CF1011E8A4DF40167EB4F57C'), 'TRABAJO SOCIAL - INDIVIDUAL');
INSERT INTO tipo_evolucion (id_tipo_evolucion, nombre) VALUES (UNHEX('A28ACBEECF1011E8A4DF40167EB4F57C'), 'TRABAJO SOCIAL - FAMILIAR');

INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA58C357B111E8A87C40167EB4F57C'), 'Psiquiatria');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA61A457B111E8A87C40167EB4F57C'), 'Psiquiatria Infantil');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), 'Medicina general');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA68B857B111E8A87C40167EB4F57C'), 'Jefe enfermeria');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA6EA357B111E8A87C40167EB4F57C'), 'Enfermeria');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA748057B111E8A87C40167EB4F57C'), 'Psicologia');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA7A5757B111E8A87C40167EB4F57C'), 'Fisioterapeuta');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA846857B111E8A87C40167EB4F57C'), 'Trabajo social');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA8DB257B111E8A87C40167EB4F57C'), 'Facilitador terapeutico');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA943757B111E8A87C40167EB4F57C'), 'Terapeuta ocupacional');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BA9A2257B111E8A87C40167EB4F57C'), 'Fonoaudiologia');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BAA00457B111E8A87C40167EB4F57C'), 'NeuroPsicologia');
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('B5BAA61557B111E8A87C40167EB4F57C'), 'Educacion Especial');

USE Rehabilicop;
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('5A9EEE99CFE711E8A4DF40167EB4F57C'), UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('A28660F1CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('7BFD2D7ECFE711E8A4DF40167EB4F57C'), UNHEX('B5BA943757B111E8A87C40167EB4F57C'), UNHEX('A28AA892CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('AEC3EB5BCFF111E8A4DF40167EB4F57C'), UNHEX('B5BA7A5757B111E8A87C40167EB4F57C'), UNHEX('A28AAC30CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('E42264F6CFF111E8A4DF40167EB4F57C'), UNHEX('B5BA8DB257B111E8A87C40167EB4F57C'), UNHEX('A28AAFD6CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('20EF5EF0CFF211E8A4DF40167EB4F57C'), UNHEX('B5BAA00457B111E8A87C40167EB4F57C'), UNHEX('A28AB2B2CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('42E02111CFF211E8A4DF40167EB4F57C'), UNHEX('B5BA748057B111E8A87C40167EB4F57C'), UNHEX('A28AC579CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('73E35967CFF211E8A4DF40167EB4F57C'), UNHEX('B5BA748057B111E8A87C40167EB4F57C'), UNHEX('A28AB8E2CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('ECC81D0FCFF511E8A4DF40167EB4F57C'), UNHEX('B5BA58C357B111E8A87C40167EB4F57C'), UNHEX('A28ABCB1CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('ECC98223CFF511E8A4DF40167EB4F57C'), UNHEX('B5BA58C357B111E8A87C40167EB4F57C'), UNHEX('A28ABF92CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('2CE80FC3CFF611E8A4DF40167EB4F57C'), UNHEX('B5BA61A457B111E8A87C40167EB4F57C'), UNHEX('A28ABCB1CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('2CF31341CFF611E8A4DF40167EB4F57C'), UNHEX('B5BA61A457B111E8A87C40167EB4F57C'), UNHEX('A28ABF92CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('887C0AB1CFF611E8A4DF40167EB4F57C'), UNHEX('B5BA846857B111E8A87C40167EB4F57C'), UNHEX('A28AC579CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('887C1812CFF611E8A4DF40167EB4F57C'), UNHEX('B5BA846857B111E8A87C40167EB4F57C'), UNHEX('A28AC855CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('887C1F60CFF611E8A4DF40167EB4F57C'), UNHEX('B5BA846857B111E8A87C40167EB4F57C'), UNHEX('A28ACBEECF1011E8A4DF40167EB4F57C'));

INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E5830DCFF711E8A4DF40167EB4F57C'), UNHEX('B5BA58C357B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E80DB6CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA61A457B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E81C92CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E82784CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA68B857B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E831E7CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA6EA357B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E8332BCFF711E8A4DF40167EB4F57C'), UNHEX('B5BA748057B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E83E40CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA7A5757B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E847B3CFF711E8A4DF40167EB4F57C'), UNHEX('B5BA846857B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E8518ECFF711E8A4DF40167EB4F57C'), UNHEX('B5BA8DB257B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E85A7FCFF711E8A4DF40167EB4F57C'), UNHEX('B5BA943757B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E869EFCFF711E8A4DF40167EB4F57C'), UNHEX('B5BA9A2257B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E87466CFF711E8A4DF40167EB4F57C'), UNHEX('B5BAA00457B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));
INSERT INTO rol_tipo_evolucion (id_rol_tipo_evolucion, id_rol, id_tipo_evolucion) VALUES (UNHEX('72E87C1BCFF711E8A4DF40167EB4F57C'), UNHEX('B5BAA61557B111E8A87C40167EB4F57C'), UNHEX('A28AC276CF1011E8A4DF40167EB4F57C'));

USE Rehabilicop;
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('1264A6E5CFC411E8A4DF40167EB4F57C'), 'ROLE_eliminar parametrizacion evolucion');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('1264A6E5CFC411E8A4DF40167EB4F57C'));

USE Rehabilicop;
DELETE FROM parametrizacion_evolucion;

USE Rehabilicop;
INSERT INTO rol (id_rol, nombre) VALUES (UNHEX('14D892B2D1AA11E89C0940167EB4F57C'), 'Auditor');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('14DD17DED1AA11E89C0940167EB4F57C'), 'ROLE_auditar');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('14D892B2D1AA11E89C0940167EB4F57C'), UNHEX('14DD17DED1AA11E89C0940167EB4F57C'));

USE Rehabilicop;
select * from usuario;
call evoluciones();

USE Rehabilicop;
select HEX(id_permiso), nombre from permiso where nombre like '%audi%' or nombre like '%evolucion%';

USE Rehabilicop;
select HEX(id_rol), nombre from rol;
/*Medicina general*/
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('3FCA7BF998E611E8B2BE40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('3FCDF47898E611E8B2BE40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('3FCE00CA98E611E8B2BE40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('FCCA0A1DD00311E8A4DF40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('B5BA629457B111E8A87C40167EB4F57C'), UNHEX('A67B1ED9771911E8934440167EB4F57C'));

call evoluciones('C3362A815B9511E8A1EE40167EB4F57C', 2018, 10);

USE Rehabilicop;
select hex(id_aseguradora), nombre from aseguradora;

USE Rehabilicop;
/*Permiso auditoria para admin global*/
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('14DD17DED1AA11E89C0940167EB4F57C'));
/*Permiso procesos para auditor*/
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('14D892B2D1AA11E89C0940167EB4F57C'), UNHEX('A67B1ED9771911E8934440167EB4F57C'));

use rehabilicop;
select hex(id_permiso), nombre from permiso where nombre like '%epicrisis%';

use rehabilicop;
call evoluciones('C3362A815B9511E8A1EE40167EB4F57C', 2018, 10);

select HEX(id_aseguradora), a.* from aseguradora a where HEX(id_aseguradora) = 'C3362A815B9511E8A1EE40167EB4F57C'

show variables like "collation_database";

use rehabilicop;
select * from evoluciones

USE Rehabilicop;
call UUIDGenerator(5);

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('5BE9993C47EF11E986EA40167EB4F57C'), 'ROLE_dosis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('5BE9A74E47EF11E986EA40167EB4F57C'), 'ROLE_consultar dosis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('5BE9AA5847EF11E986EA40167EB4F57C'), 'ROLE_crear dosis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('5BE9AD2347EF11E986EA40167EB4F57C'), 'ROLE_editar dosis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('5BE9AFE847EF11E986EA40167EB4F57C'), 'ROLE_eliminar dosis');

USE Rehabilicop;
select * from medicamento;
ALTER TABLE dosis DROP FOREIGN KEY FKi4tfpmdquqlntr8877bqcmttu;
ALTER TABLE dosis DROP COLUMN id_tratamiento_farmacologico;

USE Rehabilicop;
select count(*) from permiso; 

INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('5BE9993C47EF11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('5BE9A74E47EF11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('5BE9AA5847EF11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('5BE9AD2347EF11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('5BE9AFE847EF11E986EA40167EB4F57C'));

USE Rehabilicop;
call UUIDGenerator(5);

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('0849ACC5480A11E986EA40167EB4F57C'), 'ROLE_orden medica');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('084B690A480A11E986EA40167EB4F57C'), 'ROLE_consultar orden medica');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('084B71FD480A11E986EA40167EB4F57C'), 'ROLE_crear orden medica');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('084B7A78480A11E986EA40167EB4F57C'), 'ROLE_editar orden medica');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('084B8586480A11E986EA40167EB4F57C'), 'ROLE_eliminar orden medica');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('0849ACC5480A11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('084B690A480A11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('084B71FD480A11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('084B7A78480A11E986EA40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('084B8586480A11E986EA40167EB4F57C'));

USE Rehabilicop;
Select * from orden_medica;
USE Rehabilicop;
Select * from medicamentos_orden_medica;

USE Rehabilicop;
call UUIDGenerator(5);

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('9281ABF2502B11E9872F40167EB4F57C'), 'ROLE_hoja eventual');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('9281BA4C502B11E9872F40167EB4F57C'), 'ROLE_consultar hoja eventual');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('9281BD91502B11E9872F40167EB4F57C'), 'ROLE_crear hoja eventual');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('9281C0A8502B11E9872F40167EB4F57C'), 'ROLE_editar hoja eventual');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('9281C6A6502B11E9872F40167EB4F57C'), 'ROLE_eliminar hoja eventual');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('9281ABF2502B11E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('9281BA4C502B11E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('9281BD91502B11E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('9281C0A8502B11E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('9281C6A6502B11E9872F40167EB4F57C'));

USE Rehabilicop;
call UUIDGenerator(5);

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('FCFC10ED503711E9872F40167EB4F57C'), 'ROLE_epicrisis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('FCFD3DAA503711E9872F40167EB4F57C'), 'ROLE_consultar epicrisis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('FCFD50D7503711E9872F40167EB4F57C'), 'ROLE_crear epicrisis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('FCFD58C1503711E9872F40167EB4F57C'), 'ROLE_editar epicrisis');
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('FCFECB14503711E9872F40167EB4F57C'), 'ROLE_eliminar epicrisis');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('FCFC10ED503711E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('FCFD3DAA503711E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('FCFD50D7503711E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('FCFD58C1503711E9872F40167EB4F57C'));
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('FCFECB14503711E9872F40167EB4F57C'));

use rehabilicop;
select * from gineco_obstetricio;
delete from gineco_obstetricio;

use rehabilicop;
select * from epicrisis;
select * from tratamiento_farmacologico;

delete  from tratamiento_farmacologico;
delete from epicrisis;

USE Rehabilicop;
call UUIDGenerator(3);

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('CA100AC0987711E9AD3840167EB4F57C'), 'ROLE_crear signos vitales');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('CA100AC0987711E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('A551E69E9F8711E9AD3840167EB4F57C'), 'ROLE_crear notas de enfermeria');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('A551E69E9F8711E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('796A40CB9FF611E9AD3840167EB4F57C'), 'ROLE_crear administracion de medicamentos');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('796A40CB9FF611E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('DF29761CA03311E9AD3840167EB4F57C'), 'ROLE_crear cuidados de enfermeria');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('DF29761CA03311E9AD3840167EB4F57C'));

USE Rehabilicop;
select * from cuidados_de_enfermeria

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('07A8CFDBA1E111E9AD3840167EB4F57C'), 'ROLE_consultar valoracion enfermeria');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('07A8CFDBA1E111E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('07AAEB4FA1E111E9AD3840167EB4F57C'), 'ROLE_crear valoracion enfermeria');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('07AAEB4FA1E111E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('07AAF566A1E111E9AD3840167EB4F57C'), 'ROLE_editar valoracion enfermeria');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('07AAF566A1E111E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('3A6D2EC2A1E311E9AD3840167EB4F57C'), 'ROLE_consultar hospitalizacion');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('3A6D2EC2A1E311E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('3A6D3E91A1E311E9AD3840167EB4F57C'), 'ROLE_crear hospitalizacion');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('3A6D3E91A1E311E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('3A6D4803A1E311E9AD3840167EB4F57C'), 'ROLE_editar hospitalizacion');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('3A6D4803A1E311E9AD3840167EB4F57C'));

/**/
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('7F922E2FA1E311E9AD3840167EB4F57C'), 'ROLE_crear kardex');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('7F922E2FA1E311E9AD3840167EB4F57C'));

/**/
INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('A5A2658DA1E311E9AD3840167EB4F57C'), 'ROLE_consultar adverso');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('A5A2658DA1E311E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('A5A27398A1E311E9AD3840167EB4F57C'), 'ROLE_crear adverso');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('A5A27398A1E311E9AD3840167EB4F57C'));

INSERT INTO permiso (id_permiso, nombre) VALUES (UNHEX('A5A27A3DA1E311E9AD3840167EB4F57C'), 'ROLE_editar adverso');
INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (UNHEX('C79D8B3257AE11E8A87C40167EB4F57C'), UNHEX('A5A27A3DA1E311E9AD3840167EB4F57C'));

use rehabilicop;
select * from administracion;

use rehabilicop;
update permiso
set nombre = 'ROLE_administracion de medicamentos'
where nombre = 'ROLE_crear administracion de medicamentos';

select * from permiso where nombre like '%admi%'

use rehabilicop;
delete from administracion;
delete from medicamentos_orden_medica;
delete from orden_medica;

use rehabilicop;
select * from administracion;
select * from medicamentos_orden_medica;
select * from orden_medica;

use rehabilicop;
ALTER TABLE administracion DROP COLUMN fecha;

use rehabilicop;
select hex(a.id_admision), a.* from admision a;
select * from epicrisis 

/*71D93B5C5FE643D99A6BE0CDEE9273E1*/

use rehabilicop;
delete from administracion;
delete from medicamentos_orden_medica;
delete from orden_medica;
delete from evolucion;
delete from hoja_eventual;
delete from tratamiento_farmacologico;
delete from epicrisis;
delete from historia;

USE Rehabilicop;

DELETE FROM patologico;
DELETE FROM antecedente;
DELETE FROM traumatico;
DELETE FROM farmacologico;
DELETE FROM toxico;
DELETE FROM gineco_obstetricio;
DELETE FROM examen_fisico;
DELETE FROM examen_fisico2;
DELETE FROM examen_fisico3;
DELETE FROM examen_fisico4;
DELETE FROM examen_fisico5;
DELETE FROM examen_fisico6;
DELETE FROM evolucion;
DELETE FROM historia;

DELETE FROM administracion;
DELETE FROM notas_de_enfermeria;
DELETE FROM signos_vitales;
DELETE FROM cuidados_de_enfermeria;
DELETE FROM cuidados_de_enfermeria;
DELETE FROM historia;
DELETE FROM admision;
DELETE FROM paciente;

delete from usuario_rol where id_rol != UNHEX('C79D8B3257AE11E8A87C40167EB4F57C')

delete from aseguradora
select * from aseguradora

delete from usuario where username != 'admin' OR username is null
select * from usuario

use rehabilicop;
select * from evolucion




