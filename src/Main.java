/*
   Projeto: Perguntados
   Data de criação: 08/11/2022
   Versão: 7
   Data da modificação: 07/06/2023
   Integrantes:
     - Juan Souza Santos
     - Kaick Santos Muniz
     - Pedro Ferreira Lima
*/

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
        Perguntas perguntasRespostas = new Perguntas();
        Menu menu = new Menu();
        Ranking ranking =  new Ranking();
        int rodada = 0, vidas = 4, pontuacao = 0, numeroResposta = 0;
        char opcao, respostaMenuFinal;
        String nome = "", resposta, classificacao;

        do {

            if (rodada == 0) {
                nome = menu.menuInicial();
                opcao = menu.menuSecundario(nome);
            } else {
                opcao = menu.menuRodada(nome);
            }

            if (opcao != '0') {

                ArrayList<Questoes> perguntas = perguntasRespostas.perguntas(opcao);

                for (int i = 0; i < perguntas.size(); i++) {
                    menu.write(perguntas.get(i).getPergunta());
                    menu.write("Digite a resposta: ");
                    resposta = input.nextLine();

                    if (vidas > 0) {
                        numeroResposta = Interacoes.coferirResposta(resposta, perguntas, vidas, i);
                    }

                    switch (numeroResposta) {
                        case 1 -> pontuacao += perguntas.get(i).getPontoQuestao();
                        case 2 -> vidas--;
                        case 3 -> vidas = 0;
                    }

                    if (vidas == 0) {
                        i = perguntas.size();
                        classificacao = Interacoes.classificacao(pontuacao);
                        Interacoes.fimVidas(pontuacao, classificacao);
                        ranking.guardarClassificacao(nome, classificacao, pontuacao);

                    } else if (i == perguntas.size() - 1) {
                        classificacao = Interacoes.classificacao(pontuacao);
                        Interacoes.fimDeJogo(pontuacao, classificacao);
                        ranking.guardarClassificacao(nome, classificacao, pontuacao);
                    }
                }

                vidas = 4;
                pontuacao = 0;
                numeroResposta = 0;

                respostaMenuFinal = menu.menuFinal(nome);

                switch (respostaMenuFinal) {
                    case '1' -> rodada++;
                    case '0' -> opcao = '0';
                    default -> rodada = 0;
                }
            }


            if(opcao == '0'){
                BancoDados.closeConnection();
            }

        } while (opcao != '0');
    }
}
