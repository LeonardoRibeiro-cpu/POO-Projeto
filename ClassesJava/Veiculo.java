package ClassesJava;
public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;

    public Veiculo(){
    }

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }
   public String exibe() {
    return modelo + "Cor: "+ cor + " - Placa: " + placa;
 }
} 