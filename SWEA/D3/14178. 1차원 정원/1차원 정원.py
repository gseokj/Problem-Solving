import math
for x in range(int(input())):
    a,b = map(int,input().split())
    print(f"#{x+1}",math.ceil(a/(b*2+1)))