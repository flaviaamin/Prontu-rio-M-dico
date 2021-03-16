package protuariomedico;

import entidade.Consulta;
import entidade.Doenca;
import entidade.Medicamentos;
import entidade.Paciente;
import java.io.InputStream;
import java.util.Scanner;
import entidade.Paciente;
import entidade.Registros;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class ProntuarioMedico {

    Scanner entrada;

    Registros reg;

    public ProntuarioMedico() {
        reg = new Registros();
        entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ProntuarioMedico pm = new ProntuarioMedico();

        Scanner entrada = new Scanner(System.in);
        int opcao;
        System.out.println("Seja bem vindo ao sistema Medico\n");
        do {
            System.out.println("\n\n\nMENU\n"
                    + "1 para cadastrar um novo paciente\n"
                    + "2 para cadastrar um novo medicamento\n"
                    + "3 para cadastrar uma doença\n"
                    + "4 para cadastrar uma nova consulta\n"
                    + "5 para sair");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    pm.cadastroPaciente();
                    break;
                case 2:
                    pm.cadastroMedicamento();
                    break;
                case 3:
                    pm.cadastroDoenca();
                    break;
                case 4:
                    pm.cadastroConsulta();
                    break;
                case 5:
                    System.out.println("Você saiu do programa");
                    break;

                default:
                    System.out.println("Digite novamente");

            }

        } while (opcao != 5);
    }

    private void cadastroConsulta() {
        Scanner entrada = new Scanner(System.in);
        String medico, sintomas, diagnostico, data, hora;
        System.out.println("Digite o nome do paciente");
        String nome = entrada.nextLine();
        Paciente paciente = procurarPaciente(nome);

        if (paciente == null) {
            System.out.println("paciente não encontrado, cadastre o paciente");
            paciente = cadastroPaciente();
        }

        System.out.println("Digite o nome do medico: ");
        medico = entrada.nextLine();
        System.out.println("Digite a data da consulta");
        data = entrada.nextLine();
        System.out.println("Digite a hora da consulta");
        hora = entrada.nextLine();

        Consulta c = new Consulta(paciente);
        c.setMedico(medico);
        c.setData(data);
        c.setHora(hora);
        realizarConsulta(c);

    }

    public void realizarConsulta(Consulta c) {
        Scanner entrada;
        String sintomas;
        entrada = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Digite os sintomas do paciente: ");
        sintomas = entrada.nextLine();
        c.setSintomas(sintomas);

        String diagnostico = realizarDiagnostico(sintomas);
        System.out.println("\n\n");
        c.setDiagnostico(diagnostico);
        System.out.println("O diagnostico é: " + diagnostico);

    }

    public String realizarDiagnostico(String sintomas) {
        String diagnostico = "";
        ArrayList<Doenca> possivelDoencas = new ArrayList<>();

        for (int i = 0; i < reg.getArrayDoencas().size(); i++) {
            Doenca d = reg.getArrayDoencas().get(i);
            if (d.getSintomas().contains(sintomas)) {
                possivelDoencas.add(d);
            }

        }
        System.out.println("\n\n");
        System.out.println("Conforme os sintomas essas são as possiveis doenças: ");
        for (int i = 0; i < possivelDoencas.size(); i++) {
            System.out.println("Doença: " + possivelDoencas.get(i).getNome()
                    + "\nSintomas: " + possivelDoencas.get(i).getSintomas());
            System.out.println("Confirma?\nS - sim \nN -não");
            String aceita = entrada.nextLine();
            if (aceita.compareTo("S") == 0) {
                diagnostico += possivelDoencas.get(i).getNome() + " ";

            }
        }
        if (diagnostico.compareTo("") == 0) {
            System.out.println("\n\n");
            System.out.println("1 - Deseja deixar sem diagnostico");

            System.out.println("2 - Cadastrar nova doença");
            if (entrada.nextInt() == 1) {

                diagnostico = ("Nenhum diagnóstico");

            } else {

                Doenca d = cadastroDoenca();
                diagnostico += d.getNome();
            }

        }

        return diagnostico;

    }

    public Paciente procurarPaciente(String nome) {
        for (int i = 0; i < reg.getArrayPacientes().size(); i++) {

            if (reg.getArrayPacientes().get(i).getNome().compareTo(nome) == 0) {
                return reg.getArrayPacientes().get(i);
            }

        }
        return null;

    }

    private Doenca cadastroDoenca() {

        String nome, sintomas, medicamentos;
        System.out.println("\n\n");
        System.out.println("Digite o nome da doença: ");
        nome = entrada.next();
        System.out.println("Digite os sintomas desta doença: ");
        sintomas = entrada.next();
        System.out.println("Digite os medicamentos que podem combater essa doença: ");
        medicamentos = entrada.next();
        Doenca doencas = new Doenca(nome, sintomas);
        reg.getArrayDoencas().add(doencas);
        return doencas;
    }

    private void cadastroMedicamento() {

        String nome, doencas;
        System.out.println("\n\n");
        System.out.println("Digite o nome do Medicamento: ");
        nome = entrada.next();
        System.out.println("Digite o nome das doenças que pode combater: ");
        doencas = entrada.next();
        Medicamentos med = new Medicamentos(nome, doencas);
        reg.getArrayMedicamentos().add(med);
    }

    private Paciente cadastroPaciente() {

        String nome, sexo, endereco;
        int idade;
        System.out.println("\n\n");
        
        System.out.println("Digite o nome do paciente: ");
        nome = entrada.next();
        System.out.println("Digite o sexo do paciente: ");
        sexo = entrada.next();
        System.out.println("Digite o endereço do paciente: ");
        endereco = entrada.next();
        System.out.println("Digite a idade do paciente: ");
        idade = entrada.nextInt();
        Paciente p = new Paciente(nome, sexo, endereco, idade);
        reg.getArrayPacientes().add(p);
        return p;
    }

}
