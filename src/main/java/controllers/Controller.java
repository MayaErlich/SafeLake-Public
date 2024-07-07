package controllers;

import models.Model;
import views.BaseView;

public class Controller {
    private final Model model;
    private final BaseView view;

    public Controller(Model model, BaseView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void start() {

    }
}
