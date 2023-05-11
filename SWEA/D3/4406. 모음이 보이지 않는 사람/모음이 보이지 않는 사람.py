for x in range(1,int(input())+1):
    moum=['a', 'e', 'i', 'o', 'u']
    a = input()
    res = ''
    for i in a:
        if i not in moum :
            res+=i
    print(f"#{x} {res}")
