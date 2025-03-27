def hanoi(n, start, end):
    global ret
    if n == 1:
        ret.append((start, end))
        return
    else:
        aux = 6 - start - end
        hanoi(n-1, start, aux)
        ret.append((start, end))
        hanoi(n-1, aux, end)
        return
num = int(input())
ret = []
hanoi(num, 1, 3)
print(len(ret))
for i in range(len(ret)):
    a, b = ret[i]
    print(a, b)