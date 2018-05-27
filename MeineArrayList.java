import java.util.Arrays;

/**
 * @author Till Wischniewski
 *
 * @version 1.0
 * a very simplified version of java.util.ArrayList
 *
 * @param <E>
 */

public class MeineArrayList<E> {
    private E[] list;
    private int size;
    private int capacity;
    private int increment;

    /**
     * constructs a MeineArrayList-Object with initial capacity c
     * and increment inc
     * @param c the initial capacity
     * @param inc the number of positions that will be added
     * when the list is made bigger
     */
    public MeineArrayList(int c, int inc) {
        capacity = c;
        list = (E[]) new Object[c];
        size = 0;
        increment = inc;
    }


    @Override
    public String toString()
    {
        return Arrays.toString(list);
    }

    public void addElement(E newElement){

        if (size == capacity){
            //vergrößere liste und speicher element an neuer position +1
            list=Arrays.copyOf(list, capacity+1);
            capacity++;
        }
        list[size] = newElement;
        size++;
    }

    public E removeElement(int index){
        // position kleiner als 0 oder größer capacity dann out of bounds und return null
        if(index < 0 || index > capacity-1) {
            System.out.println("Index out of bounds! ");
            return null;
        }
        E removedElement = list[index];
        if (index < capacity-1){
            // lösche element bei index, verschiebe hintere elemente nach vorne
            for (int j=index; j < capacity-1; j++){
                list[j] = list[j+1];
            }
        }
        list=Arrays.copyOf(list, capacity-1);
        capacity--;

        if (removedElement != null){
            size--;
        }
        return removedElement;
    }

    public void removeAll() {

        list=Arrays.copyOf(list, 0);
        capacity = 0;
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public static void main(String[] args){

        MeineArrayList mAL = new MeineArrayList(5,1);
        System.out.println(mAL.toString());
        System.out.println(mAL.getSize());
        mAL.addElement("poop");
        mAL.addElement("hallo");
        mAL.addElement("ich");
        //mAL.addElement("du");
        //mAL.addElement("sie");
        //mAL.addElement("wir");
        System.out.println(mAL.toString());
        System.out.println(mAL.getSize());
        mAL.removeElement(4);
        System.out.println(mAL.toString());
        System.out.println(mAL.getSize());

        mAL.removeAll();
        System.out.println(mAL.toString());
        System.out.println(mAL.getSize());
    }

}
