T= int(input())
medi=T//2 # median(중앙값)
A=list(map(int,input().split()))
print(sorted(A)[medi])