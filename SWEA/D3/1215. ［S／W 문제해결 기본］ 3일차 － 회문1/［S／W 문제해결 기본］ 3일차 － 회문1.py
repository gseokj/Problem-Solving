for x in range(1,11):
    k = int(input())
    a_col = [input() for i in range(8)]
    a_row = []
    res=0
    for i in range(8):
        temp=''
        for j in range(8):
            temp+=a_col[j][i]
        a_row.append(temp)
    for i in a_col:
        for j in range(8-k+1):
            if i[j:j+k] == i[j:j+k][::-1]:
                res +=1
    for i in a_row:
        for j in range(8-k+1):
            if i[j:j+k] == i[j:j+k][::-1] :
                res +=1
    print(f"#{x}",res)
