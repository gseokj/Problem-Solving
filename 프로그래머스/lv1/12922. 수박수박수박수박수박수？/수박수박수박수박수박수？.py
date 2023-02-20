def solution(n):
    answer=''
    hi = n//2
    if n == 1 :
        answer="수"
        
    else : 
        if n % 2 == 0 :
            answer=(hi*"수박")
        else :
            answer=(hi*"수박")+"수"
    return answer