package com.example.appbooking.page.admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appbooking.Database.MySQLite;
import com.example.appbooking.MainActivity;
import com.example.appbooking.R;
import com.example.appbooking.page.admin.QuanLyDanhGia.QuanLyDanhGia;

import com.example.appbooking.page.admin.adRoom.quanLyPhong;
import com.example.appbooking.page.admin.quanLyUser.quanLyUser;

public class homeAdmin extends AppCompatActivity {
    LinearLayout qlUser, qlPhong, qlDanhGia, qlMa, qlDon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences sharedPreferences = this.getSharedPreferences("UserInfo", this.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        String hinh = sharedPreferences.getString("hinh", "Guest");
        String name = sharedPreferences.getString("ten", "Guest");
        qlUser = findViewById(R.id.qlUser);
        qlPhong = findViewById(R.id.qlPhong);
        qlDanhGia = findViewById(R.id.qlDanhGia);
        qlMa = findViewById(R.id.qlMa);
        qlDon = findViewById(R.id.qlDon);
        //imgAvt = findViewById(R.id.imgAvt);
        //tvTenTK = findViewById(R.id.tvTenTK);
        //
        // tvTenTK.setText(name);
        MySQLite db = new MySQLite();
        String anh = db.getDrawableResourceUrl(this, hinh);
//        imgAvt.setImageURI(Uri.parse(anh));
        qlUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(homeAdmin.this, quanLyUser.class);
                startActivity(in1);
            }
        });

        qlPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(homeAdmin.this, quanLyPhong.class);
                startActivity(in2);
            }
        });

        qlDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        qlMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        qlDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}