package win.elegentjs.datastructor.hash;

/**
 * 哈希表(采用开放地址法)
 */
public class HashTable {

    // 负载因子（当持有的元素跟数组容量的比率大于等于负载因子时执行扩容）
    private static final float LOAD_FACTOR = 3 / 4;

    private Entry[] entries;

    // 实际存储的元素的个数
    private int count;

    public HashTable(int size) {
        entries = new Entry[size];
    }

    public HashTable() {
        this(10);
    }


    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 往哈希表中新增元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Entry entry = new Entry(key, value);

        int hashIndex = entries.length % key;



        int index;
       for (index = hashIndex; index < entries.length; index ++) {
            if (entries[index] != null && entries[index].key == key) {
                entries[index] = entry;
                return;
            }

            if (entries[index] == null) {
                break;
            }
       }

       entries[index] = entry;
       count ++;
    }


    public int get(int key) {
        int hashIndex = entries.length % key;

        int index;
        for (index = hashIndex; index < entries.length; index ++) {
            if (entries[index] != null && entries[index].key == key) {
                return entries[index].value;
            }
        }

        return -1;
    }



    /**
     * 定义Entry
     */
    private static class Entry {
        // key
        private int key;

        // value 值
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.put(1, 10);
        hashTable.put(1, 15);
        hashTable.put(2, 11);
        hashTable.put(3, 12);

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(3));
    }
}
