package sorting;

import java.util.Random; // Импортируем класс Random для генерации случайных чисел

// Java класс, реализующий сортировку Бого сорт
public class BogoSort implements SortingMethod {

    // Метод сортировки
    public void sort(int[] array) {
        while (!isSorted(array)) { // Пока массив не отсортирован
            shuffle(array); // Перемешиваем элементы массива
        }
    }

    // Метод проверки, отсортирован ли массив
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; // Если текущий элемент больше следующего, массив не отсортирован
            }
        }
        return true; // Если все элементы отсортированы
    }

    // Метод для перемешивания элементов массива
    private void shuffle(int[] array) {
        Random random = new Random(); // Создаем экземпляр генератора случайных чисел
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length); // Генерируем случайный индекс
            // Меняем текущий элемент с элементом на случайном индексе
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}