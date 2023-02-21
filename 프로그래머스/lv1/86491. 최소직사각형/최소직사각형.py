def solution(sizes):
    width=0
    height=0
    answer = 0
    for i in sizes:
        i = sorted(i)
        if i[0] > width :
            width = i[0]
        if i[1] > height :
            height = i[1]
    return width*height