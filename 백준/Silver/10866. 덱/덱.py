# push_front X: 정수 X를 덱의 앞에 넣는다.
# push_back X: 정수 X를 덱의 뒤에 넣는다.
# pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# size: 덱에 들어있는 정수의 개수를 출력한다.
# empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
# front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.\

from sys import stdin
T = int(stdin.readline())
deck=[]
for i in range(T):
    A = list(stdin.readline().split())
    if A[0] == 'push_front' :
        deck.insert(0,A[1])
    elif A[0] == 'push_back' :
        deck.append(A[1])
    elif A[0] == 'pop_front' :
        if len(deck)!=0 :
            print(deck[0])
            deck.pop(0)
            
        else :
            print(-1)
    elif A[0] == 'pop_back' :
        if len(deck)!=0 :
            print(deck[-1])
            deck.pop(-1)
        else :
            print(-1)            
    elif A[0] == 'empty' :
        if len(deck)==0 :
            print(1)
        else :
            print(0)
    elif A[0] == 'size' :
        print(len(deck))
    elif A[0] == 'front' :
        if len(deck) == 0 :
            print(-1)
        else :
            print(deck[0])
    
    elif A[0] == 'back' :
        if len(deck) == 0 :
            print(-1)
        else :
            print(deck[-1])