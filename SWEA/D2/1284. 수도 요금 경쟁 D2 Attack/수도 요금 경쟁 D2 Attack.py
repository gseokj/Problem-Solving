T = int(input())

for i in range(1,T+1):
    p, q, r, s, w = map(int,input().split())
    A_fee = p * w
    B_fee = q
    if r < w :
        B_fee += (w-r) * s
    print(f"#{i} {min(A_fee,B_fee)}")
    