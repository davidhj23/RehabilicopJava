use rehabilicop;

SELECT  

ef.abdomen,
ef.cabezaycuello,
ef.cardio_pulmar,
ef.descripcion,
ef.extremidades,
ef.genitourinario,

o.nombre id_agitacion,
o2.nombre id_alerta,
o3.nombre id_comas,
o4.nombre id_estupor,
o5.nombre id_inconctinencia_urinariaofecal,
o6.nombre id_movimientos_anormales,
o7.nombre id_perdida_de_la_sensibilidad,
o8.nombre id_reflejos_muscolo_tendinosoo_alterados,
o9.nombre id_signosmeningeos_presentes,
o10.nombre id_somnolencia,
o11.nombre id_sin_alteraciones_evidentes
        
FROM	usuario u	

LEFT JOIN   admision ad on ad.id_usuario = u.id_usuario
LEFT JOIN   historia h on h.id_admision = ad.id_admision
LEFT JOIN   examen_fisico4 ef on ef.id_historia = h.id_historia

LEFT JOIN   opcion o on o.id_opcion = ef.id_agitacion
LEFT JOIN   opcion o2 on o2.id_opcion = ef.id_alerta
LEFT JOIN   opcion o3 on o3.id_opcion = ef.id_comas
LEFT JOIN   opcion o4 on o4.id_opcion = ef.id_estupor
LEFT JOIN   opcion o5 on o5.id_opcion = ef.id_inconctinencia_urinariaofecal
LEFT JOIN   opcion o6 on o6.id_opcion = ef.id_movimientos_anormales
LEFT JOIN   opcion o7 on o7.id_opcion = ef.id_perdida_de_la_sensibilidad
LEFT JOIN   opcion o8 on o8.id_opcion = ef.id_reflejos_muscolo_tendinosoo_alterados
LEFT JOIN   opcion o9 on o9.id_opcion = ef.id_signosmeningeos_presentes
LEFT JOIN   opcion o10 on o10.id_opcion = ef.id_somnolencia
LEFT JOIN   opcion o11 on o11.id_opcion = ef.id_sin_alteraciones_evidentes

WHERE   ad.id_admision = UNHEX('f9e06bc5544346dc8f099ba00ac27e4a')
/*WHERE   ad.id_admision = UNHEX($P{identificacion})*/