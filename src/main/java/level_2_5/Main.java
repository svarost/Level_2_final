package level_2_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static final int size = 100_000_000;
    private static float[] arr = new float[size];
    static float sum1 = 0;
    static float sum2 = 0;



    public static void main(String[] args) {
        singleThread(arr);
        multiThreads(arr, 7);


    }

    //Single Thread
    static void singleThread (float[] arr){
        long a  = System.currentTimeMillis();
        calcArr(arr);
        System.out.println(System.currentTimeMillis() - a);
    }



    //MultiThreads
    static void multiThreads(float[] arr, int parts) {
        long a  = System.currentTimeMillis();
        int volume = arr.length / parts;
        int d = arr.length - volume * parts;
        float[][] list = new float[parts - 1][volume];
        float[] last_list = new float[volume + d];
        for (int i = 0; i < parts - 1; i++) {
            System.arraycopy(arr, i * volume, list[i], 0, volume);
        }
        System.arraycopy(arr, volume * (parts - 1), last_list, 0, volume + d);

        for (float[] lst: list) {
            new Thread(() -> {
                calcArr(lst);
            }).start();
        }

        for (int i = 0; i < parts - 1; i++) {
            System.arraycopy(list[i], 0, arr, i * volume, volume);
        }
        System.arraycopy(last_list, 0, arr, volume * (parts - 1), volume + d);
        System.out.println(System.currentTimeMillis() - a);
    }

    static void calcArr(float[] arr) {
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }




}
