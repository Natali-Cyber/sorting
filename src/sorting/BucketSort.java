package sorting;

import java.util.Arrays;

class BucketSort implements SortingMethod {
    public void sort(int[] array) {
        // Находим максимальное значение для определения ведер
        int maxValue = Arrays.stream(array).max().orElse(0);
        int bucketCount = (maxValue / 10) + 1; // Определяем количество ведер (ширина ведра - 10)
        int[][] buckets = new int[bucketCount][];

        // Инициализация ведер
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new int[0];
        }

        // Разбиваем массив по ведрам
        for (int value : array) {
            int bucketIndex = value / 10;
            buckets[bucketIndex] = append(buckets[bucketIndex], value);
        }

        // Сортируем каждое ведро и объединяем
        int index = 0;
        for (int[] bucket : buckets) {
            Arrays.sort(bucket);
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }

    // Вспомогательный метод для динамического добавления элементов в массив.
    private int[] append(int[] arr, int value) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = value;
        return newArr;
    }
}