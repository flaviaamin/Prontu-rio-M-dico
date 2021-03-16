package entidade;


public class Doenca {
    private String nome, sintomas;

    public Doenca(String nome, String sintomas) {
        this.nome = nome;
        this.sintomas = sintomas;
    }
 
    
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    
}
