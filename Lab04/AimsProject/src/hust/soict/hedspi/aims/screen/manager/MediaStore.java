package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import hust.soict.hedspi.aims.media.*;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore(Media media, StoreManagerScreen managerScreen) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e -> {
				managerScreen.PlayMedia((Playable) media);
            });
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
