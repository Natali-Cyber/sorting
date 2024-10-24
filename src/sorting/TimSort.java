package sorting;

import java.util.Arrays;

class TimSort implements SortingMethod {
    private static final int RUN = 32;

    // Метод для слияния двух отсортированных подмассивов
    private void merge(int[] array, int left, int middle, int right) {
        // размеры подмассивов
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // временные массивы
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // копируем данные во временные массивы
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        // объединение временных массивов
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // копируем оставшиеся элементы
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Метод TimSort
    public void sort(int[] array) {
        int n = array.length;

        // сортируем подмассивы размером RUN
        for (int start = 0; start < n; start += RUN) {
            int end = Math.min(start + RUN - 1, n - 1);
            Arrays.sort(array, start, end + 1);
        }

        // сортировка слиянием для объединения отсортированных подмассивов
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int middle = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (middle < right) {
                    merge(array, left, middle, right);
                }
            }
        }
    }
}