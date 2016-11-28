/* Alunos:				     Matricula:
*  Ricardo Souza Rachaus		     14/0161244
*  Juarez Aires Sampaio Filho
* Cria tabelas referentes aos dados do ENEM 2013
*/

-- Cria tabela UnidadeFederacao
CREATE TABLE UnidadeFederacao (
	codigo INTEGER PRIMARY KEY,
	nome VARCHAR (150) NOT NULL
);

-- Cria tabela Municipio
CREATE TABLE Municipio (
	codigo INTEGER PRIMARY KEY,
	nome VARCHAR (150) NOT NULL,
	codigoUF INTEGER NOT NULL,
	FOREIGN KEY (codigoUF) REFERENCES UnidadeFederacao (codigo)
);

-- Cria tabela CadernoProva com os dados das provas
CREATE TABLE CadernoProva(
	codigo INTEGER	PRIMARY KEY,
	tipoConteudo VARCHAR (3) NOT NULL,
	cor VARCHAR (10) NOT NULL
);

-- Cria tabela GabaritoQuestao, com o gabarito das provas
CREATE TABLE GabaritoQuestao(
	codigoProva integer not null,
	numeroQuestao char(3) not null,
	gabarito char not null,
	foreign key (codigoProva) REFERENCES CadernoProva (codigo),
	primary key (codigoProva, numeroQuestao)
);

