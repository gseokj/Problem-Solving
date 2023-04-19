s = input()
cnt = 0
pre ='?'

for i in s:
    if i != pre:
        pre=i
        cnt += 1
        
print((cnt)//2)