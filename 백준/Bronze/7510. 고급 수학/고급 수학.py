T = int(input())
for i in range(1,T+1):
    print(f"Scenario #{i}:")
    a=list(map(int,input().split()))
    a.sort()
    if a[0]**2+a[1]**2 == a[2]**2:
        print("yes")
    else:
        print("no")
    print()