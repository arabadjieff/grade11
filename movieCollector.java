import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class movieCollector extends JFrame {

    static class Movie {
        String title, genre;
        Movie(String title, String genre) {
            this.title = title;
            this.genre = genre;
        }
    }

    Movie[] movies = new Movie[100];
    int count = 0;

    JTextField titleField = new JTextField(10);
    JComboBox<String> genreBox = new JComboBox<>(new String[]{"Action", "Comedy", "Horror", "Drama"});
    DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Title", "Genre"}, 0);
    JTable table = new JTable(tableModel);
    JTextField searchField = new JTextField(10);
    JLabel countLabel = new JLabel("Total: 0");

    public movieCollector() {
        setTitle("The Best Ever Movie Collection Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //top is the input
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Title:"));
        topPanel.add(titleField);
        topPanel.add(new JLabel("Genre:"));
        topPanel.add(genreBox);

        JButton addButton = new JButton("Add Movie");
        topPanel.add(addButton);
        add(topPanel, BorderLayout.NORTH);

        //table is in the center
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel sortPanel = new JPanel();
        JButton sortTitleButton = new JButton("Sort by Title (A-Z)");
        JButton sortGenreButton = new JButton("Sort by Genre");

        sortPanel.add(sortTitleButton);
        sortPanel.add(sortGenreButton);
        centerPanel.add(sortPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        //bottom is search + number of
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        bottomPanel.add(searchButton);
        bottomPanel.add(countLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        //add
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String genre = (String) genreBox.getSelectedItem();
                if (!title.isEmpty() && count < movies.length) {
                    movies[count++] = new Movie(title, genre);
                    titleField.setText("");
                    updateTable();
                }
            }
        });

        //sorting
        sortTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(movies, 0, count, (a, b) -> a.title.compareToIgnoreCase(b.title));
                updateTable();
            }
        });

        sortGenreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(movies, 0, count, (a, b) -> a.genre.compareToIgnoreCase(b.genre));
                updateTable();
            }
        });

        //search
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search = searchField.getText().trim().toLowerCase();
                for (int i = 0; i < count; i++) {
                    if (movies[i].title.toLowerCase().equals(search)) {
                        table.setRowSelectionInterval(i, i);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Movie not found.");
            }
        });

        setVisible(true);
    }

    void updateTable() {
        tableModel.setRowCount(0);
        for (int i = 0; i < count; i++) {
            tableModel.addRow(new Object[]{movies[i].title, movies[i].genre});
        }
        countLabel.setText("Total: " + count);
    }

    public static void main(String[] args) {
        new movieCollector();
    }
}
