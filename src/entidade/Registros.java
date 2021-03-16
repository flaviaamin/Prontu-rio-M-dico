package entidade;

import java.util.ArrayList;

public class Registros {

    private ArrayList<Paciente> arrayPacientes;
    private ArrayList<Medicamentos> arrayMedicamentos;
    private ArrayList<Doenca> arrayDoencas;

    public Registros() {
        arrayPacientes = new ArrayList();
        arrayMedicamentos = new ArrayList();
        arrayDoencas = new ArrayList();
        
        carregarMedicamentos();
        carregarDoencas();
        carregarPacientes();

    }

    public void carregarPacientes() {
        arrayPacientes.add(new Paciente("flavia", "feminino", "av.tiaraju", 19));
        arrayPacientes.add(new Paciente("joão", "masculino", "av.ibicui", 16));
        arrayPacientes.add(new Paciente("Henrique", "masculino", "av.sapé", 45));
        arrayPacientes.add(new Paciente("rafaela", "feminino", "av.sapé", 50));
        arrayPacientes.add(new Paciente("bruno", "masculino", "travessa b", 23));

    }

    public void carregarMedicamentos() {
        arrayMedicamentos.add(new Medicamentos("cinegripe", "gripe"));
        arrayMedicamentos.add(new Medicamentos("dorflex", "inflamação muscular"));
        arrayMedicamentos.add(new Medicamentos("insulina", "diabetes"));
        arrayMedicamentos.add(new Medicamentos("", ""));

    }

    public void carregarDoencas() {
        arrayDoencas.add(new Doenca("gripe", "febre, dor de cabeça, dor no corpo"));
    }

    public ArrayList<Medicamentos> getArrayMedicamentos() {
        return arrayMedicamentos;

    }

    public ArrayList<Paciente> getArrayPacientes() {
        return arrayPacientes;
    }

    public ArrayList<Doenca> getArrayDoencas() {
        return arrayDoencas;
    }

}
