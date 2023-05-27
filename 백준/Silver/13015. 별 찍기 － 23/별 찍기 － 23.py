n = int(input())

for i in range(1, n + 1):
    if i == 1 or i == 2 * n:
        print("*" * n + " " * (2 * (n - 1) - 1) + "*" * n)
    elif i != n:
        print(" " * (i - 1) + "*" + " " * (n - 2) + "*" + " " * (2 * (n - i) - 1) + "*" + " " * (n - 2) + "*")
    else:
        print(" " * (i - 1) + "*" + " " * (n - 2) + "*" + " " * (2 * (n - i) - 1) + " " * (n - 2) + "*")

for i in range(n, 0, -1):
    if i == 1 or i == 2 * n:
        print("*" * n + " " * (2 * (n - 1) - 1) + "*" * n)
    elif i != n:
        print(" " * (i - 1) + "*" + " " * (n - 2) + "*" + " " * (2 * (n - i) - 1) + "*" + " " * (n - 2) + "*")