CREATE TABLE clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita int NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);

 INSERT INTO clienti(nome,Cognome,DataNascita,regioneResidenza) VALUES('Mario','Rossi',1990,'Calabria');
 INSERT INTO clienti(nome,Cognome,DataNascita,regioneResidenza) VALUES('Federico','Neri',1880,'Roma');
 SELECT * FROM clienti;
DROP TABLE fatture;

CREATE TABLE fatture(
	numeroFattura SERIAL PRIMARY KEY,
	Tipologia VARCHAR NOT NULL,
	importo FLOAT NOT NULL,
	iva INT NOT NULL,
	IdCliente INT NOT NULL,
	dataFattura INT NOT NULL,
	numeroFornitore int NOT NULL UNIQUE,
	CONSTRAINT fk_Cliente FOREIGN KEY(idCliente) REFERENCES clienti (NumeroCliente)
);
INSERT INTO Fatture(tipologia,importo,iva,idCliente,dataFattura,numeroFornitore) VALUES('frutta',20.4,20,1,1902,3);
INSERT INTO Fatture(tipologia,importo,iva,idCliente,dataFattura,numeroFornitore) VALUES('macchine',50.4,20,2,1880,5);

SELECT * FROM fatture;

CREATE TABLE prodotti (
idProdotto SERIAL PRIMARY KEY,
	decrizione VARCHAR NOT NULL,
	inProduzione boolean NOT NULL,
	inCOMMERCIO boolean NOT NULL,
	dataAttivazione INT NOT NULL,
	dataDisattivazione INT NOT NULL
);

CREATE TABLE  fornitori(
    numeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR NOT NULL,
	regioneResidenza VARCHAR NOT NULL,
	CONSTRAINT fk_Fornitori FOREIGN KEY(numeroFornitore)REFERENCES fatture(numeroFornitore)
);
