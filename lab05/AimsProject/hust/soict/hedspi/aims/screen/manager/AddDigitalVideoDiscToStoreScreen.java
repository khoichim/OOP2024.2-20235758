package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.store.Store; // Giả định bạn đã có class Store

import java.awt.*;    
import javax.swing.*;    // Import các thư viện cần thiết

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
        // Add text fields and confirm button to get title, category, length, cost, etc.
    }
}
