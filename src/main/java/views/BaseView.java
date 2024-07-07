package views;

import controllers.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface BaseView {
    void setController(Controller controller);
    void showData(List<List<Object>> data);

}
