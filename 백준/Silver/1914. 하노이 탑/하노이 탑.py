def tower_of_hanoi(moves, source, auxiliary, target):
    if moves == 1:
        print(source, target, sep=" ")
    else:
        tower_of_hanoi(moves - 1, source, target, auxiliary)
        tower_of_hanoi(1, source, auxiliary, target)
        tower_of_hanoi(moves - 1, auxiliary, source, target)

n = int(input())
print(2 ** n - 1)
if n <= 20:
    tower_of_hanoi(n, 1, 2, 3)