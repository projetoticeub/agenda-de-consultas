CREATE TABLE pacientes (
    id SERIAL PRIMARY KEY,
    nome_completo VARCHAR(255),
    cpf VARCHAR(11),
    data_nascimento DATE,
    telefone VARCHAR(20),
    email VARCHAR(255),
    genero VARCHAR(10),
    cep VARCHAR(8),
    bairro VARCHAR(255),
    rua VARCHAR(255),
    numero VARCHAR(10),
    complemento VARCHAR(255),
    uf VARCHAR(2)
);
