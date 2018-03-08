package com.example.welcomebos.intentalifix;

import android.app.SearchManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    ListView outputlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buah = (Button)findViewById(R.id.button1);
        Button bunga = (Button) findViewById(R.id.button2);
        Button listView = (Button) findViewById(R.id.button3); //Menambahkan baru
        outputlistview = (ListView) findViewById(R.id.output);

        //BUTTON SATU
        buah.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent_buah = new Intent(MainActivity.this,MainActivity_listview.class);
                startActivityForResult(intent_buah,101);
            }
        });

        //BUTTON DUA
        bunga.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent_bunga = new Intent(MainActivity.this,MainActivity_gridview.class);
                startActivityForResult(intent_bunga,102);
            }
        });

        //BUTTON TIGA
        listView.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent_listView = new Intent(MainActivity.this, MainActivity_listview_baru.class);
                startActivityForResult(intent_listView, 103);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResults = data.getExtras();
                String[] vresult = myResults.getStringArray("selectedItems");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vresult);
                outputlistview.setAdapter(arrayAdapter);
            }

            else if ((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResults = data.getExtras();
                String[] vresult = myResults.getStringArray("selectedItems");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vresult);
                outputlistview.setAdapter(arrayAdapter);
            }

            else if ((requestCode == 103 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResults = data.getExtras();
                String[] vresult = myResults.getStringArray("selectedItems");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vresult);
                outputlistview.setAdapter(arrayAdapter);

            }

        }
        catch (Exception e) {


        }
    }
}
