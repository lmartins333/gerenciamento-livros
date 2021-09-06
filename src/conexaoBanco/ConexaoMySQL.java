package conexaoBanco;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConexaoMySQL {
    private final String host = "localhost";
    private final String banco = "gerenciadorlivros";
    private final String usuario = "root";
    private final String senha = "admin";
    private final String porta = "3306";
    private final String url = "jdbc:mysql://"+ host + ":" + porta + "/" + banco + "?useTimezone=true&serverTimezone=UTC";

    public Connection conexao;

    public ConexaoMySQL() {
        boolean conectado = conectar();

        if (!conectado) {
            System.out.println("Não foi possível se conectar ao banco!");
        }
    }

    public void verificarConexao() {
        try {
            if (conexao.isClosed()) {
                conectar();
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    // select * from animais where nome='mel';
    public ResultSet consultar(String comando) {
        verificarConexao();
        return select(comando);
    }

    // insert into animais (nome, dono, raca, sexo, nascimento, morte) values ('Mel', 'Lucas', 'Poodle', 'F', '2018-12-19', '2019-12-19');
    public boolean inserir(String comando) {
        verificarConexao();
        return executar(comando);
    }

    // delete from animais where nome='mel';
    public boolean deletar(String comando) {
        verificarConexao();
        return executar(comando);
    }

    // update animais set dono='Martins' where nome='mel';
    public boolean atualizar(String comando) {
        verificarConexao();
        return executar(comando);
    }

    public boolean fecharConexao() {
        return desconectar();
    }

    private boolean executar(String comando) {
        boolean sucesso = false;

        verificarConexao();

        try {
            execute(comando);

            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    /**
     * Estabelece a conexão com o banco de dados.
     *
     * @return boolean
     */
    protected boolean conectar() {
        boolean conectado = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            this.conexao = DriverManager.getConnection(url,usuario, senha);
            conectado = true;
        } catch( SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
            conectado = false;

            e.getStackTrace();
        }
       
        return conectado;
    }
   
    /**
     * Desconecta o banco de dados.
     *
     * @return boolean
     */
    protected boolean desconectar() {
        boolean conectado = false;

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();

            conexao = DriverManager.getConnection(url, usuario, senha);

            conexao.close();

            conectado = false;
        } catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
            e.getStackTrace();
        }

        return conectado;
    }

    /**
     * Executa a query dada, e retorna um ResultSet.
     *
     * @param comando 
     * @return ResultSet
     */
    protected ResultSet select(String comando) {
        Statement st;
        ResultSet rs;

        verificarConexao();

        try {
            st = this.conexao.createStatement();
            rs = st.executeQuery(comando);
        } catch ( SQLException e ) {
            e.printStackTrace();

            return null;
        }

        return rs;
    }

    /**
     * Executa uma query como update, delete ou insert.
     * Retorna o número de registros afetados quando falamos de um update ou delete
     * ou retorna 1 quando o insert é bem sucedido. Em outros casos retorna -1
     *
     * @param comando
     * @return (retorna 0 para um insert bem sucedido e -1 para erro)
     */
    protected int execute(String comando) {
        Statement st;
        int result = -1;

        verificarConexao();

        try {
            st = this.conexao.createStatement();
            result = st.executeUpdate(comando);
        } catch ( SQLException e ) {
            e.printStackTrace();
        }

        return result;
    }
}