package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproject.ATask.LoginTry;
import com.example.myproject.Dto.MemberDTO;

public class MainActivity extends AppCompatActivity {
    public static MemberDTO loginDTO = null;

    EditText etId, etPasswd;
    Button btnLogin, btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkDangerousPermissions();

        etId = findViewById(R.id.etId);
        etPasswd = findViewById(R.id.etPASSWD);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);

        //로그인 버튼
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etId.getText().toString().length() != 0 && etPasswd.getText().toString().length() != 0) {
                    String id = etId.getText().toString();
                    String passwd = etPasswd.getText().toString();

                    LoginTry loginTry = new LoginTry(id, passwd);
                    try {
                        loginTry.execute().get();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "아이디와 암호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (loginDTO != null) {
                    Toast.makeText(MainActivity.this, "로그인되었습니다. 환영합니다!", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", loginDTO.getId() + "님 로그인 되었습니다 !!!");
                } else {
                    Toast.makeText(MainActivity.this, "아이디 혹은 비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    Log.d("main:login", "아이디 혹은 비밀번호 불일치");
                    etId.setText("");
                    etPasswd.setText("");
                    etId.requestFocus();
                }
            }
        });//btnLogin.setOnClickListener()

        //회원가입 버튼
       btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });//btnJoin.setOnClickListener()
    }//onCreate()

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}//class