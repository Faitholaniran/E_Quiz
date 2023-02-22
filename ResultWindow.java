import javax.swing.*;

public class ResultWindow extends JFrame {
    ResultWindow(int score,int total) {
        super("Results"); // sets the title
        JLabel resLabel = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(450,100);
        setSize(600,350);

        resLabel.setBounds(100,140,500,70);
        String result = "YOUR TOTAL SCORE IS " + score + "/" + total;

        resLabel.setText(result);
        add(resLabel);
        setVisible(true);
    }
}
