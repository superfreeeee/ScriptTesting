nums = list(map(int, input().split(' ')))
reach = int(input()) + 30
count = 0
for num in nums:
    if num <= reach:
        count += 1
print(count)