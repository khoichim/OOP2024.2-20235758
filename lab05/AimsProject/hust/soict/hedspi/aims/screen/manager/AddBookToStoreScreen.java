package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import javax.swing.*;
import java.util.List; // Cần cho danh sách tác giả
import java.util.Arrays; // Hỗ trợ xử lý chuỗi tác giả


public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField authorsField;      // Nhập danh sách tác giả, có thể cách nhau bởi dấu phẩy
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");   // Gọi constructor của lớp cha với tiêu đề "Add Book"
    }
}
