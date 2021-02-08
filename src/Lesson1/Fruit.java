package Lesson1;

public abstract class Fruit implements Weightable{
    protected float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
