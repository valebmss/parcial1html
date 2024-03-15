def mochila(weights, values, capacity):
    n = len(weights)

    dp = [[0] * (capacity + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            else:
                dp[i][w] = dp[i - 1][w]

    return dp[n][capacity]

n = int(input("Ingrese el número de elementos: "))
pesos = []
valores = []
for i in range(n):
    peso = int(input(f"Ingrese el peso del elemento {i + 1}: "))
    valor = int(input(f"Ingrese el valor del elemento {i + 1}: "))
    pesos.append(peso)
    valores.append(valor)
capacidad = int(input("Ingrese la capacidad de la mochila: "))
print("El valor máximo que se puede obtener es:", mochila(pesos, valores, capacidad))

