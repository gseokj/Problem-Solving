def solution(s):
    lis = ['zero','one','two','three','four','five','six','seven','eight','nine']
    lis_d = {}
    for i in range(10):
        lis_d[lis[i]] = i
    answer = ''
    result = ''
    for i in s :
        if i.isdigit() :
            answer += i
        else :
            result += i
            if result in lis :
                answer += str(lis_d[result])
                result=''
    return int(answer)