ALTER TABLE tcattle_ad
ADD bd_city VARCHAR(50) NULL AFTER bd_coduser;

ALTER TABLE tcattle_ad
ADD bd_state VARCHAR(50) NULL AFTER bd_city;