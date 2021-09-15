public class demo {
    public static int abs(int x){
        if(x < 0) return -x;
        else return x;
    }
    public static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i = 2; i * i <= x; ++i){
            if(x % i ==0) return false;
        }
        return true;
    }
    public static double abs(double x){
        if(x < 0.0) return -x;
        else return x;
    }
    public static void main(String[] args){
        int x = Integer.parseInt(args[0]);
        System.out.println(abs(x));
    }
}