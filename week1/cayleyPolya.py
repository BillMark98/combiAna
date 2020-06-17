import numpy as np

def cayleyPolya(N):
    Hn = [None] * (N+1)
    helpHn = [None] * (N+1)
    ratio = [None] * (N+1)
    Hn[1] = 1
    ratio[1] = 1
    for i in range(1,N + 1):
        helpHn[i] = 1
    
    for i in range(2, N + 1):
        temp = 0
        for j in range(1, i):
            temp += Hn[i-j] * helpHn[j]
        Hn[i] = temp//(i - 1)
        for index in range(i, N + 1, i):
            helpHn[index] += Hn[i] * i
        ratio[i] = Hn[i] / Hn[i-1]
    if (N <= 30):
        for i in range(1, N+1):
            print("{0:10d}".format(i),end = "")
        print()
        if (N <= 23):
            for i in range(1, N+1):
                print("{0:10d}".format(Hn[i]),end = "")
            print()
        for i in range(1, N+1):
            print("{0:10.5f}".format(ratio[i]),end = "")
        print()
    # print("HN: ", Hn[N])
    print("ratio: ", Hn[N]/Hn[N-1])
cayleyPolya(10000)