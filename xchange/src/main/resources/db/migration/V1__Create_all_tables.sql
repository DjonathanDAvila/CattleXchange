-- Tabela: TUSER
CREATE TABLE TUSER
(
    bd_coduser    binary(16) NOT NULL,
    bd_doc        VARCHAR(20),
    bd_name       VARCHAR(50),
    bd_lastName   VARCHAR(50),
    bd_email      VARCHAR(100),
    bd_password   VARCHAR(100),
    bd_createDate DATE,
    CONSTRAINT PK_TUSER PRIMARY KEY (bd_coduser)
);

-- Tabela: TCATTLE_AD
CREATE TABLE TCATTLE_AD
(
    bd_codAd     binary(16) NOT NULL,
    bd_title     VARCHAR(100),
    bd_desc      TEXT,
    bd_unitValue DECIMAL(10, 2),
    bd_quantity  integer,
    bd_breed     VARCHAR(50),
    bd_sex       CHAR(1),
    bd_coduser   binary(16),
    bd_adDate    DATE,
    bd_status    VARCHAR(20),
    CONSTRAINT PK_TCATTLE_AD PRIMARY KEY (bd_codAd),
    CONSTRAINT FK_TUSER_TCATTLEAD FOREIGN KEY (bd_coduser) REFERENCES TUSER (bd_coduser)
);

-- Tabela: TIMAGE_AD
CREATE TABLE TIMAGE_AD
(
    bd_codImage binary(16) NOT NULL,
    bd_codAd    binary(16),
    bd_url      VARCHAR(255),
    CONSTRAINT PK_TIMAGE_AD PRIMARY KEY (bd_codImage),
    CONSTRAINT FK_TIMAGE_AD_TCATTLE_AD FOREIGN KEY (bd_codAd) REFERENCES TCATTLE_AD (bd_codAd)
);

-- Tabela: TCATTLE_BUY
CREATE TABLE TCATTLE_BUY
(
    bd_codBuy     binary(16) NOT NULL,
    bd_coduser    binary(16),
    bd_dateBuy    DATE,
    bd_totalValue DECIMAL(10, 2),
    CONSTRAINT PK_TCATTLE_BUY PRIMARY KEY (bd_codBuy),
    CONSTRAINT FK_TCATTLE_BUY_TUSER FOREIGN KEY (bd_coduser) REFERENCES TUSER (bd_coduser)
);

-- Tabela: TITENS_BUY
CREATE TABLE TITENS_BUY
(
    bd_codItem binary(16) NOT NULL,
    bd_codBuy  binary(16),
    bd_codAd   binary(16),
    CONSTRAINT PK_TITENS_BUY PRIMARY KEY (bd_codItem, bd_codBuy),
    CONSTRAINT FK_TITENS_BUY_TCATTLE_BUY FOREIGN KEY (bd_codBuy) REFERENCES TCATTLE_BUY (bd_codBuy),
    CONSTRAINT FK_TITENS_BUY_TCATTLE_AD FOREIGN KEY (bd_codAd) REFERENCES TCATTLE_AD (bd_codAd)
);