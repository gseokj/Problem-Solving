def solution(emergency):
    e = sorted(emergency,reverse=True)
    return [e.index(i)+1 for i in emergency]
