package ru.kpfu.itis.javalab.testeremail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("application.properties")
@ComponentScan
public class Config {

    @Value("${email.username}")
    private String username;
    @Value("${email.port}")
    private Integer port;
    @Value("${email.password}")
    private String password;
    @Value("${email.mail.transport.protocol}")
    private String mtp;
    @Value("${email.mail.smtp.auth}")
    private String msa;
    @Value("${email.mail.starttls.enable}")
    private String msse;
    @Value("${email.host}")
    private String host;

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mtp);
        props.put("mail.smtp.auth", msa);
        props.put("mail.smtp.starttls.enable", msse);
//        props.put("mail.debug", "true");

        return mailSender;
    }
}
