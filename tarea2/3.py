def repuestos():
    repuestos= {
        "Bujia":1.40,
        "Pastillas de freno": 5.80,
        "Radiador": 300.50,
        "Rodamiento": 10.70}
    input_repuesto = input("Ingrese el repuesto que desea comprar: ").capitalize()
    input_cantidad = int(input("Ingrese la cantidad que desea comprar: "))
    if input_repuesto in repuestos:
        resultado = repuestos[input_repuesto] * input_cantidad
        print(f"El precio total de la compra es: {resultado} dolares")
    else:
        print("El repuesto ingresado no es valido")
    
repuestos()
    