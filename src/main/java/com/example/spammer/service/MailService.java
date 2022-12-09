package com.example.spammer.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class MailService {

    private String message = " ";




    private final List<String > mails = new ArrayList<>();


    public List<String> getMails(){
        return mails;
    }

    public void addMail(String mail){
        mails.add(mail);
    }
}
