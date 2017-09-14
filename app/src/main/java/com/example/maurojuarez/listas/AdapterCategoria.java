package com.example.maurojuarez.listas;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCategoria extends ArrayAdapter<Categoria> {

    LayoutInflater inflater;

    public AdapterCategoria(Context context, List<Categoria> items) {
        super(context,  R.layout.activity_lista, items);
        inflater = LayoutInflater.from(context);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.activity_lista, parent, false);

        TextView titulo=(TextView) row.findViewById(R.id.titulo);
        titulo.setText(this.getItem(position).getTitulo());

        TextView descripcion = (TextView) row.findViewById(R.id.descripcion);
        descripcion.setText(this.getItem(position).getDescripcion());

        ImageView icono = (ImageView) row.findViewById(R.id.icono);

        switch (this.getItem(position).getId()) {
            case 1 :
                icono.setImageResource(R.drawable.facebook);
                break;
            case 2 :
                icono.setImageResource(R.drawable.twitter);
                break;
            default:
                icono.setImageResource(R.drawable.pinterest);
                break;
        }
        return(row);
    }
}
