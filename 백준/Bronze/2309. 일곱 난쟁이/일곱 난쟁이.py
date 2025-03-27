a = []
sum = 0

for _ in range(9): # range(0, 10)
    i = int(input())
    a.append(i)
    sum += i

a1 = -1
a2 = -1
for i in range(9): # 가짜 난쟁이 후보 1
    for j in range(9): # 가짜 난쟁이 후보 2
        if sum - a[i] - a[j] == 100:
            a1 = a[i]
            a2 = a[j]
            
a.remove(a1)
a.remove(a2)
a.sort()
for i in a:
    print(i)