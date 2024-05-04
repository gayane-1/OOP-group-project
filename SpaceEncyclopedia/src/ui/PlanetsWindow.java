package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.*;
import measures.CivilDate;
import measures.IllegalDateException;

public class PlanetsWindow extends JFrame implements ActionListener
{
    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1400;
    private static final int MENUBAR_WIDTH = 100;
    private static final int MENUBAR_HEIGHT = 100;
    private static final int TEXT_AREA_FONT_SIZE = 13;
    private static final int TEXT_AREA_WIDTH = 500;
    private static final int TEXT_AREA_HEIGHT = 500;
    private static final int INFO_AREA_WIDTH = 500;
    private static final int INFO_AREA_HEIGHT = 1000;
    private static final int NUMBER_OF_PLANETS = 8;
    private static final int TEXT_FIELD_WIDTH = 150;
    private static final int TEXT_FIELD_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 82;
    private static final int BUTTON_HEIGHT = 82;

    private ImageIcon titleImage = new ImageIcon("src/gfx/TitleImage.jpg");
    private ImageIcon nextButtonIcon = new ImageIcon("src/gfx/next.jpg");
    private ImageIcon backButtonIcon = new ImageIcon("src/gfx/back.jpg");
    private ImageIcon planetParametersImage = new ImageIcon("src/gfx/Orbit.png");

    private JPanel calculationsPanel;
    private JPanel statisticsPanel;
    private JMenuBar menuBar;
    private JMenuItem[] planets;
    private JTextArea statisticsArea;
    private JTextArea infoArea;
    private JTextField[] calculationsTextField;
    private JTextField inputDateTextField;
    private JTextField inputWeightTextField;
    private JTextField inputPlanetTextField;
    private JButton nextButton;
    private JButton[] backButton;
    private JLabel buttonLabel;
    private JLabel planetImageLabel;
    private JLabel inputDateLabel;
    private JLabel inputWeightLabel;
    private JLabel inputPlanetLabel;
    private JLabel[] calculationsLabel;
    private Planet planet;

    public PlanetsWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Planets");
        setIconImage(titleImage.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(MENUBAR_WIDTH, MENUBAR_HEIGHT));
        menuBar.setLayout(new GridLayout(3, 2));
        setJMenuBar(menuBar);

