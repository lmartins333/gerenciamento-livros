/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import gerenciadorlivros.models.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Martins
 */
public class InterfaceBanco {
    private conexaoBanco.ConexaoMySQL conexao;

    public InterfaceBanco() {
        conexao = new conexaoBanco.ConexaoMySQL();
    }

    public boolean isNomeUsuarioDisponivel(Usuario usuario) {
        try {
            String consulta = "SELECT nome FROM usuario WHERE nome_usuario= '" 
                    + usuario.getNome_usuario()+ "';";

            ResultSet resultado = conexao.consultar(consulta);

            if (resultado.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
    public boolean isCpfCadastrado(Usuario usuario) {
        try {
            String consulta = "SELECT nome FROM usuario WHERE cpf= '" 
                    + usuario.getCpf()+ "';";

            ResultSet resultado = conexao.consultar(consulta);

            if (resultado.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean isCodigoCadastrado(Livro livro) {
        try {
            String consulta = "SELECT codigo_barras FROM livro WHERE codigo_barras = '" 
                    + livro.getCodigo_barras()+ "';";

            ResultSet resultado = conexao.consultar(consulta);

            if (resultado.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean adicionarUsuario(Usuario usuario) {
        String comando = "INSERT INTO usuario values("
                + "'" + usuario.getCpf() + "', "
                + "'" + usuario.getNome_usuario() + "', "
                + "'" + usuario.getSenha() + "', "
                + "'" + usuario.getNome() + "', "
                + "'" + usuario.getEndereco() + "', "
                + "'" + usuario.getData_cadastro() + "', "
                + usuario.getPerfil()+ ");";

        conexao.inserir(comando);

        return true;
    }

    public boolean adicionarLivro(Livro livro) {
        String comando = "INSERT INTO livro VALUES("
                + "'" + livro.getCodigo_barras()+ "', "
                + "'" + livro.getTitulo()+ "', "
                + "'" + livro.getAutor()+ "', "
                + "'" + livro.getEditora()+ "', "
                + "'" + livro.getAno()+ "', "
                + "'" + livro.getEdicao() + "', "
                + "'" + livro.getVolume() + "', "
                + "'" + GetTimeDate.getDateSQL() + "', "
                + "'" + livro.getUsuario().getCpf() + "');";

        conexao.inserir(comando);

        return true;
    }

    public boolean atualaizarLivro(Livro livro) {
        String comando = "UPDATE livro SET "
                + "titulo = '" + livro.getTitulo()+ "', "
                + "autor = '" + livro.getAutor()+ "', "
                + "editora = '" + livro.getEditora()+ "', "
                + "ano = '" + livro.getAno()+ "', "
                + "edicao = '" + livro.getEdicao() + "', "
                + "volume = '" + livro.getVolume() + "', "
                + "data_cadastro = '" + GetTimeDate.getDateSQL() + "', "
                + "usuario = '" + livro.getUsuario().getCpf() + "' WHERE codigo_barras = '" + livro.getCodigo_barras() + "';";

        conexao.atualizar(comando);

        return true;
    }

    public Usuario validarCredenciais(Usuario usuario) {
        try {
            String consulta = "SELECT * FROM usuario WHERE nome_usuario= '" 
                    + usuario.getNome_usuario()+ "' && senha= '" + usuario.getSenha() + "';";

            ResultSet resultado = conexao.consultar(consulta);

            if (resultado.next()) {
                usuario = new Usuario();

                try {
                    usuario.setCpf(resultado.getString("cpf"));
                    usuario.setEndereco(resultado.getString("endereco"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setNome_usuario(resultado.getString("nome_usuario"));
                    usuario.setPerfil(resultado.getString("perfil"));
                    usuario.setSenha(resultado.getString("senha"));
                } catch (SQLException ex) {
                    Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                usuario = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public ArrayList<Perfil> getListaPefis() {
        ArrayList<Perfil> listaPerfis = new ArrayList<>();

        String comando = "SELECT * FROM perfil;";

        ResultSet resultado = conexao.consultar(comando);

        try {
            while (resultado.next()) { 
                Perfil perfil = new Perfil();

                perfil.setId(resultado.getInt("id"));
                perfil.setNome(resultado.getString("nome"));

                listaPerfis.add(perfil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPerfis;
    }
    
    public ArrayList<Livro> getListaLivros() {
        ArrayList<Livro> listaLivros = new ArrayList<>();
        
        String comando = "SELECT livro.codigo_barras, livro.titulo, livro.autor, "
                + "livro.editora, livro.ano, livro.edicao, livro.volume, "
                + "livro.data_cadastro, usuario.cpf, usuario.nome from livro "
                + "left join usuario on livro.usuario = usuario.cpf;";

        ResultSet resultado = conexao.consultar(comando);
        
        try {
            while(resultado.next()) {
                Usuario usuario = new Usuario();
                Livro livro = new Livro();
        
                livro.setCodigo_barras(resultado.getString("codigo_barras"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setEditora(resultado.getString("editora"));
                livro.setAno(resultado.getString("ano"));
                livro.setEdicao(resultado.getString("edicao"));
                livro.setVolume(resultado.getString("volume"));
                livro.setData_cadastro(resultado.getString("data_cadastro"));
                
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setNome(resultado.getString("nome"));
                
                livro.setUsuario(usuario);
                
                livro.setUsuario(usuario);
                
                listaLivros.add(livro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaLivros;
    }
    
    public Livro getLivro(String codigo_livro) {
        String comando = "SELECT * FROM livro  where codigo_barras = '" + codigo_livro + "';";
        Livro livro = new Livro();

        ResultSet resultado = conexao.consultar(comando);
        
        try {
            while(resultado.next()) {
                livro.setCodigo_barras(resultado.getString("codigo_barras"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setEditora(resultado.getString("editora"));
                livro.setAno(resultado.getString("ano"));
                livro.setEdicao(resultado.getString("edicao"));
                livro.setVolume(resultado.getString("volume"));
                livro.setData_cadastro(resultado.getString("data_cadastro"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return livro;
    }
    
    public boolean perfilComPermissao(Usuario usuario, String acao, String cpfUsuarioAdd, String codigoLivro) {
        String comando;
        if (usuario.getPerfil().equals("1")) {
            return true;
        }
        
        if (!cpfUsuarioAdd.equals(usuario.getCpf())) {
            return false;
        }
        
        comando = "SELECT * FROM acao_perfil WHERE id = " + acao + " AND perfil = " + usuario.getPerfil() + ";";

        ResultSet permissao = conexao.consultar(comando);
        
        try {
            return permissao.next();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean excluirLivro(String codigo_barras) {
        String comando = "DELETE FROM livro WHERE codigo_barras = '" + codigo_barras + "';";
        
        return conexao.deletar(comando);
    }
}