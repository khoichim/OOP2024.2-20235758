package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.Media;  
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        JLabel cost = new JLabel(media.getCost() + " $");
        this.add(title);
        this.add(cost);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(this,
                        "Media is now playing.", "Playing", JOptionPane.INFORMATION_MESSAGE);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(this,
                        "Error playing media: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            this.add(playButton);
        }
    }
}
