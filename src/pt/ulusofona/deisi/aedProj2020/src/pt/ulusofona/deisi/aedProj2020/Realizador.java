package pt.ulusofona.deisi.aedProj2020;

public class Realizador {

    String nome;
    int idDirector;

    int idMovie;

    public Realizador(int idDirector, String nome, int idMovie) {
        this.idDirector = idDirector;
        this.nome = nome;
        this.idMovie = idMovie;
    }

    public Realizador(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome + "|" + idDirector + "|" + idMovie;
    }
}
