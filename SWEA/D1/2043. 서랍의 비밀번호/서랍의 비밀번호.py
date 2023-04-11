A,B = map(int,input().split())
cnt=1
while (A!=B):
    cnt+=1
    B+=1
    if (B>999):
        B=0
print(cnt)