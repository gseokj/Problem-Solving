import sys

input_read = sys.stdin.readline

num_cranes = int(input_read())
cranes_weights = list(map(int, input_read().split()))

num_boxes = int(input_read())
box_weights = list(map(int, input_read().split()))

cranes_weights.sort(reverse=True)
box_weights.sort(reverse=True)

if box_weights[0] > cranes_weights[0]:
    print(-1)
    sys.exit()
else:
    total_time = 0

    while box_weights:
        if not box_weights:
            break

        for crane_weight in cranes_weights:
            for box_weight in box_weights:
                if crane_weight >= box_weight:
                    box_weights.remove(box_weight)
                    break

        total_time += 1

    print(total_time)