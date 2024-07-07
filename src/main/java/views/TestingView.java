package views;

import controllers.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Temporary class to test the functionaly of our model
 * <p>
 *     Will later replace with a javax.Swing
 * </p>
 * */

public class TestingView implements BaseView {
    Controller controller;
    /**
     * Structures a 2d list of data values
     * */
//    private String structuredData(List<Object> values){
//        StringBuilder data = new StringBuilder("Data:\n");
//        for(Object obj : values){
//            data.append(obj).append("\n");
//        }
//        return data.toString();
//    }
    private String structuredData(List<List<Object>> values){
        StringBuilder data = new StringBuilder("Data:\n");
        for(List<Object> row : values){
            data.append(row).append("\n");
        }
        return data.toString();
    }

    @Override
    public void setController(Controller controller) {
        //List
        //ArrayList<T> implements List, ?
        //ArrayList<RowData> data = new ArrayList<>();
        //RowCollection data = new RowCollection();
        //data.unit == "ug" ? ...
        //

        this.controller = controller;
    }

    public void showData(List<List<Object>> values){

        System.out.println(structuredData(values));
    }

//    public void showData(List<Object> data) throws Exception{
//        Object obj = data.get(1);
//        List<Object> dat = Collections.unmodifiableList((List<Object>) obj);
//        System.out.println(structuredData(data));
//    }
}
