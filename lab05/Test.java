package lab05;

import java.util.Arrays;

public class Test {
    public  static void main(String[] args) {
        int[] numbers={12, -4, 7, 0, 3, -8};
        System.out.println(Arrays.toString(numbers));
        System.out.println("Другий метод");
        for(int n:numbers){
            System.out.println(n + "");
        }
    }
}
