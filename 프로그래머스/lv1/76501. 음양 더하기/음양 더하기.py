def solution(absolutes, signs):
    return sum([-absolutes[i] if signs[i]==False else absolutes[i] for i in range(len(absolutes))])
