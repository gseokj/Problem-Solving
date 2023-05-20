from collections import deque
for x in range(1,11):
    input()
    arr=input().split()
    input()
    comm=deque(input().split())
    while comm:
        if comm[0] == "I":
            comm.popleft()
            seq = int(comm.popleft())
            cnt = int(comm.popleft())
            temp=[]
            while cnt:
                cnt-=1
                temp.append(comm.popleft())
            while temp:
                arr.insert(seq,temp.pop())
        elif comm[0] == "D":
            comm.popleft()
            seq = int(comm.popleft())
            cnt = int(comm.popleft())
            while cnt:
                cnt-=1
                arr.pop(seq)
    print(f"#{x}",*arr[:10])