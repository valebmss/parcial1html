def usuario():
    informacion = {}
    informacion['nombre'] = input('Nombre: ')
    informacion['edad'] = int(input('Edad: '))
    informacion['telefono'] = int(input('Telefono: '))
    informacion['direccion'] = input('Direccion: ')
    print(f"{informacion['nombre']} tiene {informacion['edad']} años, vive en {informacion['direccion']} y su numero de telefono es {informacion['telefono']}")
    
usuario()