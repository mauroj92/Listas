package com.example.maurojuarez.listas;

/**
 * Created by Mauro Juarez on 14 sep 2017.
 */

public class Categoria {
    private int id;
    private String titulo;
    private String descripcion;

    public Categoria() {
        super();
    }

    public Categoria(int id, String titulo, String descripcion) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
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
}
