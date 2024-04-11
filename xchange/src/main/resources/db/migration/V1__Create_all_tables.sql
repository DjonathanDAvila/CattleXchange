-- Tabela: TUSER
CREATE TABLE TUSER
(
    bd_coduser    VARCHAR(36) PRIMARY KEY,
    bd_doc        VARCHAR(20),
    bd_name       VARCHAR(50),
    bd_lastName   VARCHAR(50),
    bd_email      VARCHAR(100),
    bd_password   VARCHAR(100),
    bd_createDate DATE
);

-- Tabela: TCATTLE_AD
CREATE TABLE TCATTLE_AD
(
    bd_codAd     VARCHAR(36) PRIMARY KEY,
    bd_title     VARCHAR(100),
    bd_desc      TEXT,
    bd_unitValue DECIMAL(10, 2),
    bd_breed     VARCHAR(50),
    bd_sex       CHAR(1),
    bd_coduser   VARCHAR(36),
    bd_adDate    DATE,
    bd_status    VARCHAR(20),
    FOREIGN KEY (bd_coduser) REFERENCES TUSER (bd_coduser)
);

-- Tabela: TIMAGE_AD
CREATE TABLE TIMAGE_AD
(
    bd_codImage VARCHAR(36) PRIMARY KEY,
    bd_codAd    VARCHAR(36),
    bd_url      VARCHAR(255),
    FOREIGN KEY (bd_codAd) REFERENCES TCATTLE_AD (bd_codAd)
);

-- Tabela: TCATTLE_BUY
CREATE TABLE TCATTLE_BUY
(
    bd_codBuy     VARCHAR(36) PRIMARY KEY,
    bd_coduser    VARCHAR(36),
    bd_dateBuy    DATE,
    bd_totalValue DECIMAL(10, 2),
    FOREIGN KEY (bd_coduser) REFERENCES TUSER (bd_coduser)
);

-- Tabela: TITENS_BUY
CREATE TABLE TITENS_BUY
(
    bd_codItem VARCHAR(36) PRIMARY KEY,
    bd_codBuy  VARCHAR(36),
    bd_codAd   VARCHAR(36),
    FOREIGN KEY (bd_codBuy) REFERENCES TCATTLE_BUY (bd_codBuy),
    FOREIGN KEY (bd_codAd) REFERENCES TCATTLE_AD (bd_codAd)
);
