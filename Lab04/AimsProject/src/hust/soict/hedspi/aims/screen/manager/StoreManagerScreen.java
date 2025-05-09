package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.media.*;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	public JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    // View Store option
	    JMenuItem viewStore = new JMenuItem("View Store");
	    viewStore.addActionListener(e -> {
	        // Close other windows and reload this one
	        this.dispose();
	        new StoreManagerScreen(store);
	    });
	    menu.add(viewStore);

	    // Update Store submenu
	    JMenu updateStoreMenu = new JMenu("Update Store");

	    JMenuItem addBookItem = new JMenuItem("Add Book");
	    addBookItem.addActionListener(e -> {
	        new AddBookToStoreScreen(store);
	        StoreManagerScreen.this.dispose();
	    });

	    JMenuItem addCDItem = new JMenuItem("Add CD");
	    addCDItem.addActionListener(e -> {
	        new AddCompactDiscToStoreScreen(store);
	        StoreManagerScreen.this.dispose();
	    });

	    JMenuItem addDVDItem = new JMenuItem("Add DVD");
	    addDVDItem.addActionListener(e -> {
	        new AddDigitalVideoDiscToStoreScreen(store);
	        StoreManagerScreen.this.dispose();
	    });

	    updateStoreMenu.add(addBookItem);
	    updateStoreMenu.add(addCDItem);
	    updateStoreMenu.add(addDVDItem);

	    menu.add(updateStoreMenu);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}
	
	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		header.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter()
	{
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < 9; ++i) {
			if (i < mediaInStore.size()) {
				center.add(new MediaStore(mediaInStore.get(i), this));
		    } else {
		        center.add(new JPanel()); 
		    }
		}
		
		return center;
	}
	
	void PlayMedia(Playable media) {
		JDialog playDialog = new JDialog(this, "Playing Media", true);
		playDialog.setLayout(new BorderLayout());
		String title = new String();
		if(media instanceof Media) {
			title = ((Media) media).getTitle();
		}
		else {
			title = "Unknown";
		}
		int length = 0;
		if(media instanceof DigitalVideoDisc) {
			length = ((DigitalVideoDisc) media).getLength();
		}
		else if(media instanceof CompactDisc) {
			length =((CompactDisc) media).getLength();
		}
		
		playDialog.add(new JLabel("Playing : "+ title +"[ Length "+ length +" minutes]"));
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(e -> playDialog.dispose());
		playDialog.add(stopButton, BorderLayout.SOUTH);
		playDialog.setSize(400, 100);
		playDialog.setLocationRelativeTo(null);
		playDialog.setVisible(true);
	}
	private void showErrorMessage() {
		JOptionPane.showMessageDialog(this,"Book can be played","Error!", JOptionPane.ERROR_MESSAGE);
	}
}
