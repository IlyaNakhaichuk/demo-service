package com.example.graph.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class GraphController {

    @PostMapping("/post")
    public String createGraph(@RequestParam("file") MultipartFile file) {
        String gotString;
        try {
            gotString = new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error extracting text data, " + e);
            return null;
        }

        return gotString;
    }

    @GetMapping("/get")
    public String getMethod() {
        return "Privet Teftelka!";
    }

    @GetMapping("/getRandom")
    public String getMethodRandom(){
        int min = 0;
        int max = 64000;
        Random randomNumberOne = new Random( );
        Random randomNumberTwo = new Random( );
        ArrayList<Double> numberListOne = new ArrayList<>(  );
        ArrayList<Double> numberListTwo = new ArrayList<>(  );
        double numberOne;
        double numberTwo;
        while (true){
            numberOne = randomNumberOne.nextInt((max-min)+ 1);
            numberTwo = randomNumberTwo.nextInt((max-min)+ 1);
            if (numberOne == numberTwo){
                return "Data matched."+ "\n" + "Attempt: " + (numberListOne.size() + 1) + "\n" + "Numbers: " + numberOne;
            }
            numberListOne.add( numberOne );
            numberListTwo.add( numberTwo );
        }
    }
}
