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

package menu;

import java.util.Scanner;
import classificacao.Ranking;

public class Menu {
    Scanner input = new Scanner(System.in);
    
    public String menuInicial(){
        write("\n\n========== Jogo Perguntados ==========");
        write("Perguntados é um quiz de 20 perguntas");
        write("Escolha as alternativas corretas e descubra sua classificação!!\n");
        System.out.print("Por favor informe seu nome: ");
        return input.next();

    }

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

    public void write(String text){
        System.out.println(text);
    }
}
