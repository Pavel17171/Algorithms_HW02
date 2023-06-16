package org.example;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 1, 5, 6, 2, 4, 6, 2, 23, 31, 5, 12, 53, 47, 34, 21, 82, 60, 0, 2, 5, 5};
        printArray("Исходный массив:", array);
        SortArr(array);
        printArray("Отсортированный массив:", array);
    }

   // Алгоритм пирамидальной сортировки (сортировка кучей).

    /**
     * Сортировка кучей
     * @param arr - исходный массив
     */
    public static void SortArr(int arr[]) {
        int sizeArr = arr.length;

        for (int i = sizeArr / 2 - 1; i >= 0; i--) {
            heapify(arr, sizeArr, i);
        }

        for (int i = sizeArr - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    /**
     * Преобразование в двоичную кучу поддерева с корневым узлом
     * @param arr - куча (массив)
     * @param sizeArr размер кучи
     * @param i - корневой узел
     */
    static void heapify(int arr[], int sizeArr, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < sizeArr && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < sizeArr && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, sizeArr, largest);
        }

    }

    /**
     * Печать элементов массива в строку через пробел
     * @param text текст перед массивом
     * @param arr массив
     */
    static void printArray(String text, int arr[]) {
        System.out.println(text + " ");
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }
}