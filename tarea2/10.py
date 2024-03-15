
clientes = {}

def agregar_cliente():
    nif = input("Ingrese el NIF del cliente: ")
    nombre = input("Ingrese el nombre del cliente: ")
    direccion = input("Ingrese la dirección del cliente: ")
    telefono = input("Ingrese el teléfono del cliente: ")
    correo = input("Ingrese el correo del cliente: ")
    preferente = input("¿Es un cliente preferente? (SI/NO): ")
    
    cliente = {
        "nombre": nombre,
        "dirección": direccion,
        "teléfono": telefono,
        "correo": correo,
        "preferente": preferente
    }
    
    clientes[nif] = cliente
    print("Cliente agregado correctamente.")

def eliminar_cliente():
    nif = input("Ingrese el NIF del cliente que desea eliminar: ")
    if nif in clientes:
        del clientes[nif]
        print("Cliente eliminado correctamente.")
    else:
        print("No se encontró ningún cliente con ese NIF.")

def mostrar_cliente():
    nif = input("Ingrese el NIF del cliente que desea mostrar: ")
    if nif in clientes:
        cliente = clientes[nif]
        print("Datos del cliente:")
        print(f"NIF: {nif}")
        print(f"Nombre: {cliente['nombre']}")
        print(f"Dirección: {cliente['dirección']}")
        print(f"Teléfono: {cliente['teléfono']}")
        print(f"Correo: {cliente['correo']}")
        print(f"Preferente: {cliente['preferente']}")
    else:
        print("No se encontró ningún cliente con ese NIF.")

def listar_clientes():
    print("Lista de todos los clientes:")
    for nif, cliente in clientes.items():
        print(f"NIF: {nif}")
        print(f"Nombre: {cliente['nombre']}")
        print()

def listar_clientes_preferentes():
    print("Lista de clientes preferentes:")
    for nif, cliente in clientes.items():
        if cliente['preferente'] == "True":
            print(f"NIF: {nif}")
            print(f"Nombre: {cliente['nombre']}")
            print()

while True:
    print("Menú:")
    print("(1) Añadir cliente")
    print("(2) Eliminar cliente")
    print("(3) Mostrar cliente")
    print("(4) Listar todos los clientes")
    print("(5) Listar clientes preferentes")
    print("(6) Terminar")
    
    opcion = int(input("Seleccione una opción: ")) 
    
    if opcion == "1":
        agregar_cliente()
    elif opcion == "2":
        eliminar_cliente()
    elif opcion == "3":
        mostrar_cliente()
    elif opcion == "4":
        listar_clientes()
    elif opcion == "5":
        listar_clientes_preferentes()
    elif opcion == "6":
        print("Programa terminado.")
        break
    else:
        print("Opción inválida. Por favor, seleccione una opción válida.")