package com.example.projecttask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView ListViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewItems = (ListView) findViewById(R.id.listViewItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListViewItems.setAdapter(itemsAdapter);
        items.add("Liitutaulu");
        items.add("Kirjoita myös");

        Button btnGallery = (Button) findViewById(R.id.btnGallery);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalleria();
            }
        });
    }

    public void openGalleria() {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("appcompat.app.AppCompatActivity.INDEX", 1);
        startActivity(intent);
    }

    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.ListViewNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }
}