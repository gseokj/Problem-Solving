def solution(s, n):
    alph = 'abcdefghijklmnopqrstuvwxyz'
    alph2 = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    answer = ''
    for i in s :
        if not i.isdigit() :
            if i == ' ':
                answer+=i
            elif i==i.upper():
                
                answer+=alph2[(alph2.find(i)+n)%26]
            else :
                answer+=alph[(alph.find(i)+n)%26]
        
    return answer