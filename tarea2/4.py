def fecha():
    meses={1:"Enero", 2:"Febrero", 3:"Marzo", 4:"Abril", 5:"Mayo", 6:"Junio", 7:"Julio", 8:"Agosto", 9:"Septiembre", 10:"Octubre", 11:"Noviembre", 12:"Diciembre"}
    input_fecha = input("Ingrese la fecha en formato dd/mm/aaaa: ")
    dia = (input_fecha[0:2])
    mes = int(input_fecha[3:5])
    anio = int(input_fecha[6:10])
    print(f"La fecha ingresada es: {dia} de {meses[mes]} del {anio}")
    
fecha()