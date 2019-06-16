package ru.kpfu.itis.javalab.testeremail.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailService {
    @Autowired
    protected JavaMailSender javaMailSender;
    @Value("${email.subject}")
    protected String subject;
    @Value("${email.from}")
    protected String from;

    @SneakyThrows
    public void sendEmail(String to, String body) {
        // TODO обработка исключений
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setText(body, true);
        javaMailSender.send(message);
    }
}
