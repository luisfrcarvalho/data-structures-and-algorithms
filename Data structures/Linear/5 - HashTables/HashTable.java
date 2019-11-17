package HashTables;

import java.util.LinkedList;

// Implementing a HashTable using the Chaining approach
public class HashTable {

    private class Entry {
        private String key;
        private int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable() {
        this.entries = new LinkedList[20];
    }

    public void put(String key, int value) {
        var index = hashFunction(key);

        if(this.entries[index] == null)
            this.entries[index] = new LinkedList<>();

        // checking if the key already exists
        for(var entry : this.entries[index]) {
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        // else
        this.entries[index].addLast(new Entry(key, value));
    }

    public int get(String key) {
        var index = hashFunction(key);

        if(this.entries[index] != null){
            var bucket = this.entries[index];
            for(var entry : bucket) {
                if(entry.key == key) {
                    return entry.value;
                }
            }
        }

        return -1;
    }

    public void remove(String key) {
        var index = hashFunction(key);

        if(this.entries[index] == null) {
            throw new IllegalStateException();
        }

        var bucket = this.entries[index];
        for(var entry : bucket) {
            if(entry.key == key) {
                bucket.remove(entry);
            }
        }
    }

    private int hashFunction(String key) {
        return getKeyValue(key) % entries.length;
    }

    private int getKeyValue(String key) {
        int value = 0;
        for(char ch : key.toCharArray()) {
            value += ch;
        }
        return value;
    }

}

