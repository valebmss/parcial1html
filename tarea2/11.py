def directorio_clientes():
    directorio = "cedula;nombre;email;teléfono;descuento\n1001234567L;LuisGonzález;luisgonzalez@mail.com;656343576;12.5\n1014737846;ValeriaLarrea;leidyvale244z@gmail.com;3158812329;10"
    #directorio1= str( input("Ingrese el directorio de clientes: "))
    lineas = directorio.strip().split('\n')
    campos = lineas[0].split(';')

    clientes = {}

    for linea in lineas[1:]:
        valores = linea.split(';')
        cliente = {}
        for i in range(len(campos)):
            cliente[campos[i]] = valores[i]        
        clientes[valores[0]] = cliente

    print(clientes)

directorio_clientes()
    