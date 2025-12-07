package ClassesJava;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private int cpf;
    private List<Veiculo> veiculos;


    public Cliente() {
        this.veiculos = new ArrayList<>();
     
    }

<<<<<<< HEAD
    public Cliente(String nome, String email, int cpf) {
=======
    public Cliente(String nome, String email, int cpf, List<Veiculo> veiculos) {

>>>>>>> f5eb4c458e7b43bbcd2b4db8f5acb84ac0a215db
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.veiculos = new ArrayList<>();
    }

    public boolean removerVeiculo(String placa) {
    for (Veiculo v : veiculos) {
        if (v.getPlaca().equalsIgnoreCase(placa)) {
            veiculos.remove(v);
            return true;
        }
    }
    return false;
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
        String texto = "Cliente: " + nome +
                   "\nEmail: " + email +
                   "\nCPF: " + cpf +
                   "\nVeículos:";

        for (Veiculo v : veiculos) {
            texto += "\n - " + v.exibe();
    } 
      return texto;
    }
}


