#a = map(int, input().split()) # "1 16 16".split() -> ["1", "16", "16"]
a = input().split() # "1 16 16".split() -> ["1", "16", "16"]
e = int(a[0])
s = int(a[1])
m = int(a[2])

E = 1
S = 1
M = 1

for year in range(1, 15 * 28 * 19 + 1):
    if e == E and s == S and m == M:
        print(year)
        break 
    
    E += 1
    S += 1
    M += 1

    if E > 15:
        E = 1
    if S > 28:
        S = 1
    if M > 19:
        M = 1