package com.thealteria.timestables;

import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void genTable(int timesT) {

        ArrayList<String> arrayList = new ArrayList<String>();

        for(int i = 1; i <= 10; i++) {

            arrayList.add(Integer.toString(i*timesT));
        }



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seek);
        listView = (ListView) findViewById(R.id.table);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesT;

                if (progress < min) {
                    timesT = min;
                    seekBar.setProgress(min);
                }

                else {
                    timesT = progress;
                }

                genTable(timesT);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        genTable(10);

    }
}
