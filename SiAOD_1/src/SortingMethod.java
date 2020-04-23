import java.util.Arrays;
import java.util.Scanner;

public class SortingMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите порядок матрицы:");
        int n = in.nextInt(); //задаем кол-во строк и столбцов
        int[][] array = new int[n][n]; //объявляем массив
        //генерируем значения для массива
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = (int)(Math.random()*(n+1));
            }
        }
        System.out.println("Сгенерированная матрица:");
        //выводим матрицу в консоль
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        //создаем копию массива для сортировки другим способом
        int[][] array2= array;
        int[][] sortedArray = array;
        long startTime = System.nanoTime();
        //применяем способ сортировки "методом обмена"
        bubbleSort(array, n, n);
        long endTime = System.nanoTime();
        sortedArray = bubbleSort(array, n, n);
        long Time = endTime-startTime;
        //выводим время его выполнения
        System.out.println("   М Е Т О Д   О Б М Е Н А");
        System.out.println("Время выполнения: " + Time + " нс");
        System.out.println("Отсортированная матрица:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(sortedArray[i][j] + " ");
            }
            System.out.println();
        }
        startTime = System.nanoTime();
        //применяем способ сортировки "QuickSort"
        for(int i = 0; i < n; i++){
            QuickSort(array2[i],0,array2[i].length-1);
        }
        endTime = System.nanoTime();
        Time = endTime-startTime;
        //выводим время его выполнения
        System.out.println("   Q U I C K S O R T");
        System.out.println("Время выполнения: " + Time + " нс");
        System.out.println("Отсортированная матрица:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
        startTime = System.nanoTime();
        //применяем встроенный метод сортировки
        for(int i = 0; i < n; i++) {
            Arrays.sort(array[i]);
        }
        endTime = System.nanoTime();
        Time = endTime-startTime;
        //System.out.println(Arrays.deepToString(array));
        System.out.println("   В С Т Р О Е Н Н Ы Й   М Е Т О Д");
        System.out.println("Время выполнения: " + Time + " нс");
        System.out.println("Отсортированная матрица:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] bubbleSort(int[][] arr, int n, int m){
        int temp;
        for(int k = 0; k < n*m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j < m - 1) {
                        if (arr[i][j + 1] < arr[i][j]) {
                            temp = arr[i][j + 1];
                            arr[i][j + 1] = arr[i][j];
                            arr[i][j] = temp;
                        }
                    }
                }
            }
        }
        return arr;
    }
    public static void QuickSort(int[] arr, int low, int high) {
        if (arr.length == 0)
            return;
        if(low >= high)
            return;
        int mid = low + (high - low)/2;
        int opora = arr[mid];
        int i = low, j = high;
        while(i <= j) {
            while (arr[i] < opora)
                i++;
            while (arr[j] > opora)
                j--;
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if(low < j)
            QuickSort(arr,low,j);
        if(high > j)
            QuickSort(arr,i,high);
    }
}
