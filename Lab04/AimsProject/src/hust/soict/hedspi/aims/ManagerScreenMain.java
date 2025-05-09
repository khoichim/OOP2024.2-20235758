package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class ManagerScreenMain {
    public static void main(String[] args) {
        Store store = new Store();

        Book book1 = new Book(1, "Java Programming", "Education", 15.99f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 19.99f);
        CompactDisc cd1 = new CompactDisc(2, "Best Hits", "Music", 9.99f, "Various", 50, "Various Artists");

      
        Book book2 = new Book(3, "Clean Code", "Education", 18.50f);
        Book book3 = new Book(4, "Harry Potter", "Fantasy", 12.00f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Action", "Christopher Nolan", 148, 17.99f);
        CompactDisc cd2 = new CompactDisc(5, "Pop Collection", "Pop", 10.00f, "ProducerX", 40, "Pop Artists");
        
        store.addMedia(book1);
        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(dvd2);
        store.addMedia(cd2);
        
        new StoreManagerScreen(store);
    }
}