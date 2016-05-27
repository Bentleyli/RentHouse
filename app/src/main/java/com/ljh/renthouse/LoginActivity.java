package com.ljh.renthouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ljh.renthouse.custom.OvalButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_register,bt_forgetpwd;
    OvalButton bt_ovalButton;
    ImageView iv_out;
    EditText et_phoneNumber,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        bt_register = (Button) findViewById(R.id.button_register);
        bt_ovalButton = (OvalButton) findViewById(R.id.ovalButton_login);
        bt_forgetpwd = (Button) findViewById(R.id.button_forgetpwd_login);
        iv_out = (ImageView) findViewById(R.id.imageView_out);
        et_phoneNumber = (EditText) findViewById(R.id.editText_phonenumber_login);
        et_password = (EditText) findViewById(R.id.editText_password_login);

        bt_forgetpwd.setOnClickListener(this);
        bt_ovalButton.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        iv_out.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_register:
                Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ovalButton_login:
                Toast.makeText(LoginActivity.this, "登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_forgetpwd_login:
                Toast.makeText(LoginActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_out:
                finish();
                break;
        }
    }
}
