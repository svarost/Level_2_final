package level_2_5;

public class SingleMode {
    static final int size = 10_000_000;
    private static float[] arr = new float[size];

    public static void main(String[] args) {
        doArray(arr);
    }


    public static void doArray (float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a  = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

}
