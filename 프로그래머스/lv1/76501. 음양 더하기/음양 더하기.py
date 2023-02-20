def solution(absolutes, signs):
    answer = 123456789
    for i in range(len(absolutes)):
        if signs[i]==False :
            absolutes[i]=-absolutes[i]
    return sum([-absolutes[i] if signs[i]=='false' else absolutes[i] for i in range(len(absolutes))])