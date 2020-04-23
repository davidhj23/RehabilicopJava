use rehabilicop;

SELECT  

ef.tipo,
ef.tipo_alimenticio,

o.nombre id_asfixias,
o2.nombre id_adecuado,
o3.nombre id_alimentacion,
o4.nombre id_alucinaciones,
o5.nombre id_cociliacion,
o6.nombre id_curso,
o7.nombre id_disartrias,
o8.nombre id_fijacion,
o9.nombre id_global,
o10.nombre id_hipersomnio,
o11.nombre id_insomnio,
o12.nombre id_inteligencia,
o13.nombre id_introspeccion,
o14.nombre id_reciente,
o15.nombre id_reconciliacion,
o16.nombre id_remota,
o17.nombre id_juicio,
o18.nombre id_prospeccion,
o19.nombre id_comprensible
        
FROM	usuario u	

LEFT JOIN   admision ad on ad.id_usuario = u.id_usuario
LEFT JOIN   historia h on h.id_admision = ad.id_admision
LEFT JOIN   examen_fisico6 ef on ef.id_historia = h.id_historia

LEFT JOIN   asfixia o on o.id_asfixia = ef.id_asfixias
LEFT JOIN   opcion o2 on o2.id_opcion = ef.id_adecuado
LEFT JOIN   alimentacion o3 on o3.id_alimentacion = ef.id_alimentacion
LEFT JOIN   alucinacion o4 on o4.id_alucinacion = ef.id_alucinaciones
LEFT JOIN   opcion o5 on o5.id_opcion = ef.id_cociliacion
LEFT JOIN   curso o6 on o6.id_curso = ef.id_curso
LEFT JOIN   opcion o7 on o7.id_opcion = ef.id_disartrias
LEFT JOIN   memoria2 o8 on o8.id_memoria2 = ef.id_fijacion
LEFT JOIN   opcion o9 on o9.id_opcion = ef.id_global
LEFT JOIN   opcion o10 on o10.id_opcion = ef.id_hipersomnio
LEFT JOIN   opcion o11 on o11.id_opcion = ef.id_insomnio
LEFT JOIN   inteligencia o12 on o12.id_inteligencia = ef.id_inteligencia
LEFT JOIN   introspeccion o13 on o13.id_introspeccion = ef.id_introspeccion
LEFT JOIN   memoria2 o14 on o14.id_memoria2 = ef.id_reciente
LEFT JOIN   opcion o15 on o15.id_opcion = ef.id_reconciliacion
LEFT JOIN   memoria2 o16 on o16.id_memoria2 = ef.id_remota
LEFT JOIN   introspeccion o17 on o17.id_introspeccion = ef.id_juicio
LEFT JOIN   introspeccion o18 on o18.id_introspeccion = ef.id_prospeccion
LEFT JOIN   comprensible o19 on o19.id_comprensible = ef.id_comprensible

WHERE   ad.id_admision = UNHEX('f9e06bc5544346dc8f099ba00ac27e4a')
/*WHERE   ad.id_admision = UNHEX($P{identificacion})*/