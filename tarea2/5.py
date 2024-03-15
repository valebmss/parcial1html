def creditosMaterias():
    materias={
        "Matematicas": 4,
        "Programacion": 3,
        "Base de datos": 3,
        "Fisica": 4,
        "Quimica": 3,
        "Biologia": 3,
        "Ingles": 2,
        "Historia": 2,
        "Filosofia": 2,
        "Educacion fisica": 2,
        "Arte": 2,
        "Geografia": 2}
    for materia in materias:
        print(f"{materia} tiene {materias[materia]} creditos")
    print("El total de creditos es: ", sum(materias.values()))
    
creditosMaterias()
