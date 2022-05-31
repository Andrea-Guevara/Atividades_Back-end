package org.serratec.backend.java2.projetoBorracharia.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.java2.projetoBorracharia.dto.BorrachariaDTO;
import org.serratec.backend.java2.projetoBorracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;
	@Value("${spring.mail.username}")
	private String userName;

	@Value("${spring.mail.password}")
	private String senha;

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.email.remetente}")
	private String emailRemetente;

	// configuracao para enviar o gamil
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();

		enviarEmail.setHost(host);
		enviarEmail.setPort(465);
		enviarEmail.setUsername(userName);
		enviarEmail.setPassword(senha);
		enviarEmail.setProtocol("smtp");
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		return enviarEmail;
	}

	public void SendMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public void emailTeste(BorrachariaDTO borrachariaDTO) throws MessagingException, EmailException {
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom("andreaguevara32001@gmail.com");
			helper.setTo(emailRemetente);
			helper.setSubject("Agora foi:)");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>" 
			        + "<body>" 
					+ "<div>\r\n" + "========Borracharia service========<br/>" + "\r\n"
					+ "Tipo de servico: " + borrachariaDTO.getTipoDeServico() + "<br/>" + "Valor do servico: "
					+ borrachariaDTO.getValor() + "<br/>" + "Data: " + borrachariaDTO.getData() + "<br/>"
					+ "===============================" 
					+ "<br/>" 
					+ "Att,<br/>" 
					+ "Andrea G. <div/>" 
					+ "\r\n" 
					+ "<body/>"
					+ "</html>");
			helper.setText(sBuilder.toString(), true);
			emailSender.send(message);
		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar o email " + e.getMessage());
		}
	}

}
