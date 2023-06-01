/*
    Nome do Projeto: Perguntados
    Data de Criação: 08/11/2022
    Versão: 7
    Data da Última Modificação: 01/06/2023
    Versão do Java: 17 (Oracle)
    Equipe de Desenvolvimento:
        - Juan Souza Santos
        - Kaick Santos Muniz
        - Pedro Ferreira Lima

    Descrição: Este programa é um jogo de perguntas e respostas onde os jogadores devem responder corretamente a uma série de perguntas aleatórias para acumular pontos e obter uma classificação.

    O programa possui funcionalidades como exibição de perguntas, cálculo de pontuação, classificação dos jogadores e armazenamento dos resultados em um banco de dados.

*/

//O pacote "banco" é utilizado para armazenar classes que lidam com funcionalidades relacionadas ao banco de dados
package banco;

//   A classe "BancoException" é uma exceção personalizada que estende a classe RuntimeException. Ela é utilizada para representar exceções relacionadas a operações no banco de dados. O construtor da classe recebe uma mensagem de erro que é repassada para o construtor da classe pai (RuntimeException) por meio do método "super(msg)".
public class BancoException extends RuntimeException {

  // A variável "serialVersionUID" é um identificador único para a classe serializada, que é necessário quando se trabalha com serialização de objetos. Ela é marcada como "final" para que não possa ser modificada e seu valor é definido como 1L.
  private static final long serialVersionUID = 1L;

  public BancoException(String msg) {
    super(msg);
  }
}
