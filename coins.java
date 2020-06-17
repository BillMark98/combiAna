public class helloWorld {
    public static void main(String[] args) {
        StdOut.println("Hello world");
        int N = 101;
        int[][] coins = new int[4][N];
        calcuCombi(coins,1,5,10,25);

    }
    public static void resetArr(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = 0;
        }
    }

    public static void findMaxCombi(int[][] coins, int N) {
        int max = 0;
        int m1M = -1,m2M = -1,m3M = -1,m4M = -1;
        for (int m1 = 1; m1 <= N; m1++) {
            setArr(coins[0],m1);
            for (int m2 = m1; m2 <= N; m2++) {
                polyaSetArr(coins[1],coins[0],m2);
                for (int m3 = m2; m3 <= N; m3++) {
                    polyaSetArr(coins[2],coins[1],m3);
                    for (int m4 = m3; m4 <= N; m4++) {
                        polyaSetArr(coins[3],coins[2],m4);
                        if (coins[3][N] > max) {
                            max = coins[3][N];
                            m1M = m1;
                            m2M = m2;
                            m3M = m3;
                            m4M = m4;
                        }
                        resetArr(coins[3]);
                    }
                    resetArr(coins[2]);
                }
                resetArr(coins[1]);
            }
            resetArr(coins[0]);
        }
        System.out.printf("The maximized combi: %5d, %5d, %5d, %5d total count: %5d\n", m1M,m2M,m3M,m4M,max);
    }
    public static void setArr(int[] list, int step) {
        for (int i = 0; i < list.length; i+= step) {
            list[i] = 1;
        }
    }
    public static void polyaSetArr(int [] toSetList, int [] refList, int step) {
        for (int i = 0; i < step; i++) {
            toSetList[i] = refList[i];
        }
        for (int i = step; i < toSetList.length; i++) {
            toSetList[i] = toSetList[i-step] + refList[i];
        }
    }
    public static void calcuCombi(int[][] coins, int m1, int m2, int m3, int m4) {
        setArr(coins[0],m1);
        int [] arr = {m1,m2,m3,m4};
        for (int i = 1; i < coins.length; i++) {
            polyaSetArr(coins[i],coins[i-1],arr[i]);
        }
        for (int i = 0; i < coins[0].length; i++) {
            System.out.printf("%5d",i);
        }
        System.out.println();
        for (int i = 0; i < coins.length; i++) {
            for (int val : coins[i]) {
                System.out.printf("%5d",val);
            }
            System.out.println();
        }
    }
}
