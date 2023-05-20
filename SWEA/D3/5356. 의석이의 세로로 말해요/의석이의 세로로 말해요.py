for x in range(int(input())):
    result=''
    a = [input() for i in range(5)]
    for i in range(30):
        for j in range(5):
            try:
                result+=a[j][i]
            except:
                continue
    print(f"#{x+1}",result)