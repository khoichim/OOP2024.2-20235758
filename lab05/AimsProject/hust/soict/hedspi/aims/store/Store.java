package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Store {
    // Dùng ArrayList thay vì mảng tĩnh
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Thêm media vào cửa hàng
    public void addMedia(Media media) {
        if (media == null) {
            System.err.println("Cannot add null media to store.");
            return;
        }
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" is already in the store.");
        }
    }

    // Xoá media khỏi cửa hàng
    public void removeMedia(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.err.println("Cannot remove media with null or empty title.");
            return;
        }
        
        Media mediaToRemove = null;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                mediaToRemove = media;
                break;
            }
        }
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);
            System.out.println(title + " has been removed from the store.");
        } else {
            System.out.println("No media found with the title: " + title);
        }
    }

    // Hiển thị danh sách media trong cửa hàng
    public void displayMediaDetails(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.err.println("Cannot display details for null or empty title.");
            return;
        }
        
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                media.displayInfo();
                return;
            }
        }
        System.out.println("Media not found in store.");
    }
    public void addToCart(String title, Cart cart) {
        if (title == null || title.trim().isEmpty()) {
            System.err.println("Cannot add media with null or empty title to cart.");
            return;
        }
        if (cart == null) {
            System.err.println("Cannot add media to null cart.");
            return;
        }
        
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                cart.addMedia(media);
                return;
            }
        }
        System.out.println("Media not found in store.");
    }
    public void playMedia(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.err.println("Cannot play media with null or empty title.");
            return;
        }
        
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                if (media instanceof Playable) {
                    try {
                        ((Playable) media).play();
                        return;
                    } catch (Exception e) {
                        System.err.println("Error playing media: " + e.getMessage());
                        return;
                    }
                } else {
                    System.out.println("Media is not playable.");
                    return;
                }
            }
        }
        System.out.println("Media not found in store.");
    }



    // Getter để truy xuất danh sách nếu cần
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
