SELECT  

o.nombre cianosis,
o2.nombre cicatrices_tatuajes,
o3.nombre deformidad,
o4.nombre hematomas_equimosis_heridas,
o5.nombre ictericia,
o6.nombre llenado_capilar_alterado,
o7.nombre movilidad_alterada,
o8.nombre palidez_mucocutanea,
o9.nombre pulso_ausentes,
o10.nombre pulsos_perifericos_presentes,
o11.nombre sin_alteraciones_evidentes
        
FROM	usuario u	

LEFT JOIN   admision ad on ad.id_usuario = u.id_usuario
LEFT JOIN   historia h on h.id_admision = ad.id_admision
LEFT JOIN   examen_fisico3 ef on ef.id_historia = h.id_historia

LEFT JOIN   opcion o on o.id_opcion = ef.id_cianosis
LEFT JOIN   opcion o2 on o2.id_opcion = ef.id_cicatrices_tatuajes
LEFT JOIN   opcion o3 on o3.id_opcion = ef.id_deformidad
LEFT JOIN   opcion o4 on o4.id_opcion = ef.id_hematomas_equimosis_heridas
LEFT JOIN   opcion o5 on o5.id_opcion = ef.id_ictericia
LEFT JOIN   opcion o6 on o6.id_opcion = ef.id_llenado_capilar_alterado
LEFT JOIN   opcion o7 on o7.id_opcion = ef.id_movilidad_alterada
LEFT JOIN   opcion o8 on o8.id_opcion = ef.id_palidez_mucocutanea
LEFT JOIN   opcion o9 on o9.id_opcion = ef.id_pulso_ausentes
LEFT JOIN   opcion o10 on o10.id_opcion = ef.id_pulsos_perifericos_presentes
LEFT JOIN   opcion o11 on o11.id_opcion = ef.id_sin_alteraciones_evidentes

WHERE   ad.id_admision = UNHEX('f9e06bc5544346dc8f099ba00ac27e4a')
/*WHERE   ad.id_admision = UNHEX($P{identificacion})*/