package com.krong.structure.linear;

public class ArrayList<E> implements List<E>{

    private static final int DEFAULT_CAPACITY = 10;       // 최소(기본) 용적 크기
    private static final Object[] EMPTY_ELEMENTDATA = {}; // 빈 비열

    Object[] elementData;                                 // 요소들이 담기는 용기
    private int size;                                     // 실질적인 요소들의 수


    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    @SafeVarargs
    public ArrayList(E ...values) {
        int length = values.length;
        this.elementData = new Object[length];
        for (E value : values) {
            this.elementData[this.size++] = value;
        }
    }

    @Override
    public boolean add(E value) {
        return false;
    }

    @Override
    public void add(int index, E value) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) > -1;
    }

    @Override
    public int indexOf(Object value) {
        return indexOfRange(value, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if(o == null) {
            for(int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for(int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }
}
