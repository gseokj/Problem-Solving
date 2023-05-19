for x in range(int(input())):
    s,c=input(),0
    for i in range(len(s)):
        if s[i] == "(" :
            c+=1
        elif s[i] == ")" and s[i-1] != "(":
            c+=1
    print(f"#{x+1}",c)