def traductor():
    traducciones = {}
    palabras = input("Ingrese las palabras en español e inglés separadas por dos puntos, y cada par <palabra>:<traducción> separados por comas: ").split(",")
    for palabra in palabras:
        palabra = palabra.split(":")
        traducciones[palabra[0]] = palabra[1]
    print(traducciones)
    
    frase = input("Ingrese una frase en español: ").split()
    for palabra in frase:
        if palabra in traducciones:
            print(traducciones[palabra], end=" ")
        else:
            print(palabra, end=" ")
            
traductor()



