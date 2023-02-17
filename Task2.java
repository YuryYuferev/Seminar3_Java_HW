/* Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифм. из этого списка*/

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = rnd.nextInt(-100, 100);
            list1.add(num);
        }
        System.out.printf("Первоначальный список %s\n", list1);
        
        int maxItem = list1.get(0);
        int minItem = list1.get(0);
        int sumItems = 0;
        for (int item : list1) {
            if (item > maxItem) {
                maxItem = item;
            }
            if (item < minItem) {
                minItem = item;
            }
            sumItems += item;
        }
        float average = (float)sumItems/list1.size();
        
        System.out.printf("Максимальный элемент %s\n", maxItem);
        System.out.printf("Минимальный элемент %s\n", minItem);
        System.out.printf("Среднее арифметическое %s\n", average);
    }
}
