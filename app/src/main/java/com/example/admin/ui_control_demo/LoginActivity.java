package com.example.admin.ui_control_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText userName;
    @BindView(R.id.pass)
    EditText password;
    @BindView(R.id.btnLogin) Button btnLogin;

    @BindString(R.string.content) String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClicked(View view){
        String name=userName.getText().toString();
        String pass=password.getText().toString();

        Toast.makeText(this, ""+name+" "+ pass, Toast.LENGTH_SHORT).show();

    }


}
