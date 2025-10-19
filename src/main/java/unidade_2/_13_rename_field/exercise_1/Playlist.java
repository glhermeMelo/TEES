package unidade_2._13_rename_field.exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Adicionada à playlist '" + name + "': " + song.getTtl());
    }

    public void removeSong(Song song) {
        if (this.songs.remove(song)) {
            System.out.println("Removida da playlist '" + name + "': " + song.getTtl());
        } else {
            System.out.println("Música não encontrada na playlist '" + name + "': " + song.getTtl());
        }
    }

    public void displayPlaylist() {
        System.out.println("\n--- Playlist: " + name + " (" + songs.size() + " músicas) ---");
        if (songs.isEmpty()) {
            System.out.println("  Playlist vazia.");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            System.out.println((i + 1) + ". " + song.getTtl() + " - " + song.getArt());
        }
    }
}