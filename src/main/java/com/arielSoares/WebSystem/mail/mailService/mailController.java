package com.arielSoares.WebSystem.mail.mailService;

import com.arielSoares.WebSystem.mail.Email;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class mailController {

    private final mailService mailService;

    public mailController(mailService mailService) {
        this.mailService = mailService;
    }

    public static void sendMail(Email email, mailService mailService) {
        mailService.sendEmail(email);
    }

}
