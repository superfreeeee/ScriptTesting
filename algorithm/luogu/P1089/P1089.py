store = 0
rest = 0
for i in range(12):
    spend = int(input())
    if (300 + rest) < spend:
        print(-i-1)
        break
    else:
        rest = 300 + rest - spend
        store += int(rest/100) * 100
        rest = rest%100
else:
    print(int(rest + store*1.2))

