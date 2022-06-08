package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }
    private int getParentIndex(int index){
        return (index - 1) / 2;
    }
    private int getFirstChildIndex(int index){
        return 2 * index + 1;
    }
    private int getSecondChildIndex(int index){
        return 2 * index + 2;
    }
    private boolean checkIndex(int index){
        return index < values.size();
    }
    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        //TODO zie oefening 3
        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        //TODO : oefening 4
        int index = values.size() - 1;
        int parentIndex = getParentIndex(index);
        while (values.get(parentIndex).compareTo(values.get(index)) > 0){
            switchValues(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    private void switchValues(int index1, int index2) {
        E tmp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, tmp);
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        // TODO zie oefening 5
        int index = 0;
        int firstChildIndex = getFirstChildIndex(index);
        int secondChildIndex = getSecondChildIndex(index);

            while (checkIndex(firstChildIndex) && (values.get(index).compareTo(values.get(firstChildIndex)) > 0)
                    || checkIndex(secondChildIndex) && values.get(index).compareTo(values.get(secondChildIndex)) > 0){
                if (!checkIndex(secondChildIndex)){
                    switchValues(index, firstChildIndex);
                    break;
                }
                else{
                    int childIndex = values.get(firstChildIndex).compareTo(values.get(secondChildIndex)) < 0 ? firstChildIndex: secondChildIndex;
                    switchValues(index, childIndex);
                    index = childIndex;
                    firstChildIndex = getFirstChildIndex(index);
                    secondChildIndex = getSecondChildIndex(index);
                }
            }
    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        return null;
    }
}