package org.example.dz_obj_summary.storage_task2;

import java.util.Arrays;
import java.util.Objects;

public class Storage <T>{
    private T[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public Storage(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T item) {
        if (size == items.length) {
            throw new IndexOutOfBoundsException("Превышена емкость хранилища. Увеличьте емкость или удалите лишний " +
                    "элемент");
        }
        items[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы диапазона: " + index);
        }
        return items[index];
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage<?> storage = (Storage<?>) o;
        return size == storage.size && Arrays.equals(items, storage.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }
}
