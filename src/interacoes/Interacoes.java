/*
    Nome do Projeto: Perguntados
    Data de Criação: 08/11/2022
    Versão: 7
    Data da Última Modificação: 03/06/2023
    Versão do Java: 17 (Oracle)
    Banco de dados: MySQL
    Equipe de Desenvolvimento:
        - Juan Souza Santos
        - Kaick Santos Muniz
        - Pedro Ferreira Lima

    Descrição: Este programa é um jogo de perguntas e respostas onde os jogadores devem responder corretamente a uma série de perguntas aleatórias para acumular pontos e obter uma classificação.

    O programa possui funcionalidades como exibição de perguntas, cálculo de pontuação, classificação dos jogadores e armazenamento dos resultados em um banco de dados.
*/

// O pacote "interacoes" contém as classes relacionadas às interações com o usuário no jogo.
package interacoes;

// Importações das classes necessárias para o funcionamento do programa.
import java.util.ArrayList;
import java.util.Scanner;
import menu.Menu;
import perguntas.Questoes;

public class Interacoes {

    // Método estático "coferirResposta" que recebe uma string "resposta", um ArrayList de objetos da classe "Questoes" chamado "perguntas", um inteiro "vidas" e um inteiro "i". Esse método é responsável por verificar se a resposta fornecida pelo jogador está correta em relação à questão atual.
    public int coferirResposta(String resposta, ArrayList<Questoes> perguntas, int vidas, int i) {
        // Cria uma instância da classe "Menu" para exibir mensagens.
        Menu menu = new Menu();

        // Se a resposta fornecida pelo jogador for igual à resposta correta da questão atual, exibe a mensagem de parabéns, limpa a tela e retorna o valor 1.
        if (resposta.equalsIgnoreCase(perguntas.get(i).getResposta())) {
            menu.write("\nParabéns você acertou!");
            limpaTela();
            return 1;

        // Caso contrário, se o número de vidas for igual a 2, decrementa o valor de vidas, exibe uma mensagem informando o erro e o número de vidas restantes, limpa a tela e retorna o valor 2.    
        } else if (vidas == 2) {
            vidas--;
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nResta apenas " + vidas + " vida.");
            limpaTela();
            return 2;
        
        // Caso contrário, se o número de vidas for igual a 0, exibe uma mensagem informando o erro e a resposta correta da questão atual, limpa a tela e retorna o valor 4.
        } else if (vidas == 0) {
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + ".");
            limpaTela();
            return 4;

        // Caso contrário, se o número de vidas for igual a 1, exibe uma mensagem informando o erro, a resposta correta da questão atual e que não restam mais vidas, limpa a tela e retorna o valor 3.
        } else if (vidas == 1) {
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nAcabaram suas vidas!");
            limpaTelaClassificacao();
            return 3;

        // Caso contrário, decrementa o valor de vidas, exibe uma mensagem informando o erro e o número de vidas restantes, limpa a tela e retorna o valor 2.
        } else {
            vidas--;
            menu.write(
                    "\nQue pena! você errou. A reposta certa é a alternativa: " + perguntas.get(i).getResposta() + "."
                            + "\nRestam apenas " + vidas + " vidas.");
            limpaTela();
            return 2;
        }
    }

    // Método estático "fimVidas" que recebe a pontuação do jogador como um inteiro "pontuacao" e a classificação do jogador como uma string "ranking". Esse método é responsável por exibir a mensagem de fim de jogo quando o jogador perde todas as vidas.
    public void fimVidas(int pontuacao, String ranking) {

        System.out.println("\nInfelizmente acabaram suas vidas.");
        System.out.println("Você fez " + pontuacao + " pontos.");
        System.out.println("Sua classificação foi, " + ranking + ".");
    }

    // Método estático "fimDeJogo" que recebe a pontuação do jogador como um inteiro "pontuacao" e a classificação do jogador como uma string "ranking". Esse método é responsável por exibir a mensagem de fim de jogo quando o jogador conclui todas as perguntas.
    public void fimDeJogo(int pontuacao, String ranking) {

        System.out.println("\nParabéns você concluiu todas as perguntas");
        System.out.println("Você fez " + pontuacao + " pontos.");
        System.out.println("Sua classificação foi, " + ranking + ".");
    }

    // Método estático "nivelDeJogo" que recebe uma opção de jogo como um caractere "opcao" e retorna o nível de dificuldade correspondente como uma string.
    public String nivelDeJogo(char opcao) {
        String nivel = "";

        if (opcao == '1') {
            nivel = "Fácil";
        } else {
            nivel = "difícil";
        }

        return nivel;
    }

    // Método estático "limpaTela" que é responsável por limpar a tela do console antes de exibir a próxima pergunta.
    public void limpaTela() {
        System.out.print("\npressione <enter> para ir para a próxima pergunta!.\n");
        new Scanner(System.in).nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método estático "limpaTelaClassificacao" que é responsável por limpar a tela do console antes de exibir a classificação do jogador.
    public void limpaTelaClassificacao() {
        System.out.print("\npressione <enter> para ver sua classificação!.\n");
        new Scanner(System.in).nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
