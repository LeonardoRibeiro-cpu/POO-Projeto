package ClassesJava;

public class Vagas {
    private int numero;
    private boolean ocupada;
    private Veiculo veiculo;
    public Vagas() {
    }
       public Vagas(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.veiculo = null;
    }

    public boolean ocupar(Veiculo v) {
        if (this.ocupada) {
            return false; 
        }
        this.veiculo = v;
        this.ocupada = true;
        return true;
    }

    
    public boolean liberar() {
        if (!this.ocupada) {
            return false; 
        }
        this.veiculo = null;
        this.ocupada = false;
        return true;
    }
     public boolean isOcupada() {
        return ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public String exibe() {
        if (ocupada) {
            return "Vaga " + numero + " - Ocupada - " + veiculo.exibe();
        } else {
            return "Vaga " + numero + " - Livre";
        }
    }
}
