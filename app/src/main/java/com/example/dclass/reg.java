package com.example.dclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class reg extends AppCompatActivity {

    Button auth, reg;
    private int AUTH_RESULT = 1;
    private ConstraintLayout regs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        auth = (Button) findViewById(R.id.auth);
        reg = (Button) findViewById(R.id.rgs);
        regs = findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), AUTH_RESULT);

            }
        });

        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avt();
            }
        });


    }

    private void avt() {

        if(FirebaseAuth.getInstance().getCurrentUser() == null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), AUTH_RESULT);
        else
            step();
    }

    private void step() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast toast = Toast.makeText(getApplicationContext(), "Вы авторизованы", Toast.LENGTH_SHORT);
        toast.show();
    }
}