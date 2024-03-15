from typing import Dict


def convertir_divisa():
    divisas = {"Dolar": 3927, "Euro": 4255, "Yen": 26.12 , "Libra": 4987, "Peso Mexicano": 230.08, "Bitcoin": 200284458, "Yuan": 545.79, "Etherum": 11531560, "Franco":4469, "Sol": 1039 }
    
    input_divisa = input("Ingrese la divisa a la que desea convertir: ").capitalize()
    input_cantidad = float(input("Ingrese la cantidad de pesos colombianos a convertir: "))
    print(f"La taza de cambio de {input_divisa} es: {divisas[input_divisa]} {input_divisa} por 1 peso colombiano (COP")
    if input_divisa in divisas:
        resultado = input_cantidad / divisas[input_divisa]
        print(f"El resultado de la conversion es: {resultado} {input_divisa}")
    else:
        print("La divisa ingresada no es valida")
        

convertir_divisa()


