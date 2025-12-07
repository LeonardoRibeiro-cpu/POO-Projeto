package ClassesJava;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private int cpf;
    private List<Veiculo> veiculos;
    public static int contadorClientes;

    public Cliente() {
        this.veiculos = new ArrayList<>();
        contadorClientes++;
    }

    public Cliente(String nome, String email, int cpf, List<Veiculo> veiculos) {


        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.veiculos = veiculos;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo v) {
        if (v != null) {
            veiculos.add(v);
        }
    }

    public String exibe(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nome)
          .append("\nEmail: ").append(email)
          .append("\nCPF: ").append(cpf)
          .append("\nVeículos:");

        for (Veiculo v : veiculos) {
            sb.append("\n  - ").append(v.toString());
        }

        return sb.toString();
    }
    }


