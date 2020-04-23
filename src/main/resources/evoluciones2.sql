CREATE DEFINER=`root`@`localhost` PROCEDURE `evoluciones`(id_aseguradora VARCHAR(64), year_param int, month_param int)
BEGIN
    
    SELECT  HEX(e.id_evolucion) 'id_evolucion',
			ase.nombre 'aseguradora', 
			e.fecha 'fecha_evolucion', 
			HEX(u.id_usuario) 'id_paciente', 
            u.identificacion 'identificacion', 
            CONCAT(u.nombres, ' ', u.apellidos) 'nombre_paciente',
            HEX(te.id_tipo_evolucion) 'id_tipo_evolucion', 
            te.nombre 'tipo_evolucion', 
            e.descripcion 'descripcion_evolucion',
            HEX(ur.id_usuario) 'id_responsable', 
            CONCAT(ur.nombres, ' ', ur.apellidos) 'nombre_responsable',
            a.fecha_de_ingreso 'fecha_de_ingreso'
    FROM evolucion e
    JOIN historia h ON h.id_historia = e.id_historia
    JOIN admision a ON a.id_admision = h.id_admision
    JOIN usuario u ON u.id_usuario = a.id_usuario
    JOIN usuario ur ON ur.id_usuario = e.id_usuario
    JOIN aseguradora ase ON ase.id_aseguradora = u.id_aseguradora
    JOIN tipo_evolucion te ON te.id_tipo_evolucion = e.id_tipo_evolucion
    WHERE binary HEX(ase.id_aseguradora) = binary id_aseguradora 
    AND   YEAR(e.fecha) = year_param
    AND   MONTH(e.fecha) = month_param    
    ORDER BY ase.nombre, e.fecha ASC, u.id_usuario;
END