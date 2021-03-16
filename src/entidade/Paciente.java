package entidade;


import java.util.ArrayList;


public class Paciente {

    private String nome, sexo, endereco;
    private int idade;
    private ArrayList<Consulta> consultas; 

    public Paciente(String nome, String sexo, String endereco, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        consultas = new ArrayList();
    }

    public ArrayList <Consulta> getConsultas(){
        return consultas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}
