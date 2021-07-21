CREATE DEFINER=`root`@`localhost` PROCEDURE `getMedicamentosOrdenMedica`(id_orden_medica VARCHAR(32))
BEGIN

SELECT
	mom.id_medicamentos_orden_medica,	
    mom.id_orden_medica,
	
    med.id_medicamento,
	med.nombre as medicamento,

	dos.id_dosis as id_dosis_mom,
    dos.nombre as dosis_mom,
	
    mom.cantidad_entregada,
	mom.cantidad_solicitada,
	mom.fecha as fecha_mom

FROM  medicamentos_orden_medica mom
JOIN  medicamento med on med.id_medicamento = mom.id_medicamento
JOIN  dosis dos on dos.id_dosis = mom.id_dosis

WHERE mom.id_orden_medica = UNHEX(id_orden_medica);

END