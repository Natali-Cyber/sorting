package sorting;

// Java класс, реализующий сортировку слиянием (Merge Sort)
public class MergeSort implements SortingMethod { // Класс MergeSort реализует интерфейс SortingMethod

    // Метод объединяет два подмассива массива[].
    // Первый — от leftIndex до midIndex
    // Второй — от midIndex + 1 до rightIndex
    void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        // Находим размеры подмассивов
        int leftLength = midIndex - leftIndex + 1; // Длина левого подмассива
        int rightLength = rightIndex - midIndex; // Длина правого подмассива

        // Создаем временные массивы
        int[] leftArray = new int[leftLength]; // Временный массив для левой части
        int[] rightArray = new int[rightLength]; // Временный массив для правой части

        // Копируем данные во временные массивы для обработки
        for (int i = 0; i < leftLength; ++i) // Копируем левый подмассив
            leftArray[i] = array[leftIndex + i];
        for (int j = 0; j < rightLength; ++j) // Копируем правый подмассив
            rightArray[j] = array[midIndex + 1 + j];

        // Объединяем временные массивы
        // Начальные индексы первого и второго подмассивов
        int i = 0, j = 0; // Индексы для левого (i) и правого (j) подмассивов
        // Начальный индекс для основного массива
        int k = leftIndex; // Индекс для основного массива

        // Проходим по массивам, выбирая элементы в порядке
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]; // Если элемент в левом массиве меньше или равен правому, добавляем его в основной массив
                i++; // Увеличиваем индекс для левого подмассива
            } else {
                array[k] = rightArray[j]; // Иначе добавляем элемент из правого массива
                j++; // Увеличиваем индекс для правого подмассива
            }
            k++; // Увеличиваем индекс для основного массива
        }

        // Копируем оставшиеся элементы из leftArray и rightArray
        while (i < leftLength) {
            array[k] = leftArray[i]; // Копируем оставшиеся элементы левого подмассива
            i++; // Увеличиваем индекс для левого подмассива
            k++; // Увеличиваем индекс для основного массива
        }
        while (j < rightLength) {
            array[k] = rightArray[j]; // Копируем оставшиеся элементы правого подмассива
            j++; // Увеличиваем индекс для правого подмассива
            k++; // Увеличиваем индекс для основного массива
        }
    }
    // Сортирует массив[leftIndex..rightIndex] с использованием merge()
    public void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) { // Проверяем, что подмассив содержит больше одного элемента
            // Находим средний индекс
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2; // Избегаем переполнения
            // Сортируем первый и второй подмассивы
            mergeSort(array, leftIndex, midIndex); // Сортируем левую часть
            mergeSort(array, midIndex + 1, rightIndex); // Сортируем правую часть
            // Объединяем отсортированные подмассивы
            merge(array, leftIndex, midIndex, rightIndex); // Объединяем отсортированные подмассивы
        }
    }
    // Входная точка сортировки
    public void sort(int[] array) { // Реализация метода сортировки из интерфейса SortingMethod
        mergeSort(array, 0, array.length - 1); // Запускаем сортировку слиянием для всего массива
    }
}