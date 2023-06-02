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

// O pacote "classificacao" contém as classes relacionadas à classificação dos jogadores no jogo.
package classificacao;

// Importações das classes necessárias para o funcionamento do programa.
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.BancoDados;

public class Ranking {

    // Método "classificacao" que recebe a pontuação do jogador como um inteiro "pontuacao" e retorna a classificação correspondente como uma string.
    public String classificacao(int pontuacao) {
        String resposta;

        if (pontuacao <= 120 && pontuacao >= 80) {
            resposta = "Bronze";
        } else if (pontuacao <= 170 && pontuacao >= 130) {
            resposta = "Prata";
        } else if (pontuacao <= 220 && pontuacao >= 180) {
            resposta = "Ouro";
        } else if (pontuacao > 230) {
            resposta = "Diamante";
        } else {
            resposta = "Latão";
        }
        return resposta;
    }

    // Método "guardarClassificacao" que recebe informações do jogador, como nome, nível, classificação e pontuação, e armazena essas informações no banco de dados.
    public void guardarClassificacao(String nome, String nivel, String classificacao, int pontuacao) {

        // Inicializa as variáveis "conn" e "st" como nulas
        Connection conn = null;
        PreparedStatement st = null;

        try {
            // Tenta estabelecer uma conexão com o banco de dados chamando o método "getConnection" da classe "BancoDados" para obter uma instância de conexão.
            conn = BancoDados.getConnection();

            // Prepara uma instrução SQL usando a conexão estabelecida para inserir os dados do jogador na tabela "ranking".
            st = conn.prepareStatement(
                    "insert into ranking "
                            + "(Nome, Nivel, Classificacao, Pontuacao) "
                            + "values "
                            + "(?, ?, ?, ?)");

            // Atribui os valores dos parâmetros do método aos devidos campos da instrução SQL.
            st.setString(1, nome);
            st.setString(2, nivel);
            st.setString(3, classificacao);
            st.setInt(4, pontuacao);

            // Executa a instrução SQL chamando o método "executeUpdate" do objeto "st" para inserir os dados no banco de dados.
            st.executeUpdate();

        // Em caso de exceção de SQL, imprime o rastreamento da pilha de erros.    
        } catch (SQLException e) {
            e.printStackTrace();

        // Finalmente, chama o método "closeStatement" da classe "BancoDados" para fechar o objeto "st" e liberar recursos.
        } finally {
            BancoDados.closeStatement(st);
        }

        // Após a execução desse método, as informações do jogador serão armazenadas no banco de dados para fins de classificação e ranking.
    }

    // Método estático "exibirClassificacao" responsável por exibir o ranking dos jogadores armazenados no banco de dados.
    public void exibirClassificacao() {

        // Exibe a mensagem de título "========== Ranking ==========" para indicar o início da exibição do ranking.
        System.out.println("\n========== Ranking ==========\n");

        // Inicializa as variáveis "conn", "st" e "rs" como nulas.
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        
        try {
            // Tenta estabelecer uma conexão com o banco de dados chamando o método "getConnection" da classe "BancoDados" para obter uma instância de conexão.
            conn = BancoDados.getConnection();

            // Cria uma instrução SQL usando a conexão estabelecida chamando o método "createStatement" para criar um objeto de instrução.
            st = (Statement) conn.createStatement();

            // Executa uma consulta SQL para selecionar todos os registros da tabela "ranking" chamando o método "executeQuery" do objeto "st". O resultado da consulta é armazenado no objeto "rs".
            rs = st.executeQuery("select * from ranking");

            // Percorre os resultados da consulta utilizando o método "next" do objeto "rs" para avançar para o próximo registro. Dentro do loop, são recuperados os valores dos campos "Nome", "Pontuacao", "Classificacao" e "Nivel" e são impressos na saída padrão.
            while (rs.next()) {
                System.out.println(rs.getString("Nome") + ", "
                + rs.getInt("Pontuacao") + " pontos, Classificacao: "
                + rs.getString("Classificacao") + " - Nivel: "
                + rs.getString("Nivel"));
            }

        // Em caso de exceção de SQL, imprime o rastreamento da pilha de erros.
        } catch (SQLException e) {
            e.printStackTrace();

        // Finalmente, chama os métodos "closeStatement" e "closeResultSet" da classe "BancoDados" para fechar os objetos "st" e "rs" e liberar recursos.
        } finally {
            BancoDados.closeStatement(st);
            BancoDados.closeResultSet(rs);
        }

    // Após a execução desse método, o ranking dos jogadores será exibido na saída padrão.
    }
}
