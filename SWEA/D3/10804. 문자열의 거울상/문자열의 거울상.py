d={'q':'p','p':'q','b':'d','d':'b'}
for x in range(int(input())):
    a,r=input(),''
    for i in range(len(a)-1,-1,-1):
        r+=d[a[i]]
    print(f"#{x+1}",r)