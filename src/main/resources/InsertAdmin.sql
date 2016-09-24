INSERT INTO pessoa(
            pes_cpf, pes_idade, pes_nome, pes_senhaOperacao)
    VALUES ('00000000000', 99, 'admin', '123456');

INSERT INTO usuario(
            usu_login, usu_senha, usu_tipousuario,
            usu_idpessoa)
    VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 0, 1);

