package com.example.mymessenger;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    public static Historial instance;
    private List<String> messages;

    private Historial(){
        messages = new ArrayList<>();
    }
    public static Historial getInstance(){
        if(instance==null){
            instance = new Historial();
        }
        return instance;
    }
    public List<String> getMessages(){
        return messages;
    }
    public void addMessages(String message){
        messages.add(message);
    }
}