package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString(String s);

    String getNextString();

    List<String> getPrintedElementHistory();

    String toString();

}
