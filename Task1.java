/*Пусть дан произвольный список целых чисел, удалить из него четные числа*/
 
import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = rnd.nextInt(-100, 100);
            list1.add(num);
        }
        System.out.printf("Первоначальный список %s\n", list1);
        int i = 0;
        while (i < list1.size()) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
            }
            else {
                i++;
            }
        }
        System.out.printf(" Список после удаления чётных чисел %s", list1);
    }
}
