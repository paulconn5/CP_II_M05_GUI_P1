import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton fortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int previousIndex = -999;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top panel
        titleLabel = new JLabel("Fortune Teller", new ImageIcon("fortuneteller.png"), JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);

        // Middle panel
        fortuneArea = new JTextArea(10, 30);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        fortuneButton = new JButton("What's My Fortune?");
        fortuneButton.setFont(new Font("Arial", Font.BOLD, 24));
        fortuneButton.addActionListener((ActionEvent e) -> showFortune());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fortuneButton);

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will meet a talking dog.");
        fortunes.add("You will win a lifetime supply of bubble wrap.");
        fortunes.add("Your going to fall into a ravine.");
        fortunes.add("It is best you don't know...");
        fortunes.add("The future is looking dim...");
        fortunes.add("You're gonna find twelve cents on the ground.");
        fortunes.add("You're gonna win a Lamborghini, but then crash it");
        fortunes.add("You will learn to fly, as soon as you grow wings.");
        fortunes.add("You will step in gum.");
        fortunes.add("You're gonna run out of toilet paper.");
        fortunes.add("You will find a broken TV");
        fortunes.add("JACKPOT! You win $1!");


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height;
        setLocation((screenSize.width - width) / 2, 0);
        setSize(width, height);
        setVisible(true);
    }

    private void showFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunes.size());
        if (index == previousIndex) {
            showFortune();
            return;
        }
        fortuneArea.append(fortunes.get(index) + "\n");
        previousIndex = index;
    }
}
