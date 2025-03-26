public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.printf("Add %s succesfully!\n", disc.getTitle());
		}
		else
			System.out.println("The cart is full!");
		displayCartItem();
	}
	
	public float totalCost() {
		float res = 0;
		for(int i = 0; i < qtyOrdered; ++i) {
			res += itemsOrdered[i].getCost();
		}
		return res;
	}
	
	public void displayCartItem() {
		for(int i = 0; i < qtyOrdered; ++i) {
			System.out.printf("%-5d", i+1);
			System.out.printf("%-20s", itemsOrdered[i].getTitle());
			System.out.printf("%.2f$\n", itemsOrdered[i].getCost());
		}
		System.out.printf("     %-20s%.2f$\n\n", "Total cost: ", totalCost());
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean change = false;
		for(int i = 0; i < qtyOrdered; ++i) {
			if(itemsOrdered[i].getTitle().equals(disc.getTitle()) && itemsOrdered[i].getDirector().equals(disc.getDirector())) {
				int j;
				for(j = i; j < qtyOrdered-1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[--qtyOrdered] = null;

				change = true;
				break;
			}
		}
		if(change) {
			System.out.printf("Remove %s succesfully!\n", disc.getTitle());
		}
		else {
			System.out.printf("Remove %s failed!\n", disc.getTitle());
		}
		displayCartItem();
	}
}
