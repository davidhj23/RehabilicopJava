CREATE DEFINER=`root`@`localhost` PROCEDURE `getAdministraciones`(id_medicamentos_orden_medica VARCHAR(32))
BEGIN
SELECT

	adm.id_administracion,
	adm.id_medicamento_orden_medica as id_medicamentos_orden_medica, 

	dos.id_dosis,
	dos.nombre as dosis,

	pon.id_usuario as id_administra,
	pon.nombres as nombre_administra,
	pon.apellidos as apellido_administra,

	adm.fecha as fecha_adm,
	adm.hora,
	adm.ampm,
    adm.valida

FROM  administracion adm
JOIN  medicamentos_orden_medica mom on mom.id_medicamentos_orden_medica = adm.id_medicamento_orden_medica
JOIN  dosis dos on dos.id_dosis = mom.id_dosis
LEFT JOIN usuario pon on pon.id_usuario = adm.id_administra

WHERE adm.id_medicamento_orden_medica = UNHEX(id_medicamentos_orden_medica);
END