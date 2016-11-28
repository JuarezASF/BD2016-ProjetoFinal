import sys


def process(filename, output_filename, table_to_columns_list):
    with open(filename, "r") as fp, open(output_filename, "w") as output_fp:
        line_counter = 0;

        for line in fp.readlines():
            if line_counter == 0:
                pass
            else:
                fields = line.split(";")

                for table in table_to_columns_list:
                    columns = table_to_columns_list[table]

                    columns_data = [fields[k] for k in columns]

                    command = "insert into {} values (".format(table)
                    for d in columns_data:
                        command += "{},".format(d)
                    command = command[:len(command) - 1]
                    command += ");"

                    output_fp.write(command + "\n")

            line_counter += 1


if __name__ == "__main__":

    if len(sys.argv) != 2:
        print "error! inform file to read from!"
    filename = sys.argv[1]
    output_filename = filename[:filename.find(".")] + ".sql"

    print 'reading data from:', filename
    print 'writing data to:', output_filename

    # table_to_columns = {
    #     "Aluno": [0, 1, 2, 4, 6, 7, 15, 16, 17, 18, 20, 22, 23, 26, 27, 28, 29, 30, 31, 32, 33, 34,
    #               35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53],
    #     "Escola": [7, 8, 10, 12, 13, 14, 24, 25]
    # }
    table_to_columns = {
        "Aluno": [0, 1, 2, 4, 6, 7, 15, 16, 17, 18, 20, 22, 23, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                  35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53]
    }

    process(filename, output_filename, table_to_columns)