        planets = new JMenuItem[NUMBER_OF_PLANETS];
        for (int i = 0; i < NUMBER_OF_PLANETS; i++)
        {
            planets[i] = new JMenuItem();
            planets[i].setFocusPainted(false);
            planets[i].setForeground(Color.BLACK);
            planets[i].setPreferredSize(new Dimension(50, 50));
            planets[i].setBackground(new Color(106, 106, 116));
            planets[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            planets[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            planets[i].setFont(new Font("Noto Mono", Font.BOLD, 10));
            planets[i].setText(Planet.values()[i].toString());
            menuBar.add(planets[i]);
        }
        statisticsArea = new JTextArea();
        statisticsArea.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        statisticsArea.setPreferredSize(new Dimension(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT));
        statisticsArea.setEditable(false);
        statisticsArea.setBackground(Color.GRAY);
        statisticsArea.setForeground(Color.BLACK);

        infoArea = new JTextArea();
        infoArea.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        infoArea.setPreferredSize(new Dimension(INFO_AREA_WIDTH, INFO_AREA_HEIGHT));
        infoArea.setLineWrap(true);
        infoArea.setEditable(false);
        infoArea.setBackground(Color.GRAY);
        infoArea.setForeground(Color.BLACK);
        infoArea.setText(Planet.info());

        planetImageLabel = new JLabel();
        planetImageLabel.setPreferredSize(new Dimension(400, 400));
        planetImageLabel.setBackground(Color.GRAY);
        planetImageLabel.setIcon(planetParametersImage);

        nextButton = new JButton();
        nextButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        nextButton.setFocusable(false);
        nextButton.setBorder(null);
        nextButton.setIcon(nextButtonIcon);
        nextButton.setContentAreaFilled(false);

        backButton = new JButton[2];

        for (int i = 0; i < backButton.length; i++)
        {
            backButton[i] = new JButton();
            backButton[i].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            backButton[i].setFocusable(false);
            backButton[i].setBorder(null);
            backButton[i].setIcon(backButtonIcon);
            backButton[i].setContentAreaFilled(false);
        }

        buttonLabel = new JLabel();
        buttonLabel.setPreferredSize(new Dimension(300, 100));
        buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonLabel.setVerticalAlignment(SwingConstants.TOP);
        buttonLabel.setLayout(new FlowLayout());
        buttonLabel.add(backButton[0]);
        buttonLabel.add(nextButton);

        statisticsPanel = new JPanel();
        statisticsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        statisticsPanel.setBackground(Color.GRAY);
        statisticsPanel.setLayout(new BorderLayout());
        statisticsPanel.add(statisticsArea, BorderLayout.WEST);
        statisticsPanel.add(buttonLabel, BorderLayout.SOUTH);
        statisticsPanel.add(infoArea, BorderLayout.EAST);
        statisticsPanel.add(planetImageLabel, BorderLayout.CENTER);
        statisticsPanel.setVisible(true);
        add(statisticsPanel);

        inputDateTextField = new JTextField();
        inputDateTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputDateTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        inputDateTextField.setText("/ / /");
        inputDateTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputDateTextField.setBackground(Color.GRAY);
        inputDateTextField.setForeground(Color.BLACK);
        inputDateTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputWeightTextField = new JTextField();
        inputWeightTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputWeightTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        inputWeightTextField.setText("Enter the weight here");
        inputWeightTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputWeightTextField.setBackground(Color.GRAY);
        inputWeightTextField.setForeground(Color.BLACK);
        inputWeightTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputPlanetTextField = new JTextField();
        inputPlanetTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputPlanetTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        inputPlanetTextField.setText("Planet Name");
        inputPlanetTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputPlanetTextField.setBackground(Color.GRAY);
        inputPlanetTextField.setForeground(Color.BLACK);
        inputPlanetTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputDateLabel = new JLabel();
        inputDateLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputDateLabel.setForeground(new Color(238, 226, 222));
        inputDateLabel.setPreferredSize(new Dimension(300, 50));
        inputDateLabel.setText("Input Date");
        inputDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputDateLabel.setVerticalAlignment(SwingConstants.TOP);
        inputDateLabel.setLayout(new BorderLayout());
        inputDateLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputDateLabel.add(inputDateTextField, BorderLayout.SOUTH);

        inputWeightLabel = new JLabel();
        inputWeightLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputWeightLabel.setForeground(new Color(238, 226, 222));
        inputWeightLabel.setPreferredSize(new Dimension(300, 50));
        inputWeightLabel.setText("Input Weight");
        inputWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputWeightLabel.setVerticalAlignment(SwingConstants.TOP);
        inputWeightLabel.setLayout(new BorderLayout());
        inputWeightLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputWeightLabel.add(inputWeightTextField, BorderLayout.SOUTH);

        inputPlanetLabel = new JLabel();
        inputPlanetLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputPlanetLabel.setForeground(new Color(238, 226, 222));
        inputPlanetLabel.setPreferredSize(new Dimension(300, 50));
        inputPlanetLabel.setText("Input Planet Name");
        inputPlanetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPlanetLabel.setVerticalAlignment(SwingConstants.TOP);
        inputPlanetLabel.setLayout(new BorderLayout());
        inputPlanetLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputPlanetLabel.add(inputPlanetTextField, BorderLayout.SOUTH);


        calculationsPanel = new JPanel();
        calculationsPanel.setBackground(Color.GRAY);
        calculationsPanel.setLayout(new GridLayout(4, 3));
        calculationsPanel.add(inputDateLabel);
        calculationsPanel.add(inputWeightLabel);
        calculationsPanel.add(inputPlanetLabel);
        calculationsPanel.setVisible(false);

        calculationsLabel = new JLabel[10];
        calculationsTextField = new JTextField[10];
        for (int i = 0; i < calculationsTextField.length; i++)
        {
            calculationsLabel[i] = new JLabel();
            calculationsLabel[i].setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
            calculationsLabel[i].setForeground(new Color(238, 226, 222));
            calculationsLabel[i].setPreferredSize(new Dimension(300, 50));
            calculationsLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            calculationsLabel[i].setVerticalAlignment(SwingConstants.TOP);
            calculationsLabel[i].setLayout(new BorderLayout());
            calculationsLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            calculationsTextField[i] = new JTextField();
            calculationsTextField[i].setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
            calculationsTextField[i].setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
            calculationsTextField[i].setEditable(false);
            calculationsTextField[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            calculationsTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
            calculationsTextField[i].setBackground(Color.GRAY);
            calculationsTextField[i].setForeground(Color.BLACK);
            calculationsLabel[i].add(calculationsTextField[i], BorderLayout.SOUTH);
            calculationsPanel.add(calculationsLabel[i]);
        }

        calculationsLabel[0].setText("Days From Now ");
        calculationsLabel[1].setText("Mean Anomaly ");
        calculationsLabel[2].setText("Heliocentric Longitude ");
        calculationsLabel[3].setText("Ratio to Earths Orbit ");
        calculationsLabel[4].setText("Coordinates of The Planet ");
        calculationsLabel[5].setText("Distance of The Planet From Earth ");
        calculationsLabel[6].setText("Surface Gravity of The Planet ");
        calculationsLabel[7].setText("Weight ");
        calculationsLabel[8].setText("Distance Comparison From Sun ");
        calculationsLabel[9].setText("Mass Ratio of 2 Planets ");
        calculationsPanel.add(backButton[1]);

        for (int i = 0; i < NUMBER_OF_PLANETS; i++)
        {
            planets[i].addActionListener(this);
        }

        nextButton.addActionListener(this);
        backButton[0].addActionListener(this);
        backButton[1].addActionListener(this);
        setVisible(true);

    }

    private void checkInput(JMenuItem planetMenuItem)
    {
        CivilDate date;
        Planet planet = Planet.valueOf(planetMenuItem.getText());
        double weight = 0;
        String name = inputPlanetTextField.getText().toUpperCase();
        name = name.trim();
        String[] dateString = new String[3];
        boolean isCorrectDateInput = true;
        boolean isCorrectWeightInput = true;
        boolean isCorrectPlanetName = true;

        if (inputDateTextField.getText().isEmpty())
            isCorrectDateInput = false;

        for (int i = 0; i < inputDateTextField.getText().length(); i++)
        {
            if (isCorrectDateInput)
                dateString = inputDateTextField.getText().split("/");
        }
        if (inputWeightTextField.getText().isEmpty())
            isCorrectWeightInput = false;

        int count = 0;
        for (int i = 0; i < inputWeightTextField.getText().length(); i++)
        {

            if (inputWeightTextField.getText().charAt(i) == '.')
            {
                count++;
            }
            if (count > 1)
            {
                isCorrectWeightInput = false;
                calculationsTextField[7].setText("Invalid Weight");
                break;
            }

            if (!Character.isDigit(inputWeightTextField.getText().charAt(i)) && inputWeightTextField.getText().charAt(i) != '.')
            {
                isCorrectWeightInput = false;
                calculationsTextField[7].setText("Invalid Weight");
                break;
            }
        }
        if (isCorrectWeightInput)
        {
            weight = Double.parseDouble(inputWeightTextField.getText());
            if (weight < 0)
            {
                calculationsTextField[7].setText("Invalid Weight");
            }
            calculationsTextField[7].setText((planet.surfaceWeight(weight)) + " kg");
        }

        if (name.isEmpty())
            isCorrectPlanetName = false;

        if (!name.equals("EARTH") && !name.equals("MARS") && !name.equals("VENUS") && !name.equals("JUPITER") && !name.equals("SATURN")
                && !name.equals("URANUS") && !name.equals("NEPTUNE") && !name.equals("MERCURY"))
        {
            isCorrectPlanetName = false;
            calculationsTextField[8].setText("No Planet Name Found");
            calculationsTextField[9].setText("No Planet Name Found");
        }
        if (isCorrectPlanetName)
        {
            calculationsLabel[9].setText("Mass Ratio of " + planet + " and " + name + " is");
            calculationsTextField[8].setText(planet.compareDistanceFromSun(Planet.valueOf(name)));
            calculationsTextField[9].setText(Double.toString(planet.massRatio(Planet.valueOf(name))));
        }
        if (isCorrectDateInput)
        {
            for (int i = 0; i < dateString.length; i++)
            {
                if (dateString[i].isEmpty())
                {
                    isCorrectDateInput = false;
                    break;
                }
                dateString[i] = dateString[i].trim();
                for (int c = 0; c < dateString[i].length(); c++)
                {
                    if (!Character.isDigit(dateString[i].charAt(c)))
                    {
                        isCorrectDateInput = false;
                        for (int k = 0; k < 6; k++)
                            calculationsTextField[k].setText("Wrong Date, Please Try Again!");
                        break;
                    }

                }
            }
        }


        if (isCorrectDateInput)
        {
            try
            {
                date = new CivilDate(Integer.parseInt(dateString[0]), Integer.parseInt(dateString[1]),
                        Integer.parseInt(dateString[2]));
                calculationsTextField[0].setText(Double.toString(planet.calculateDaysFromNow(date)));
                calculationsTextField[1].setText(Double.toString(planet.meanAnomaly(date)));
                calculationsTextField[2].setText(Double.toString(planet.heliocentricLongitude(date)));
                calculationsTextField[3].setText(Double.toString(planet.ratioToEarthsOrbit(date)));
                calculationsTextField[4].setText(Double.toString(planet.calculateCoordinatesOfPlanet(date)));
                calculationsTextField[5].setText(Double.toString(planet.distanceOfThePlanetFromEarth(date)));
                calculationsTextField[6].setText(Double.toString(planet.surfaceGravity()));
            } catch (IllegalDateException e)
            {
                for (JTextField field : calculationsTextField)
                    field.setText("Wrong Date, Please Try Again!");
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < NUMBER_OF_PLANETS; i++)
        {
            if (e.getSource() == planets[i] && statisticsPanel.isVisible())
            {
                planet = Planet.valueOf(planets[i].getText());
                statisticsArea.setText(planet.displayStats());
            }
            if (e.getSource() == nextButton)
            {
                statisticsPanel.setVisible(false);
                add(calculationsPanel);
                calculationsPanel.setVisible(true);
            }
            if (e.getSource() == planets[i] && calculationsPanel.isVisible())
            {
                checkInput(planets[i]);
            }
            if (e.getSource() == backButton[0] && statisticsPanel.isVisible())
            {
                statisticsPanel.setVisible(false);
                FirstWindow firstWindow = new FirstWindow();
                dispose();
            }
            if (e.getSource() == backButton[1] && calculationsPanel.isVisible())
            {
                calculationsPanel.setVisible(false);
                statisticsPanel.setVisible(true);
            }

        }
    }
}
