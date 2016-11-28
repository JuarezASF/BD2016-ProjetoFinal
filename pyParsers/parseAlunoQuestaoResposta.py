import sys


def write_commands(anw, aluno, prova, tabela, ofp):
    i = 0
    for x in anw:
        command = "insert into {}(idAluno,idProva,indexQuestao) values({},{},{},{});".format(
            tabela, aluno, prova, i, x
        )

        ofp.write(command + "\n")

        i += 1


if __name__ == "__main__":

    if len(sys.argv) != 2:
        print "error! inform file to read from!"
        exit(0)
    filename = sys.argv[1]
    output_filename = "alunoQuestaoResposta.sql"

    print 'reading data from:', filename
    print 'writing data to:', output_filename

    with open(filename, "r") as fp, open(output_filename, "w") as ofp:
        line_counter = 0

        for line in fp.readlines():
            if line_counter == 0:
                pass
            else:
                fields = line.split(";")

                student_number = fields[0]
                resposta_cn = [x for x in fields[74]]
                resposta_ch = [x for x in fields[75]]
                resposta_lc = [x for x in fields[76]]
                resposta_mt = [x for x in fields[77]]

                write_commands(
                    resposta_cn, student_number, fields[66], "alunoQuestaoResposta", ofp)
                write_commands(
                    resposta_ch, student_number, fields[67], "alunoQuestaoResposta", ofp)
                write_commands(
                    resposta_lc, student_number, fields[68], "alunoQuestaoResposta", ofp)
                write_commands(
                    resposta_mt, student_number, fields[69], "alunoQuestaoResposta", ofp)

            line_counter += 1
