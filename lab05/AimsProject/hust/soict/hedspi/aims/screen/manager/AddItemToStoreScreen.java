package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store; 

import javax.swing.*;   
import java.awt.*;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        this.setTitle(title);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}