import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import jdk.nashorn.internal.parser.JSONParser;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by juarez on 28/11/16.
 */
public class Histogram {
    private JPanel panel;
    private JLabel imageLabel;

    public static void main(String[] args) {

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("BD UnB 2016 Data Visualization");
        frame.setContentPane(new Histogram().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public Histogram() {
        this.panel = new JPanel(new GridLayout(1, 1));
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("JavaWorld", new Integer(75));
        pieDataset.setValue("Other", new Integer(25));

        JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", // Title
                pieDataset// Dataset
        );

        BufferedImage image = chart.createBufferedImage(500, 300);

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(image));

        panel.add(imageLabel);

//        String[] seriesNames = new String[]{"2001", "2002"};
//        String[] categoryNames = new String[]{"First Quater",
//                "Second Quater"};
//        Number[][] categoryData = new Integer[][]{{new Integer(20),
//                new Integer(35)},
//                {new Integer(40),
//                        new Integer(60)}
//        };
//        CategoryDataset categoryDataset = new DefaultCategoryDataset(seriesNames,
//                categoryNames,
//                categoryData);
//
//        JFreeChart chartB = ChartFactory.createVerticalBarChart3D
//                ("Sample Category Chart", // Title
//                        "Quarters", // X-Axis label
//                        "Sales", // Y-Axis label
//                        categoryDataset, // Dataset
//                        true // Show legend
//                );


    }


    private void createUIComponents() {
    }

}
