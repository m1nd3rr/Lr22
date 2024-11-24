package com.example.lr22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Console;

public class Ex2_activity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton hotDrink;
    private RadioButton coldDrink;
    private RadioGroup deliveryRadioGroup;
    private CheckBox milkCheckBox;
    private CheckBox creamCheckBox;
    private CheckBox sugarCheckBox;
    private CheckBox syrupCheckBox;
    private Button deliverButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        imageView = findViewById(R.id.image);
        radioGroup = findViewById(R.id.radio_group);
        hotDrink = findViewById(R.id.hotRBtn);
        coldDrink = findViewById(R.id.coldRBtn);
        deliveryRadioGroup = findViewById(R.id.radioGroup);
        milkCheckBox = findViewById(R.id.milk);
        creamCheckBox = findViewById(R.id.Sliwki);
        sugarCheckBox = findViewById(R.id.Sugar);
        syrupCheckBox = findViewById(R.id.Sirop);
        deliverButton = findViewById(R.id.deliver_button);

     hotDrink.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             imageView.setBackgroundResource(R.drawable.baseline_whatshot_24);
         }
     });
        coldDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setBackgroundResource(R.drawable.baseline_severe_cold_24);
            }
        });

        deliverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedDrinkId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedDrink = findViewById(selectedDrinkId);
                String drinkType = selectedDrink != null ? selectedDrink.getText().toString() : "Не выбрано";
                RadioButton selDeliv = findViewById(deliveryRadioGroup.getCheckedRadioButtonId());
                String deliveryType = selDeliv != null ? selDeliv.getText().toString() : "Не выбрано";

                StringBuilder description = new StringBuilder();
                description.append("Напиток: ").append(drinkType).append("\n");
                description.append("Доставка: ").append(deliveryType).append("\n");
                if (milkCheckBox.isChecked()) {
                    description.append("Молоко\n");
                }
                if (creamCheckBox.isChecked()) {
                    description.append("Сливки\n");
                }
                if (sugarCheckBox.isChecked()) {
                    description.append("Сахар\n");
                }
                if (syrupCheckBox.isChecked()) {
                    description.append("Сироп\n");
                }

                Intent intent = new Intent(Ex2_activity.this, Order_Activity.class);
                intent.putExtra("ORDER_DESCRIPTION", description.toString());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Матукевич Артур", Toast.LENGTH_SHORT).show();


            }
        });
    }

}