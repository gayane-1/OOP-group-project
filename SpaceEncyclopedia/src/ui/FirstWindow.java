package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame implements ActionListener
{
    private PlanetsWindow planetWindow;
    private ConverterWindow converterWindow;
    private JButton planetButton, converterButton;
    private JPanel mainButtonPanel;
    private JLabel textLabel;
    private ImageIcon titleImage = new ImageIcon("src/gfx/TitleImage.jpg");
    private ImageIcon planetButtonImage = new ImageIcon("src/gfx/Planet.jpg");
    private ImageIcon converterButtonImage = new ImageIcon("src/gfx/Calculator.png");
    private static final int MAIN_WIDTH = 1400;
    private static final int MAIN_HEIGHT = 1000;
    private static final int FONT_SIZE = 30;

    public FirstWindow()
    {
        super();
        setSize(MAIN_WIDTH, MAIN_HEIGHT);
        setTitle("Space Encyclopedia");
        setIconImage(titleImage.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(3, 6, 55));

        textLabel = new JLabel();
        textLabel.setText("Space Encyclopedia");
        textLabel.setFont(new Font("Noto Mono", Font.BOLD, FONT_SIZE));
        textLabel.setForeground(new Color(238, 226, 222));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(textLabel,BorderLayout.NORTH);

        mainButtonPanel = new JPanel();
        planetButton = new JButton();
        converterButton = new JButton();
        planetButton.setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
        planetButton.setIcon(planetButtonImage);
        converterButton.setBorder(BorderFactory.createEmptyBorder(-1,-1,-1,-1));
        converterButton.setBackground(new Color(3, 6, 55));
        converterButton.setIcon(converterButtonImage);

        mainButtonPanel.setBackground(new Color(3, 6, 55));
        mainButtonPanel.setLayout(new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS));
        mainButtonPanel.setBorder(BorderFactory.createEmptyBorder(-300, 20, 50, 50));
        mainButtonPanel.add(planetButton);
        mainButtonPanel.add(Box.createRigidArea(new Dimension(100,0)));
        mainButtonPanel.add(converterButton);

        add(mainButtonPanel);

        setVisible(true);

        planetButton.addActionListener(this);
        converterButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == planetButton)
        {
            planetWindow = new PlanetsWindow();
            dispose();
        }
        if(e.getSource() == converterButton)
        {
            converterWindow = new ConverterWindow();
            dispose();
        }
    }
}
