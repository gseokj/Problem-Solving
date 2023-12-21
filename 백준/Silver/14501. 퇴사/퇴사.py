num_days = int(input())
work_times, rewards = [0 for _ in range(num_days+1)], [0 for _ in range(num_days+1)]

for i in range(num_days):
    daily_work, daily_reward = map(int, input().split())
    work_times[i] = daily_work
    rewards[i] = daily_reward

dp = [0 for _ in range(num_days+1)]

for i in range(len(work_times)-2, -1, -1):  
    if work_times[i] + i <= num_days: 
        dp[i] = max(rewards[i] + dp[i + work_times[i]], dp[i+1])   
    else: 
        dp[i] = dp[i+1]

print(dp[0])