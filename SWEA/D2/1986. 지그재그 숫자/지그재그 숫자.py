a =int(input())
for i in range(1,a+1):
    T = int(input())
    result = 0
    for j in range(1,T+1):
        if j % 2 == 0 :
            result= result-j
        else :
            result+=j
    print(f"#{i}",result)