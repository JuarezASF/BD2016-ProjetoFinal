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

    table_to_columns = {
        "Aluno": [0],
        "Cidade:": [1]
    }

    process(filename, output_filename, table_to_columns)
