def solution(participant, completion):
    dicHash = {}
    sumHash = 0
    for i in participant :
        dicHash[hash(i)] = i
        sumHash += hash(i)
    for i in completion :
        sumHash -= hash(i)
    return dicHash[sumHash]