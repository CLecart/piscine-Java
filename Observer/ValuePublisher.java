package Observer;

import java.util.ArrayList;
import java.util.List;

public class ValuePublisher {
    private final List<NumericBaseObserver> observers = new ArrayList<>();

    public void updateState(int value) {
        for (NumericBaseObserver o : observers) {
            o.updateState(value);
        }
    }

    public void subscribe(NumericBaseObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(NumericBaseObserver observer) {
        observers.remove(observer);
    }
}