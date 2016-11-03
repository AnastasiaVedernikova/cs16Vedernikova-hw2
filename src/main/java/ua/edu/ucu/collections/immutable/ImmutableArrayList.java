package ua.edu.ucu.collections.immutable;
import java.util.Arrays;


public class ImmutableArrayList implements ImmutableList{
    private Object[] myArray;
    private int actSize = 0;
    private ImmutableArrayList(Object[] arr) {
        myArray = arr;
    }

    public ImmutableArrayList() {
        myArray = new Object[1];
    }
    @Override
    public String toString(){
        return Arrays.toString(myArray);
    }

    public Object get(int index) {
        if (index < actSize) {
            return myArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public ImmutableList add(Object obj) {
        if (myArray.length - actSize < 1) {
            increaseListSize();
        }
        myArray[actSize++] = obj;
        return new ImmutableArrayList(myArray);
    }

    public ImmutableList remove(int index) {
        if (index < actSize) {
            Object obj = myArray[index];
            myArray[index] = null;
            int tmp = index;
            while (tmp < actSize-1) {

                myArray[tmp] = myArray[tmp + 1];
                tmp++;
            }
            myArray[tmp] = null;
            actSize--;
            decreaseListSize();
            return new ImmutableArrayList(myArray);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public int size() {
        return actSize;
    }
    private void decreaseListSize(){
        myArray = Arrays.copyOf(myArray,myArray.length-1);
    }

    private void increaseListSize() {
        myArray = Arrays.copyOf(myArray, myArray.length+1);



    }//implementing interfaces
    public ImmutableList add(int index, Object e){
        if (index>=0 && index <= size()){
            increaseListSize();
            for (int i=size()-1;i>=index;i--){
                myArray[i+1]=myArray[i];
            }
            myArray[index]= e;
            actSize+=1;
        }else{
            throw new IndexOutOfBoundsException();
        }
        return new ImmutableArrayList(myArray);
    }
    public  ImmutableList addAll(Object[] c){
        for (Object i: c){
            this.add(i);
        }
        return new ImmutableArrayList(myArray);
    }
    public ImmutableList addAll(int index, Object[] c){
        if (index>=0 && index<=size()){
            for (int i=0; i<c.length;i++){
                increaseListSize();
            }
            Object[]arr1 = new Object[actSize-index];
            int am = actSize - index;

            for(int i=index;i<=actSize;i++){
                System.arraycopy(myArray,index,arr1,0,am);
            }
            for (int i=index;i<c.length+index;i++){
                myArray[i] = c[i-index];
                actSize+=1;
            }
            for (int i = index+c.length;i<actSize;i++){
                myArray[i] = arr1[i-(index+c.length)];
            }

        }else{
            throw new IndexOutOfBoundsException();
        }
        return new ImmutableArrayList(myArray);
    }
    public ImmutableList set(int index, Object e){
        if (index>=0 && index<actSize){
            myArray[index] = e;
        }else{
            throw new IndexOutOfBoundsException();
        }
        return new ImmutableArrayList(myArray);
    }
    public int indexOf(Object e){
        int ind = 0;
        for(Object i:myArray){
            if (i.equals(e)){
                return ind;
            }ind += 1;
        }
        return -1;
    }
    public ImmutableList clear(){
        myArray = new Object[0];
        actSize = 0;
        return new ImmutableArrayList(myArray);
    }
    public boolean isEmpty(){
        return  (actSize == 0);
    }
    public Object[] toArray(){
        Object[] arr1 = new Object[actSize];
        System.arraycopy(myArray,0,arr1,0,actSize);
        return arr1;
    }
}

