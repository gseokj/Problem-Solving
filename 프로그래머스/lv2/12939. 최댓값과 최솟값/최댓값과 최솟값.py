def solution(s):
    s_list = list(map(int,s.split(" ")))
    return f"{min(s_list)} {max(s_list)}"