-- Querie 1: quantidade de alternativas C para todas as provas.
SELECT COUNT(gabarito) AS QtdAlternativaC
FROM GabaritoQuestao
WHERE gabarito = 'C';

-- Querie 2: quantidade de alunos menor de 15 anos que participam do Enem.
SELECT COUNT(idade) AS MenorDe15
FROM Aluno
WHERE idade < 15;

-- Querie 3: numero de estrangeiros que fizeram o Enem.
SELECT COUNT(nacionalidade) AS Estrangeiros
FROM Aluno
WHERE nacionalidade = 3;

-- Queria 4: quantidade de pessoas maior de 90 anos que fizeram o Enem.
SELECT COUNT(idade) AS MaiorDe90
FROM Aluno
WHERE idade > 90;

-- Querie 5: retorna quantidade de pessoas da cidade de Sao Paulo que fizeram o Enem
SELECT COUNT (codigoMunicipioResidencia) AS QtdPessoasSP
FROM Aluno
WHERE codigoMunicipioResidencia = 3550308;