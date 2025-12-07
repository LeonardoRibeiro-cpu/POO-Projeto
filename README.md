@startuml
class App {
}

class Cliente {
  private String nome
  private String endereco
  private String telefone
  private String email
  public getNome() : String
  public getEndereco() : String
  public getTelefone() : String
  public getEmail() : String
}

class Funcionario {
  private String nome
  private String cargo
  private double salario
  public getNome() : String
  public getCargo() : String
  public getSalario() : double
}

class Produto {
  private String nome
  private double preco
  private int quantidade
  public getNome() : String
  public getPreco() : double
  public getQuantidade() : int
}

class Servico {
  private String descricao
  private double valor
  public getDescricao() : String
  public getValor() : double
}

class Venda {
  private Cliente cliente
  private Funcionario funcionario
  private Produto produto
  private int quantidade
  public getCliente() : Cliente
  public getFuncionario() : Funcionario
  public getProduto() : Produto
  public getQuantidade() : int
}

class Veiculo {
  private String modelo
  private String marca
  private int ano
  private String cor
  public getModelo() : String
  public getMarca() : String
  public getAno() : int
  public getCor() : String
}
@enduml
