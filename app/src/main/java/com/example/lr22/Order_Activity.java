package com.example.lr22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Order_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView orderDescription = findViewById(R.id.orderDescription);
        Intent intent = getIntent();
        String sms = intent.getStringExtra("ORDER_DESCRIPTION");
        orderDescription.setText(sms);
    }
}