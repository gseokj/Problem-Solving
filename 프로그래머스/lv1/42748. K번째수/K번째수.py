def solution(array, commands):
    answer = []
    for i in commands :
        first=i[0]-1
        second =i[1]
        third=i[2]-1
        if second>len(array) :
            second=len(array) 
        answer.append(sorted(array[first:second])[third])
    return answer