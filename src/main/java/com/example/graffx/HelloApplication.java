package com.example.graffx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        String inputString = "aaasdfasdfasdfAasdf".toLowerCase(Locale.ROOT);
        Map<Character, Integer> charCounter = new HashMap<>();
        for(int i = 0; i < inputString.length(); i++) {
            Character character = inputString.charAt(i);
            if(charCounter.containsKey(character)) {
                Integer count = charCounter.get(character);
                count = count + 1;
                charCounter.put(character, count);
            } else {
                charCounter.put(character, 1);
            }
        }
        System.out.println(charCounter);

        CategoryAxis x=new CategoryAxis();
        NumberAxis y=new NumberAxis();
        x.setLabel("Years");
        y.setLabel("Income");
        BarChart barchart=new BarChart<>(x,y);

        XYChart.Series series=new XYChart.Series<>();

        series.getData().add(new XYChart.Data<>("2001",5));
        series.getData().add(new XYChart.Data<>("2002",40));
        series.getData().add(new XYChart.Data<>("2003",100));
        series.getData().add(new XYChart.Data<>("2004",10));
        series.getData().add(new XYChart.Data<>("2005",150));
        series.getData().add(new XYChart.Data<>("2006",70));
        series.getData().add(new XYChart.Data<>("2007",79));

        series.setName("ECONOMICS");
        barchart.getData().add(series);
        BorderPane bpane=new BorderPane();
        bpane.setCenter(barchart);

        stage.setTitle("UK");
        Scene scene2=new Scene(bpane,800,500);
        stage.setScene(scene2);
        stage.show();

    }
}