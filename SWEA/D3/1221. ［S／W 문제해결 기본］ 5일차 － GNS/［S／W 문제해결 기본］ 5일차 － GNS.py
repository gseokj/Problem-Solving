from collections import Counter
for x in range(int(input())):
    input()
    T=Counter(input().split())
    arr=["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    print(f"#{x+1}")
    for i in range(10):
        print(T[arr[i]]*(arr[i]+" "),end=" ")