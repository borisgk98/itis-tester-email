package ru.kpfu.itis.javalab.testeremail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.javalab.testeremail.services.FreemarkerHtmlEmailBodyGenerator;
import ru.kpfu.itis.javalab.testeremail.services.MailService;

@RestController
@RequestMapping("email")
public class MailController {
    @Autowired
    protected FreemarkerHtmlEmailBodyGenerator generator;
    @Autowired
    protected MailService service;


}
