SET @user_id = UNHEX(REPLACE(UUID(), '-', ''));

INSERT INTO TUSER
(
      bd_coduser
    , bd_doc
    , bd_name
    , bd_lastName
    , bd_email
    , bd_password
    , bd_createDate
)
VALUES
(
    @user_id, -- Gera um UUID e converte para binary(16)
    '12345678901', -- Exemplo de número de documento
    'Edsu', -- Nome do usuário
    'Adriano', -- Sobrenome do usuário
    'edsu.adriano@email.com', -- E-mail do usuário
    '$2a$10$xjjBdSzvvnIA6O9uGX94eOK1VN3tLWd0QZB6TYKTimtifyUtqZGZ2', -- Senha do usuário (de preferência, faça hash dela antes de inserir)
    CURDATE() -- Data de criação do usuário (atual)
);

SET @cattle_id = UNHEX(REPLACE(UUID(), '-', ''));

INSERT INTO TCATTLE_AD
(
    bd_codAd
    , bd_title
    , bd_desc
    , bd_unitValue
    , bd_quantity
    , bd_breed
    , bd_sex
    , bd_coduser
    , bd_adDate
    , bd_status
)
VALUES
(
   @cattle_id,
   'Boi sherk',
   'Boi latino alterado com DNA de Sherek',
   875.98,
   1,
   'CHAROLES',
   'M',
   @user_id,
   CURDATE(),
   'ACTIVE'
);

INSERT INTO TIMAGE_AD
(
    bd_codImage
    , bd_codAd
    , bd_sequence
    , bd_url
)
VALUES
(
    UNHEX(REPLACE(UUID(), '-', '')),
    @cattle_id,
    1,
    'https://www.comprerural.com/wp-content/uploads/2024/02/WhatsApp-Image-2024-02-05-at-11.10.57-750x430.jpeg'
);