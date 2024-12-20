import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoListApp() {
        JFrame frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
           taskList.setBackground(Color.YELLOW);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(taskList);

        taskInput = new JTextField(20);
        taskInput.setBackground(Color.cyan);
        JButton addButton = new JButton("Add Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(listScrollPane);
        frame.add(taskInput);
        frame.add(addButton);
        frame.setVisible(true);
    }

    private void addTask() {
        String taskText = taskInput.getText().trim();
        if (!taskText.isEmpty()) {
            taskListModel.addElement(taskText);
            taskInput.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoListApp();
        });
    }
}
