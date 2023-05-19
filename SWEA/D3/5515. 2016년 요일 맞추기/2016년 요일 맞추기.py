a=[31,29,31,30,31,30,31,31,30,31,30,31]
for x in range(int(input())):m,d=map(int,input().split());print(f"#{x+1}",((sum(a[:m-1])+d)%7+3)%7)