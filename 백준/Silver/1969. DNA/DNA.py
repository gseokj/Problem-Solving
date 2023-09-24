N, M = map(int, input().split())
DNA = [input() for _ in range(N)]
HM_small_DNA = '' 
HM_count = 0

for i in range(M):
    ACGT = [0, 0, 0, 0] 
    for j in range(N):
        if DNA[j][i] == 'A':
            ACGT[0] += 1
        elif DNA[j][i] == 'C':
            ACGT[1] += 1
        elif DNA[j][i] == 'G':
            ACGT[2] += 1
        elif DNA[j][i] == 'T':
            ACGT[3] += 1
    
    max_idx = ACGT.index(max(ACGT))
    if max_idx == 0:
        HM_small_DNA += 'A'
    elif max_idx == 1:
        HM_small_DNA += 'C'
    elif max_idx == 2:
        HM_small_DNA += 'G'
    elif max_idx == 3:
        HM_small_DNA += 'T'

    HM_count += N - max(ACGT) 
print(HM_small_DNA)
print(HM_count)