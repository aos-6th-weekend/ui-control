package com.example.admin.ui_control_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    TextView textView;
    Button btnSignup, btnLogin,btnFbLogin;
    ToggleButton btnToggle;
    Switch autoSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        btnSignup=findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnLogin);
        btnFbLogin=findViewById(R.id.btnFbLogin);
        btnToggle=findViewById(R.id.btnToggle);
        autoSwitch=findViewById(R.id.switch1);

        String content =getString(R.string.content);
        //textView.setText(content);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("on Signup");
            }
        });


        btnSignup.setOnLongClickListener(this);
        btnLogin.setOnLongClickListener(this);
        btnFbLogin.setOnClickListener(it -> showMessage("lambda expression"));


        btnToggle.setOnCheckedChangeListener((view,isChecked)->{
            if(isChecked)
                showMessage(view.getText().toString());
            else
                 showMessage(view.getText().toString());
        });

        autoSwitch.setOnCheckedChangeListener((view,isChecked)->{
            if(isChecked)
                showMessage(view.getText().toString());
            else
                showMessage(view.getText().toString());
        });
    }

    public void onLoginClicked(View view){
        Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show();
    }

    private void showMessage(String smg){
        Toast.makeText(this, smg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {

        switch (v.getId()){
            case R.id.btnLogin:
                showMessage("on Login Long clicked");
                return true;

            case  R.id.btnSignup :
                showMessage("on Signup Long clicked");
                return true;

                default:  return true;
        }

    }

    List<String> os=new ArrayList<>();
    public void onCheckBox(View view){
        CheckBox checkBox=(CheckBox) view;
        if(checkBox.isChecked()){
            os.add(checkBox.getText().toString());
        }else
            os.remove(checkBox.getText().toString());

        showMessage(os.toString());
    }

    public void onRadioButton(View v){
        RadioButton rd=(RadioButton)v;
        if(rd.isChecked())
            showMessage(rd.getText().toString());
    }
}
