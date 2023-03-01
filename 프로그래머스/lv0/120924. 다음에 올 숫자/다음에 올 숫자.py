def solution(common):
    one, two, three = common[:3]
    if two - one == three - two:
        result = common[-1] + (two-one)
    elif two // one == three // two:
        result = common[-1] * (two//one)  
    return result