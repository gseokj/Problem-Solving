a=[0,31,28,31,30,31,30,31,31,30,31,30,31]
for i in range(1,int(input())+1):
    m1,d1,m2,d2 = map(int,input().split())
    print(f"#{i} {sum(a[m1:m2])-d1+d2+1}")
    