/*
   Projeto: Perguntados
   Data de criação: 08/11/2022
   Versão: 7
   Data da modificação: 01/06/2023
   Integrantes:
     - Juan Souza Santos
     - Kaick Santos Muniz
     - Pedro Ferreira Lima
*/

package perguntas;

public class Questoes {
    private String pergunta;
    private String resposta;
    private int pontoQuestao;

    public Questoes(String pergunta, String resposta, int pontoQuestao) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.pontoQuestao = pontoQuestao;
    }

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
