package ua.edu.ucu.collections.immutable;
import java.util.Arrays;


public class ImmutableArrayList implements ImmutableList{
    private Object[] myArray;
    private int actSize = 0;
//    private ImmutableArrayList(Object[] arr) {
//        myArray = arr;
//    }

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
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        NewList.myArray[NewList.actSize++] = obj;
        return NewList;
    }

    public ImmutableList remove(int index) {
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        if (index < NewList.actSize) {
            Object obj = NewList.myArray[index];
            NewList.myArray[index] = null;
            int tmp = index;
            while (tmp < NewList.actSize-1) {
                NewList.myArray[tmp] = myArray[tmp + 1];
                tmp++;
            }
            NewList.myArray[tmp] = null;
            NewList.actSize--;
            NewList.decreaseListSize();
            return NewList;
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
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        if (index>=0 && index <= NewList.size()){
            NewList.increaseListSize();
            for (int i=NewList.size()-1;i>=index;i--){
                NewList.myArray[i+1] = NewList.myArray[i];
            }
            NewList.myArray[index]= e;
            NewList.actSize+=1;
        }else{
            throw new IndexOutOfBoundsException();
        }
        return NewList;
    }
    public  ImmutableList addAll(Object[] c) {
        int a = c.length - (myArray.length - actSize);
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        if (a > 0) {
            for (int i = 0; i < a; i++) {
                NewList.increaseListSize();
            }
        }
        for (Object i : c) {
            NewList.myArray[NewList.actSize++] = i;
        }
        return NewList;
        }

    public ImmutableList addAll(int index, Object[] c){
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        if (index>=0 && index <= NewList.size()){
            int a = c.length - (myArray.length - actSize);
            if (a > 0) {
                for (int i = 0; i < a; i++) {
                    NewList.increaseListSize();
                }
            }
            Object[]arr1 = new Object[NewList.actSize-index];
            int am = NewList.actSize - index;

            for(int i = index;  i<= NewList.actSize; i++){
                System.arraycopy(NewList.myArray,index,arr1,0,am);
            }
            for (int i = index ; i<c.length + index; i++){
                NewList.myArray[i] = c[i-index];
                NewList.actSize+=1;
            }
            for (int i = index + c.length; i < NewList.actSize;i++){
                NewList.myArray[i] = arr1[i-(index+c.length)];
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
        return NewList;
    }
    public ImmutableList set(int index, Object e){
        ImmutableArrayList NewList = new ImmutableArrayList();
        NewList.myArray = new Object[myArray.length];
        System.arraycopy(myArray, 0, NewList.myArray, 0, myArray.length);
        NewList.actSize = actSize;
        if (index>=0 && index<NewList.actSize){
            NewList.myArray[index] = e;
        }else{
            throw new IndexOutOfBoundsException();
        }
        return NewList;
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
        return new ImmutableArrayList();
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

