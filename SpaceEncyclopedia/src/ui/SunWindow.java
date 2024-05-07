package ui;

import measures.CivilDate;
import measures.IllegalDateException;
import core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SunWindow extends JFrame implements ActionListener
{
    private static final int WIDTH = 1500;
    private static final int HEIGHT = 1000;
    private static final int MENU_BAR_WIDTH = 50;
    private static final int MENU_BAR_HEIGHT = 50;
    private static final int MENU_ITEM_HEIGHT = 30;
    private static final int MENU_ITEM_WIDTH = 250;
    private static final int TEXT_AREA_FONT_SIZE = 16;
    private static final int TEXT_FIELD_WIDTH = 150;
    private static final int TEXT_FIELD_HEIGHT = 30;
    private static final int BUTTON_WIDTH = 82;
    private static final int BUTTON_HEIGHT = 82;

    private ImageIcon titleImage = new ImageIcon("src/gfx/TitleImage.jpg");
    private ImageIcon backButtonIcon = new ImageIcon("src/gfx/back.jpg");

    private FirstWindow firstWindow;
    private JLabel inputDateLabel;
    private JLabel inputLongLabel;
    private JLabel inputLatLabel;
    private JLabel outputLabel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem[] menuItems;
    private JTextField inputDateTextField;
    private JTextField[] inputTextField;
    private JTextField outputTextField;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JButton backButton;

    public SunWindow()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Sun");
        setIconImage(titleImage.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        menuBar.setBackground(new Color(22, 32, 66));
        menuBar.setBorder(BorderFactory.createEmptyBorder(-1, -1, -1, -1));
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(menuBar, BorderLayout.NORTH);

        menu = new JMenu("Calculate");
        menu.setFont(new Font("Noto Mono", Font.BOLD, 25));
        menu.setForeground(Color.BLACK);
        menu.setFocusable(false);

        menuItems = new JMenuItem[5];

        for (int i = 0; i < menuItems.length; i++)
        {
            menuItems[i] = new JMenuItem();
            menuItems[i].setFocusPainted(false);
            menuItems[i].setForeground(Color.BLACK);
            menuItems[i].setPreferredSize(new Dimension(MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT));
            menuItems[i].setBorder(BorderFactory.createEmptyBorder(-1, -1, -1, -1));
            menuItems[i].setBackground(new Color(106, 106, 116));
            menuItems[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            menuItems[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            menuItems[i].setFont(new Font("Noto Mono", Font.BOLD, 14));
            menu.add(menuItems[i]);
        }

        menuItems[0].setText("Get Azimuth");
        menuItems[1].setText("Sun Rise");
        menuItems[2].setText("Sun Altitude");
        menuItems[3].setText("Sun Right Ascension");
        menuItems[4].setText("Sun Declination");
        menuBar.add(menu);

        inputDateTextField = new JTextField();
        inputDateTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputDateTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        inputDateTextField.setText("/ / /");
        inputDateTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputDateTextField.setBackground(Color.GRAY);
        inputDateTextField.setForeground(Color.BLACK);
        inputDateTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputTextField = new JTextField[2];
        for (int i = 0; i < inputTextField.length; i++)
        {
            inputTextField[i] = new JTextField();
            inputTextField[i].setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
            inputTextField[i].setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
            inputTextField[i].setBackground(Color.GRAY);
            inputTextField[i].setForeground(Color.BLACK);
            inputTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
            inputTextField[i].setForeground(Color.BLACK);
            inputTextField[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }
        inputTextField[0].setText("Longitude");
        inputTextField[1].setText("Latitude");

        backButton = new JButton();
        backButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        backButton.setFocusable(false);
        backButton.setBorder(null);
        backButton.setIcon(backButtonIcon);
        backButton.setContentAreaFilled(false);

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

        outputTextField = new JTextField();
        outputTextField.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        outputTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        outputTextField.setText(" ");
        outputTextField.setEditable(false);
        outputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        outputTextField.setBackground(new Color(106, 106, 116));
        outputTextField.setForeground(Color.BLACK);
        outputTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputLongLabel = new JLabel();
        inputLongLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputLongLabel.setForeground(new Color(238, 226, 222));
        inputLongLabel.setPreferredSize(new Dimension(300, 50));
        inputLongLabel.setText("Input Longitude");
        inputLongLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLongLabel.setVerticalAlignment(SwingConstants.TOP);
        inputLongLabel.setLayout(new BorderLayout());
        inputLongLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputLongLabel.add(inputTextField[0], BorderLayout.SOUTH);

        inputLatLabel = new JLabel();
        inputLatLabel.setFont(new Font("Noto Mono", Font.BOLD, TEXT_AREA_FONT_SIZE));
        inputLatLabel.setForeground(new Color(238, 226, 222));
        inputLatLabel.setPreferredSize(new Dimension(300, 50));
        inputLatLabel.setText("Input Latitude");
        inputLatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLatLabel.setVerticalAlignment(SwingConstants.TOP);
        inputLatLabel.setLayout(new BorderLayout());
        inputLatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inputLatLabel.add(inputTextField[1], BorderLayout.SOUTH);

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
        inputPanel.setBackground(new Color(22, 32, 66));
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputDateLabel);
        inputPanel.add(inputLongLabel);
        inputPanel.add(inputLatLabel);
        add(inputPanel, BorderLayout.CENTER);

        outputPanel = new JPanel();
        outputPanel.setBackground(new Color(22, 32, 66));
        outputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        outputPanel.add(backButton);
        outputPanel.add(outputLabel);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);

        for (int i = 0; i < menuItems.length; i++)
            menuItems[i].addActionListener(this);

        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < menuItems.length; i++)
        {
            if (e.getSource() == menuItems[i])
            {
                checkInput(menuItems[i]);
            }
        }
        if (e.getSource() == backButton)
        {
            firstWindow = new FirstWindow();
            dispose();
        }
    }

    private void checkInput(JMenuItem item)
    {
        boolean isCorrectDateInput = true;
        boolean isCorrectLongLatInput = true;
        String[] dateString = new String[3];

        if (inputDateTextField.getText().isEmpty())
            isCorrectDateInput = false;

        for (int i = 0; i < inputDateTextField.getText().length(); i++)
        {
            if (isCorrectDateInput)
                dateString = inputDateTextField.getText().split("/");
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
                            outputTextField.setText("Wrong Date, Please Try Again!");
                        break;
                    }

                }
            }
        }

        for (int i = 0; i < inputTextField.length; i++)
        {
            if (inputTextField[i].getText().isEmpty())
            {
                isCorrectLongLatInput = false;
                outputTextField.setText("Invalid Longitude/Latitude");
            }


            if (isCorrectLongLatInput)
            {
                int dotCount = 0;
                int minusCount = 0;
                for (int j = 0; j < inputTextField[i].getText().length(); j++)
                {
                    if (inputTextField[i].getText().charAt(j) == '.')
                    {
                        dotCount++;
                    }
                    if (inputTextField[i].getText().charAt(j) == '-')
                    {
                        minusCount++;
                    }
                    if (dotCount > 1 || minusCount > 1)
                    {
                        isCorrectLongLatInput = false;
                        outputTextField.setText("Invalid Longitude/Latitude");
                        break;
                    }

                    if (!Character.isDigit(inputTextField[i].getText().charAt(j)) && inputTextField[i].getText().charAt(j) != '.'
                            && inputTextField[i].getText().charAt(j) != '-')
                    {
                        isCorrectLongLatInput = false;
                        outputTextField.setText("Invalid Longitude/Latitude");
                        break;
                    }
                }
            }
        }
        if (isCorrectDateInput && isCorrectLongLatInput)
        {
            CivilDate date = null;
            Sun sun = new Sun();
            int dayNumber = 0;
            try
            {
                date = new CivilDate(Integer.parseInt(dateString[0]),
                        Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]));
                dayNumber = Converter.civilDateToDayNumber(date);
            } catch (IllegalDateException e)
            {
                outputTextField.setText("Wrong Date, Please Try Again!");
            }
            if (item.getText().equals(menuItems[0].getText()))
                outputTextField.setText(Double.toString(sun.getAzimuth(dayNumber, Double.parseDouble(inputTextField[0].getText()), Double.parseDouble(inputTextField[1].getText()))));
            else if (item.getText().equals(menuItems[1].getText()))
                outputTextField.setText(Double.toString(sun.computeRiseTime(Double.parseDouble(inputTextField[0].getText()), Double.parseDouble(inputTextField[1].getText()), dayNumber, 4)));
            else if (item.getText().equals(menuItems[2].getText()))
                outputTextField.setText(Double.toString(sun.getAltitude(dayNumber, Double.parseDouble(inputTextField[0].getText()), Double.parseDouble(inputTextField[1].getText()))));
            else if (item.getText().equals(menuItems[3].getText()))
                outputTextField.setText(Double.toString(sun.getRA(dayNumber)));
            else if (item.getText().equals(menuItems[4].getText()))
                outputTextField.setText(Double.toString(sun.getDecl(dayNumber)));
        }
    }
}

