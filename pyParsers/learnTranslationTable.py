import sys


def learn(filename, cod_name_pairs):
    line_counter = 0

    output = [dict() for _ in range(len(cod_name_pairs))]
    with open(filename, "r") as fp:
        for line in fp.readlines():

            if line_counter == 0:
                pass
            else:
                field = line.split(";")
                k = 0
                for pair in cod_name_pairs:
                    cod_column_index = pair[0]
                    name_column_index = pair[1]

                    minimumLength = max(cod_column_index, name_column_index)

                    if len(field) < minimumLength:
                        print "error! line {} incomplete!".format(line_counter)
                        continue

                    cod = field[cod_column_index]
                    name = field[name_column_index]

                    if cod in output[k]:
                        if name != output[k][cod]:
                            print "redinition of code:name !"
                        else:
                            pass
                    else:
                        output[k][cod] = name
                    k += 1

            if line_counter % 10000 == 0:
                print ".",
            if line_counter % 800000 == 0:
                print "."
            line_counter += 1

    return output


import json


def save_to(data, file):
    print 'saving data to:', file
    with open(file, "w") as fp:
        json.dump(data, fp, indent=2, sort_keys=True)


def generate_insert_sql_translate_table(output_filename, translation_map, table_name):
    with open(output_filename, "w") as fp:
        keys = translation_map.keys()
        keys.sort()
        for key in keys:
            command = "insert into {} values({},{});".format(table_name, key, translation_map[key])
            fp.write(command + "\n")


if __name__ == "__main__":

    if len(sys.argv) != 2:
        print "error! inform file to read from!"
    filename = sys.argv[1]

    mappings = learn(filename, [(2, 3), (4, 5)])
    municipio_mapping = mappings[0]
    uf_mapping = mappings[1]

    save_to(municipio_mapping, "municipioMapping.json")
    save_to(uf_mapping, "ufMapping.json")

    generate_insert_sql_translate_table("municipioMapping.sql", municipio_mapping, "municipioCodeMapping")
    generate_insert_sql_translate_table("ufMappingMapping.sql", uf_mapping, "ufCodeMapping")
