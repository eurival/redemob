

create sequence PESSOA_ID_SEQ start 1 increment 1;

CREATE TABLE public.pessoa (
	id int8 NOT NULL PRIMARY KEY DEFAULT nextval('PESSOA_ID_SEQ'),
	cpf varchar(14) NOT NULL,
	data_nascimento date NULL,
	email varchar(255) NOT NULL,
	foto oid NULL,
	foto_content_type varchar(255) NULL,
	nome_mae varchar(60) NULL,
	nome_pessoa varchar(100) NOT NULL,
	usuario_id int8
);

create sequence CIDADE_ID_SEQ start 1 increment 1;
CREATE TABLE public.cidade (
	id int8 NOT NULL PRIMARY KEY DEFAULT nextval('CIDADE_ID_SEQ'),
	nome_cidade varchar(60) not null
);

create sequence USUARIO_ID_SEQ start 1 increment 1;
CREATE TABLE public.usuario (
	id int8 NOT NULL PRIMARY KEY DEFAULT nextval('USUARIO_ID_SEQ'),
	admin boolean default false,
	senha varchar(255) not null,
	pessoa_id int8 NULL
);

ALTER TABLE public.usuario ADD CONSTRAINT fk_usuario__pessoa_id 
FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);

create sequence INSCRICAO_ID_SEQ start 1 increment 1;
CREATE TABLE public.inscricao (
	id int8 NOT NULL PRIMARY KEY DEFAULT nextval('INSCRICAO_ID_SEQ'),
	bairro varchar(255) NULL,
	complemento varchar(50) NULL,
	endereco varchar(100) NULL,
	status varchar(255) NULL,
	cidade_id int8 NOT NULL,
	pessoa_id int8 NOT NULL,
	data_inscricao timestamp with time zone not null

);

create sequence ARQUIVO_ID_SEQ start 1 increment 1;
CREATE TABLE public.arquivo (
	id int8 NOT NULL PRIMARY KEY DEFAULT nextval('ARQUIVO_ID_SEQ'),
	nome_arquivo varchar(255) NULL,
	caminho_arquivo varchar(255) NULL,
	inscricao_id int8 not NULL,
	tipo varchar(255)
);

ALTER TABLE public.inscricao ADD CONSTRAINT fk_inscricao_pessoa FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
ALTER TABLE public.inscricao ADD CONSTRAINT fk_inscricao_cidade FOREIGN KEY (cidade_id) REFERENCES public.cidade(id);

ALTER TABLE public.usuario ADD CONSTRAINT fk_usuario_pessoa FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(id);
ALTER TABLE public.arquivo ADD CONSTRAINT fk_arquivo_inscricao FOREIGN KEY (inscricao_id) REFERENCES public.inscricao(id);


INSERT INTO cidade (nome_cidade)
VALUES
  ('GOIÂNIA'),
  ('NERÓPOLIS'),
  ('NOVA VENEZA'),
  ('HIDROLÂNDIA'),
  ('CALDAZINHA'),
  ('CATURAÍ'),
  ('BRAZABRANTES'),
  ('GUAPÓ'),
  ('INHUMAS'),
  ('BONFINÓPOLIS');
  
INSERT INTO pessoa (cpf,data_nascimento,email,nome_pessoa,nome_mae)
VALUES
  ('79133147181','2022-10-10','condimentum@hotmail.couk','Marshall de Azevedo','Peter Inacio'),
  ('33453829348','2023-06-19','ipsum.nunc.id@outlook.couk','Lucius Magalhaes','Dolan Mendes'),
  ('81540754552','2022-05-08','at.iaculis.quis@hotmail.couk','Juliet de Melo','Oscar da Rocha'),
  ('36920250462','2023-04-04','amet@google.couk','Charlotte de Fatima','Ivana Magalhaes'),
  ('58517581137','2023-05-09','consequat@yahoo.com','Dai Pereira','Yvette da Silveira'),
  ('51342643581','2021-12-28','eros.proin@yahoo.com','Reagan Nonato','Mollie Pacheco'),
  ('43700370642','2021-09-19','mauris@yahoo.org','Phelan Mendes','Cain da Silveira');
  

INSERT INTO inscricao (bairro,endereco,status,complemento,cidade_id,pessoa_id, data_inscricao)
VALUES
  ('Colombo','918-2571 Nullam Av.','EM_ANALISE','-0.0310996665',4,1,(select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Abaetetuba','Ap #152-8117 Volutpat. St.','EM_ANALISE','0.0479106541',5,2, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Bragança','Ap #806-1666 Tempor, St.','APROVADO','-0.3946764772',6,3, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Belém','568-6895 Vestibulum Rd.','APROVADO','-0.3916367971',3,4, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Cametá','292-6200 Parturient Av.','REPROVADO','0.1835261209',2,5, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Juazeiro do Norte','880-8044 Orci Rd.','REPROVADO','-0.0268407560',7,6, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Colombo','Ap #922-7794 A Rd.','EM_ANALISE','-0.3042054370',4,7, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Sousa','692-1478 In, Ave','EM_ANALISE','-0.0187711048',7,1, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Santa Rita','Ap #394-260 Justo. Av.','APROVADO','0.0703900735',6,5, (select (current_timestamp at time zone 'UTC') at time zone 'UTC')),
  ('Marabá','735-2003 Amet Av.','APROVADO','0.0954157276',5,7, (select (current_timestamp at time zone 'UTC') at time zone 'UTC'));

  
  INSERT INTO usuario (senha,pessoa_id)
VALUES
  ('MFY40DVX2GT',1),
  ('NZP58XLT2WW',2),
  ('MTP77PZM3ME',3),
  ('KYQ54TXZ4DQ',4),
  ('GEQ86MGR4OB',5),
  ('WEI96ZKJ0LG',6),
  ('LMJ73XXI0GW',7);  
  