-- Cria tabela Aluno
CREATE TABLE Aluno (
	inscricao CHAR (12) PRIMARY KEY,
	ano INTEGER NOT NULL,
	codigoMunicipioResidencia INTEGER NOT NULL,
	codigoUFResidencia INTEGER NOT NULL,
	classeHospitalar INTEGER NOT NULL,
	idade INTEGER,
	sexo CHAR (1) NOT NULL,
	nacionalidade INTEGER NOT NULL,
	codigoMunicipioNascimento INTEGER NOT NULL,
	codigoUFNascimento INTEGER NOT NULL,
	conclusaoEnsinoMedio INTEGER NOT NULL,
	anoConclusao INTEGER,
	estadoCivil INTEGER NOT NULL,
	corRaca INTEGER NOT NULL,
	baixaVisao INTEGER NOT NULL,
	cegueira INTEGER NOT NULL,
	surdez INTEGER NOT NULL,
	deficienciaAuditiva INTEGER NOT NULL,
	surdoCegueira INTEGER NOT NULL,
	deficienciaFisica INTEGER NOT NULL,
	deficienciaMental INTEGER NOT NULL,
	deficitAtencao INTEGER NOT NULL,
	dislexia INTEGER NOT NULL,
	gestante INTEGER NOT NULL,
	lactante INTEGER NOT NULL,
	idoso INTEGER NOT NULL,
	autismo INTEGER NOT NULL,
	sabatista INTEGER NOT NULL,
	braille INTEGER NOT NULL,
	ampliada24 INTEGER NOT NULL,
	ampliada18 INTEGER NOT NULL,
	ledor INTEGER NOT NULL,
	acesso INTEGER NOT NULL,
	transcricao INTEGER NOT NULL,
	libras INTEGER NOT NULL,
	leituraLabial INTEGER NOT NULL,
	mesaCadeiraRodas INTEGER NOT NULL,
	mesaCadeiraSeparada INTEGER NOT NULL,
	apoioPerna INTEGER NOT NULL,
	guiaInterprete INTEGER NOT NULL,
	questao01 CHAR (2) NOT NULL,
	questao02 CHAR (2) NOT NULL,
	questao03 CHAR (2) NOT NULL,
	questao04 CHAR (2) NOT NULL,
	questao05 CHAR (2) NOT NULL,
	questao06 CHAR (2) NOT NULL,
	questao07 CHAR (2) NOT NULL,
	questao08 CHAR (2) NOT NULL,
	questao09 CHAR (2) NOT NULL,
	questao10 CHAR (2) NOT NULL,
	questao11 CHAR (2) NOT NULL,
	questao12 CHAR (2) NOT NULL,
	questao13 CHAR (2) NOT NULL,
	questao14 CHAR (2) NOT NULL,
	questao15 CHAR (2) NOT NULL,
	questao16 CHAR (2) NOT NULL,
	questao17 CHAR (2) NOT NULL,
	questao18 CHAR (2) NOT NULL,
	questao19 CHAR (2) NOT NULL,
	questao20 CHAR (2) NOT NULL,
	questao21 CHAR (2) NOT NULL,
	questao22 CHAR (2) NOT NULL,
	questao23 CHAR (2) NOT NULL,
	questao24 CHAR (2) NOT NULL,
	questao25 CHAR (2) NOT NULL,
	questao26 CHAR (2) NOT NULL,
	questao27 CHAR (2) NOT NULL,
	questao28 CHAR (2) NOT NULL,
	questao29 CHAR (2) NOT NULL,
	questao30 CHAR (2) NOT NULL,
	questao31 CHAR (2) NOT NULL,
	questao32 CHAR (2) NOT NULL,
	questao33 CHAR (2) NOT NULL,
	questao34 CHAR (2) NOT NULL,
	questao35 CHAR (2) NOT NULL,
	questao36 CHAR (2) NOT NULL,
	questao37 CHAR (2) NOT NULL,
	questao38 CHAR (2) NOT NULL,
	questao39 CHAR (2) NOT NULL,
	questao40 CHAR (2) NOT NULL,
	questao41 CHAR (2) NOT NULL,
	questao42 CHAR (2) NOT NULL,
	questao43 CHAR (2) NOT NULL,
	questao44 CHAR (2) NOT NULL,
	questao45 CHAR (2) NOT NULL,
	questao46 CHAR (2) NOT NULL,
	questao47 CHAR (2) NOT NULL,
	questao48 CHAR (2) NOT NULL,
	questao49 CHAR (2) NOT NULL,
	questao50 CHAR (2) NOT NULL,
	questao51 CHAR (2) NOT NULL,
	questao52 CHAR (2) NOT NULL,
	questao53 CHAR (2) NOT NULL,
	questao54 CHAR (2) NOT NULL,
	questao55 CHAR (2) NOT NULL,
	questao56 CHAR (2) NOT NULL,
	questao57 CHAR (2) NOT NULL,
	questao58 CHAR (2) NOT NULL,
	questao59 CHAR (2) NOT NULL,
	questao60 CHAR (2) NOT NULL,
	questao61 CHAR (2) NOT NULL,
	questao62 CHAR (2) NOT NULL,
	questao63 CHAR (2) NOT NULL,
	questao64 CHAR (2) NOT NULL,
	questao65 CHAR (2) NOT NULL,
	questao66 CHAR (2) NOT NULL,
	questao67 CHAR (2) NOT NULL,
	questao68 CHAR (2) NOT NULL,
	questao69 CHAR (2) NOT NULL,
	questao70 CHAR (2) NOT NULL,
	questao71 CHAR (2) NOT NULL,
	questao72 CHAR (2) NOT NULL,
	questao73 CHAR (2) NOT NULL,
	questao74 CHAR (2) NOT NULL,
	questao75 CHAR (2) NOT NULL,
	questao76 CHAR (2) NOT NULL,
	FOREIGN KEY (codigoMunicipioResidencia) REFERENCES Municipio (codigo),
	FOREIGN KEY (codigoUFResidencia) REFERENCES UnidadeFederacao (codigo),
	FOREIGN KEY (codigoMunicipioNascimento) REFERENCES Municipio (codigo),
	FOREIGN KEY (codigoUFNascimento) REFERENCES UnidadeFederacao (codigo)
);

-- Cria tabela Escola
CREATE TABLE Escola (
	codigoEscola INTEGER PRIMARY KEY,
	codigoMunicipioEscola INTEGER NOT NULL,
	codigoUFEscola INTEGER NOT NULL,
	dependenciaAdministrativa INTEGER NOT NULL,
	localizacaoEscola INTEGER NOT NULL,
	situacaoFuncionamento INTEGER NOT NULL,
	tipoEscola INTEGER NOT NULL,
	tipoEnsino INTEGER NOT NULL,
	FOREIGN KEY (codigoMunicipioEscola) REFERENCES Municipio (codigo),
	FOREIGN KEY (codigoUFEscola) REFERENCES UnidadeFederacao (codigo)
);
