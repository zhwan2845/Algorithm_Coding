def binary_search(li, start, end, target):
    if start > end:
        return None
    mid = (start + end) // 2
    if li[mid] < target:
        return binary_search(li, mid + 1, end, target)
    elif li[mid] > target:
        return binary_search(li, start, mid - 1, target)
    else:
        return mid

n = int(input())
n_list = input().split()
for idx in range(len(n_list)):
    n_list[idx] = int(n_list[idx])
n_list = sorted(n_list) # 정렬시키기

m = int(input())
m_list = input().split()
for idx in range(len(m_list)):
    m_list[idx] = int(m_list[idx])

for m_elem in m_list:
    idx = binary_search(n_list, 0, len(n_list) - 1, m_elem)
    if idx != None:
        print(1)
    else:
        print(0)