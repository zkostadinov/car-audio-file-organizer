import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainFrame {
    private final Model model;
    private JPanel panel1;
    private JList folders;
    private JList files;
    private JToolBar toolbar;
    private JButton delete;
    private JButton add;

    public MainFrame() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFile();
            }
        });

        model = new Model();
        folders.setModel(model);
    }

    private void addFile() {
        JOptionPane.showMessageDialog(panel1, "TODO");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TODO: title");
        frame.setContentPane(new MainFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class Model extends AbstractListModel {

    final ArrayList<Folder> folders = new ArrayList<>();

    public Model() {
        for (int i = 0; i < 6; i ++) {
            folders.add(new Folder(i));
        }
    }

    @Override
    public int getSize() {
        return folders.size();
    }

    @Override
    public Object getElementAt(int index) {
        return folders.get(index);
    }
}

class Folder {
    final int index;
    final List<File> files = new LinkedList<>();

    Folder(int index) {
        this.index = index;
    }
}

class File {
    String name;
    String path;
}