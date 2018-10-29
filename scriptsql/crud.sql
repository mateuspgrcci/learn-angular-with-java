CREATE TABLE crud.pessoa(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	sobrenome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	cpf VARCHAR(20) NOT NULL
);

CREATE TABLE crud.cartao(
	numero VARCHAR(20) PRIMARY KEY,
	validade DATE NOT NULL,
	seguranca VARCHAR(3) NOT NULL,
	id_pessoa INTEGER REFERENCES crud.pessoa(id) NOT NULL
);

SELECT * FROM crud.pessoa;
SELECT * FROM crud.cartao;

SELECT * FROM crud.cartao AS c
INNER JOIN crud.pessoa AS p
ON c.id_pessoa = p.id

DROP TABLE crud.pessoa CASCADE;
DROP TABLE crud.cartao CASCADE;


