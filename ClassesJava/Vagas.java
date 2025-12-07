package ClassesJava;

public class Vagas {
    private int numero;
    private boolean ocupada;
    private Veiculo veiculo;

    private static int ocupadas;
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
        ocupadas++;
        return true;
    }

    
    public boolean liberar() {
        if (!this.ocupada) {
            return false; 
        }
        this.veiculo = null;
        this.ocupada = false;
         ocupadas--;
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
    public static int getTotalOcupadas() {
    return ocupadas;
}
    public String exibe() {
        if (ocupada) {
            return "Vaga " + numero + " - Ocupada - " + veiculo.exibe();
        } else {
            return "Vaga " + numero + " - Livre";
        }
    }
}
