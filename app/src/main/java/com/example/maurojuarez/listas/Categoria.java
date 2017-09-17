package com.example.maurojuarez.listas;

/**
 * Created by Mauro Juarez on 14 sep 2017.
 */

public class Categoria {
    private int id;
    private String titulo;
    private String descripcion;
    private double interes;
    private Boolean elegido;

    public Categoria() {
        super();
    }

    public Categoria(int id, String titulo, String descripcion, double interes) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.interes = interes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public Boolean getElegido() {
        return elegido;
    }

    public void setElegido(Boolean elegido) {
        this.elegido = elegido;
    }
}
