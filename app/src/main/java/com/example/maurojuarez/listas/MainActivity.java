package com.example.maurojuarez.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lista);
        Categoria[] cat = new Categoria[]{
                new Categoria(1,"Facebook","Red Social",4.0),
                new Categoria(2,"Twitter", "Red Social",1.0),
                new Categoria(3,"Pinterest","Red Social",4.0),
                new Categoria(4,"Instagram", "Red Social",0),
                new Categoria(5,"Google","Red Social",5.0),
                new Categoria(6,"Youtube", "Red Social",5.0),
                new Categoria(1,"Facebook","Red Social",4.0),
                new Categoria(2,"Twitter", "Red Social",1.0),
                new Categoria(3,"Pinterest","Red Social",4.0),
                new Categoria(4,"Instagram", "Red Social",0),
                new Categoria(5,"Google","Red Social",5.0),
                new Categoria(6,"Youtube", "Red Social",5.0),
        };
        AdapterCategoria adapter = new AdapterCategoria(getApplicationContext(), Arrays.asList(cat));
        lv.setAdapter(adapter);
    }
}
