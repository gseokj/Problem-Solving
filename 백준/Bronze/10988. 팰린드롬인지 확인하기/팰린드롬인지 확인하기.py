a=input()
l1,l2 = len(a) // 2, len(a) // 2
if len(a) % 2 :
    l2 = len(a)//2 +1
if a[:l1] == a[l2:][::-1] :
    print(1)
else :
    print(0)