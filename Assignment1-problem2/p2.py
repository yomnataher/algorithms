import math

def main():
    N = None
    k = None
    cin >> N >> k >> Globals.m_w >> Globals.m_z
    arr = [0 for _ in range(N)]
    i = 0
    while i < N:
        arr[i] = Globals.get_random()
        i += 1
    print(Globals.kthSmallest(arr, 0, N-1, k), end = '')
