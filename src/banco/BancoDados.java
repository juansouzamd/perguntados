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

//O pacote "banco" é utilizado para armazenar classes que lidam com funcionalidades relacionadas ao banco de dados.
package banco;

// Importações das classes necessárias para o funcionamento do programa.
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BancoDados {

    // Declara uma variável estática para armazenar a conexão com o banco de dados
    private static Connection conn = null;

    // Obtém a conexão com o banco de dados. Se a conexão ainda não foi
    // estabelecida, cria uma nova conexão e a retorna. Caso contrário, retorna a
    // conexão existente.
    public static Connection getConnection() {
        // verifica se não há conexão estabelecida
        if (conn == null) {
            try {
                // Carrega as propriedades de configuração do banco de dados
                Properties props = loadProperties();

                // Obtém a URL do banco de dados
                String url = props.getProperty("dburl");

                // Cria a conexão com o banco de dados usando a URL e as propriedades
                conn = DriverManager.getConnection(url, props);

                // Lança uma exceção personalizada em caso de erro na conexão
            } catch (SQLException e) {
                throw new BancoException(e.getMessage());
            }
        }

        // Retorna a conexão estabelecida ou criada
        return conn;
    }

    // Fecha a conexão com o banco de dados, caso esteja aberta. Caso contrário,
    // nenhum procedimento é realizado.
    public static void closeConnection() {

        // verifica se há uma conexão estabelecida
        if (conn != null) {
            try {

                // Fecha a conexão com o banco de dados
                conn.close();

                // Lança uma exceção personalizada em caso de erro no fechamento da conexão
            } catch (SQLException e) {
                throw new BancoException(e.getMessage());
            }
        }
    }

    // Carrega as propriedades do arquivo "banco.properties" e retorna um objeto
    // Properties. As propriedades são carregadas a partir de um arquivo de
    // configuração externo. Em caso de falha ao carregar as propriedades, é lançada
    // uma exceção personalizada.
    private static Properties loadProperties() {

        // Abre o arquivo de propriedades "banco.properties"
        try (FileInputStream fs = new FileInputStream("banco.properties")) {

            // Cria um novo objeto Properties
            Properties props = new Properties();

            // Carrega as propriedades a partir do arquivo
            props.load(fs);

            // Retorna o objeto Properties carregado
            return props;

            // Lança uma exceção personalizada com a mensagem de erro, em caso de erro
        } catch (IOException e) {
            throw new BancoException(e.getMessage());
        }
    }

    // Fecha um objeto Statement, liberando os recursos associados. Verifica se o
    // objeto é diferente de nulo antes de fechá-lo. Em caso de falha ao fechar o
    // objeto, é lançada uma exceção personalizada.
    public static void closeStatement(Statement st) {

        // Verifica se o objeto Statement não é nulo
        if (st != null) {
            try {

                // Fecha o Statement
                st.close();

                // Lança uma exceção personalizada com a mensagem de erro, em caso de erro
            } catch (SQLException e) {
                throw new BancoException(e.getMessage());
            }
        }
    }

    // Fecha um objeto ResultSet, liberando os recursos associados. Verifica se o
    // objeto é diferente de nulo antes de fechá-lo. Em caso de falha ao fechar o
    // objeto, é lançada uma exceção personalizada.
    public static void closeResultSet(ResultSet rs) {

        // Verifica se o objeto ResultSet não é nulo
        if (rs != null) {
            try {

                // Fecha o ResultSet
                rs.close();

                // Lança uma exceção personalizada com a mensagem de erro, em caso de erro
            } catch (SQLException e) {
                throw new BancoException(e.getMessage());
            }
        }
    }
}
