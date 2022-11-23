package com.example.bkt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView btdk;
    Button btlogin;
    EditText usLI,paLI;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btdk = (TextView) findViewById(R.id.chuyendk);
        btlogin = (Button) findViewById(R.id.btnLogin);
        usLI = (EditText) findViewById(R.id.txtPhone);
        paLI = (EditText) findViewById(R.id.txtPassWord);
        btdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }
    public void loginUser() {
        String gmail =usLI.getText().toString();
        String pass = paLI.getText().toString();

        if (TextUtils.isEmpty(gmail)) {
            usLI.setError("Không thể để trống email");
            usLI.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            paLI.setError("Không thể để trống mật khẩu");
            paLI.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(gmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, ListCayThuocNam.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}