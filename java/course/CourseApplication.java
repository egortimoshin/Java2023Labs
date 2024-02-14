package course;

import java.awt.*;
import java.io.PrintStream;
import javax.swing.*;

public class CourseApplication extends JFrame {

    private JTextArea text;
    private JTextField input;
    private JComboBox<String> programDropdown;
    private String[] programOptions = {
            "Проект1",
            "Проект2",
            "Проект3",
            "Проект4",
            "Проект5",
            "Проект6"
    };

    public CourseApplication(String name) {
        super(name);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel(new GridLayout(2, 3));

        programDropdown = new JComboBox<>(programOptions);

        compsToExperiment.add(programDropdown);

        JButton clear = new JButton("Очистить вывод");

        JButton start = new JButton("Старт");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(clear, BorderLayout.SOUTH);
        bottomPanel.add(start, BorderLayout.WEST);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Ввод:"), BorderLayout.NORTH);
        input = new JTextField(50);
        inputPanel.add(input, BorderLayout.CENTER);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPanel.add(new JLabel("Вывод программы:"), BorderLayout.NORTH);
        text = new JTextArea(20, 30);
        text.setEditable(false);
        JScrollPane scroll = new JScrollPane(text);
        textPanel.add(scroll, BorderLayout.CENTER);

        JPanel textWrapper = new JPanel(new BorderLayout());
        textWrapper.add(textPanel, BorderLayout.WEST);

        JPanel imageWrapper = new JPanel(new BorderLayout());

        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.add(inputPanel, BorderLayout.NORTH);
        bottomWrapper.add(textWrapper, BorderLayout.CENTER);
        bottomWrapper.add(imageWrapper, BorderLayout.EAST);
        bottomWrapper.add(bottomPanel, BorderLayout.SOUTH);

        PrintStream stream = new PrintStream(System.out) {
            public void print(String texts) {
                text.append(texts + "\n");
            }
        };

        System.setOut(stream);

        start.addActionListener(x -> {
            text.setText("");
            String userInput = input.getText().trim();
            input.setText("");

            int selectedProgramIndex = programDropdown.getSelectedIndex();
            if (selectedProgramIndex >= 0) {
                switch (selectedProgramIndex) {
                    case 0 -> lab1.Main.main(new String[]{userInput});
                    case 1 -> lab2.Main.main();
                    case 2 -> lab3.Main.main();
                    case 3 -> lab4.Main.main();
                    case 4 -> lab5.Main.main();
                    case 5 -> lab6.Main.main();
                }
            } else {
                text.append("Пожалуйста, выберите программу.\n");
            }
        });

        clear.addActionListener(x -> {
            text.setText("");
        });

        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(bottomWrapper, BorderLayout.CENTER);
    }

    private static void createAndShowGUI() {
        CourseApplication frame = new CourseApplication("Программы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());
        frame.setSize(1200, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(CourseApplication::createAndShowGUI);
    }
}
