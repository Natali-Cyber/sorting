package sorting;


class CombSort implements SortingMethod {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    // Простой обмен
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13; // уменьшить коэффициент
        return (gap < 1) ? 1 : gap;
    }
}