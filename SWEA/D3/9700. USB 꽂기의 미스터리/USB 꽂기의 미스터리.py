for x in range(int(input())):
    p,q=map(float,input().split())
    s1,s2 = (1-p)*q, p * (1-q) * q
    c = f"#{x+1}"
    print(c,"YES") if s1<s2 else print(c,"NO")