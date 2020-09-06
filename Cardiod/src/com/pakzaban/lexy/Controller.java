
package com.pakzaban.lexy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.ArrayList;

public class Controller {
    private int num;
    public Slider slider1;
    public Slider slider2;
    public Label numLabel;
    public Label numLabel2;
    public Pane graphPane;
    private double origin = 300.0;
    private int multiplier = 2;

    public void draw(){
        graphPane.getChildren().clear();
        double radius = 250;
        double theta = (Math.PI * 2)/num;
        ArrayList<Circle> circleList = new ArrayList<>();
        for (int i = 0; i < num; i++){
            double x = origin + (Math.cos(theta * i) * radius);
            double y = origin + (Math.sin(theta * i) * radius);
            Circle c = new Circle(x,y,3, Color.rgb(255,198,107));
            graphPane.getChildren().add(c);
            circleList.add(c); }
        for (int i = 0; i < circleList.size() - 1; i++){
            double startX = circleList.get(i).getCenterX();
            double startY = circleList.get(i).getCenterY();
            double endX = circleList.get((i*multiplier) % num).getCenterX();
            double endY = circleList.get((i*multiplier) % num).getCenterY();
            Line l = new Line(startX,startY,endX,endY);
            l.setStroke(Color.WHITE);
            graphPane.getChildren().add(l); } }

    public void setSlider(){
        slider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newNumber) {
                numLabel.setText(String.valueOf(newNumber.intValue()));
                num = newNumber.intValue();
                draw(); }}); }

    public void setSlider2(){
        slider2.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newNumber) {
                numLabel2.setText(String.valueOf(newNumber.intValue()));
                multiplier = newNumber.intValue();
                draw(); }}); }

    public String colorize(){
        String colorString = "cyan,blue,hotpink,salmon,magenta,mediumpurple,limegreen,lightskyblue,turquoise";
        String[] colorArray = colorString.split(",");
        int randomIndex = (int)(Math.random()*colorArray.length);
        return colorArray[randomIndex]; }}



        