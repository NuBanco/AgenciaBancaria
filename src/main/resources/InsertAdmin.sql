INSERT INTO pessoa(
            ps_cpf, ps_idade, ps_nome, ps_senha)
    VALUES ('00000000000', 99, 'admin', '1');

INSERT INTO usuario(
            usu_login, usu_senha, usu_senhaoperacao, usu_tipousuario,
            usu_idpessoa)
    VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 0, 1);

