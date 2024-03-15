
def compra():
    cesta = {}
    while True:
        articulo = input("Ingrese el articulo: ")
        precio = float(input("Ingrese el precio: "))
        cesta[articulo] = precio
        continuar = input("Desea continuar? (S/n): ").strip().lower()
        if continuar != "n":
            continuar = "s"
        if continuar != "s":
            break
    
    print("\nFactura")
    print("-" * 30)
    print("{:<15} {:<10}".format("Articulo", "Precio"))
    print("-" * 30)
    total = 0
    for articulo, precio in cesta.items():
        print("{:<15} {:<10.2f}".format(articulo, precio))
        total += precio
    print("-" * 30)
    print("{:<15} {:<10.2f}".format("Costo total:", total))
    
compra()
