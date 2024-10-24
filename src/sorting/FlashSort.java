package sorting;

class FlashSort implements SortingMethod {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        if (n == 0) return;

        // Найти максимальное и минимальное значение
        int max = array[0], min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        if (min == max) return;  // Все элементы равны

        // Инициализация корзин
        int[] buckets = new int[n];
        double range = max - min;

        // Если диапазон значений очень мал, можно использовать фиксированное количество корзин
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((array[i] - min) * (n - 1) / range);
            // Убедимся, что индекс корзины не выходит за пределы
            if (bucketIndex >= n)
                bucketIndex = n - 1;
            buckets[bucketIndex]++;
        }

        // Определяем начальные позиции корзин
        for (int i = 1; i < n; i++) {
            buckets[i] += buckets[i - 1];
        }

        // Сортировка массива
        int[] result = new int[n];
        int[] temp = array.clone();
        for (int i = 0; i < n; i++) {
            // Проверяем индекс корзины, чтобы избежать выхода за пределы
            int bucketIdx = (int) ((temp[i] - min) * (n - 1) / range);
            if (bucketIdx >= n) bucketIdx = n - 1;

            while (buckets[bucketIdx] > 0) {
                result[buckets[bucketIdx] - 1] = temp[i];
                buckets[bucketIdx]--;
                temp[i] = Integer.MAX_VALUE; // Используем метку, чтобы избежать многократного учета
            }
        }

        System.arraycopy(result, 0, array, 0, n);
    }
}
