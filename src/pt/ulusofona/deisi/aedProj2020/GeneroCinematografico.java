package pt.ulusofona.deisi.aedProj2020;

public class GeneroCinematografico {

    int idGenero;
    String nome;
    int idFilme;

    public GeneroCinematografico(int idFilme, int idGenero) {
        this.idFilme = idFilme;
        this.idGenero = idGenero;

    }

    public GeneroCinematografico(int idGenero, String nome) {
        this.idGenero = idGenero;
        this.nome = nome;

    }

    GeneroCinematografico(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "GeneroCinematografico{" + "idGenero=" + idGenero + ", nome=" + nome + ", idFilme=" + idFilme + '}';
    }
}
