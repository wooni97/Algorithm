
T = int(input())


for _ in range(T) :
    max_profit = 0

    days = int(input())
    rate = list(map(int, input().split()))

    max_rate = rate[-1]
    for i in range(days-2, -1, -1) :
        if rate[i] > max_rate :
            max_rate = rate[i]
        elif rate[i] < max_rate :
            max_profit += max_rate - rate[i]
    print(max_profit)