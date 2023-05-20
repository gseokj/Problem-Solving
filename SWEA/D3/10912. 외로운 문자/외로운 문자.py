from collections import Counter
for x in range(int(input())):
    T=sorted(Counter(input()).most_common())
    arr=[]
    for i in T:
        if i[1]%2:
            arr.append(i[0])
    if arr:
        print(f"#{x+1}",''.join(arr))
    else:
        print(f"#{x+1}","Good")