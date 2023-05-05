import sys
input = sys.stdin.readline
from collections import deque

n,m = map(int,input().split())
arr = dict()
for i in range(1,n+1):
    pokemon=input().rstrip()
    arr[i] = pokemon
    arr[pokemon] = i
for _ in range(m):
    find_pokemon=input().rstrip()
    if find_pokemon.isalpha():
        print(arr[find_pokemon])
    else:
        print(arr[int(find_pokemon)])
