for x in range(1,int(input())+1):
    comm = input()
    a,b=1,1
    for i in comm:
        if i == "L":
            b = a+b
        else :
            a = a+b

    print(f"#{x} {a} {b}")


