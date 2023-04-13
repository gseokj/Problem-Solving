A=int(input())
user = []
for _ in range(A):
    age, name = input().split()
    user.append([int(age),name])

for i in sorted(user,key=lambda x : x[0]):
    print(i[0],i[1])