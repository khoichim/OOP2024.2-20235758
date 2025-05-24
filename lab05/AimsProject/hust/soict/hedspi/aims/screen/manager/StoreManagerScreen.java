package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store; // Giả định bạn đã có class Store


import javax.swing.*;
import java.awt.*;
public class StoreManagerScreen extends JFrame {

    private Store store;  // Dùng để quản lý dữ liệu store

    public StoreManagerScreen(Store store) {
        this.store = store;

        // Thiết lập giao diện cơ bản
        this.setTitle("Store");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Thêm phần NORTH vào giao diện
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);

        setVisible(true);
    }

    // Tạo phần NORTH (gồm tiêu đề AIMS và menu bar)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());    // Tiêu đề AIMS
        north.add(createMenuBar());   // Menu "Options"
        return north;
    }

    // Tạo tiêu đề "AIMS"
    JPanel createHeader() {
        JPanel header = new JPanel();
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.CYAN);
        header.add(title);
        return header;
    }

    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    
    public static void main(String[] args) {
        new StoreManagerScreen(new Store()); // Store giả định, bạn cần tạo class Store phù hợp
    }
}
