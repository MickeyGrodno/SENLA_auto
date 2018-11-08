import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//Написать программу, составляющую всевозможные комбинации 3-х значных чисел из 3-х введенных пользователем цифр. Цифры вводятся вручную.

public class Numbers {
    public static void main(String[] args) {

        String[] arr = new String[3];
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите значение №"+ (i+1));
            arr[i] = sc.nextLine();
        }

        set.add(arr[0]+arr[1]+arr[2]);
        set.add(arr[1]+arr[0]+arr[2]);
        set.add(arr[1]+arr[2]+arr[0]);
        set.add(arr[0]+arr[2]+arr[1]);
        set.add(arr[2]+arr[0]+arr[1]);
        set.add(arr[2]+arr[1]+arr[0]);

        System.out.println("Возможный следующие комбинации:");

        for (Iterator iter = set.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}
