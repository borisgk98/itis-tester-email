package ru.kpfu.itis.javalab.testeremail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import ru.kpfu.itis.javalab.testeremail.services.FreemarkerHtmlEmailBodyGenerator;
import ru.kpfu.itis.javalab.testeremail.services.MailService;

import java.net.MulticastSocket;
import java.util.Arrays;

@SpringBootApplication
public class TesterEmailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesterEmailApplication.class, args);
	}


	@Autowired
	public MailService mailService;
	@Autowired
	public FreemarkerHtmlEmailBodyGenerator generator;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(generator.generateHtml());
		System.exit(0);
	}
}
