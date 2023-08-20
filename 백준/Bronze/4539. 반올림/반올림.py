n = int(input())

for _ in range(n):
    s = list(input())
    for i in range(len(s)-1, 0, -1):
        if int(s[i]) >=5:
            s[i-1] = str(int(s[i-1]) +1)
        s[i] = '0'
            
    for j in range(len(s)):
        print(s[j],end ='')
    print()