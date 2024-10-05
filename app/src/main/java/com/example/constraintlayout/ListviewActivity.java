package com.example.constraintlayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListviewActivity extends AppCompatActivity {

    private ListView lv;
    private String[] number = {"Lê Văn Quý - 22115053122333", "Lê Văn A - 22115053122333", "Lê Văn B - 22115053122333", "Lê Văn C - 22115053122333", "Lê Văn D - 22115053122333", "Lê Văn E - 22115053122333"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv = (ListView) findViewById(R.id.lvMaSinhVien);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, number);
        lv.setAdapter(arrayAdapter);
    }
}