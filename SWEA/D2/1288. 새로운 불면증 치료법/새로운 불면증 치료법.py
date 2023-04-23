
for i in range(1,int(input())+1):
    lis = []
    n = int(input())
    cnt = 0
    while len(lis) < 10 :
        cnt+=1
        test = n * cnt
        for j in str(test)  :
            if int(j) not in lis :
                lis.append(int(j))

    print(f"#{i} {n*cnt}")