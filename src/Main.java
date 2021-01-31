import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        doTaskOne();
        doTaskTwo();
        doTaskThree();
        doTaskFour();
        doTaskFive();
        System.out.println(doTaskSix(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(doTaskSix(new int[]{1, 1, 1, 2, 1}));
        doTaskSeven(new int[]{1, 2, 3}, 1);
        doTaskSeven(new int[]{3, 5, 6, 1}, -2);
    }

    /*    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
        [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    static void doTaskOne() {
        System.out.print("Задание №1\n");

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */
    static void doTaskTwo() {
        System.out.print("\nЗадание №2\n");

        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(array[i] + " ");
        }
    }

    /*    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        и числа меньшие 6 умножить на 2;
    */
    static void doTaskThree() {
        System.out.print("\nЗадание №3\n");

        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
    }
    /*    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    */
    static void doTaskFour() {
        System.out.print("\nЗадание №4\n");

        int array[][] = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i == array.length - j - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*    5. ** Задать одномерный массив и найти в нем
        минимальный и максимальный элементы (без помощи интернета);
    */
    static void doTaskFive() {
        System.out.print("\nЗадание №5\n");

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
        }
        System.out.println("\nМаксимальное значение массива: " + max);
        System.out.println("Минимальное значение массива: " + min);
    }

    /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
        вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.
    */
    static boolean doTaskSix(int[] array) {
        System.out.print("\nЗадание №6\n");
        int sum = 0;
        int lSum = 0;
        int rSum;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int i = 0;
        while (lSum < sum / 2) {
            lSum += array[i];
            i++;
        }
        rSum = sum - lSum;
        return (lSum == rSum);
    }

    /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2
        (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    */
    static void doTaskSeven(int[] array, int n) {
        System.out.print("\nЗадание №7\n");

        System.out.println(Arrays.toString(array));

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }
        } else {
            for (int i = 0; i < n * (-1); i++) {
                int temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}