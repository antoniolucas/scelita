package util;

import java.util.Observable;

/**
 *
 * @author Lucas
 */
public class MyObservable extends Observable{

    @Override
    public void setChanged(){
        super.setChanged();
    }

    @Override
    public void clearChanged(){
        super.clearChanged();
    }
}
