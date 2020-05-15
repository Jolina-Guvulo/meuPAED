
package pt.ulusofona.deisi.aedProj2020;

/**
 *
 * @author jolina Guvulo
 */
public class Actor {
    int idActor;
    String nome;
    String sexo;
    int idFilme;
    
     public Actor( int idActor,String nome, String sexo,int idFilme) {
        this.idActor = idActor;
        this.nome = nome;
        this.sexo = sexo;
        this.idFilme = idFilme;      
     }

    Actor(int id, String nome, boolean masculino) {
        
    }

    @Override
    public String toString() {
        return  idActor + "|" + nome + "|" + sexo + "|" + idFilme + '|';
    }    
}
