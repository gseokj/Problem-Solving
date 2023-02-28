def solution(num_list, n):
    return [num_list[ix-n:ix] for ix in range(n, len(num_list)+1, n)]