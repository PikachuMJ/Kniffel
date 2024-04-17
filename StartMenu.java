import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartMenu implements ActionListener
{
    JFrame menu = new JFrame();
    JButton startButton = new JButton("Start");
    JButton regelButton = new JButton("Regeln");
    JButton exitButton = new JButton("Exit");
    ImageIcon regelnBild = new ImageIcon("kniffelRegeln.png");
        public StartMenu()
        {
            menu.setTitle(":O");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            startButton.setFocusable(false);
            startButton.setBounds(200,300,100,100);
            startButton.setPreferredSize(new Dimension(150, 50));

            JPanel panelStart = new JPanel();
            panelStart.setBounds(0,400,150,60);
            panelStart.add(startButton );

            regelButton.setFocusable(false);
            regelButton.setBounds(200,105,150,100);
            regelButton.setPreferredSize(new Dimension(150, 50));

            JPanel panelRegeln = new JPanel();
            panelRegeln.setBounds(170,400,150,60);
            panelRegeln.add(regelButton);

            exitButton.setFocusable(false);
            exitButton.setBounds(200,150, 150, 100);
            exitButton.setPreferredSize(new Dimension(150, 50));
            JPanel panelExit = new JPanel();
            panelExit.setBounds(340,400,150,60);
            panelExit.add(exitButton);

            JLabel textLabel = new JLabel("Willkommen zu Kniffel!");
            textLabel.setSize(500, 150);
            textLabel.setHorizontalAlignment(JLabel.CENTER);
            textLabel.setFont(new Font("Monospace", Font.PLAIN, 40));
            textLabel.setForeground(Color.WHITE);

            JLabel bildLabel = new JLabel();
            bildLabel.setSize(500, 390);
            bildLabel.setIcon(new ImageIcon("end.png"));

            startButton.addActionListener(this);
            regelButton.addActionListener(this);
            exitButton.addActionListener(this);

            menu.add(panelStart);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setLayout(null);
            menu.setSize(500,500);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.add(panelRegeln);
            menu.add(panelExit);
            menu.add(textLabel);
            menu.add(bildLabel);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton clickedButton = (JButton) e.getSource();
        if (startButton == clickedButton)
        {
            Punkte.start = true;
            menu.dispose();
            new Kniffel();
        }
        if(regelButton == clickedButton)
        {
                menu.dispose();
                String zurueck = (String)JOptionPane.showInputDialog(null,
                        "Geben sie ’back’ ein, um wieder zurück zu gehen",
                        "Regeln",
                        JOptionPane.PLAIN_MESSAGE, regelnBild, null, "");
            if(Objects.equals(zurueck, "back"))
            {
                new StartMenu();
            }
        }
        if(exitButton == clickedButton)
        {
            System.exit(0);
        }
    }
}
