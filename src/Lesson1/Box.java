package Lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <T extends Weightable>  implements Weightable{

    private ArrayList<T> storage;


    public Box(){
       storage = new ArrayList<T>();
    }

    public int getNumberElement(){
        return storage.size();
    }
    public void addToBoxElement(T elem){
        storage.add(elem);
    }

    public void putInBox (Box<T> simpleBox){
        storage.addAll(simpleBox.storage);
        simpleBox.storage.clear();

    }

    public boolean compare(Box o) {
        return Math.abs(this.getWeight()-o.getWeight())<0.000001;
    }

    @Override
    public float getWeight() {
        if (storage.size()==0){
            return 0.0f;
        }
        float weight=0.0f;
        for (int i = 0; i < storage.size(); i++) {
            weight+=storage.get(i).getWeight();
        }
       return weight;
    }
}
