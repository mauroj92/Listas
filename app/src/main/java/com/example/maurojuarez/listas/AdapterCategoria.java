package com.example.maurojuarez.listas;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class AdapterCategoria extends ArrayAdapter<Categoria> {

    LayoutInflater inflater;
    List<Categoria> items;
    int posicionSeleccionada = -1;
    RadioButton radioSeleccionado = null;

    public AdapterCategoria(Context context, List<Categoria> items) {
        super(context,  R.layout.activity_lista, items);
        inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        //El convertView nos dice si la fila ya está dibujada en pantalla.
        //Si es null, entonces no está dibujada. En otro caso, se reutiliza.

        if (row == null) {
            row = inflater.inflate(R.layout.activity_lista, parent, false);
        }

        ViewHolder holder = (ViewHolder) row.getTag();
        //ViewHolder guarda toda la información de layout.

        if (holder == null) {
            holder = new ViewHolder(row);
            row.setTag(holder);

            RatingBar.OnRatingBarChangeListener listenerRatingBar = new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    //Acá se obtiene la posición donde se dispara el evento
                    Integer miPosicion = (Integer) ratingBar.getTag();
                    getItem(miPosicion).setInteres(v);

                    Log.d("miPosicion",String.valueOf(miPosicion));
                }
            };

            RadioButton.OnCheckedChangeListener listenerRadioButton = new RadioButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Integer posicion = (Integer) compoundButton.getTag();

                    if (posicion != posicionSeleccionada && radioSeleccionado != null) {
                        radioSeleccionado.setChecked(false);
                    }

                    posicionSeleccionada = posicion;
                    radioSeleccionado = (RadioButton) compoundButton;

                    //Setear como elegido al radio que dispara el evento.
                    items.get(posicion).setElegido(true);

                    //Setear como no elegidos a los demás radio.
                    for (int i = 0; i < items.size(); i++) {
                        if (i != posicion) {
                            items.get(i).setElegido(false);
                        }
                    }

                }
            };

            holder.interes.setOnRatingBarChangeListener(listenerRatingBar);
            holder.radio.setOnCheckedChangeListener(listenerRadioButton);
        }

        holder.titulo.setText(this.getItem(position).getTitulo());

        holder.descripcion.setText(this.getItem(position).getDescripcion());

        holder.interes.setTag(position);
        holder.interes.setRating((float) this.getItem(position).getInteres());

        holder.radio.setTag(position);

        if(posicionSeleccionada != position){
            holder.radio.setChecked(false);
        }else{
            holder.radio.setChecked(true);
            if(radioSeleccionado != null && holder.radio != radioSeleccionado){
                radioSeleccionado = holder.radio;
            }
        }

        try {
            holder.radio.setChecked(this.getItem(position).getElegido());
        }catch (Exception e ){}


        switch (this.getItem(position).getId()) {
            case 1 :
                holder.icono.setImageResource(R.drawable.facebook);
                break;
            case 2 :
                holder.icono.setImageResource(R.drawable.twitter);
                break;
            default:
                holder.icono.setImageResource(R.drawable.pinterest);
                break;
        }
        return(row);
    }

    class ViewHolder {
        ImageView icono = null;
        TextView titulo = null;
        TextView descripcion = null;
        RatingBar interes = null;
        RadioButton radio = null;

        ViewHolder(View base) {
            this.icono = (ImageView) base.findViewById(R.id.icono);
            this.titulo = (TextView) base.findViewById(R.id.titulo);
            this.descripcion = (TextView) base.findViewById(R.id.descripcion);
            this.interes= (RatingBar) base.findViewById(R.id.interes);
            this.radio = (RadioButton) base.findViewById(R.id.radio);
        }
    }
}
