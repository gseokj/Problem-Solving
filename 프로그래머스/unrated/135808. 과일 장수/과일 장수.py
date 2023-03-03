def solution(k, m, score):
    answer = 0
    score = sorted(score,reverse=True)
    for i in range(0,len(score),m) :
        sli=score[i:i+m]
        if len(sli) == m :
            answer+=min(sli)*m
    return answer