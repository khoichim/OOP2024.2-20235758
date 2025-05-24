import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];  // Các nút từ 0 đến 9
    private JButton btnDelete, btnReset;             // Nút delete và reset
    private JTextField tfDisplay;                    // Ô hiển thị

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Tạo panel chứa các nút và đặt layout 4x3
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Lấy content pane để thêm các thành phần
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Cài đặt cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    // Thêm các nút số và nút chức năng vào panel
    private void addButtons(JPanel panel) {
        ButtonListener listener = new ButtonListener();

        // Thêm nút 1 đến 9
        for (int i = 1; i <= 9; ++i) {
            btnNumbers[i] = new JButton("" + i);
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(listener);
        }

        // Nút "DEL"
        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(listener);

        // Nút 0
        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(listener);

        // Nút "C" (Reset)
        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(listener);
    }

    // Xử lý sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();

            if (btnLabel.equals("DEL")) {
                // Xóa ký tự cuối
                String text = tfDisplay.getText();
                if (text.length() > 0) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (btnLabel.equals("C")) {
                // Xóa toàn bộ
                tfDisplay.setText("");
            } else {
                // Thêm số vào ô hiển thị
                tfDisplay.setText(tfDisplay.getText() + btnLabel);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
