package unidade_2._13_rename_field.exercise_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void constructor_shouldInitializeSongCorrectly() {
        Song song = new Song("My Awesome Song", "My Cool Artist", 240, "Greatest Hits");

        assertEquals("My Awesome Song", song.getTtl());
        assertEquals("My Cool Artist", song.getArt());
        assertEquals(240, song.getDurSecs());
        assertEquals("Greatest Hits", song.getAlb());
    }

    @Test
    void setters_shouldUpdateSongFields() {
        Song song = new Song("Old Title", "Old Artist", 100, "Old Album");

        song.setTtl("New Title");
        song.setArt("New Artist");
        song.setDurSecs(300);
        song.setAlb("New Album");

        assertEquals("New Title", song.getTtl());
        assertEquals("New Artist", song.getArt());
        assertEquals(300, song.getDurSecs());
        assertEquals("New Album", song.getAlb());
    }

    @Test
    void toString_shouldReturnFormattedString() {
        Song song = new Song("Test Track", "Test Band", 150, "Test Album"); // 2min 30seg

        String expected = "Título: 'Test Track'\n" +
                "  Artista: Test Band\n" +
                "  Álbum: Test Album\n" +
                "  Duração: 2:30";

        assertEquals(expected, song.toString());
    }
}