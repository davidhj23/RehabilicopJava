package com.davidhenriquez.base.business_logic.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import org.apache.velocity.app.VelocityEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.davidhenriquez.base.business_logic.util.Util;
import com.davidhenriquez.base.data_access.domain.Usuario;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender sender;

	/*@Autowired
	private EventoService eventoService;*/	
	
	/*public void sendMail(Boleta boleta) throws MessagingException{
		Evento evento = eventoService.findById(boleta.getEvento().getIdEvento());
		Usuario usuario = boleta.getCliente();
		String htmlTemplate = Util.getHTMLTemplate()
				.replace("@Evento", evento.getNombre())
				.replace("@Usuario", usuario.getNombres()+" - "+usuario.getApellidos())
				.replace("@Fecha", evento.getFechaInicio().toString())
				.replace("@Precio", evento.getPrecioActual()+"");
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(usuario.getEmail());
        helper.setFrom("tuboleta@outlook.com");
        helper.setText(htmlTemplate, true);
        ClassPathResource ticketlogo = new ClassPathResource(Util.EMAIL_RESOURCES_FILE_DIR_IMG+"bg-ticket.jpg");
        ClassPathResource toshowlogo = new ClassPathResource(Util.EMAIL_RESOURCES_FILE_DIR_IMG+"sign-tushow.jpg");
        ClassPathResource qrcode = new ClassPathResource(Util.QRCODES_FILE_DIR2+boleta.getCodigo()+".png");
        ClassPathResource separator = new ClassPathResource(Util.EMAIL_RESOURCES_FILE_DIR_IMG+"sep2.png");
        helper.addInline("ticketlogo", ticketlogo);
        helper.addInline("toshowlogo", toshowlogo);
        helper.addInline("qrcode", qrcode);
        helper.addInline("separator", separator);
        helper.setSubject(Util.EMAIL_SUBJECT);
        sender.send(message);

	}*/
}
