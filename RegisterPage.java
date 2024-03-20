package com.example.onlineshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import javax.xml.validation.Validator;

public class RegisterPage extends AppCompatActivity {

    private Button registerButton, loginReturnButton;
    private EditText usernameInput, loginInput, passwordInput;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        registerButton = (Button) findViewById(R.id.register_btn);
        usernameInput = (EditText) findViewById(R.id.username_input);
        loginInput = (EditText) findViewById(R.id.login_name_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        loginReturnButton = (Button) findViewById(R.id.login_return);
        loading = new ProgressDialog(this);

        loginReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnLoginIntent = new Intent(RegisterPage.this,LoginPage.class);
                startActivity(returnLoginIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String username = usernameInput.getText().toString();
        String login = loginInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this, "Вы не ввели имя", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(login))
        {
            Toast.makeText(this, "Вы не ввели логин", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Вы не ввели пароль", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loading.setTitle("Создание аккаунта");
            loading.setMessage("Пожалуйста, подождите");
            loading.setCanceledOnTouchOutside(false);
            loading.show();

            ValidationLogin(username, login, password);
        }
    }

    private void ValidationLogin(String username, String login, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(login).exists()))
                {
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("login", login);
                    userDataMap.put("username", username);
                    userDataMap.put("password", password);

                    RootRef.child("Users").child(login).updateChildren(userDataMap)
                           .addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        loading.dismiss();
                                        Toast.makeText(RegisterPage.this,"Аккаунт зарегистрирован",Toast.LENGTH_SHORT).show();
                                        Intent loginIntent = new Intent(RegisterPage.this,LoginPage.class);
                                   startActivity(loginIntent);
                                    }
                                    else {
                                        loading.dismiss();
                                        Toast.makeText(RegisterPage.this,"Ошибка :(",Toast.LENGTH_SHORT).show();
                                    }
                               }
                           });


                }
                else {
                    loading.dismiss();
                    Toast.makeText(RegisterPage.this, "Этот логин уже занят", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}