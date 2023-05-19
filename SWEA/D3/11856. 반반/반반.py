from collections import Counter
for x in range(int(input())):a=Counter(input()).most_common();print(f"#{x+1}","Yes")if len(a)==2 and a[0][1]==2and a[1][1]==2else print(f"#{x+1}","No")