for x in range(1,int(input())+1):
    a = input()
    for i in range(1,16):
        if a[:i] ==  a[i:i*2]:
            print(f"#{x} {i}")
            break
        