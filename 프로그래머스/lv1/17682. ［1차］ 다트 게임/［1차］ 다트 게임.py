def solution(dartResult):
    n = ''
    result = []
    for i in dartResult:
        if i.isdigit():
            n += i
        elif i == 'S':
            n = int(n)**1
            result.append(n)
            n = ''
        elif i == 'D':
            n = int(n)**2
            result.append(n)
            n = ''
        elif i == 'T':
            n = int(n)**3
            result.append(n)
            n = ''
        elif i == '*':
            if len(result) > 1:
                result[-2] = result[-2] * 2
                result[-1] = result[-1] * 2
            else:
                result[-1] = result[-1] * 2
        elif i == '#':
            result[-1] = result[-1] * -1
        
    return sum(result)