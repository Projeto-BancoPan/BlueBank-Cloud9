INSERT INTO tb_clientes (email, nome, renda, telefone, tipo_cliente)   VALUES ( 'joão@pan.com.br', 'João Pedro', 7500, '11 99992020', 'PESSOAFISICA');
INSERT INTO tb_clientes (email, nome, renda, telefone, tipo_cliente)   VALUES ( 'leonadro@pan.com.br', 'Leandro Barros', 7500, '11 940002020', 'PESSOAFISICA');
INSERT INTO tb_clientes (email, nome, renda, telefone, tipo_cliente)   VALUES ( 'luiz@pan.com.br', 'Luiz Nascimento', 7500, '11 94502020', 'PESSOAFISICA');
INSERT INTO tb_clientes (email, nome, renda, telefone, tipo_cliente)   VALUES ( 'marcel@pan.com.br', 'Marcel Pinotti', 7500, '11 99002020', 'PESSOAFISICA');


INSERT INTO tb_enderecos (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES (1, 'Centro', '39853-000', 'Belo Horizonte', 'Apto 5', 'SP', 'Rua A', 69);
INSERT INTO tb_enderecos (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES (2, 'Realengo', '21710-261', 'Rio de Janeiro', 'CS 1', 'SP', 'Rua Bernardo de Vasconcelos', 402);
INSERT INTO tb_enderecos (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES (3, 'Centro', '04616-010', 'São Paulo', 'C 3', 'SP', 'Rua C', 31);
INSERT INTO tb_enderecos (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES (4, 'Vila Bela', '03102-000', 'São Paulo', 'Apartamento 87', 'SP', 'Rua A', 68);


INSERT INTO tb_contas_corrente (conta, data_de_abertura, saldo_da_conta, agencia) VALUES (1, '2021-11-27', 10000, 'AGENCIA1');
INSERT INTO tb_contas_corrente (conta, data_de_abertura, saldo_da_conta, agencia) VALUES (2, '2021-11-27', 10000, 'AGENCIA1');
INSERT INTO tb_contas_corrente (conta, data_de_abertura, saldo_da_conta, agencia) VALUES (3, '2021-11-27', 10000, 'AGENCIA1');
INSERT INTO tb_contas_corrente (conta, data_de_abertura, saldo_da_conta, agencia) VALUES (4, '2021-11-27', 10000, 'AGENCIA1');


UPDATE tb_clientes SET conta = 1, id_endereco = 1 WHERE (id_cliente = 1);
UPDATE tb_clientes SET conta = 2, id_endereco = 2 WHERE (id_cliente = 2);
UPDATE tb_clientes SET conta = 3, id_endereco = 3 WHERE (id_cliente = 3);
UPDATE tb_clientes SET conta = 4, id_endereco = 4 WHERE (id_cliente = 4);


/**/