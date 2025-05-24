package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public interface Playable {
    public void play() throws PlayerException;  // Phương thức trừu tượng play() để các lớp cài đặt
}
