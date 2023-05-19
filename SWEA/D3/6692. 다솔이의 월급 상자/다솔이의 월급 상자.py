for x in range(int(input())):
    r=0
    for i in range(int(input())):
        a,b=map(float,input().split())
        r+=a*b
    print("#{} {:.5f}".format(x+1,r))