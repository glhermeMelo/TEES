package unidade_2._11_move_field.exercise_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void constructor_shouldSetNameAndInitializeEmptySongsListAndZeroDuration() {
        Playlist playlist = new Playlist("My Playlist");
        assertEquals("My Playlist", playlist.getName());
        assertTrue(playlist.getSongs().isEmpty());
        assertEquals(0, playlist.getCurrentSongDurationSeconds());
    }

    @Test
    void addSong_shouldAddSongToListAndSetCurrentSongDuration() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song = new Song("Test Song", "Test Artist");
        int duration = 180;

        playlist.addSong(song, duration);

        assertEquals(1, playlist.getSongs().size());
        assertTrue(playlist.getSongs().contains(song));
        assertEquals(duration, playlist.getCurrentSongDurationSeconds());
    }

    @Test
    void addSong_shouldUpdateCurrentSongDurationToLastAddedSong() {
        Playlist playlist = new Playlist("Dynamic Playlist");
        Song song1 = new Song("First Song", "Artist A");
        Song song2 = new Song("Second Song", "Artist B");

        playlist.addSong(song1, 200);
        assertEquals(200, playlist.getCurrentSongDurationSeconds());

        playlist.addSong(song2, 300);
        assertEquals(300, playlist.getCurrentSongDurationSeconds());
    }

    @Test
    void formatDuration_shouldFormatSecondsToMMSSCorrectly() {
        Playlist playlist = new Playlist("Formatter Test");
        assertEquals("00:00", playlist.formatDuration(0));
        assertEquals("00:30", playlist.formatDuration(30));
        assertEquals("01:00", playlist.formatDuration(60));
        assertEquals("01:05", playlist.formatDuration(65));
        assertEquals("10:30", playlist.formatDuration(630));
        assertEquals("60:00", playlist.formatDuration(3600));
        assertEquals("99:59", playlist.formatDuration(5999));
    }

    @Test
    void displayPlaylist_shouldIncludeSongDetailsAndCurrentDuration() {
        Playlist playlist = new Playlist("Display Test");
        Song song1 = new Song("Display Song 1", "Artist X");
        Song song2 = new Song("Display Song 2", "Artist Y");

        playlist.addSong(song1, 150);
        playlist.addSong(song2, 250);

        assertDoesNotThrow(() -> playlist.displayPlaylist());
    }

    @Test
    void getCurrentSongDurationSeconds_shouldReturnCurrentValue() {
        Playlist playlist = new Playlist("Duration Getter Test");
        playlist.addSong(new Song("A", "B"), 123);
        assertEquals(123, playlist.getCurrentSongDurationSeconds());
        playlist.addSong(new Song("C", "D"), 456);
        assertEquals(456, playlist.getCurrentSongDurationSeconds());
    }
}