INSERT INTO pessoa(
            pes_cpf, pes_idade, pes_nome, pes_senhaOperacao)
    VALUES ('00000000000', 99, 'admin', '123456');

INSERT INTO usuario(
            usu_login, usu_senha, usu_tipousuario,
            usu_idpessoa)
    VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 0, 1);

