package career08.oop;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Exam_8_3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class JukeBox {
  private CDPlayer cdPlayer;
  private User user;
  private Set<CD> cdCollection;
  private SongSelected ts;

  public Song getCurrentSong() {
    return ts.getCurrentSong();
  }

}

class SongSelected {
  public Song getCurrentSong() {
    return null;
  };
}

class CDPlayer {
  private Playlist list;
  private CD c;

  public void playSong(Song s) {
  }

}

class Playlist {

  private Song nowSong;
  private Queue<Song> songQueue;

  public Song getNextSong() {
    return songQueue.peek();
  }

  public void addSong(Song s) {
    this.songQueue.add(s);
  }
}

class CD {

  private long id;
  private String artist;
  private List<Song> songs;
}

class Song {
  private long id;
  private CD cd;
  private String title;
  private long timeLength;
}

class User {
  private String name;
  private long ID;
}