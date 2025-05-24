package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(int id, String title, String category, String artist, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track \" " + track.getTitle() + " \" has been added to CD: " + this.getTitle());
		} else {
			System.out.println("Track has already existed in CD!");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track \" " + track.getTitle() + " \" has been removed from CD: " + this.getTitle());
		} else {
			System.out.println("Track doesn't exist in CD!");
		}
	}
	
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = iter.next();
				nextTrack.play();
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public String toString() {
		return this.getId() + " - CD: " + this.getTitle() + " - Category: " + this.getCategory() + " - Artist: " + this.getArtist() + " - Length: " + this.getLength() + " seconds" + " - Cost: " + this.getCost() + "$";
	}
}
