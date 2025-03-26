
public class Aims {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 18.50f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 12.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony & Joe Russo", 181, 24.99f);
        
        Cart cart1 = new Cart();
        
        cart1.addDigitalVideoDisc(dvd1);
        cart1.addDigitalVideoDisc(dvd2);
        cart1.addDigitalVideoDisc(dvd2);
        cart1.addDigitalVideoDisc(dvd3);
        cart1.addDigitalVideoDisc(dvd4);
        cart1.addDigitalVideoDisc(dvd5);
        
        cart1.displayCartItem();
        cart1.removeDigitalVideoDisc(dvd1);
        cart1.removeDigitalVideoDisc(dvd1);
	}
}
