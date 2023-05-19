for x in range(int(input())):
    n,k = map(int,input().split())
    s = sorted(list(map(int,input().split())),reverse=True)
    print(f"#{x+1}",sum(s[:k]))