package com.example.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
public class RecibeMensajeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recibe_mensaje);
        List<String> chat = Historial.getInstance().getMessages();
        TextView layoutChat = (TextView) findViewById(R.id.chat);
        StringBuilder formato = new StringBuilder();
        for(String m: chat){
            formato.append(m).append("\n");
        }
        layoutChat.setText(formato);

    }
    public void onSendMessage(View view){
        EditText obtener = (EditText) findViewById(R.id.message);
        String mensaje = "Conductor: " + obtener.getText().toString();
        Historial.getInstance().addMessages(mensaje);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
