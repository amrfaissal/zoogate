package com.gliesex.zoogate;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class TodoUI extends UI {
    private VerticalLayout layout;

    @Autowired
    TodoList todoList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addActionButton();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        layout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        TextField taskfield = new TextField();
        Button addButton = new Button("Add");
        addButton.addClickListener(evt -> todoList.addComponent(new Label(taskfield.getValue())));

        formLayout.addComponents(taskfield, addButton);
        layout.addComponent(formLayout);
    }

    private void addTodoList() {
        layout.addComponent(todoList);
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete completed");
        layout.addComponent(deleteButton);
    }
}
