@startuml
skinparam classAttributeIconSize 0
skinparam shadowing true
skinparam class {
    BackgroundColor #F9F9F9
    BorderColor #333
    ArrowColor #333
}
skinparam packageStyle rectangle

left to right direction

package "Pessoas" #DDDDFF {
    class Cliente {
        - nome : String
        - endereco : String
        - telefone : String
        - email : String
        --
        + getNome() : String
        + getEndereco() : String
        + getTelefone() : String
        + getEmail() : String
    }

    class Funcionario {
        - nome : String
        - cargo : String
        - salario : double
        --
        + getNome() : String
        + getCargo() : String
        + getSalario() : double
    }
}

package "Produtos & Serviços" #DDFFDD {
    class Produto {
        - nome : String
        - preco : double
        - quantidade : int
        --
        + getNome() : String
        + getPreco() : double
        + getQuantidade() : int
    }

    class Servico {
        - descricao : String
        - valor : double
        --
        + getDescricao() : String
        + getValor() : double
    }
}

package "Operações" #FFDDDD {
    class Venda {
        - cliente : Cliente
        - funcionar
