package ru.kpfu.itis.javalab.testeremail.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class FreemarkerHtmlEmailBodyGenerator {
    @Autowired
    protected Configuration freemarkerConfiguration;

    @SneakyThrows
    public String generateHtml() {
        Template template = freemarkerConfiguration.getTemplate("message.ftl");
        return template.toString();
    }
}
