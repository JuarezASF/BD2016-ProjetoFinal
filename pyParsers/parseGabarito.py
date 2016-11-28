import string


def hasLetter(x):
    return any(e in x for e in string.letters)


def compare(x, y):
    if not hasLetter(x) and not hasLetter(y):
        return int(x) - int(y)
    elif hasLetter(x) and not hasLetter(y):
        return int(x[:len(x) - 1]) - int(y)
    elif not hasLetter(x) and hasLetter(y):
        return int(x) - int(y[:len(y) - 1])
    else:
        if x[:len(x) - 1] == y[:len(y) - 1]:
            return ord(x[-1]) - ord(y[-1])
        else:
            return int(x[:len(x) - 1]) - int(y[:len(y) - 1])


baseDir = "/home/juarez/Documents/BD/trabalhoFinal/Microdados_Enem_2013/PLANILHAS"

names = [
    'ITENS_ENEM_2013.csv.0',
    'ITENS_ENEM_2013.csv.1',
    'ITENS_ENEM_2013.csv.2',
    'ITENS_ENEM_2013.csv.3',
    'ITENS_ENEM_2013.csv.4',
    'ITENS_ENEM_2013.csv.5',
    'ITENS_ENEM_2013.csv.6',
    'ITENS_ENEM_2013.csv.7',
]

meaning = [
    "CH",
    "CH_LEDOR",
    "CN",
    "CN_LEDOR",
    "LCT",
    "LCT_LEDOR",
    "MT",
    "MT_LEDOR"
]

meaning = [
    "CH",
    "CH_LEDOR",
    "CN",
    "CN_LEDOR",
    "LCT",
    "LCT_LEDOR",
    "MT",
    "MT_LEDOR"
]

codigos = [
    [167, 168, 169, 170],
    [187],
    [171, 172, 173, 170],
    [188],
    [175, 176, 177, 178],
    [189],
    [179, 180, 181, 182],
    [190]
]

files = [baseDir + "/" + f for f in names]

file_index = 0

outputFileName = "insertGabarito.sql"

print 'writing output to:', outputFileName
outputFile = open(outputFileName, "w")


for filename in files:
    print filename
    gabarito = dict()
    with open(filename, "r") as fp:
        line_number = 0
        for line in fp.readlines():
            if line_number == 0:
                if file_index % 2 == 0:
                    gabarito["A"] = dict()
                    gabarito["B"] = dict()
                    gabarito["C"] = dict()
                    gabarito["D"] = dict()
                else:
                    gabarito["A"] = dict()
            else:
                fields = line.split(",")

                if file_index % 2 == 0:
                    gabarito["A"][fields[3]] = fields[5]
                    gabarito["B"][fields[7]] = fields[9]
                    gabarito["C"][fields[11]] = fields[13]
                    gabarito["D"][fields[15]] = fields[17]
                else:
                    gabarito["A"][fields[3]] = fields[5]

            line_number += 1
    cod = codigos[file_index]
    c = 0
    for caderno in sorted(gabarito.keys()):
        print "caderno:", caderno
        print cod[c]
        chaves = [x for x in gabarito[caderno].keys()]
        chaves.sort(cmp=compare)

        final_vector = list()


        for k in chaves:
            item_answer = gabarito[caderno][k]
            # print "\t{}:{}".format(k, item_answer)
            final_vector.append(item_answer)
            outputFile.write("insert into GabaritoQuestao(codigoProva,numeroQuestao,gabarito) values({},'{}','{}');\n".format(
                cod[c], k, item_answer))
        c += 1


        print "\t", final_vector
    file_index += 1

outputFile.close()
