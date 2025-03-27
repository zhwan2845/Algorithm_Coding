a = []
for i in range(9):
    e = input()
    e = int(e)
    a.append(e)

max = -1
cnt = 0
for i in range(9):
    if a[i] > max:
        max = a[i]
        cnt = i + 1

print(max)
print(cnt)