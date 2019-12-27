from math import ceil

target = int(input())
choices = []
prices = []
for i in range(3):
    nums = list(map(int, input().split(' ')))
    choices.append(nums)
for nums in choices:
    count = ceil(target / nums[0])
    price = count * nums[1]
    prices.append(price)
print(sorted(prices)[0])