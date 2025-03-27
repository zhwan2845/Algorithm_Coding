a = input().upper()
d = {}
for i in a:
    if i not in d:
        d[i] = 1
    else:
        d[i] += 1

max = -1
max_key = ""

for k in d:
    if d[k] > max:
        max = d[k]
        max_key = k
cnt = 0
for k in d:
    if d[k] == max:
        cnt += 1

if cnt != 1:
    print('?') 
else:
    print(max_key)