package com.example.welcomebos.intentalifix;

/**
 * Created by Welcome Bos on 4/17/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity_gridview extends Activity {
    Button btnsave;
    ArrayAdapter<String> arrayAdapter;
    GridView simpleList;
    String listbunga[] = {"Sawi", "Kangkung", "Kacang Panjang", "Brokoli", "Selada", "Buncis", "Bawang", "Bombai", "Wortel", "Tomat", "Bayem", "Terong", "Tulip", "Flamboyan", "Matahari", "Edelwis", "Camellia", "Bangkai", "Krisan", "Bougenvil", "Protea", "Grandia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gridview);

        simpleList = (GridView) findViewById(R.id.simpleGridView);
        btnsave = (Button) findViewById(R.id.btnsavegridview);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listbunga);
        simpleList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        simpleList.setAdapter(arrayAdapter);

        btnsave.setOnClickListener(new View.OnClickListener(){
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