package ClassesJava;
import java.util.Scanner;
public class App {
    public static Scanner s = new Scanner(System.in);
     public static Estacionamento leDados() {
        System.out.print("Nome do Estacionamento: ");
        String nome = s.nextLine();

        System.out.print("Endereço do Estacionamento: ");
        String endereco = s.nextLine();

        System.out.print("Quantidade de Vagas: ");
        int qtdVagas = s.nextInt();
        s.nextLine();
        return new Estacionamento(nome, endereco, qtdVagas);
     }

     public static void menu(Estacionamento est) {
        int op = 0;

        do {
          System.out.println("=== MENU DO ESTACIONAMENTO ===");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Adicionar Cliente");
        System.out.println("3. Adicionar Veículo ao Cliente");
        System.out.println("4. Exibir Vagas");
        System.out.println("5. Ocupar Vaga");
        System.out.println("6. Liberar Vaga");
        System.out.println("7. Exibir Funcionários");
        System.out.println("8. Exibir Clientes");
        System.out.println("9. Exibir Veículos de um Cliente");
        System.out.println("10. Apagar Funcionário");
        System.out.println("11. Apagar Cliente");
        System.out.println("12. Apagar Veículo de um Cliente");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
            op = s.nextInt();
            s.nextLine(); 
            switch (op) {
                case 1:
                    adicionarFuncionario(est);
                    break;
                case 2:
                    adicionarCliente(est);
                    break;
                case 3:
                    adicionarVeiculoCliente(est);
                    break;
                case 4:
                    est.exibirVagas();
                    break;
                case 5:
                    ocuparVaga(est);
                    break;
                case 6:
                    System.out.print("Número da Vaga a ser liberada: ");
                    int numero = s.nextInt();
                    s.nextLine();
                    boolean sucesso = est.liberarVaga(numero);
                    if (sucesso) {
                        System.out.println("Vaga liberada com sucesso!");
                    } else {
                        System.out.println("Vaga já está livre ou número inválido.");
                    }
                    break;
                case 7:
                    exibirFuncionarios(est);
                    break;
                case 8:
                    exibirClientes(est);
                    break;
                case 9:
                    exibirVeiculosCliente(est);
                    break;
                case 10:
                    System.out.print("CPF do Funcionário a ser removido: ");
                    String cpfFunc = s.nextLine();
                    boolean removedFunc = est.removerFuncionario(cpfFunc);
                    if (removedFunc) {
                        System.out.println("Funcionário removido com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 11:
                    System.out.print("CPF do Cliente a ser removido: ");
                    String cpfCli = s.nextLine();
                    boolean removedCli = est.removerCliente(cpfCli);
                    if (removedCli) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                
                case 12:
                    System.out.print("CPF do Cliente: ");
                    String cpf = s.nextLine();
                    Cliente cliente = est.buscarClientePorCpf(cpf);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Placa do Veículo a ser removido: ");
                    String placa = s.nextLine();
                    boolean removed = cliente.removerVeiculo(placa);
                    if (removed) {
                        System.out.println("Veículo removido com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);
        
     }
    
     public static void adicionarFuncionario(Estacionamento est) {
        System.out.print("Nome do Funcionário: ");
        String nome = s.nextLine();

        System.out.print("CPF do Funcionário: ");
        String cpf = s.nextLine();

        System.out.print("Cargo do Funcionário: ");
        String cargo = s.nextLine();

        System.out.print("Salário do Funcionário: ");
        double salario = s.nextDouble();
        s.nextLine(); 

        Funcionario f = new Funcionario(nome, cpf, cargo, salario);
        est.adicionarFuncionario(f);
        System.out.println("Funcionário adicionado com sucesso!");
     }
    
    public static void adicionarCliente(Estacionamento est) {
        System.out.print("Nome do Cliente: ");
        String nome = s.nextLine();
        System.out.print("Email do Cliente: ");
        String email = s.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = s.nextLine();
       
        Cliente c = new Cliente(nome, email, cpf);
        est.adicionarCliente(c);
        System.out.println("Cliente adicionado com sucesso!");
    }
    
    public static void adicionarVeiculoCliente(Estacionamento est) {
        System.out.print("CPF do Cliente: ");
        String cpf = s.nextLine();
     
        Cliente cliente = est.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.print("Placa do Veículo: ");
        String placa = s.nextLine();
        System.out.print("Modelo do Veículo: ");
        String modelo = s.nextLine();
        System.out.print("Cor do Veículo: ");
        String cor = s.nextLine();
        Veiculo v = new Veiculo(placa, modelo, cor);
        cliente.adicionarVeiculo(v);
        System.out.println("Veículo adicionado ao cliente com sucesso!");
    }
    
    public static void ocuparVaga(Estacionamento est) {
       System.out.print("CPF do Cliente: ");
    String cpf = s.nextLine();

    Cliente cliente = est.buscarClientePorCpf(cpf);
    if (cliente == null) {
        System.out.println("Cliente não encontrado!");
        return;
    }

    // Mostrar veículos do cliente
    System.out.println("Veículos do cliente:");
    for (int i = 0; i < cliente.getVeiculos().size(); i++) {
        System.out.println(i + " - " + cliente.getVeiculos().get(i).exibe());
    }

    // Escolher qual veículo vai ocupar a vaga
    System.out.print("Escolha o índice do veículo: ");
    int index = s.nextInt();
    s.nextLine();

    Veiculo v = cliente.getVeiculos().get(index);

    System.out.print("Número da Vaga a ser ocupada: ");
    int numero = s.nextInt();
    s.nextLine();

    boolean sucesso = est.ocuparVaga(numero, v);

    if (sucesso) {
        System.out.println("Vaga ocupada com sucesso!");
    } else {
        System.out.println("Vaga já ocupada ou número inválido.");
    }

 }

    public static void liberarVaga(Estacionamento est) {
        System.out.print("Número da Vaga a ser liberada: ");
        int numero = s.nextInt();
        s.nextLine();
        boolean sucesso = est.liberarVaga(numero);
        if (sucesso) {
            System.out.println("Vaga liberada com sucesso!");
        } else {
            System.out.println("Vaga já está livre ou número inválido.");
        }
    }
   
    public static void removerCliente(Estacionamento est) {
        System.out.print("CPF do Cliente a ser removido: ");
        String cpf = s.nextLine();
        boolean removed = est.removerCliente(cpf);
        if (removed) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void removerFuncionario(Estacionamento est) {
        System.out.print("CPF do Funcionário a ser removido: ");
        String cpf = s.nextLine();
        boolean removed = est.removerFuncionario(cpf);
        if (removed) {
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void removerVeiculoCliente(Estacionamento est) {
        System.out.print("CPF do Cliente: ");
        String cpf = s.nextLine();
        Cliente cliente = est.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.print("Placa do Veículo a ser removido: ");
        String placa = s.nextLine();
        boolean removed = cliente.removerVeiculo(placa);
        if (removed) {
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static void exibirFuncionarios(Estacionamento est) {
        est.exibirFuncionarios();
    }
   
    public static void exibirClientes(Estacionamento est) {
        est.exibirClientes();
    }

    public static void exibirVagas(Estacionamento est) {
        est.exibirVagas();
    }

    public static void exibirVeiculosCliente(Estacionamento est) {
        System.out.print("CPF do Cliente: ");
        String cpf = s.nextLine();
      
        Cliente cliente = est.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Veículos do Cliente " + cliente.getNome() + ":");
        for (Veiculo v : cliente.getVeiculos()) {
            System.out.println(v.exibe());
        }
    }
    
    
    
    public static void main(String[] args) {
        Estacionamento est = leDados();
        menu(est);
    }
}
