players = []
for i in range(int(input())):
    players.append(list(reversed(list(map(int, input().split(" "))))))
players = sorted(players, reverse=True)
printed_country = []
i = 0
while True:
    if printed_country.count(players[i][2]) < 2:
        print(players[i][2], players[i][1])
        printed_country.append(players[i][2])
    if len(printed_country) == 3:
        break
    i += 1