package ClassesJava;

public class Funcionario {
    private String nome;
    private String cpf;
    private String cargo;
    private double salario;
    public Funcionario(){
    }
    public Funcionario(String nome, String cpf, String cargo, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }
    public String exibe() {
        return "Nome: " + nome + " - CPF: " + cpf + " - Cargo: " + cargo + " - Salário: " + salario;
    }

    public String getCpf() {
        return cpf;
    }
}
