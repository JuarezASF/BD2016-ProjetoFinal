import com.jrefinery.chart.ChartFactory;
import com.jrefinery.chart.JFreeChart;
import com.jrefinery.data.CategoryDataset;
import com.jrefinery.data.DefaultCategoryDataset;
import com.jrefinery.data.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by juarez on 28/11/16.
 */
public class Histogram {
    private JPanel panel;
    private JLabel imageLabel;
    private JComboBox selectedOption;

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
        panel = new JPanel(new BorderLayout());

        selectedOption.addItem("Operation 1");
        selectedOption.addItem("Operation 2");


        selectedOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selected = selectedOption.getSelectedIndex();

                String[] seriesNames = new String[]{"2001", "2002"};
                String[] categoryNames = new String[]{"First Quater",
                        "Second Quater"};
                Number[][] categoryData = new Integer[][]{{new Integer(20),
                        new Integer(35)},
                        {new Integer(40),
                                new Integer(60)}
                };
                switch (selected) {
                    case 0:
                        categoryData = new Integer[][]{{new Integer(20),
                                new Integer(35)},
                                {new Integer(40),
                                        new Integer(60)}
                        };

                        break;
                    case 1:
                        categoryData = new Integer[][]{{new Integer(35),
                                new Integer(20)},
                                {new Integer(60),
                                        new Integer(40)}
                        };
                        break;
                    default:
                        break;
                }
                CategoryDataset categoryDataset = new DefaultCategoryDataset(seriesNames,
                        categoryNames,
                        categoryData);

                JFreeChart chart = ChartFactory.createVerticalBarChart3D
                        ("Sample Category Chart", // Title
                                "Quarters", // X-Axis label
                                "Sales", // Y-Axis label
                                categoryDataset, // Dataset
                                true // Show legend
                        );
                BufferedImage image = chart.createBufferedImage(500, 300);

                imageLabel.setIcon(new ImageIcon(image));

            }
        });
        selectedOption.setSelectedIndex(0);

        panel.add(selectedOption, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

    }


    private void createUIComponents() {
    }

}
