import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String name;
    String[] options;
    String correct_option;

    Question(String name, String options, String correct_option) {
        this.name = name;
        this.options = options.split(" ");
        this.correct_option = correct_option;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("questions.txt");
        Scanner input = new Scanner(file);
        ArrayList<Question> question_list = new ArrayList<>();

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] sections = line.split("\\=");
            question_list.add(new Question(sections[0], sections[1], sections[2]));
        }

        new Window(question_list,0,0,0);
    }
}