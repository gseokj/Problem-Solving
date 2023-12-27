def calculate_probability(name, team_name):
    L = name.count("L") + str(team_name).count("L")
    O = name.count("O") + str(team_name).count("O")
    V = name.count("V") + str(team_name).count("V")
    E = name.count("E") + str(team_name).count("E")
    num = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100
    return num

def main():
    user_name = input()
    num_of_teams = int(input())
    team_list = []
    prob_list = []

    for _ in range(num_of_teams):
        team_name = input()
        probability = calculate_probability(user_name, team_name)
        prob_list.append((probability, team_name))

    prob_list.sort(key=lambda x: (-x[0], x[1]))

    print(prob_list[0][1])

if __name__ == "__main__":
    main()