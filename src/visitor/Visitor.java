package visitor;

//A interface visitante declara um conjunto de métodos
//visitantes que correspondem com as classes elemento. A
//assinatura de um método visitante permite que o visitante
//identifique a classe exata do elemento com o qual ele está
//lidando.

public interface Visitor {
    String exibirCarro(CarroComVisitor carro);
    String exibirAcessorios(AcessoriosComVisitor acessorios);
}