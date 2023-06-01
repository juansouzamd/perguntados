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

// O pacote "menu" contém as classes relacionadas à implementação do menu de opções do jogo.
package menu;

// Importações das classes necessárias para o funcionamento do programa.
import java.util.Scanner;
import classificacao.Ranking;

public class Menu {
    Scanner input = new Scanner(System.in);
    
    // Método público "menuInicial" que exibe o menu inicial do jogo e solicita ao jogador que informe o seu nome.
    public String menuInicial(){
        write("\n\n========== Jogo Perguntados ==========");
        write("Perguntados é um quiz de 20 perguntas");
        write("Escolha as alternativas corretas e descubra sua classificação!!\n");
        System.out.print("Por favor informe seu nome: ");
        return input.next();
    }

    // Método público "menuSecundario" que exibe o menu secundário do jogo e solicita ao jogador que escolha uma opção de dificuldade. Recebe o nome do jogador como parâmetro. O menu apresenta as opções de dificuldade ("Fácil" e "Difícil") e a opção de sair do jogo.
    public char menuSecundario(String nome){
        char resposta;
        int primeiraVez = 0;

        do {
            if(primeiraVez == 0){
                write("\nSeja bem-vindo(a) " + nome + "!");
            }
        write("\nEscolha uma das dificuldades abaixo:");
        write("1. Fácil");
        write("2. Difícil");
        write("0. Sair");
        System.out.print("Infome uma opção: ");
        resposta = input.next().charAt(0);
        primeiraVez++;
        if(resposta!= '0' && resposta!='1' && resposta!='2'){
            write("\nOpção invália");
        }

        } while(resposta!= '0' && resposta!='1' && resposta!='2');
        
        return resposta;
    }

    // Método público "menuRodada" que exibe o menu de opções de dificuldade para cada rodada do jogo. Recebe o nome do jogador como parâmetro. O menu apresenta as opções de dificuldade ("Fácil" e "Difícil") e a opção de sair do jogo.
    public char menuRodada(String nome){
        char resposta;

        do {

        write("\nEscolha uma das dificuldades abaixo " + nome + "!");
        write("1. Fácil");
        write("2. Difícil");
        write("0. Sair");
        System.out.print("Infome uma opção: ");
        resposta= input.next().charAt(0);

        if(resposta!='0' && resposta!='1' && resposta!='2'){
            write("\nOpção invália");
        }

        } while(resposta!='0' && resposta!='1' && resposta!='2');
        
        return resposta;
    }

    // Método público "menuFinal" que exibe o menu de opções finais do jogo. Recebe o nome do jogador como parâmetro. O menu apresenta as opções de jogar novamente, iniciar um novo jogo, jogar como outro usuário, exibir o ranking e sair do jogo.
    public char menuFinal(String nome){
        char resposta;

        do {

        write("\nEscolha uma das opções abaixo " + nome + "!");
        write("1. Jogar novamente");
        write("2. Inciar um novo jogo");
        write("3. Jogar como outro usuário");
        write("4. Exibir ranking");
        write("0. Sair");
        System.out.print("Infome uma opção: ");
        resposta= input.next().charAt(0);

        if(resposta!='0' && resposta!='1' && resposta!='2' && resposta!='3' && resposta!='4'){
            write("\nOpção invália");
        }

        if(resposta == '4'){
            Ranking.exibirClassificacao();
        }

        } while(resposta!='0' && resposta!='1' && resposta!='2' && resposta!='3');
        
        return resposta;
    }

    // Método público "write" que recebe uma string como parâmetro e exibe o texto no console.
    public void write(String text){
        System.out.println(text);
    }
}
