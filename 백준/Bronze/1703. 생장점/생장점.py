while True:
    input_list = list(map(int, input().split()))
    if input_list[0] == 0:
        break
    result = 1
    for i in range(input_list[0]):
        sf = input_list[2*i + 1]
        p = input_list[2*i + 2]
        result = result * sf - p
    print(result)