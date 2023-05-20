from collections import Counter
for x in range(int(input())):T = ''.join([i[0] for i in sorted(Counter(input()).most_common()) if i[1]%2]);print(f"#{x+1}",''.join(T)) if T else print(f"#{x+1}","Good")