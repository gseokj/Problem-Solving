def solution(s):
    test_list = s.split(" ")
    result=[]
    for i in test_list :
        result.append(i.capitalize())
    return ' '.join(result)