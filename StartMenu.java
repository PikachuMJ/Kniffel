import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu implements ActionListener
{
    ImageIcon[] image = {new ImageIcon("start.png"), new ImageIcon("regeln.png"), new ImageIcon("exit.png")};

    JFrame menu = new JFrame();
    JButton startButton = new JButton(image[0]);
    JButton regelButton = new JButton(image[1]);
    JButton exitButton = new JButton(image[2]);
    ImageIcon regelnBild = new ImageIcon("kniffelRegeln.png");
    public StartMenu()
        {

            menu.setTitle(":O");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            startButton.setFocusable(false);
            startButton.setBounds(200,300,50,100);
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
        if (startButton == e.getSource())
        {
            menu.dispose();
            new Kniffel();
        }
        if(regelButton == e.getSource())
        {
            menu.dispose();
            JOptionPane.showMessageDialog(null, "", "",JOptionPane.ERROR_MESSAGE, regelnBild);
            new StartMenu();
        }
        if(exitButton == e.getSource())
        {
            System.exit(0);
        }
    }
}
