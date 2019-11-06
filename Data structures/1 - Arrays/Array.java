package Arrays;

public class Array {

    private int[] array;
    private int count;

    public Array (int length) {
        this.array = new int [length];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void Insert(int value) {
        // Checking if the arrays is full. If true, we double his size
        if(array.length == count) {
            int[] new_array = new int[this.count*2];

            for(int i = 0; i < this.array.length; i++) {
                new_array[i] = this.array[i];
            }

            this.array = new_array;
         }

        array[count++] = value;
    }

    public void removeAt(int index) {
        // Validating index
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // Shifting the items
        for(int i = index; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    public int indexOf(int value) {
        for(int  i = 0; i < count; i++) {
            if(this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }
}
