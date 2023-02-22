import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {
    static JLabel questionLabel;

    static JRadioButton[] optRadiobuttons = new JRadioButton[4];
    static ArrayList<Question> List;
    static int Currnum;
    static int count;
    static int sum;
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int current = 0;

    Window(ArrayList<Question> input, int num, int score,int total) {
        super("Question no. " + (num + 1)); // sets the title
        List = input;
        Currnum = num;
        sum = total;
        count = score;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setSize(600, 350);


        questionLabel = new JLabel();
        Question q = input.get(num);
        questionLabel.setText(q.name);
        add(questionLabel);


        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optRadiobuttons[i] = new JRadioButton();
            optRadiobuttons[i].setText(q.options[i]);
            add(optRadiobuttons[i]);
            bg.add(optRadiobuttons[i]);
        }


        btnNext = new JButton("Next");
        btnResult = new JButton("Result");

        // check if we're at the last question
        // and enable the appropriate button
        if (Currnum == List.size() - 1) {
            btnNext.setVisible(false);
            btnResult.setVisible(true);
        } else {
            btnNext.setVisible(true);
            btnResult.setVisible(false);
        }

        btnResult.addActionListener(this);
        btnNext.addActionListener(this);

        add(btnNext);
        add(btnResult);


        questionLabel.setBounds(30, 40, 450, 20);

        optRadiobuttons[0].setBounds(50, 80, 450, 20);
        optRadiobuttons[1].setBounds(50, 110, 200, 20);
        optRadiobuttons[2].setBounds(50, 140, 450, 20);
        optRadiobuttons[3].setBounds(50, 170, 200, 20);

        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {

            for (int c = 0; c < 4; c++) {

                if (optRadiobuttons[c].getText().equals(List.get(Currnum).correct_option) && optRadiobuttons[c].isSelected()) {
                    count += 5;
                }
            }
            setVisible(false);
            new Window(List, Currnum + 1, count,sum);
        }

        if (e.getSource() == btnResult) {
            for (int c = 0; c < 4; c++) {
                sum+=5;

                if (optRadiobuttons[c].getText().equals(List.get(Currnum).correct_option) && optRadiobuttons[c].isSelected()) {
                    count += 5;
                }
            }

            setVisible(false);
            new ResultWindow(count,sum);
        }
    }

}
