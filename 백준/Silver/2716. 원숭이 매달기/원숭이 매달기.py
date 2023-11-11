import sys

t = int(sys.stdin.readline())

for _ in range(t):
    op = sys.stdin.readline()

    d = 0
    tree = list()
    for o in op:
        if o == ']':
            d = max(len(tree), d)
            tree.pop()
        else:
            tree.append('[')

    print(2**d)