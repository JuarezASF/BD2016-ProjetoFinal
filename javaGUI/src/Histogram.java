import com.jrefinery.chart.ChartFactory;
import com.jrefinery.chart.JFreeChart;
import com.jrefinery.data.CategoryDataset;
import com.jrefinery.data.DefaultCategoryDataset;
import com.jrefinery.data.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by juarez on 28/11/16.
 */
public class Histogram {
    private JPanel panel;
    private JLabel imageLabel;
    private JLabel imageLabelB;

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
        this.panel = new JPanel(new GridLayout(1, 2));
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("JavaWorld", new Integer(75));
        pieDataset.setValue("Other", new Integer(25));

        JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart", // Title
                pieDataset,
                true
        );

        BufferedImage image = chart.createBufferedImage(500, 300);

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(image));

        panel.add(imageLabel);

        String[] seriesNames = new String[]{"2001", "2002"};
        String[] categoryNames = new String[]{"First Quater",
                "Second Quater"};
        Number[][] categoryData = new Integer[][]{{new Integer(20),
                new Integer(35)},
                {new Integer(40),
                        new Integer(60)}
        };
        CategoryDataset categoryDataset = new DefaultCategoryDataset(seriesNames,
                categoryNames,
                categoryData);

        JFreeChart chartB = ChartFactory.createVerticalBarChart3D
                ("Sample Category Chart", // Title
                        "Quarters", // X-Axis label
                        "Sales", // Y-Axis label
                        categoryDataset, // Dataset
                        true // Show legend
                );

        BufferedImage imageB = chartB.createBufferedImage(500, 300);

        imageLabelB = new JLabel();
        imageLabelB.setIcon(new ImageIcon(imageB));
        panel.add(imageLabelB);


    }


    private void createUIComponents() {
    }

}
