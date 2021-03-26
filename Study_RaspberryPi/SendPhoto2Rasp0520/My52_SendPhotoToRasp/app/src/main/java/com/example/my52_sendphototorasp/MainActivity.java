package com.example.my52_sendphototorasp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.my52_sendphototorasp.Common.CommonMethod.isNetworkConnected;

public class MainActivity extends AppCompatActivity {

    Button btnSendPhoto, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkDangerousPermissions();

        btnSendPhoto = findViewById(R.id.btnSendPhoto);
        btnExit = findViewById(R.id.btnExit);

        btnSendPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사진보내기
                if(isNetworkConnected(getApplicationContext()) == true){
                    Intent intent = new Intent(getApplicationContext(), Sub1Insert.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "인터넷이 연결되어 있지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 끝내기
                finish();
            }
        });
    }


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
}
