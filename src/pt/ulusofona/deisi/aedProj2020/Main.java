package pt.ulusofona.deisi.aedProj2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static ArrayList<Movie> filmes = new ArrayList<>();
    //Map<nomeFicheiro, qtdLinhasIgnoradas>
    static Map<String, Integer> listIgnoredLines = new HashMap<>();

    //Nomes ficheiros
    static final String FICHEIRO_MOVIES = "deisi_movies.txt";
    static final String FICHEIRO_ATORES = "deisi_actors.txt";
    static final String FICHEIRO_GENEROS = "deisi_genres.txt";
    static final String FICHEIRO_DIRECTORS = "deisi_directors.txt";
    static final String FICHEIRO_GENEROFILME = "deisi_genres_movies.txt";
    static final String FICHEIRO_VOTOSFILME = "deisi_movie_votes.txt";

    public static void main(String[] args) {

        filmes = getMovies();

        for (Movie filme : filmes) {
            System.out.println(filme.toString());
        }
    }

    public static ArrayList<Movie> getMovies() {
        parseFiles();
        return filmes;
    }

    //GUARDA FILMES
    public static void parseFiles() {
        //clean filmes
        //filmes.clear();
        lerFicheiro_Movies();
        lerFicheiro_Atores();
        lerFicheiro_Generos();
        lerFicheiro_Directors();
        lerFicheiro_GeneroFilme();
        lerFicheiro_VotosFilme();
    }

    public static void lerFicheiro_Movies() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_MOVIES));
            String linha = reader.readLine();
            do {
                // partir a linha no caractere separador
                String dados[] = linha.split(",");
                //avaliar linhas ignoradas
                if (dados.length > 5 || dados.length < 5) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_MOVIES);
                } else {
                    //Linha é valida
                    int id = Integer.parseInt(dados[0].trim());
                    String titulo = dados[1].trim();
                    float duracao = Float.parseFloat(dados[2].trim());
                    int orcamento = Integer.parseInt(dados[3].trim());
                    String dataLancamento = dados[4].trim();
                    Movie newFilme = new Movie(id, titulo, duracao, orcamento, dataLancamento);
                    //ver se filme existe
                    filmes.add(newFilme);
//                    boolean filmeExiste = false;
//                    for(Movie film : filmes){
//                        if(film.id == newFilme.id) {
//                            filmeExiste = true;
//                        }
//                    }
//                    if(!filmeExiste) {
//                        filmes.add(newFilme);
//                    }
                }
                linha = reader.readLine();
            } while (linha != null);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_MOVIES + "nao foi encontrado.";
            System.out.println(mensagem);

        }
    }

    public static void lerFicheiro_Atores() {
        //GUARDA ATORES-------------

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_ATORES));
            String linha = reader.readLine();
            do {
                // partir a linha no caractere separador
                String dados[] = linha.split(",");
                //avaliar linhas ignoradas
                if (dados.length > 4 || dados.length < 4) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_ATORES);
                } else {
                    //Linha é valida                
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    String sexo = dados[2].trim();
                    int idFilme = Integer.parseInt(dados[3].trim());
                    Actor actor = new Actor(id, nome, sexo, idFilme);
                    for (Movie film : filmes) {
                        if (film.id == idFilme) {
                            film.actores.add(actor);
                        }
                    }
                }
                linha = reader.readLine();
            } while (linha != null);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_MOVIES + "nao foi encontrado.";
            System.out.println(mensagem);
        }
    }

    public static void lerFicheiro_Generos() {

        //GUARDA GENEROS
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_GENEROS));
            String linha = reader.readLine();
            do {
                String dados[] = linha.split(",");
                //avaliar linhas ignoradas
                if (dados.length > 2 || dados.length < 2) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_GENEROS);
                } else {
                    //Linha é valida
                    String nome = dados[1].trim();
                    int idfilme = Integer.parseInt(dados[0].trim());
                    GeneroCinematografico genero = new GeneroCinematografico(nome);
                    for (Movie film : filmes) {
                        if (film.id == idfilme) {
                            film.generos.add(genero);
                        }
                    }
                }
                linha = reader.readLine();
            } while (linha != null);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_GENEROS + "nao foi encontrado.";
            System.out.println(mensagem);
        }
    }

    public static void lerFicheiro_Directors() {
        //GUARDA DIRECTORES-------------
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_DIRECTORS));
            String linha = reader.readLine();
            linha = reader.readLine();
            do {

                String dados[] = linha.split(",");

                //avaliar linhas ignoradas
                if (dados.length > 3 || dados.length < 3) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_DIRECTORS);
                } else {
                    //Linha é valida
                    int idDirector = Integer.parseInt(dados[0].trim());
                    String directorNome = dados[1].trim();
                    int idFilme = Integer.parseInt(dados[2].trim());
                    Realizador realizador = new Realizador(idDirector, directorNome, idFilme);
                    for (Movie film : filmes) {
                        if (film.id == idFilme) {
                            film.realizadores.add(realizador);
                        }
                    }
                }
                linha = reader.readLine();
            } while (linha != null);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_DIRECTORS + "nao foi encontrado.";
            System.out.println(mensagem);
        }
    }

    public static void lerFicheiro_GeneroFilme() {
        //GUARDA DIRECTORES-------------

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_GENEROFILME));
            String linha = reader.readLine();
            do {
                String dados[] = linha.split(",");
                //avaliar linhas ignoradas
                if (dados.length > 2 || dados.length < 2) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_GENEROFILME);
                } else {
                    //Linha é valida
                    int idGenero = Integer.parseInt(dados[0].trim());
                    int idFilme = Integer.parseInt(dados[1].trim());
                    GeneroCinematografico genero = new GeneroCinematografico(idGenero, idFilme);
                    for (Movie film : filmes) {
                        if (film.id == idFilme) {
                            film.generos.add(genero);
                        }
                    }
                }
                linha = reader.readLine();
            } while (linha != null);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_GENEROFILME + "nao foi encontrado.";
            System.out.println(mensagem);
        }
    }

    public static void lerFicheiro_VotosFilme() {
        //GUARDA VOTOS
        try {
            File ficheiro = new File(FICHEIRO_VOTOSFILME);
            BufferedReader reader = new BufferedReader(new FileReader(FICHEIRO_VOTOSFILME));
            String linha = reader.readLine();
            do {
                String dados[] = linha.split(",");

                //avaliar linhas ignoradas
                if (dados.length > 3 || dados.length < 3) {
                    //Linha é invalida
                    addIgnoredLine(FICHEIRO_VOTOSFILME);
                } else {
                    //Linha é valida
                    int idFilme = Integer.parseInt(dados[0].trim());
                    double mediaDeVotos = Double.parseDouble(dados[1].trim());
                    int nrDeVotos = Integer.parseInt(dados[2].trim());

                    for (Movie film : filmes) {
                        if (film.id == idFilme) {
                            film.mediaDeVotos = mediaDeVotos;
                            film.nrDeVotos = nrDeVotos;
                        }
                    }
                }
                linha = reader.readLine();
            } while (linha != null);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            String mensagem = "Erro: o ficheiro " + FICHEIRO_GENEROFILME + "nao foi encontrado.";
            System.out.println(mensagem);
        }
    }

    public static void addIgnoredLine(String fileName) {
        Integer qtdLinhasIgnoradas = listIgnoredLines.get(fileName);
        if (qtdLinhasIgnoradas == null) {
            listIgnoredLines.put(fileName, 1);
        } else {
            listIgnoredLines.put(fileName, ++qtdLinhasIgnoradas);
        }
    }

    public static int countIgnoredLines(String fileName) {
        int numLinhasIgnoradas = 0;
        switch (fileName) {
            case FICHEIRO_MOVIES:

                break;
            case FICHEIRO_ATORES:

                break;
            case FICHEIRO_GENEROS:

                break;
            case FICHEIRO_DIRECTORS:
                break;

            case FICHEIRO_GENEROFILME:
                break;
            case FICHEIRO_VOTOSFILME:
                break;
        }
        return numLinhasIgnoradas;
    }
}
