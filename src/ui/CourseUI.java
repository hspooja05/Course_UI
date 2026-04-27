package ui;

import dao.CourseDAO;
import model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CourseUI extends JFrame {

    JTextField idField, nameField, instructorField, durationField;
    JTable table;
    DefaultTableModel model;
    CourseDAO dao = new CourseDAO();

    public CourseUI() {
        setTitle("Course Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Form
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        form.add(new JLabel("ID (for update/delete):"));
        idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Course Name:"));
        nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Instructor:"));
        instructorField = new JTextField();
        form.add(instructorField);

        form.add(new JLabel("Duration (hrs):"));
        durationField = new JTextField();
        form.add(durationField);

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout());

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton view = new JButton("View");

        btnPanel.add(add);
        btnPanel.add(update);
        btnPanel.add(delete);
        btnPanel.add(view);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Instructor", "Duration"}, 0);
        table = new JTable(model);

        // Add to main
        mainPanel.add(form);
        mainPanel.add(btnPanel);
        mainPanel.add(new JScrollPane(table));

        add(mainPanel);

        // Actions
        add.addActionListener(e -> {
            dao.addCourse(
                    nameField.getText(),
                    instructorField.getText(),
                    Integer.parseInt(durationField.getText())
            );
            loadTable();
        });

        update.addActionListener(e -> {
            dao.updateCourse(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    instructorField.getText(),
                    Integer.parseInt(durationField.getText())
            );
            loadTable();
        });

        delete.addActionListener(e -> {
            dao.deleteCourse(Integer.parseInt(idField.getText()));
            loadTable();
        });

        view.addActionListener(e -> loadTable());
    }

    private void loadTable() {
        model.setRowCount(0);
        List<Course> list = dao.getAllCourses();

        for (Course c : list) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    c.getInstructor(),
                    c.getDuration()
            });
        }
    }
}