package sorting;


public class QuickSort implements SortingMethod { // Класс QuickSort реализует интерфейс SortingMethod

    // Метод для обмена двух элементов массива
    void swap(int[] array, int i, int j) {
        int temp = array[i]; // Сохраняем элемент с индексом i во временной переменной
        array[i] = array[j]; // Меняем элемент с индексом i на элемент с индексом j
        array[j] = temp; // Устанавливаем временный элемент на позицию j
    }

    /*
      Этот метод выбирает последний элемент как опорный (pivot),
      перемещает опорный элемент на правильную позицию,
      и размещает все меньшие элементы слева,
      а все большие элементы — справа от опорного.
    */
    int partition(int[] array, int left, int right) {
        // Выбираем опорный элемент
        int pivot = array[right]; // Последний элемент — опорный элемент

        // Индекс для правильной позиции опорного элемента
        int i = (left - 1); // Изначально, индекс i равен left - 1

        for (int j = left; j <= right - 1; j++) {
            // Если текущий элемент меньше опорного
            if (array[j] < pivot) {
                // Увеличиваем индекс для правильной позиции
                i++; // Увеличиваем i
                swap(array, i, j); // Обмениваем текущий элемент с элементом на позиции i
            }
        }
        swap(array, i + 1, right); // Перемещаем опорный элемент на его правильную позицию
        return (i + 1); // Возвращаем индекс опорного элемента
    }

    // Метод быстрой сортировки
    void quickSort(int[] array, int left, int right) {
        if (left < right) { // Если левая граница меньше правой
            // Перемещаем опорный элемент на правильную позицию
            int partitioningIndex = partition(array, left, right);

            // Рекурсивно сортируем элементы слева от опорного элемента
            quickSort(array, left, partitioningIndex - 1);
            // Рекурсивно сортируем элементы справа от опорного элемента
            quickSort(array, partitioningIndex + 1, right);
        }
    }

    // Реализация метода сортировки из интерфейса SortingMethod
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1); // Вызываем быструю сортировку для всего массива
    }
}