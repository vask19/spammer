package com.example.spammer.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailReceiver {
    private List<String > emails;
    private String subject;
    private String text;
}
