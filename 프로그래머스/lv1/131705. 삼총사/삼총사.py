def solution(number):
    result = 0
    for i in range(len(number)) :
        cnt = 1
        for j in range(i+1,len(number)):
            for k in range(j+1, len(number)):
                sum=number[i]+number[j]+number[k]
                
                if sum == 0 :
                    print(i,j,k,sum)   
                    result+=1
    return result