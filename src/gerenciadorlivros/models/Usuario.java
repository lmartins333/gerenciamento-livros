/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorlivros.models;

import utilitarios.GetTimeDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Martins
 */
public class Usuario {
    private String cpf;
    private String nome_usuario;
    private String senha;
    private String nome;
    private String data_cadastro;
    private String endereco;
    private String perfil;

    public Usuario () {
        data_cadastro = GetTimeDate.getDateSQL();
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        // Implementar algoritmo de conversão Hash para a senha!!!
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}