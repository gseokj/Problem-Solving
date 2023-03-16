def solution(arr):
    if len(arr) == 1:
        arr = []
        arr.append(-1)
    else:
        arr.remove(min(arr))
    return arr