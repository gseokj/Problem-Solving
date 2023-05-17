for _ in range(1,11):
    x = int(input())
    t = input()
    a = input()
    cnt=0
    for i in range(len(a)-len(t)+1):
        if t in a[i:i+len(t)]:
            cnt+=1
    print(f"#{x} {cnt}")

