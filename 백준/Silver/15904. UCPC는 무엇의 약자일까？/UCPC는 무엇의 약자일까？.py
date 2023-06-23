tar=["U","C","P","C"]
a=input()
for i in a :
    if tar and i == tar[0]:
        tar.pop(0)
if not tar :
    print("I love UCPC")
else :
    print("I hate UCPC")