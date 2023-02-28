def solution(emergency: list) -> list:
    dict = {num: index for index, num in enumerate(sorted(emergency, reverse=True), start=1)}
    
    return [dict[x] for x in emergency]