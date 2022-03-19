package com.bootdo.train;

/**
 * 未加入扩容机制，会导致链表太长 entry.next.next.next.next.next......
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> implements Map<K, V> {

    public HashMap() {
        table = new Entry[16];
    }

    int size = 0;
    private Entry<K, V>[] table = null;


    /**
     * 1.根据key查询index值
     * 2.找到数组中的entry
     * 3.如果entry为空，将当前的K-V加入进来，size++
     * 4.如果entry不为空，则将entry放入Entry构造参数的next
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, index, entry);
        }
        return table[index].getValue();
    }


    /**
     * 1.根据key查询index值
     * 2.找到数组中的entry
     * 3.判断当前对象是否有值，比较 key hash
     * 4.如果相等就直接返回，如果不相等继续next直到在链表上找到
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if (size == 0) {
            return null;
        }
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        }
        return find(k, entry);
    }

    private V find(K k, Entry<K, V> entry) {
        if (entry.getKey() == k || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return find(k, entry.next);
            }
        }
        return null;
    }


    private int hash(K k) {
        int index = k.hashCode() % 16;
        return Math.abs(index);
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}
