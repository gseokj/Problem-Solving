from collections import Counter
for x in range(int(input())):
    a=list(map(int,input().split()))
    print(f"#{x+1}",Counter(a).most_common()[-1][0])