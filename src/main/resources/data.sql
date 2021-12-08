use db_bluebank;

INSERT INTO tb_clientes (email, nome, renda, telefone, tipo_cliente)
VALUES
    ( 'joão@pan.com.br', 'João Pedro', 7500, '11 99992020', 'PESSOAFISICA'),
    ( 'leonadro@pan.com.br', 'Leandro Barros', 7500, '11 940002020', 'PESSOAFISICA'),
    ( 'luiz@pan.com.br', 'Luiz Nascimento', 7500, '11 94502020', 'PESSOAFISICA'),
    ( 'marcel@pan.com.br', 'Marcel Pinotti', 7500, '11 99002020', 'PESSOAFISICA'),
    ('pietracarlacosta@digitalsj.com.br', 'Pietra Carla Costa', 250000,'(94) 3535-6491','PESSOAJURIDICA'),
    ('lorenarenatacastro@fertility.com.br','Lorena Renata Castro', 250000, '(22) 2959-3858','PESSOAJURIDICA'),
    ('estherjulianaclarafigueiredo-88@splicenet.com.br', 'Esther Juliana Clara Figueiredo', 250000,'(17) 99662-2216','PESSOAJURIDICA'),
    ('marcosvinicius-92@latapack.com.br', 'Marcos Vinicius Anderson da Mota', 250000, '(33) 98851-8154','PESSOAJURIDICA');


INSERT INTO tb_enderecos (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero)
VALUES
    (1, 'Centro', '39853-000', 'Belo Horizonte', 'Apto 5', 'MG', 'Rua A', 69),
    (2, 'Realengo', '21710-261', 'Rio de Janeiro', 'CS 1', 'RJ', 'Rua B', 402),
    (3, 'Centro', '04616-010', 'São Paulo', 'CS 3', 'SP', 'Rua C', 238),
    (4, 'Vila Bela', '03102-000', 'São Paulo', 'Apartamento 87', 'SP', 'Rua D', 68),
    (5,'Nova Marabá','68506-100','Marabá','CASA 2','PA','Quadra Dez',95),
    (6,'Nova Friburgo','28630-443','São Geraldo','APT 1','RJ','Rua Crésio Coelho Caetano',171),
    (7,'Residencial Acapulco','15804-401','Catanduva','GALPAO','SP','Avenida das Colinas',893),
    (8,'Nossa Senhora Aparecida','35303-011','Caratinga','ANDAR 5 APT 2','MG','Rua Francisco Florentino da Costa',85);


INSERT INTO tb_contas_corrente (conta, data_de_abertura, saldo_da_conta, agencia)
VALUES
    (1, '2021-11-27', 10000, 'AGENCIA3'),
    (2, '2021-11-27', 10000, 'AGENCIA2'),
    (3, '2021-11-27', 10000, 'AGENCIA2'),
    (4, '2021-11-27', 10000, 'AGENCIA3'),
    (5, '2021-11-27', 10000, 'AGENCIA2'),
    (6, '2021-11-27', 10000, 'AGENCIA1'),
    (7, '2021-11-27', 10000, 'AGENCIA2'),
    (8, '2021-11-27', 10000, 'AGENCIA1');


UPDATE tb_clientes SET conta = 1, id_endereco = 1 WHERE (id_cliente = 1);
UPDATE tb_clientes SET conta = 2, id_endereco = 2 WHERE (id_cliente = 2);
UPDATE tb_clientes SET conta = 3, id_endereco = 3 WHERE (id_cliente = 3);
UPDATE tb_clientes SET conta = 4, id_endereco = 4 WHERE (id_cliente = 4);
UPDATE tb_clientes SET conta = 5, id_endereco = 5 WHERE (id_cliente = 5);
UPDATE tb_clientes SET conta = 6, id_endereco = 6 WHERE (id_cliente = 6);
UPDATE tb_clientes SET conta = 7, id_endereco = 7 WHERE (id_cliente = 7);
UPDATE tb_clientes SET conta = 8, id_endereco = 8 WHERE (id_cliente = 8);