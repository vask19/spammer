package com.example.spammer.controller;


import com.example.spammer.payload.EmailReceiver;
import com.example.spammer.service.MailService;
import com.example.spammer.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {
    private final MailService mailService;
    private final SenderService senderService;




    @GetMapping("/")
    public String getHomePage(Model model){
        List<String> mails = mailService.getMails();
        String message = mailService.getMessage();
        model.addAttribute("message",message);
        model.addAttribute("mails",mails);
        return "home";
    }

    @PostMapping("/mails")
    public String addMails(@RequestParam(name="mail", required = false) String mail){
        mailService.addMail(mail);
        System.out.println(mail + "mail");
        return "redirect:/api/";

    }



    @PostMapping("/messages")
    public String addMessage(@RequestParam(name="message", required = false) String message){
        mailService.setMessage(message);
        System.out.println(message);
        return "redirect:/api/";

    }

    @PostMapping("/send")
    public String send(){
        List<String> mails = mailService.getMails();
        String message = mailService.getMessage();
        EmailReceiver emailReceiver = new EmailReceiver();
        emailReceiver.setEmails(mails);
        emailReceiver.setText(message);
        emailReceiver.setSubject("test");
        senderService.sendEmailWithText(emailReceiver);

        return "redirect:/api/";

    }

}
