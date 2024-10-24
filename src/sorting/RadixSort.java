package sorting;

class RadixSort implements SortingMethod {
    // Метод для получения максимального значения в массиве
    private int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Метод для осуществления сортировки поразрядно
    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Подсчитываем количество вхождений
        for (int value : array) {
            count[(value / exp) % 10]++;
        }

        // Изменяем count[i] так, чтобы count[i] содержал действительное положение
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Строим выходной массив
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Копируем выходной массив в оригинальный массив
        System.arraycopy(output, 0, array, 0, n);
    }

    // Основной метод для осуществления Radix Sort
    public void sort(int[] array) {
        int max = getMax(array);

        // Применяем counting sort поразрядно для каждой цифры
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }
}
