count1 = []
for one in range(101):
    for two in range(51):
        for five in range(21):
            if one*0.01 + two*0.02 + five*0.05 == 1:
                count1.append((one, two, five))

count2 = []
for five in range(21):
    for two in range(51):
        one = 100 - 5*five - 2*two
        if one > 0:
            count2.append((one, two, five))

for i in count1:
    if i in count2:
        count2.remove(i)

for i in count2:
    print(i)