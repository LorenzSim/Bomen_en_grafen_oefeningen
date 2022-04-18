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
    // extra hulp methodes
    public int getIndexParentOff(int index){
        return index > 0 ? (index - 1) / 2 : -1;
    }
    public int getIndexFirstChildOff(int index){
        int res = index * 2 + 1;
        return index >= 0 && res < values.size() ? res : -1;
    }
    public int getIndexSecondChildOff(int index){
        int res = index * 2 + 2;
        return index >= 0 && res < values.size() ? res : -1;
    }

    public E getParentOf(int index){
        return index > 0 ? values.get(getIndexParentOff(index)) : null;
    }
    private E getFirstChild(int index){
        return index > 0 ? values.get(getIndexFirstChildOff(index)) : null;
    }
    private E getSecondChild(int index){
        return index > 0 ? values.get(getIndexSecondChildOff(index)) : null;
    }
    private void switchItems(int item1, int item2){
        E item = values.get(item1);
        values.set(item1, values.get(item2));
        values.set(item2, item);
    }
    private void switchWithFirstChild(int index){
        switchItems(index, getIndexFirstChildOff(index));
    }
    private void switchWithSecondChild(int index){
        switchItems(index, getIndexSecondChildOff(index));
    }
    private void switchWithParent(int index){
        switchItems(index, getIndexParentOff(index));
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        //TO DO zie oefening 3
        E res = values.get(0);
        for (int i = 1; i < values.size(); i++){
            if (values.get(i).compareTo(res) < 0){
                res = values.get(i);
            }
        }
        return res;
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value); //achteraan toevoegen
        this.bubbleUp(); //bubbleUp vanaf de laatste zie slides theorie
        return true;
    }
    // (i-1)/2
    private void bubbleUp() {
        //TODO : oefening 4
        int itemIndex = values.size() - 1;
        int parentIndex = getIndexParentOff(itemIndex);

        while (parentIndex >= 0 && values.get(itemIndex).compareTo(values.get(parentIndex)) < 0){
            switchItems(itemIndex, parentIndex);
            itemIndex = parentIndex;
            parentIndex = getIndexParentOff(itemIndex);

        }
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin(); // res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        // TODO zie oefening 5
        int indexHuidig = 0;
        int indexEersteKind = getIndexFirstChildOff(0);
        int indexTweedeKind = getIndexSecondChildOff(0);

        if (indexEersteKind != -1){

            E huidig = values.get(0);
            E eersteKind = values.get(indexEersteKind);
            E tweedeKind = values.get(indexTweedeKind);

            while (huidig.compareTo(eersteKind) > 0 || huidig.compareTo(tweedeKind) > 0){

                if (eersteKind.compareTo(tweedeKind) <= 0){
                    switchItems(indexHuidig, indexEersteKind);
                    indexHuidig = indexEersteKind;
                }
                else {
                    switchItems(indexHuidig, indexTweedeKind);
                    indexHuidig = indexTweedeKind;
                }

                indexEersteKind = getIndexFirstChildOff(indexHuidig);
                indexTweedeKind = getIndexSecondChildOff(indexHuidig);

                if (indexEersteKind == -1) break;

                huidig = values.get(indexHuidig);
                eersteKind = values.get(indexEersteKind);
                if (indexTweedeKind != -1)
                tweedeKind = values.get(indexTweedeKind);
            }
        }


    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        if (!values.contains(value)) return null;

        int huidig = 0;
        int eersteKind = getIndexFirstChildOff(huidig);
        int tweedeKind = getIndexSecondChildOff(huidig);
        ArrayList<E> result = new ArrayList<>();


        return null;
    }
}
