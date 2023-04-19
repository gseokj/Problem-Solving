while (1):
    m = 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    A = input()
    if A == "#" :
        break
    cnt = 0
    for i in A:
        if i in m :
            cnt +=1
    print(cnt)