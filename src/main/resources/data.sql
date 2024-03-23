-- Inserir dados nas tabelas Receita e Ingrediente
INSERT INTO receita (id_receita, nm_receita, img_receita, dt_receita, ds_receita) VALUES(1, 'Bolo de Cenoura', 'https://www.receiteria.com.br/wp-content/uploads/bolo-de-cenoura-de-liquidificador-1-730x548.jpeg', '2024-03-23', 'Descricao do Bolo de Cenoura');
INSERT INTO receita (id_receita, nm_receita, img_receita, dt_receita, ds_receita) VALUES(2, 'Bolo de Chocolate', 'https://bakeandcakegourmet.com.br/uploads/site/receitas/bolo-de-chocolate-facil-e-barato-rspxk8nc.jpg', '2024-03-23', 'Descricao do Bolo de Chocolate');
INSERT INTO receita (id_receita, nm_receita, img_receita, dt_receita, ds_receita) VALUES(3, 'Bolo de Laranja', 'https://uploads.metropoles.com/wp-content/uploads/2020/04/09103255/91896822_168757634249882_6340592912128928891_n-600x400.jpg', '2024-03-23', 'Descricao do Bolo de Laranja');

INSERT INTO ingrediente (id_ingrediente, nm_ingrediente, und_med_ingrediente) VALUES(1, 'Leite', 'Litro');
INSERT INTO ingrediente (id_ingrediente, nm_ingrediente, und_med_ingrediente) VALUES(2, 'Ovo', 'Unidade');
INSERT INTO ingrediente (id_ingrediente, nm_ingrediente, und_med_ingrediente) VALUES(3, 'Farinha', 'Xicara');
INSERT INTO ingrediente (id_ingrediente, nm_ingrediente, und_med_ingrediente) VALUES(4, 'Agua', 'Litro');
INSERT INTO ingrediente (id_ingrediente, nm_ingrediente, und_med_ingrediente) VALUES(5, 'Chocolate', 'Gramas');

-- Inserir dados na tabela ReceitaIngrediente
INSERT INTO receita_ingrediente (id_receita, id_ingrediente, qtd_rec_ing) VALUES (
    (SELECT id_receita FROM receita WHERE nm_receita = 'Bolo de Chocolate'),
    (SELECT id_ingrediente FROM ingrediente WHERE nm_ingrediente = 'Leite'),
    1.0
);

INSERT INTO receita_ingrediente (id_receita, id_ingrediente, qtd_rec_ing) VALUES (
    (SELECT id_receita FROM receita WHERE nm_receita = 'Bolo de Chocolate'),
    (SELECT id_ingrediente FROM ingrediente WHERE nm_ingrediente = 'Ovo'),
    4.0
);

INSERT INTO receita_ingrediente (id_receita, id_ingrediente, qtd_rec_ing) VALUES (
    (SELECT id_receita FROM receita WHERE nm_receita = 'Bolo de Chocolate'),
    (SELECT id_ingrediente FROM ingrediente WHERE nm_ingrediente = 'Farinha'),
    2.0
);

INSERT INTO receita_ingrediente (id_receita, id_ingrediente, qtd_rec_ing) VALUES (
    (SELECT id_receita FROM receita WHERE nm_receita = 'Bolo de Chocolate'),
    (SELECT id_ingrediente FROM ingrediente WHERE nm_ingrediente = 'Agua'),
    0.5
);

INSERT INTO receita_ingrediente (id_receita, id_ingrediente, qtd_rec_ing) VALUES (
    (SELECT id_receita FROM receita WHERE nm_receita = 'Bolo de Chocolate'),
    (SELECT id_ingrediente FROM ingrediente WHERE nm_ingrediente = 'Chocolate'),
    500
);
