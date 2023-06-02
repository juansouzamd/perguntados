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


// Importações das classes necessárias para o funcionamento do programa.
import java.util.*;
import banco.BancoDados;
import classificacao.Ranking;
import interacoes.Interacoes;
import perguntas.Perguntas;
import perguntas.Questoes;
import menu.Menu;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Instancia um objeto da classe Perguntas para lidar com perguntas e respostas
        Perguntas perguntasRespostas = new Perguntas();

        // Instancia um objeto da classe Menu para gerenciar as opções do menu.
        Menu menu = new Menu();

        // Instancia um objeto da classe Interações para gerenciar as opções de interações com o usuário.
        Interacoes interacoes = new Interacoes();

        // Instancia um objeto da classe Ranking para lidar com a classificação e o ranking.
        Ranking ranking =  new Ranking();

        // Variáveis de inicialização para controlar a lógica do jogo e armazenar informações relevantes durante a execução.
        int rodada = 0, vidas = 4, pontuacao = 0, numeroResposta = 0;
        char opcao, respostaMenuFinal;
        String nome = "", resposta, classificacao, nivel;

        // Início de um laço de repetição "do-while", que executa um bloco de código pelo menos uma vez e continua repetindo enquanto a condição no final do laço for verdadeira.
        do {

            if (rodada == 0) {

                // Menu inicial para obter o nome do jogador
                nome = menu.menuInicial();

                // Menu para definir a dificuldade
                opcao = menu.menuSecundario(nome);
            } else {

                 // Menu de rodada para continuar o jogo
                opcao = menu.menuRodada(nome);
            }

            if (opcao != '0') {

                // Obtem as perguntas com base na opção selecionada
                ArrayList<Questoes> perguntas = perguntasRespostas.perguntas(opcao);

                // Obtem o nível de jogo com base na opção selecionada
                nivel = interacoes.nivelDeJogo(opcao);

                // Exibir a pergunta e obtem a resposta do jogador
                for (int i = 0; i < perguntas.size(); i++) {
                    menu.write(perguntas.get(i).getPergunta());
                    menu.write("Digite a resposta: ");
                    resposta = input.nextLine();

                    // Verificar se a resposta está correta e atualiza a pontuação e vidas
                    if (vidas > 0) {
                        numeroResposta = interacoes.coferirResposta(resposta, perguntas, vidas, i);
                    }

                    // Switch-case que avalia o valor da variável numeroResposta e executa diferentes ações com base nesse valor.
                    switch (numeroResposta) {
                        case 1 -> pontuacao += perguntas.get(i).getPontoQuestao();
                        case 2 -> vidas--;
                        case 3 -> vidas = 0;
                    }

                     // Se as vidas chegarem a zero, encerra o jogo obtém a classificação e salva os dados no banco de dados
                    if (vidas == 0) {
                        i = perguntas.size();
                        classificacao = ranking.classificacao(pontuacao);
                        interacoes.fimVidas(pontuacao, classificacao);
                        ranking.guardarClassificacao(nome, nivel, classificacao, pontuacao);

                    // Se todas as perguntas forem respondidas corretamente, encerra o jogo obtém a classificação e salva os dados no banco de dados
                    } else if (i == perguntas.size() - 1) {
                        classificacao = ranking.classificacao(pontuacao);
                        interacoes.fimDeJogo(pontuacao, classificacao);
                        ranking.guardarClassificacao(nome, nivel, classificacao, pontuacao);
                    }
                }

                // Reiniciar as variáveis para a próxima rodada
                vidas = 4;
                pontuacao = 0;
                numeroResposta = 0;

                // Exibir o menu final para tomar a ação correspondente
                respostaMenuFinal = menu.menuFinal(nome);

                // Switch-case que avalia o valor da variável respostaMenuFinal e executa diferentes ações com base nesse valor.
                switch (respostaMenuFinal) {
                    case '1' -> rodada++;
                    case '0' -> opcao = '0';
                    default -> rodada = 0;
                }
            }


            // Fechar a conexão com o banco de dados ao encerrar o jogo
            if(opcao == '0'){
                BancoDados.closeConnection();
            }
        
        // Encerra o jogo caso opcao seja igual a 0
        } while (opcao != '0');

        // Fecha o objeto input que é utilizado para ler as entradas do usuário.
        input.close();
    }
}
