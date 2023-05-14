from math import sqrt

cnt = 0
while 1:
    cnt += 1
    T = input()
    if T == "0":
        break
    r, w, l = map(int, T.split())

    d = sqrt(w ** 2 + l ** 2)
    if 2*r >= d :
        print(f"Pizza {cnt} fits on the table.")
    elif 2*r < d :
        print(f"Pizza {cnt} does not fit on the table.")