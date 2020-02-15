def count(name):
    sum = 1
    nums = []
    for c in name:
        temp = ord(c) - ord('A') + 1
        sum *= temp
        nums.append(temp)
    return sum % 47

a = input()
b = input()
if count(a) == count(b):
    print("GO")
else:
    print('STAY')