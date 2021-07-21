CREATE DEFINER=`root`@`localhost` PROCEDURE `evoluciones`(id_aseguradora VARCHAR(32), year_param int, month_param int)
BEGIN
    
    SELECT  HEX(e.id_evolucion) 'idEvolucion',
			ase.nombre Aseguradora, 
			e.fecha 'fechaEvolucion', 
			HEX(u.id_usuario) 'idPaciente', 
            CONCAT(u.nombres, ' ', u.apellidos) 'nombrePaciente',
            HEX(te.id_tipo_evolucion) 'idTipoEvolucion', 
            te.nombre 'tipoEvolucion', 
            e.descripcion 'descripcionEvolucion',
            HEX(ur.id_usuario) 'idResponsable', 
            CONCAT(ur.nombres, ' ', ur.apellidos) 'nombreResponsable'
    FROM evolucion e
    JOIN historia h ON h.id_historia = e.id_historia
    JOIN admision a ON a.id_admision = h.id_admision
    JOIN usuario u ON u.id_usuario = a.id_usuario
    JOIN usuario ur ON ur.id_usuario = e.id_usuario
    JOIN aseguradora ase ON ase.id_aseguradora = u.id_aseguradora
    JOIN tipo_evolucion te ON te.id_tipo_evolucion = e.id_tipo_evolucion
    WHERE ase.id_aseguradora = UNHEX(id_aseguradora) 
    AND   YEAR(e.fecha) = year_param
    AND   MONTH(e.fecha) = month_param
    ORDER BY ase.nombre, e.fecha DESC, u.id_usuario;
END