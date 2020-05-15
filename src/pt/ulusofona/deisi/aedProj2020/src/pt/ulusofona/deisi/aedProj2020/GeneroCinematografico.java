package pt.ulusofona.deisi.aedProj2020;

public class GeneroCinematografico {

    int idGenero;   
    String nome;
    

    public GeneroCinematografico(int idGenero, String nome) {
        this.idGenero= idGenero;
        this.nome = nome;

    }

   

    @Override
    public String toString() {
        return "|" + idGenero +  "|" + nome ;
    }
}
