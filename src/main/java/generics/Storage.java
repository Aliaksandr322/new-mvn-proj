package generics;

public class Storage <T>{

    private T[] data;
    private int pos = 0;
    private int size = 0;

    public Storage() {
        this.data = (T[]) new Object[100];
    }

    public void add(T val){

        data[pos++] = val;
        size++;

    }
    public T get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }
}
