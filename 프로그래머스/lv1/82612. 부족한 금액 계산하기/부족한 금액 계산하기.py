def solution(price, money, count):
    result = 0
    for i in range(1,count+1) :
        result += price * i
    return result - money if result - money > 0 else 0