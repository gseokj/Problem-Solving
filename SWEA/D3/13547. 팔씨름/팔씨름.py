for x in range(int(input())):
    cnt=0
    for i in input():
        if i == "x":
            cnt+=1
    print(f"#{x+1}","YES" if cnt<8 else "NO")