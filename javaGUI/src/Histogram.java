import com.jrefinery.chart.ChartFactory;
import com.jrefinery.chart.JFreeChart;
import com.jrefinery.data.CategoryDataset;
import com.jrefinery.data.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by juarez on 28/11/16.
 */
public class Histogram implements WindowListener {
    private JPanel panel;
    private JLabel imageLabel;
    private JComboBox selectedOption;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    final String url = "jdbc:postgresql://localhost/testdb";
    final String user = "postgres";
    final String password = "123456";

    public static void main(String[] args) {

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("BD UnB 2016 Data Visualization");
        Histogram histogram = new Histogram();
        frame.setContentPane(histogram.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(histogram);
    }


    public Histogram() {

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to BD!", e);
        }

        panel = new JPanel(new BorderLayout());


        selectedOption = new JComboBox();
        imageLabel = new JLabel();

        selectedOption.addItem("Operation 1");
        selectedOption.addItem("Operation 2");


        selectedOption.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int selected = selectedOption.getSelectedIndex();

                        closeResultSet();
                        closeStatement();

                        String sqlCommand;
                        switch (selected)

                        {
                            case 0:
                                sqlCommand = "select * from xy";
                                break;
                            case 1:
                                sqlCommand = "select * from xy";
                                break;
                            default:
                                sqlCommand = "select * from xy";
                                break;
                        }
                        try {
                            statement = connection.prepareStatement(sqlCommand);
                        } catch (SQLException e1) {
                            throw new RuntimeException("Could not prepare statement!", e1);
                        }
                        try {
                            resultSet = statement.executeQuery();
                        } catch (SQLException e1) {
                            throw new RuntimeException("Could not executeQuery!", e1);
                        }

                        java.util.List<String> keys = new ArrayList<>();
                        java.util.List<Integer> counts = new ArrayList<>();

                        try {
                            while (resultSet.next())

                            {
                                keys.add(resultSet.getString(1));
                                counts.add(resultSet.getInt(2));
                            }
                        } catch (SQLException e1) {
                            throw new RuntimeException("Could read bd answer!", e1);
                        }

                        String keyArray[] = new String[keys.size()];
                        Integer countArray[] = new Integer[keys.size()];

                        for (int i = 0; i < keys.size(); i++) {
                            keyArray[i] = keys.get(i);
                            countArray[i] = counts.get(i);
                        }

                        String[] seriesNames = new String[]{"2002"};
                        Number[][] categoryData;
                        categoryData = new Integer[][]{countArray};

                        CategoryDataset categoryDataset =
                                new DefaultCategoryDataset(seriesNames, keyArray, categoryData);

                        JFreeChart chart = ChartFactory.createVerticalBarChart3D
                                ("Sample Category Chart", // Title
                                        "Quarters", // X-Axis label
                                        "Sales", // Y-Axis label
                                        categoryDataset, // Dataset
                                        true // Show legend
                                );
                        BufferedImage image = chart.createBufferedImage(500, 300);

                        imageLabel.setIcon(new

                                ImageIcon(image)

                        );

                    }
                }

        );
        selectedOption.setSelectedIndex(0);

        panel.add(selectedOption, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

    }

    private void closeStatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e1) {
                throw new RuntimeException("Could not close statement!");
            }
        }
    }

    private void closeResultSet() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e1) {
                throw new RuntimeException("Could not close result set!");
            }
        }
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e1) {
                throw new RuntimeException("Could not close result set!");
            }
        }
    }


    private void createUIComponents() {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Histogram.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
