def sdoku(a):
    for i in range(9):
        row = set()
        col = set()
        for j in range(9):
            row.add(a[i][j])
            col.add(a[j][i])
        if len(row) < 9 or len(col) <9 :
            return 0
    for i in range(0,7,3):
        for j in range(0,7,3):
            hap= set()
            for k in range(3):
                for l in range(3):
                    hap.add(a[i+k][j+l])
            if len(hap) < 9 :
                return 0
    return 1
for x in range(1,int(input())+1):
    a=[]
    for _ in range(9):
        a.append(list(map(int,input().split())))
    print(f"#{x} {sdoku(a)}")