package classificacao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banco.BancoDados;

public class Ranking {

    public void guardarClassificacao(String nome, String classificacao, int pontuacao) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = BancoDados.getConnection();

            st = conn.prepareStatement(
                    "insert into ranking "
                            + "(Nome, Classificacao, Pontuacao) "
                            + "values "
                            + "(?, ?, ?)");

            st.setString(1, nome);
            st.setString(2, classificacao);
            st.setInt(3, pontuacao);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.closeStatement(st);
        }
    }

    public static void exibirClassificacao() {

        System.out.println("\n========== Ranking ==========\n");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = BancoDados.getConnection();

            st = (Statement) conn.createStatement();

            // executar consulta
            rs = st.executeQuery("select * from ranking");

            // percorrer imprimindo valores
            while (rs.next()) {
                System.out.println(rs.getString("Nome") + ", " + rs.getString("Classificacao") + " - " + rs.getInt("Pontuacao") + " pontos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDados.closeStatement(st);
            BancoDados.closeResultSet(rs);
        }

    }
}
