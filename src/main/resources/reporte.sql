/* Datos paciente */
USE Rehabilicop;
SELECT  td.nombre as tipo_identificacion,
		u.identificacion,
		CONCAT(u.nombres, ' ', u.apellidos) as nombre,
        TIMESTAMPDIFF(YEAR, u.fecha_de_nacimiento, CURDATE()) as edad,
        s.nombre as sexo,
        u.ciudad,
        u.direccion,
        u.telefono,
        u.celular,
        u.email,
        u.ocupacion,
        ec.nombre as estado_civil,
		e.nombre as escolaridad,
        te.nombre as tipo_entidad,
        a.nombre as aseguradora,
        r.nombre as regimen
FROM	usuario u	
JOIN	tipo_documento td on td.id_tipo_documento = u.id_tipo_documento
JOIN	sexo s on s.id_sexo = u.id_sexo    		
JOIN	estado_civil ec on ec.id_estado_civil = u.id_estado_civil
JOIN	escolaridad e on e.id_escolaridad = u.id_escolaridad
JOIN	tipo_entidad te on te.id_tipo_entidad = u.id_tipo_entidad
JOIN	aseguradora a on a.id_aseguradora = u.id_aseguradora
JOIN	regimen r on r.id_regimen = u.id_regimen
WHERE	identificacion = '12345';

/* Evoluciones */
use rehabilicop;
SELECT 	e.fecha,
		te.nombre as tipo,
        e.descripcion,
        CONCAT(res.nombres, ' ', res.apellidos) as responsable,
        r.nombre as rol_responsable,
        ifnull(res.registro_medico, res.identificacion) as registro_medico,
        res.firma as firma
        
FROM	evolucion e

JOIN	tipo_evolucion te on te.id_tipo_evolucion = e.id_tipo_evolucion
JOIN	usuario res on res.id_usuario = e.id_usuario
JOIN	usuario_rol ur on ur.id_usuario = res.id_usuario
JOIN	rol r on r.id_rol = ur.id_rol

JOIN	historia h on h.id_historia = e.id_historia
JOIN	admision a on a.id_admision = h.id_admision and a.estado = 'ACTIVA'
JOIN	usuario pac on pac.id_usuario = a.id_usuario

WHERE	pac.identificacion = '12345';

/* Hojas eventuales */
USE Rehabilicop;
SELECT 	he.fecha,
		te.nombre as tipo,
        he.descripcion,
        CONCAT(res.nombres, ' ', res.apellidos) as responsable,
        r.nombre as rol_responsable,
        res.registro_medico
        
FROM	hoja_eventual he

JOIN	tipo_evolucion te on te.id_tipo_evolucion = he.id_tipo_evolucion
JOIN	usuario res on res.id_usuario = he.id_usuario
JOIN	usuario_rol ur on ur.id_usuario = res.id_usuario
JOIN	rol r on r.id_rol = ur.id_rol

JOIN	historia h on h.id_historia = he.id_historia
JOIN	admision a on a.id_admision = h.id_admision and a.estado = 'ACTIVA'
JOIN	usuario pac on pac.id_usuario = a.id_usuario

WHERE	pac.identificacion = '12345';

/* Ordenes medicas */
USE Rehabilicop;
SELECT 	HEX(om.id_orden_medica),
		om.fecha_de_creacion as fecha,		        
        
        CONCAT(s.nombres, ' ', s.apellidos) as solicitante,
        CONCAT(qe.nombres, ' ', qe.apellidos) as entrega,
        CONCAT(qr.nombres, ' ', qr.apellidos) as recibe,
        
        med.nombre as medicamento,
        d.nombre as dosis,
        mom.cantidad_solicitada,
        mom.cantidad_entregada
        
FROM	orden_medica om

JOIN	usuario s on s.id_usuario = om.id_solicitante
JOIN	usuario qe on qe.id_usuario = om.id_quien_entrega
JOIN	usuario qr on qr.id_usuario = om.id_quien_recibe

JOIN    medicamentos_orden_medica mom on mom.id_orden_medica = om.id_orden_medica
JOIN    medicamento med on med.id_medicamento = mom.id_medicamento
JOIN    dosis d on d.id_dosis = mom.id_dosis

JOIN	historia h on h.id_historia = om.id_historia
JOIN	admision a on a.id_admision = h.id_admision and a.estado = 'ACTIVA'
JOIN	usuario pac on pac.id_usuario = a.id_usuario

WHERE	pac.identificacion = '12345';

/* Epicrisis*/
USE Rehabilicop;
SELECT 	e.fecha_de_creacion,
		e.fecha_de_ingreso,
		e.fecha_de_continuacion,
		e.fecha_de_egreso,
        
        e.dias_de_estancia,
        
        e.justificacion,
        e.plan,
        
        CONCAT(medico.nombres, ' ', medico.apellidos) as nombre_medico,
        
        med.nombre as medicamento,
        d.nombre as dosis,
        tf.desde,
        tf.hasta
        
FROM	epicrisis e

JOIN 	tratamiento_farmacologico tf on tf.id_epicrisis = e.id_epicrisis
JOIN    medicamento med on med.id_medicamento = tf.id_medicamento
JOIN    dosis d on d.id_dosis = tf.id_dosis

JOIN	historia h on h.id_historia = e.id_historia
JOIN	admision a on a.id_admision = h.id_admision and a.estado = 'ACTIVA'
JOIN	usuario pac on pac.id_usuario = a.id_usuario

JOIN	usuario medico on medico.id_usuario = e.id_usuario

WHERE	pac.identificacion = '12345';

