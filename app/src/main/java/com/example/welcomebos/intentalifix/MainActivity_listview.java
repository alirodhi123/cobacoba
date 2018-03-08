package com.example.welcomebos.intentalifix;

/**
 * Created by Welcome Bos on 4/17/2017.
 */

import android.app.Activity;

/**
 * Created by Lina Meritha on 15/04/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity_listview extends Activity {

    //INISIALISASI
    Button btnsave;
    ArrayAdapter<String> arrayAdapter;
    ListView simpleList;
    String listbuah[] = {"Kuda", "Gajah", "Belalang", "Jangkrik", "Siput", "Macan", "Singa", "Beruang", "Semut", "Kancil", "Angsa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);

        simpleList = (ListView) findViewById(R.id.simplelistview); //Memanggil widget id ListView
        btnsave = (Button) findViewById(R.id.btnsavelistview); //Memanggil widget id Button

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listbuah); //Membuat objek Array Adapter
        simpleList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);//Memilih mode ListView
        simpleList.setAdapter(arrayAdapter);
        btnsave.setOnClickListener(new View.OnClickListener(){ //Ketika Button di klik
            public void onClick(View view){
                SparseBooleanArray checked = simpleList.getCheckedItemPositions();
                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    // Item position in adapter
                    int position = checked.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))
                        selectedItems.add(arrayAdapter.getItem(position));
                }

                String[] outputStrArr = new String[selectedItems.size()];

                for (int i = 0; i < selectedItems.size(); i++) {
                    outputStrArr[i] = selectedItems.get(i);
                }

                Intent myLocalIntent = getIntent();

                // Create a bundle object
                Bundle b = new Bundle();
                b.putStringArray("selectedItems", outputStrArr);

                // Add the bundle to the intent.
                myLocalIntent.putExtras(b);

                setResult(Activity.RESULT_OK, myLocalIntent);
                Toast.makeText(getApplicationContext(), "Berhasil Menyimpan", Toast.LENGTH_LONG).show();
            }
        });
    }
}

