A = int(input())


t_o = ["01","03","05","07","08","10","12"] # 31일 집단
t_e = ["02"] # 28일
t_z = ["04","06","09","11"] # 30일 집단

for i in range(1,A+1) :
    T = input()
    year =  T[0:4]+"/" +T[4:6]+"/"+T[6:8]
    if (T[4:6] in t_o and (int(T[7:9]) >0 and int(T[7:9]) <= 31)) or (T[4:6] in t_e and (int(T[7:9]) >0 and int(T[7:9]) <= 28)) or (T[4:6] in t_z and (int(T[7:9]) >0 and int(T[7:9]) <= 30)):
        print(f"#{i}",year)
    else :
        print(f"#{i}",-1)