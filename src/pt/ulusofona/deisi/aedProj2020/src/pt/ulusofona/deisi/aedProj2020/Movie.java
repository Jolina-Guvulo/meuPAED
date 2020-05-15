package pt.ulusofona.deisi.aedProj2020;

import java.util.ArrayList;

public class Movie {

    int id;
    String titulo;
    float duracao;
    ArrayList<Actor> actores;
    ArrayList<Realizador> realizadores;
    ArrayList<GeneroCinematografico> generos;
    String dataLancamento;
    int orcamento;
    double mediaDeVotos;
    int nrDeVotos;

    public Movie(int id, String titulo, float duracao, int orcamento, String dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.orcamento = orcamento;
        this.dataLancamento = dataLancamento;
        this.actores = new ArrayList<>();
        this.realizadores = new ArrayList<>();
        this.generos = new ArrayList<>();
    }

    public Movie(int id, String titulo, String dataLancamento, float duracao, int orcamento,
            double mediaDeVotos, int nrVotos) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.mediaDeVotos = mediaDeVotos;
        this.nrDeVotos = nrVotos;
    }

    Movie(int id, double mediaDeVotos, int nrDeVotos) {
        this.id = id;
        this.mediaDeVotos = mediaDeVotos;
        this.nrDeVotos = nrDeVotos;
    }

    Movie(int id, String titulo, String dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
            return  this.id + " | " + this.titulo + " | " + this.dataLancamento ;
                
                
    }

}
