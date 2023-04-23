for i in range(1,int(input())+1):
    a = input()
    a_r = a[::-1]
    mid = len(a)//2
    result = 0
    if a[:mid]==a_r[:mid]:
        result =1
    
    
    print(f"#{i} {result}")