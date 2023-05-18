for x in range(int(input())):
    a,c,b=input(),'.#','..#.'
    l=len(a)
    print(l*b+".")
    print(l*c*2+".")
    for i in a :
        print("#."+i+".",end='')
    print("#")
    print(l*c*2+".")
    print(l*b+".")