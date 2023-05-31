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

package interacoes;

import java.util.ArrayList;
import java.util.Scanner;
import menu.Menu;
import perguntas.Questoes;

public class Interacoes {

    public static int coferirResposta(String resposta, ArrayList<Questoes> perguntas, int vidas, int i) {
        Menu menu = new Menu();

        if (resposta.equalsIgnoreCase(perguntas.get(i).getResposta())) {

            menu.write("\nParabéns você acertou!");
            limpaTela();
            return 1;

        } else if (vidas == 2) {
            vidas--;
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nResta apenas " + vidas + " vida.");
                            limpaTela();
                            return 2;
            
        } else if (vidas == 0) {
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + ".");
                    limpaTela();
            return 4;

        } else if(vidas == 1){
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nAcabaram suas vidas!");
                            limpaTelaClassificacao();
                            return 3;

        }else {
            vidas--;
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nRestam apenas " + vidas + " vidas.");
                            limpaTela();
                            return 2;
        }
    }

    public static void fimVidas(int pontuacao, String ranking) {

        System.out.println("\nInfelizmente acabaram suas vidas.");
        System.out.println("Você fez " + pontuacao + " pontos.");
        System.out.println("Sua classificação foi, " + ranking + ".\n");
    }

    public static String classificacao(int pontuacao) {
        String resposta;

        if (pontuacao <= 120 && pontuacao >= 80) {
            resposta = "Nível Bronze";
        } else if (pontuacao <= 170 && pontuacao >= 130) {
            resposta = "Nível Prata";
        } else if (pontuacao <= 220 && pontuacao >= 180) {
            resposta = "Nível Ouro";
        } else if (pontuacao > 230) {
            resposta = "Nível Diamante";
        } else {
            resposta = "Nível Latão";
        }
        return resposta;
    }

    public static void fimDeJogo(int pontuacao, String ranking) {

        System.out.println("\nParabéns você concluiu todas as perguntas");
        System.out.println("Você fez " + pontuacao + " pontos.");
        System.out.println("Sua classificação foi, " + ranking+ ".\n");
    }

    public static void limpaTela(){
        System.out.print("\npressione <enter> para ir para a próxima pergunta!.\n");
        new Scanner(System.in).nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }

      public static void limpaTelaClassificacao(){
        System.out.print("\npressione <enter> para ver sua classificação!.\n");
        new Scanner(System.in).nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
}
