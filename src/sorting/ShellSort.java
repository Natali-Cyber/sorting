package sorting;


class ShellSort implements SortingMethod { // Класс ShellSort реализует интерфейс SortingMethod
    public void sort(int array[]) { // Метод сортировки, принимающий массив
        int n = array.length; // Получаем длину массива

        // Начинаем с максимального интервала (gap), затем уменьшаем его
        for (int gap = n / 2; gap > 0; gap /= 2) { // Выполняем цикл, уменьшая интервал
            // Применяем сортировку вставками к текущему размеру интервала
            for (int i = gap; i < n; i += 1) { // Проходим по массиву с учетом интервала
                int temp = array[i]; // Сохраняем текущий элемент

                // Сдвигаем ранее отсортированные элементы, пока не найдем
                // правильную позицию для a[i]
                int j; // Индекс для сдвига элементов
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) { // Сравниваем элементы с учетом интервала
                    array[j] = array[j - gap]; // Сдвигаем элемент на интервал
                }

                // Помещаем оригинальный a[i], сохраненный в temp, на правильную позицию
                array[j] = temp; // Устанавливаем элемент в отсортированное место
            }
        }
    }
}