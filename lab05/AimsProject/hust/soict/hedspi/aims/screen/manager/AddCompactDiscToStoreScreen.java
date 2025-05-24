package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store; // Giả định bạn đã có class Store
import hust.soict.hedspi.aims.media.CompactDisc; // Giả định bạn đã có class CompactDisc

import java.awt.*;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    // Các thành phần Swing để nhập thông tin cụ thể cho Compact Disc
    private JTextField artistField;
    private JTextField lengthField; // Có thể cần thêm trường cho tracks, phức tạp hơn
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD"); // Gọi constructor của lớp cha với tiêu đề "Add CD"

    }
}