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

// O pacote "perguntas" contém as classes relacionadas ao gerenciamento de perguntas e respostas no jogo.
package perguntas;


public class Questoes {

    // Variáveis privadas da classe "Questoes"
    private String pergunta;
    private String resposta;
    private int pontoQuestao;

    // Construtor da classe "Questoes" que recebe os parâmetros "pergunta", "resposta" e "pontoQuestao" para inicializar os atributos correspondentes. Esses parâmetros são utilizados para definir a pergunta, a resposta correta e o número de pontos da questão, respectivamente.
    public Questoes(String pergunta, String resposta, int pontoQuestao) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.pontoQuestao = pontoQuestao;
    }

    // Esses métodos são utilizados para obter os valores dos atributos correspondentes da classe "Questoes".
    public String getPergunta() {
        return pergunta;
    }
    
    public String getResposta() {
        return resposta;
    }

    public int getPontoQuestao() {
        return pontoQuestao;
    }
}
