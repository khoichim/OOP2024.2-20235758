package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo cửa hàng và giỏ hàng
        Store store = new Store();
        Cart cart = new Cart();

        // Thêm vài media vào cửa hàng (có thể thêm bằng tay hoặc tự động)
        initializeStore(store);

        // Sử dụng getItemsInStore() để truy xuất danh sách
        ArrayList<Media> items = store.getItemsInStore();
        
        // In danh sách media trong store
        System.out.println("Danh sách sản phẩm trong store:");
        for (Media item : items) {
            System.out.println(item.getTitle()); // Giả sử Media có phương thức getTitle()
        }

        // Hiển thị menu chính và xử lý lựa chọn của người dùng
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner); // Xem cửa hàng
                    break;
                case 2:
                    updateStore(store, scanner); // Cập nhật cửa hàng
                    break;
                case 3:
                    seeCurrentCart(cart, scanner); // Xem giỏ hàng
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    // Hiển thị menu chính
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Khởi tạo một số sản phẩm trong cửa hàng
    public static void initializeStore(Store store) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        ArrayList<String> authors = new ArrayList<>(); 
        authors.add("J.K. Rowling");
        store.addMedia(new Book(2, "Harry Potter", "Fantasy", 25.99f, authors));
        CompactDisc cd1 = new CompactDisc(3, "The Best Hits", "Music", "John Doe", 14.99f, "Artist Name", 60);
        cd1.addTrack(new Track("Track 1", 3));
        cd1.addTrack(new Track("Track 2", 4));
        store.addMedia(cd1);
    }

    // Xem cửa hàng và xử lý menu cho cửa hàng
    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        boolean inStore = true;
        while (inStore) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    store.displayMediaDetails(title);
                    break;
                case 2:
                    System.out.print("Enter the title of the media to add to cart: ");
                    title = scanner.nextLine();
                    store.addToCart(title, cart);
                    break;
                case 3:
                    System.out.print("Enter the title of the media to play: ");
                    title = scanner.nextLine();
                    store.playMedia(title);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 0:
                    inStore = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Menu cửa hàng
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // Cập nhật cửa hàng (thêm hoặc xóa media)
    public static void updateStore(Store store, Scanner scanner) {
        boolean inUpdate = true;
        while (inUpdate) {
            System.out.println("Options: ");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    // Thêm media vào cửa hàng (có thể làm với các loại media cụ thể như DVD, CD, Book)
                    System.out.print("Enter media type (DVD, Book, CD): ");
                    String mediaType = scanner.nextLine();
                    if ("DVD".equalsIgnoreCase(mediaType)) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter director: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter length: ");
                        int length = scanner.nextInt();
                        System.out.print("Enter cost: ");
                        float cost = scanner.nextFloat();
                        store.addMedia(new DigitalVideoDisc(title, "Category", director, length, cost));
                    }
                    // Handle other media types similarly...
                    break;
                case 2:
                    // Xóa media khỏi cửa hàng
                    System.out.print("Enter the title of the media to remove: ");
                    String titleToRemove = scanner.nextLine();
                    store.removeMedia(titleToRemove);
                    break;
                case 0:
                    inUpdate = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Xem giỏ hàng và xử lý menu giỏ hàng
    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        boolean inCart = true;
        while (inCart) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ newline

            switch (choice) {
                case 1:
                    System.out.print("Filter media by (id/title): ");
                    String filterBy = scanner.nextLine();
                    cart.filterMedia(filterBy);
                    break;
                case 2:
                    System.out.print("Sort media by (title/cost): ");
                    String sortBy = scanner.nextLine();
                    cart.sortMedia(sortBy);
                    break;
                case 3:
                    System.out.print("Enter the media title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    cart.removeMediaByTitle(titleToRemove);
                    break;
                case 4:
                    System.out.print("Enter the title of media to play: ");
                    String titleToPlay = scanner.nextLine();
                    cart.playMedia(titleToPlay);
                    break;
                case 5:
                    cart.placeOrder();
                    break;
                case 0:
                    inCart = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Menu giỏ hàng
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
}
