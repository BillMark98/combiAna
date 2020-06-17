// import java.lang.*;
public class CayleyPolya {
    public static void main(String[] args) {
        int N = 20;
        boolean outPut = true;
        cayleyPolya(N, outPut);
    }

    public static void cayleyPolya(int N,boolean outPut) {
        int [] Hn = new int[N+1];
        int [] helpHn = new int [N+1];  // helpHn[j] = \sum_{m|j}H_m \cdot m
        double [] ratio = new double[N+1]; // ratio[i] = Hn[i] / Hn[i-1]
        Hn[1] = 1;
        for (int i = 1; i <= N; i++) {
            helpHn[i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp += Hn[i-j] * helpHn[j];
            }
            Hn[i] = temp / (i-1);
            // update helpHn
            for (int index = i; index <= N; index += i) {
                helpHn[index] += Hn[i] * i;
            }
            ratio[i] = (double) Hn[i] / Hn[i-1];
        }
        if (outPut) {
            for (int i = 0; i <= N; i++) {
                System.out.printf("%10d",i);
            }
            System.out.println();
            for (int val : Hn) {
                System.out.printf("%10d",val);
            }
            System.out.println();
            for (double val : ratio)
                System.out.printf("%10.5f",val);
            System.out.println();
        }
    }
}