DROP DATABASE gerenciadorlivros;

DROP TABLE livro;
DROP TABLE categoria;
DROP TABLE usuario;
DROP TABLE acao_perfil;
DROP TABLE acao;
DROP TABLE perfil;

CREATE DATABASE gerenciadorlivros;

USE gerenciadorlivros;

CREATE TABLE perfil (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(20) NOT NULL
);

CREATE TABLE acao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL
);

CREATE TABLE acao_perfil (
	id INT PRIMARY KEY AUTO_INCREMENT,
	perfil INT NOT NULL,
	acao INT NOT NULL,
	FOREIGN KEY (perfil) REFERENCES perfil(id),
	FOREIGN KEY (acao) REFERENCES acao(id)
);

CREATE TABLE usuario (
	cpf VARCHAR(11) PRIMARY KEY,
	nome_usuario VARCHAR(20) NOT NULL PRIMARY KEY,
	senha VARCHAR(40) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	endereco VARCHAR(50) NOT NULL,
	data_cadastro DATE NOT NULL,
	perfil INT NOT NULL,
	FOREIGN KEY (perfil) REFERENCES perfil(id)
);

CREATE TABLE livro(
	codigo_barras VARCHAR(13) PRIMARY KEY,
	titulo VARCHAR(30) NOT NULL,
	autor VARCHAR(30) NOT NULL,
	editora VARCHAR(30) NOT NULL,
	ano INT NOT NULL,
	edicao INT NOT NULL,
	volume INT NOT NULL,
	data_cadastro DATE NOT NULL,
	usuario VARCHAR(11) NOT NULL,
	FOREIGN KEY (usuario) REFERENCES usuario(cpf)
);

insert into acao values(null, 'Adicionar Livro;');
insert into acao values(null, 'Editar Qualquer Livro;');
insert into acao values(null, 'Remover Qualquer Livro;');
insert into acao values(null, 'Editar Proprio Livro;');
insert into acao values(null, 'Remover Proprio Livro;');