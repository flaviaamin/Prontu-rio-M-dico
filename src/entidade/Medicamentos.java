package entidade;


public class Medicamentos {

    private String nome, doencas;

    public Medicamentos(String nome, String doencas) {
        this.nome = nome;
        this.doencas = doencas;
    }

    

    public String getDoencas() {
        return doencas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
