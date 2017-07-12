package cnvcallvisualizer;

import java.util.Random;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CNVCallVisualizer extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("CNV Call Visualizer");
        NumberAxis xAxis = new NumberAxis(702.00, 706.00, 1);
        NumberAxis yAxis = new NumberAxis(-3, 3, 1);
        ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);
        xAxis.setLabel("Position (Mb) on Chromosome 15");
        yAxis.setLabel("Log R Ratio");
        
       
       

        sc.setTitle("Copy Number Variation Region 704");
        sc.setLegendVisible(false);

        
        

        
        XYChart.Series series1 = new XYChart.Series();

        Random r = new Random();
        double mb1Min = 702.01;
        double mb1Max = 703.99;
        double lr1Min = -0.25;
        double lr1Max = 0.25;
        double lr2Min = -2.5;
        double lr2Max = -2.0;
        double mb2Min = 704.01;
        double mb2Max = 704.29;
        double mb3Min = 704.30;
        double mb3Max = 706.00;

        for (int x = 0; x < 30; x++) {

            double mb1 = mb1Min + (mb1Max - mb1Min) * r.nextDouble();
            double lr1 = lr1Min + (lr1Max - lr1Min) * r.nextDouble();
            double mb3 = mb3Min + (mb3Max - mb3Min) * r.nextDouble();
            XYChart.Data c = new XYChart.Data(mb1, lr1);

            series1.getData().add(new XYChart.Data(mb1, lr1));

            series1.getData().add(new XYChart.Data(mb3, lr1));
        }

        for (int y = 0; y < 10; y++) {

            double mb2 = mb2Min + (mb2Max - mb2Min) * r.nextDouble();
            double lr2 = lr2Min + (lr2Max - lr2Min) * r.nextDouble();

            series1.getData().add(new XYChart.Data(mb2, lr2));

        }

        sc.getData().addAll(series1);

        for (Object dataPoint : series1.getData()) {

            if (dataPoint.toString().contains("-2")) {

                ((XYChart.Data) dataPoint).getNode().setStyle("-fx-background-color: blue;");

            }

        }

        Scene scene = new Scene(sc, 800, 700);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
