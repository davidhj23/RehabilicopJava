use rehabilicop;

SELECT  

ef.descripcion,
ef.fecha,

o.nombre id_acustica,
o2.nombre id_bridipsiquia,
o3.nombre id_concreto,
o4.nombre id_curso_normal,
o5.nombre id_depresivo,
o6.nombre id_espacio,
o7.nombre id_estado_conciencia,
o8.nombre id_euprosexico,
o9.nombre id_eutimico,
o10.nombre id_expensivo,
o11.nombre id_fugas_de_idea,
o12.nombre id_hiperprosexico,
o13.nombre id_hipoprosexico,
o14.nombre id_ideas_delirantes,
o15.nombre id_ideas_obsesivas,
o16.nombre id_ideas_refenciales,
o17.nombre id_origen_normal,
o18.nombre id_pensamiento_mago,
o19.nombre id_persona,
o20.nombre id_pobreza_ideativa,
o21.nombre id_taquipsiquia,
o22.nombre id_tiempo
        
FROM	usuario u	

LEFT JOIN   admision ad on ad.id_usuario = u.id_usuario
LEFT JOIN   historia h on h.id_admision = ad.id_admision
LEFT JOIN   examen_fisico5 ef on ef.id_historia = h.id_historia

LEFT JOIN   opcion o on o.id_opcion = ef.id_acustica
LEFT JOIN   opcion o2 on o2.id_opcion = ef.id_bridipsiquia
LEFT JOIN   opcion o3 on o3.id_opcion = ef.id_concreto
LEFT JOIN   opcion o4 on o4.id_opcion = ef.id_curso_normal
LEFT JOIN   opcion o5 on o5.id_opcion = ef.id_depresivo
LEFT JOIN   opcion o6 on o6.id_opcion = ef.id_espacio
LEFT JOIN   estado_conciencia o7 on o7.id_estado_conciencia = ef.id_estado_conciencia
LEFT JOIN   opcion o8 on o8.id_opcion = ef.id_euprosexico
LEFT JOIN   opcion o9 on o9.id_opcion = ef.id_eutimico
LEFT JOIN   opcion o10 on o10.id_opcion = ef.id_expensivo
LEFT JOIN   opcion o11 on o11.id_opcion = ef.id_fugas_de_idea
LEFT JOIN   opcion o12 on o12.id_opcion = ef.id_hiperprosexico
LEFT JOIN   opcion o13 on o13.id_opcion = ef.id_hipoprosexico
LEFT JOIN   opcion o14 on o14.id_opcion = ef.id_ideas_delirantes
LEFT JOIN   opcion o15 on o15.id_opcion = ef.id_ideas_obsesivas
LEFT JOIN   opcion o16 on o16.id_opcion = ef.id_ideas_refenciales
LEFT JOIN   opcion o17 on o17.id_opcion = ef.id_origen_normal
LEFT JOIN   opcion o18 on o18.id_opcion = ef.id_pensamiento_mago
LEFT JOIN   opcion o19 on o19.id_opcion = ef.id_persona
LEFT JOIN   opcion o20 on o20.id_opcion = ef.id_pobreza_ideativa
LEFT JOIN   opcion o21 on o21.id_opcion = ef.id_taquipsiquia
LEFT JOIN   opcion o22 on o22.id_opcion = ef.id_tiempo

WHERE   ad.id_admision = UNHEX('f9e06bc5544346dc8f099ba00ac27e4a')
/*WHERE   ad.id_admision = UNHEX($P{identificacion})*/