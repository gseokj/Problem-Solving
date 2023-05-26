N,r,c=map(int,input().split())
def z(n,r,c,q):
    half = 2**(n-1)
    if n == 0 :
        return q
    if r < half :
        if c < half :
            quad =1
        else :
            quad = 2
            c -= half
    else :
        if  c < half :
            quad = 3
            r -= half
        else  :
            quad = 4
            r -= half
            c -= half
    q += (quad-1) * (half**2)
    return (z(n-1,r,c,q))
print(z(N,r,c,0))
