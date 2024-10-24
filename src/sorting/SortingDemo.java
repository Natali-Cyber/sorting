
package sorting;

class SortingDemo {
    // Метод для печати массива
    static void printArray(int array[]) {
        int n = array.length; // Получаем длину массива
        for (int i = 0; i < n; ++i) // Проходим по всем элементам массива
            System.out.print(array[i] + " "); // Печатаем каждый элемент с пробелом
        System.out.println(); // Печатаем новую строку после вывода массива
    }
}