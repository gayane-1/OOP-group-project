package ui;

import core.Converter;
import measures.*;
import measures.IllegalDateException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterWindow extends JFrame implements ActionListener
{
    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1500;
    private static final int MENU_BAR_HEIGHT = 50;
    private static final int MENU_BAR_WIDTH = 50;
    private static final int MENU_ITEM_HEIGHT = 30;
    private static final int MENU_ITEM_WIDTH = 250;
    private static final int TEXT_FIELD_WIDTH = 150;
    private static final int TEXT_FIELD_HEIGHT = 30;
    private static final int TEXT_AREA_FONT_SIZE = 16;
    private static final int BUTTON_WIDTH = 82;
    private static final int BUTTON_HEIGHT = 82;

    private ImageIcon titleImage = new ImageIcon("src/gfx/TitleImage.jpg");
    private ImageIcon backButtonIcon = new ImageIcon("src/gfx/back.jpg");

    private JPanel inputPanel;
    private JPanel outputPanel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JLabel[] inputLabel;
    private JLabel outputLabel;
    private JTextField[] inputTextField;
    private JTextField outputTextField;
    private JMenuItem[] menuItems;
    private JButton backButton;

    public ConverterWindow()
    {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("Converter");
        setIconImage(titleImage.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        menuBar.setBackground(new Color(60, 128, 94));
        menuBar.setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(menuBar, BorderLayout.NORTH);

        menu = new JMenu("Convert");
        menu.setFont(new Font("Noto Mono", Font.BOLD, 25));
        menu.setForeground(Color.BLACK);
        menu.setFocusable(false);
        menuItems = new JMenuItem[10];

        for(int i = 0; i < menuItems.length; i++)
        {
            menuItems[i] = new JMenuItem();
            menuItems[i].setFocusPainted(false);
            menuItems[i].setForeground(Color.BLACK);
            menuItems[i].setPreferredSize(new Dimension(MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT));
            menuItems[i].setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
            menuItems[i].setBackground(new Color(106, 106, 116));
            menuItems[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            menuItems[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            menuItems[i].setFont(new Font("Noto Mono", Font.BOLD, 14));
            menu.add(menuItems[i]);
        }
        menuItems[0].setText("Angle to Decimal Degrees");
        menuItems[1].setText("Decimal Degrees to Angle");
        menuItems[2].setText("Date of Easter");
        menuItems[3].setText("Civil Date to Day Numbers");
        menuItems[4].setText("Is a Leap Year");
        menuItems[5].setText("Civil Time to Decimal Hours");
        menuItems[6].setText("Decimal Hours to Civil Time");
        menuItems[7].setText("Civil Date to Julian Date");
        menuItems[8].setText("LCT to UT");
        menuItems[9].setText("LST to GST");
        menuBar.add(menu);

        inputTextField = new JTextField[10];
        for(int i = 0; i < inputTextField.length; i++)
        {
            inputTextField[i] = new JTextField();
            inputTextField[i].setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
            inputTextField[i].setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
            inputTextField[i].setText(" 0 ");
            inputTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
            inputTextField[i].setBackground(new Color(60, 128, 94));
            inputTextField[i].setForeground(Color.BLACK);
            inputTextField[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }

        outputTextField = new JTextField();
        outputTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        outputTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        outputTextField.setText("  ");
        outputTextField.setEditable(false);
        outputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        outputTextField.setBackground(new Color(60, 128, 94));
        outputTextField.setForeground(Color.BLACK);
        outputTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputLabel = new JLabel[10];
        for(int i = 0; i < inputLabel.length; i++)
        {
            inputLabel[i] = new JLabel();
            inputLabel[i].setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
            inputLabel[i].setForeground(new Color(238, 226, 222));
            inputLabel[i].setPreferredSize(new Dimension(400, 80));
            inputLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            inputLabel[i].setVerticalAlignment(SwingConstants.TOP);
            inputLabel[i].setLayout(new BorderLayout());
           // inputLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            inputLabel[i].add(inputTextField[i], BorderLayout.SOUTH);
            inputLabel[i].setVisible(false);
        }

        inputLabel[0].setText("Degrees");
        inputLabel[1].setText("Minutes");
        inputLabel[2].setText("Seconds");
        inputLabel[3].setText("Hours");
        inputLabel[4].setText("Day");
        inputLabel[5].setText("Month");
        inputLabel[6].setText("Year");
        inputLabel[7].setText("Daylight Saving");
        inputLabel[8].setText("Zone Correction");
        inputLabel[9].setText("Geographical Longitude");

        backButton = new JButton();
        backButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setIcon(backButtonIcon);
        backButton.setContentAreaFilled(false);

        outputLabel = new JLabel();
        outputLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        outputLabel.setForeground(new Color(238, 226, 222));
        outputLabel.setPreferredSize(new Dimension(400, 80));
        outputLabel.setText("Output");
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outputLabel.setVerticalAlignment(SwingConstants.TOP);
        outputLabel.setLayout(new BorderLayout());
        outputLabel.add(outputTextField, BorderLayout.SOUTH);


        inputPanel = new JPanel();
        inputPanel.setBackground(new Color(60, 128, 94));
        inputPanel.setLayout(new GridLayout(6,1));
        for(JLabel label : inputLabel)
            inputPanel.add(label);
        add(inputPanel);

        outputPanel = new JPanel();
        outputPanel.setBackground(new Color(60, 128, 94));
        outputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        outputPanel.add(backButton);
        outputPanel.add(outputLabel);
        add(outputPanel, BorderLayout.SOUTH);


        setVisible(true);

        for(JMenuItem item : menuItems)
            item.addActionListener(this);

        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < menuItems.length; i++)
            if(e.getSource() == menuItems[i])
            {
                checkInput(menuItems[i]);
            }

        if(e.getSource() == backButton)
        {
            FirstWindow firstWindow = new FirstWindow();
            dispose();
        }

    }

    private void checkInput(JMenuItem item)
    {

        if(item.getText().equals(menuItems[0].getText()))
        {
            inputLabel[0].setVisible(true);
            inputLabel[1].setVisible(true);
            inputLabel[2].setVisible(true);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(false);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[0], inputTextField[1], inputTextField[2]))
                outputTextField.setText(Double.toString(Converter.angleToDecimalDegrees(Double.parseDouble(inputTextField[0].getText()),
                                Double.parseDouble(inputTextField[1].getText()), Double.parseDouble(inputTextField[2].getText()))));
            else
                outputTextField.setText("Invalid Input");

        }
        if(item.getText().equals(menuItems[1].getText()))
        {
            inputLabel[0].setVisible(true);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(false);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[0]))
            {
                Angle angle = Converter.decimalDegreesToAngle(Double.parseDouble(inputTextField[0].getText().trim()));
                outputTextField.setText(angle.toString());
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[2].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(true);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[6]))
            {
                try
                {
                    CivilDate date = Converter.getDateOfEaster(Integer.parseInt(inputTextField[6].getText().trim()));
                    outputTextField.setText(date.toString());
                }
                catch(IllegalDateException e)
                {
                    outputTextField.setText("Invalid Input");
                }
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[3].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(true);
            inputLabel[5].setVisible(true);
            inputLabel[6].setVisible(true);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[4], inputTextField[5], inputTextField[6]))
            {
                try
                {
                    CivilDate date = new CivilDate(Integer.parseInt(inputTextField[4].getText().trim()),
                            Integer.parseInt(inputTextField[5].getText().trim()), Integer.parseInt(inputTextField[6].getText().trim()));

                    outputTextField.setText(Integer.toString(Converter.civilDateToDayNumber(date)));
                }catch (IllegalDateException e)
                {
                    outputTextField.setText("Invalid Input");
                }
            }
            else
                outputTextField.setText("Invalid Input");

        }
        if(item.getText().equals(menuItems[4].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(true);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[6]))
            {
                try
                {
                    outputTextField.setText(Boolean.toString(Converter.isLeapYear(Integer.parseInt(inputTextField[6].getText().trim()))));
                }catch (IllegalDateException e)
                {
                    outputTextField.setText("Invalid Input");
                }
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[5].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(true);
            inputLabel[2].setVisible(true);
            inputLabel[3].setVisible(true);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(false);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[1],inputTextField[2],inputTextField[3]))
                    outputTextField.setText(Double.toString(Converter.civilTimeToDecimalHours(Double.parseDouble(inputTextField[3].getText().trim()),
                            Double.parseDouble(inputTextField[2].getText().trim()),Double.parseDouble(inputTextField[3].getText().trim()))));
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[6].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(true);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(false);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[3]))
            {

                Time time = Converter.decimalHoursToCivilTime(Double.parseDouble(inputTextField[3].getText().trim()));
                outputTextField.setText(time.toString());
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[7].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(false);
            inputLabel[2].setVisible(false);
            inputLabel[3].setVisible(false);
            inputLabel[4].setVisible(true);
            inputLabel[5].setVisible(true);
            inputLabel[6].setVisible(true);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[4], inputTextField[5], inputTextField[6]))
            {

                try
                {
                    CivilDate date = new CivilDate(Integer.parseInt(inputTextField[4].getText().trim()),
                            Integer.parseInt(inputTextField[5].getText().trim()), Integer.parseInt(inputTextField[6].getText().trim()));
                    outputTextField.setText(Double.toString(Converter.civilDateToJulianDate(date)));
                }catch (IllegalDateException e)
                {
                    outputTextField.setText("Invalid Input");
                }
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[8].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(true);
            inputLabel[2].setVisible(true);
            inputLabel[3].setVisible(true);
            inputLabel[4].setVisible(true);
            inputLabel[5].setVisible(true);
            inputLabel[6].setVisible(true);
            inputLabel[7].setVisible(true);
            inputLabel[8].setVisible(true);
            inputLabel[9].setVisible(false);

            if(checkItems(inputTextField[1],inputTextField[2],inputTextField[3],inputTextField[4],
                    inputTextField[5],inputTextField[6],inputTextField[7],inputTextField[8]))
            {
                try
                {
                    DateTime dateTime = Converter.localCivilTimeToUniversalTime(Double.parseDouble(inputTextField[3].getText().trim()),
                            Double.parseDouble(inputTextField[1].getText().trim()), Double.parseDouble(inputTextField[2].getText().trim()),
                            true,Integer.parseInt(inputTextField[8].getText().trim()),
                            Double.parseDouble(inputTextField[4].getText().trim()), Integer.parseInt(inputTextField[5].getText().trim()), Integer.parseInt(inputTextField[6].getText().trim()));
                    outputTextField.setText(dateTime.toString());

                }catch (IllegalDateException e)
                {
                    outputTextField.setText("Invalid Input");
                }
            }
            else
                outputTextField.setText("Invalid Input");
        }
        if(item.getText().equals(menuItems[9].getText()))
        {
            inputLabel[0].setVisible(false);
            inputLabel[1].setVisible(true);
            inputLabel[2].setVisible(true);
            inputLabel[3].setVisible(true);
            inputLabel[4].setVisible(false);
            inputLabel[5].setVisible(false);
            inputLabel[6].setVisible(false);
            inputLabel[7].setVisible(false);
            inputLabel[8].setVisible(false);
            inputLabel[9].setVisible(true);

            if(checkItems(inputTextField[1],inputTextField[2],inputTextField[3],inputTextField[9]))
            {
                    Time time = Converter.localSiderealTimeToGreenwichSiderealTime(Double.parseDouble(inputTextField[3].getText()),
                            Double.parseDouble(inputTextField[1].getText()), Double.parseDouble(inputTextField[2].getText()), Double.parseDouble(inputTextField[9].getText()));
                    outputTextField.setText(time.toString());
            }else
                outputTextField.setText("Invalid Input");

        }
    }

    private boolean checkItems(JTextField... textFields)
    {
            for(int j = 0; j < textFields.length; j++)
            {
                String input = textFields[j].getText().trim();
                for(int k = 0; k < input.length(); k++)
                {
                    if(input.charAt(k) != '-' && input.charAt(k) != '.' && !Character.isDigit(input.charAt(k)))
                    {
                        return false;
                    }
                }
            }

        return true;
    }
}
