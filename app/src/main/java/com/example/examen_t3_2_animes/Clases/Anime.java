package com.example.examen_t3_2_animes.Clases;

public class   Anime {
    public String Nombre;
    public String Descripcion;
    public String Foto;
    public int Favorito;

    public Anime(String nombre, String descripcion, String foto, int favorito) {
        Nombre = nombre;
        Descripcion = descripcion;
        Foto = foto;
        Favorito = favorito;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public int getFavorito() {
        return Favorito;
    }

    public void setFavorito(int favorito) {
        Favorito = favorito;
    }
}
