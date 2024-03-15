facturas = {}
cobro=0

def mostrar_estado_cobro():
    total_cobrado = cobro
    total_pendiente = sum(facturas.values())
    print("Cantidad cobrada hasta el momento:", total_cobrado)
    print("Cantidad pendiente de cobro:", total_pendiente)

def añadir_factura():
    numero_factura = input("Ingrese el número de factura: ")
    coste_factura = float(input("Ingrese el coste de la factura: "))
    facturas[numero_factura] = coste_factura
    print("Factura añadida correctamente.")

def pagar_factura():
    global cobro
    numero_factura = input("Ingrese el número de factura a pagar: ")
    if numero_factura in facturas:
        cobro= facturas[numero_factura]+cobro
        del facturas[numero_factura]
        print("Factura pagada correctamente.")
        
    else:
        print("La factura no existe.")

while True:
    print("1. Añadir factura")
    print("2. Pagar factura")
    print("3. Terminar")
    opcion = input("Seleccione una opción: ")

    if opcion == "1":
        añadir_factura()
        mostrar_estado_cobro()
    elif opcion == "2":
        pagar_factura()
        mostrar_estado_cobro()
    elif opcion == "3":
        break
    else:
        print("Opción inválida. Por favor, seleccione una opción válida.")

print("Programa terminado.")