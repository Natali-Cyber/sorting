package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(); // Печатаем пустую строку для разделения
        System.out.println("* Демонстрация сортировки массива *"); // Заголовок
        System.out.println(); // Печатаем пустую строку

        // Объявляем массив экземпляров методов сортировки
        SortingMethod[] sortingMethods = {
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

        // Создаем массив для хранения времени выполнения
        double[] durations = new double[sortingMethods.length];

        // Демонстрируем работу методов
        for (int i = 0; i < sortingMethods.length; i++) {
            System.out.println(sortingMethods[i].getClass().toString()); // Выводим название текущего метода сортировки
            int[] array = {9, 8, 10, 3, 4}; // Начальный массив для сортировки

            // Показываем исходный массив
            System.out.print("Исходный массив: ");
            SortingDemo.printArray(array); // Вызываем метод для печати массива

            // Храним время начала сортировки
            double startTime = System.nanoTime(); // Сохраняем текущее время в наносекундах

            // Сортируем массив и показываем его новое состояние
            sortingMethods[i].sort(array); // Вызываем метод сортировки

            // Измеряем время выполнения метода
            double endTime = System.nanoTime(); // Получаем текущее время после сортировки
            double duration = (endTime - startTime) / 1000000; // Вычисляем длительность в миллисекундах

            // Сохраняем время выполнения
            durations[i] = duration;

            // Печатаем отсортированный массив
            System.out.print("Результирующий массив: ");
            SortingDemo.printArray(array); // Вызываем метод для печати отсортированного массива

            // Выводим время выполнения
            System.out.println("Время выполнения, мс: " + duration); // Печатаем время выполнения
            System.out.println(); // Печатаем пустую строку для разделения выводов
        }

        // Создаем массив индексов и сортируем по времени выполнения
        Integer[] indices = new Integer[sortingMethods.length];
        for (int i = 0; i < sortingMethods.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingDouble(i -> durations[i]));

        // Выводим отсортированные методы по времени выполнения
        System.out.println("Методы сортировки, отсортированные по времени выполнения:");
        for (int index : indices) {
            System.out.println(sortingMethods[index].getClass().getSimpleName() + " - " + durations[index] + " ms");
        }
    }
}