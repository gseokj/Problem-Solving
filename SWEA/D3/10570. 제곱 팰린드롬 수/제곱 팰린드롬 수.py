from math import sqrt

for x in range(1,int(input())+1):
    cnt = 0
    a,b = map(int,input().split())
    for i in range (a,b+1) :
        if int(sqrt(i)) == sqrt(i):
            if str(i) == str(i)[::-1] and str(int(sqrt(i))) == str(int(sqrt(i)))[::-1] :
                cnt+=1
    print(f"#{x} {cnt}")
