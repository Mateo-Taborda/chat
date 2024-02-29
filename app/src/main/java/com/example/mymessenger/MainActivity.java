package com.example.mymessenger;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    EditText messageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> chat = Historial.getInstance().getMessages();
        TextView layoutChat = (TextView) findViewById(R.id.chat);
        StringBuilder formato = new StringBuilder();
        for(String m: chat){
            formato.append(m).append("\n");
        }
        layoutChat.setText(formato);
    }
    public void onSendMessage(View view){
        messageEditText = findViewById(R.id.message);
        String message = messageEditText.getText().toString();
        Historial.getInstance().addMessages(message);
        Intent intento = new Intent(this,RecibeMensajeActivity.class);
        startActivity(intento);
    }
}