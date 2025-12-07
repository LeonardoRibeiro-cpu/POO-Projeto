package ClassesJava;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private String nome;
    private String endereco;

    private List<Vagas> vagas;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;

    public Estacionamento(String nome, String endereco, int qtdVagas) {
        this.nome = nome;
        this.endereco = endereco;

        // Composição — o estacionamento cria suas vagas
        vagas = new ArrayList<>();
        for (int i = 1; i <= qtdVagas; i++) {
            vagas.add(new Vagas(i));
        }

        // Agregação — adicionados externamente
        funcionarios = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    // -------------------------
    // MÉTODOS DE VAGAS
    // -------------------------

    public boolean ocuparVaga(int numero, Veiculo v) {
        if (numero < 1 || numero > vagas.size()) return false;

        return vagas.get(numero - 1).ocupar(v);
    }

    public boolean liberarVaga(int numero) {
        if (numero < 1 || numero > vagas.size()) return false;

        return vagas.get(numero - 1).liberar();
    }

    public void exibirVagas() {
        System.out.println("=== LISTA DE VAGAS ===");
        for (Vagas v : vagas) {
            System.out.println(v.exibe());
        }
        System.out.println("TOTAL OCUPADAS: " + Vagas.getTotalOcupadas());
    }

    // -------------------------
    // MÉTODOS DE FUNCIONÁRIOS
    // -------------------------

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void exibirFuncionarios() {
        System.out.println("=== FUNCIONÁRIOS ===");
        for (Funcionario f : funcionarios) {
            System.out.println(f.exibe());
        }
    }

    // -------------------------
    // MÉTODOS DE CLIENTES
    // -------------------------

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public void exibirClientes() {
        System.out.println("=== CLIENTES ===");
        for (Cliente c : clientes) {
            System.out.println(c.exibe());
        }
    }

    // -------------------------
    // EXIBIÇÃO COMPLETA
    // -------------------------

    public void exibir() {
        System.out.println("\n=== ESTACIONAMENTO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println();

        exibirVagas();
        System.out.println();

        exibirFuncionarios();
        System.out.println();

        exibirClientes();
    }
}
