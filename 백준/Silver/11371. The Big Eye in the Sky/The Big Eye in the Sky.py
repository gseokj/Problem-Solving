import math
while(1):
    x,y = map(int,input().split())
    if x == 0 and y == 0 :
        break
    print(round(math.degrees(math.atan2(y - 0, x - 0))))
