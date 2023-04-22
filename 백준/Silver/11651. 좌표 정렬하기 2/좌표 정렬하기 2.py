import sys
 
input = sys.stdin.readline
T = int(input())
cor=[]
for _ in range(T) :
    cor.append(list(map(int,input().split())))
    
cor.sort(key=lambda x : (x[1],x[0]))

for i in range(len(cor)) :
    print(f"{cor[i][0]} {cor[i][1]}")
