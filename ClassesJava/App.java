package ClassesJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static Scanner s = new Scanner(System.in);

    public static Estacionamento leDados() {
        try {
            System.out.print("Nome do Estacionamento: ");
            String nome = s.nextLine();

            System.out.print("Endereço do Estacionamento: ");
            String endereco = s.nextLine();

            System.out.print("Quantidade de Vagas: ");
            int qtdVagas = s.nextInt();
            s.nextLine();

            return new Estacionamento(nome, endereco, qtdVagas);
        } catch (InputMismatchException e) {
            s.nextLine();
            throw new InputMismatchException("Quantidade de vagas deve ser um número inteiro!");
        }
    }

    public static void menu(Estacionamento est) {
        int op = 0;

        do {
            try {
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
                        liberarVaga(est);
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
                        removerFuncionario(est);
                        break;
                    case 11:
                        removerCliente(est);
                        break;
                    case 12:
                        removerVeiculoCliente(est);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                s.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (op != 0);
    }

    public static void adicionarFuncionario(Estacionamento est) {
        try {
            System.out.print("Nome do Funcionário: ");
            String nome = s.nextLine();

            System.out.print("CPF do Funcionário: ");
            String cpf = s.nextLine();

            if (cpf.length() != 11) throw new Exception("CPF inválido! Deve ter 11 dígitos.");

            System.out.print("Cargo do Funcionário: ");
            String cargo = s.nextLine();

            System.out.print("Salário do Funcionário: ");
            double salario = s.nextDouble();
            s.nextLine();

            Funcionario f = new Funcionario(nome, cpf, cargo, salario);
            est.adicionarFuncionario(f);

            System.out.println("Funcionário adicionado!");
        } catch (InputMismatchException e) {
            s.nextLine();
            System.out.println("O salário deve ser um número!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void adicionarCliente(Estacionamento est) {
        try {
            System.out.print("Nome do Cliente: ");
            String nome = s.nextLine();
            System.out.print("Email do Cliente: ");
            String email = s.nextLine();
            System.out.print("CPF do Cliente: ");
            String cpf = s.nextLine();

            if (cpf.length() != 11) throw new Exception("CPF inválido! Deve ter 11 dígitos.");

            Cliente c = new Cliente(nome, email, cpf);
            est.adicionarCliente(c);

            System.out.println("Cliente adicionado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void adicionarVeiculoCliente(Estacionamento est) {
        try {
            System.out.print("CPF do Cliente: ");
            String cpf = s.nextLine();

            Cliente cliente = est.buscarClientePorCpf(cpf);
            if (cliente == null) throw new Exception("Cliente não encontrado!");

            System.out.print("Placa: ");
            String placa = s.nextLine();
            System.out.print("Modelo: ");
            String modelo = s.nextLine();
            System.out.print("Cor: ");
            String cor = s.nextLine();

            cliente.adicionarVeiculo(new Veiculo(placa, modelo, cor));
            System.out.println("Veículo adicionado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void ocuparVaga(Estacionamento est) {
        try {
            System.out.print("CPF do Cliente: ");
            String cpf = s.nextLine();

            Cliente cliente = est.buscarClientePorCpf(cpf);
            if (cliente == null) throw new Exception("Cliente não encontrado!");

            System.out.println("Veículos:");
            for (int i = 0; i < cliente.getVeiculos().size(); i++) {
                System.out.println(i + " - " + cliente.getVeiculos().get(i).exibe());
            }

            System.out.print("Escolha o índice: ");
            int index = s.nextInt();
            s.nextLine();

            if (index < 0 || index >= cliente.getVeiculos().size())
                throw new Exception("Índice inválido!");

            Veiculo v = cliente.getVeiculos().get(index);

            System.out.print("Número da vaga: ");
            int numero = s.nextInt();
            s.nextLine();

            boolean ok = est.ocuparVaga(numero, v);
            if (!ok) throw new Exception("Vaga inválida ou ocupada!");

            System.out.println("Vaga ocupada!");
        } catch (InputMismatchException e) {
            s.nextLine();
            System.out.println("Entrada inválida! Digite um número.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void liberarVaga(Estacionamento est) {
        try {
            System.out.print("Número da vaga: ");
            int numero = s.nextInt();
            s.nextLine();

            if (!est.liberarVaga(numero))
                throw new Exception("Vaga inválida ou já está livre!");

            System.out.println("Vaga liberada!");
        } catch (InputMismatchException e) {
            s.nextLine();
            System.out.println("Digite um número válido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void removerCliente(Estacionamento est) {
        try {
            System.out.print("CPF: ");
            String cpf = s.nextLine();

            if (!est.removerCliente(cpf))
                throw new Exception("Cliente não encontrado!");

            System.out.println("Cliente removido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void removerFuncionario(Estacionamento est) {
        try {
            System.out.print("CPF: ");
            String cpf = s.nextLine();

            if (!est.removerFuncionario(cpf))
                throw new Exception("Funcionário não encontrado!");

            System.out.println("Funcionário removido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void exibirClientes(Estacionamento est) {
        est.exibirClientes();
    }

    public static void exibirVeiculosCliente(Estacionamento est) {
        try {
            System.out.print("CPF do Cliente: ");
            String cpf = s.nextLine();

            Cliente cliente = est.buscarClientePorCpf(cpf);
            if (cliente == null) throw new Exception("Cliente não encontrado!");

            System.out.println("Veículos do Cliente:");
            for (Veiculo v : cliente.getVeiculos()) {
                System.out.println(v.exibe());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void exibirFuncionarios(Estacionamento est) {
        est.exibirFuncionarios();
    }

    public static void removerVeiculoCliente(Estacionamento est) {
        try {
            System.out.print("CPF: ");
            String cpf = s.nextLine();

            Cliente cliente = est.buscarClientePorCpf(cpf);
            if (cliente == null) throw new Exception("Cliente não encontrado!");

            System.out.print("Placa: ");
            String placa = s.nextLine();

            if (!cliente.removerVeiculo(placa))
                throw new Exception("Veículo não encontrado!");

            System.out.println("Veículo removido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Estacionamento est = leDados();
            menu(est);
        } catch (Exception e) {
            System.out.println("Erro fatal: " + e.getMessage());
        }
    }
}
