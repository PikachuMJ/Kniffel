import javax.swing.*;
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
            menu.setTitle("Willkommen zum spiel Kniffel");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            startButton.setFocusable(false);
            startButton.setBounds(9,5,150,100);
            regelButton.setFocusable(false);
            regelButton.setBounds(9,105,150,100);
            exitButton.setFocusable(false);
            exitButton.setBounds(9,205, 150, 100);

            startButton.addActionListener(this);
            regelButton.addActionListener(this);
            exitButton.addActionListener(this);

            menu.add(startButton);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setLayout(null);
            menu.setSize(170,345);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.add(regelButton);
            menu.add(exitButton);
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
