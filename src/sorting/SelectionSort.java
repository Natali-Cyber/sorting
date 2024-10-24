
package sorting;

// Java класс, реализующий сортировку выбором
public class SelectionSort implements SortingMethod {
    // Метод сортировки
    public void sort(int[] array){
        int len = array.length; // Получаем длину массива
        // Итерируемся по элементам
        for (int i = 0; i < len - 1; i++) {
            // Ищем наименьший элемент в неотсортированной части
            int i_smallest = i; // Изначально предполагаем, что текущий элемент - наименьший
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[i_smallest]) // Находим наименьший элемент
                    i_smallest = j; // обновляем индекс наименьшего элемента
            }
            /* Меняем местами наименьший элемент с первым элементом
               неотсортированного подмассива */
            int tmp = array[i_smallest]; // Временное хранение наименьшего элемента
            array[i_smallest] = array[i]; // Ставим текущий элемент на место наименьшего
            array[i] = tmp; // Помещаем наименьший элемент на место текущего
        }
    }
}