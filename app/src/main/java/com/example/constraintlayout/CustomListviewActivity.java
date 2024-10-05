package com.example.constraintlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomListviewActivity extends AppCompatActivity {

    private ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_listview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvContact = (ListView) findViewById(R.id.lvContact);
        ArrayList<Contact> arrContact = new ArrayList<>();
        Contact contact1 = new Contact("Lê Văn Quý", "22115053122333", Color.RED);
        Contact contact2 = new Contact("Lê Văn A", "22115053122333", Color.GREEN);
        Contact contact3 = new Contact("Lê Văn B", "22115053122333", Color.GRAY);
        Contact contact4 = new Contact("Lê Văn C", "22115053122333", Color.YELLOW);
        Contact contact5 = new Contact("Lê Văn D", "22115053122333", Color.BLACK);
        Contact contact6 = new Contact("Lê Văn E", "22115053122333", Color.BLUE);
        Contact contact7 = new Contact("Lê Văn F", "22115053122333", Color.CYAN);
        arrContact.add(contact1);
        arrContact.add(contact2);
        arrContact.add(contact3);
        arrContact.add(contact4);
        arrContact.add(contact5);
        arrContact.add(contact6);
        arrContact.add(contact7);
        CustomAdapter customAdaper = new CustomAdapter(this, R.layout.row_listview, arrContact);
        lvContact.setAdapter(customAdaper);
    }
}