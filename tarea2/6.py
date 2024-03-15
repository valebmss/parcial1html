def usuario():
    informacion = {}
    campos = ['nombre', 'apellido', 'edad', 'sexo', 'telefono', 'correo']
    for campo in campos:
        informacion[campo] = input(f'Ingrese su {campo}: ')
        print(informacion)

usuario()
