package sorting;

// Java класс, демонстрирующий различные методы сортировки
public class SortingDemo {
    // Метод для печати массива
    static void printArray(int array[]) {
        int n = array.length; // Получаем длину массива
        for (int i = 0; i < n; ++i) // Проходим по всем элементам массива
            System.out.print(array[i] + " "); // Печатаем каждый элемент с пробелом
        System.out.println(); // Печатаем новую строку после вывода массива
    }

    // Главный метод
    public static void main(String args[]) {
        System.out.println(); // Печатаем пустую строку для разделения
        System.out.println("* Демонстрация сортировки массива *"); // Заголовок
        System.out.println(); // Печатаем пустую строку

        // Объявляем массив экземпляров методов сортировки
        SortingMethod sortingMethods[] = {
                new InsertionSort(), // Сортировка вставками
                new SelectionSort(), // Сортировка выбором
                new BubbleSort(), // Сортировка пузырьком
                new MergeSort(), // Сортировка слиянием
                new HeapSort(), // Сортировка кучей
                new BogoSort(), // Сортировка Бого-сорт
                new QuickSort(), // Быстрая сортировка
                new CountingSort(), // Сортировка подсчетом
                new ShellSort(), // Сортировка Шелла
                new TimSort(), // TimSort
                new RadixSort(), // Radix Sort
                new BucketSort(), // Bucket Sort
                new FlashSort(), // Flash Sort
                new BinaryTreeSort(), // Binary Tree Sort
                new CombSort() // Comb Sort
        };

        // Демонстрируем работу методов
        for (int i = 0; i < sortingMethods.length; i++) {
            System.out.println(sortingMethods[i].getClass().toString()); // Выводим название текущего метода сортировки

            // Объявляем исходный массив
            int array[] = {9, 8, 10, 3, 4}; // Начальный массив для сортировки

            // Показываем исходный массив
            System.out.print("Исходный массив: ");
            printArray(array); // Вызываем метод для печати массива

            // Храним время начала сортировки
            double startTime = System.nanoTime(); // Сохраняем текущее время в наносекундах

            // Сортируем массив и показываем его новое состояние
            sortingMethods[i].sort(array); // Вызываем метод сортировки

            // Измеряем время выполнения метода
            double endTime = System.nanoTime(); // Получаем текущее время после сортировки
            double duration = (endTime - startTime) / 1000000; // Вычисляем длительность в миллисекундах

            // Печатаем отсортированный массив
            System.out.print("Результирующий массив: ");
            printArray(array); // Вызываем метод для печати отсортированного массива

            // Выводим время выполнения
            System.out.println("Время выполнения, мс: " + duration); // Печатаем время выполнения
            System.out.println(); // Печатаем пустую строку для разделения выводов
        }
    }
}