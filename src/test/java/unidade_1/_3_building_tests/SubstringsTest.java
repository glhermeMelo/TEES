package unidade_1._3_building_tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static unidade_1._3_building_tests.Substrings.substringsBetween;

public class SubstringsTest {

    @Test
    void strIsNullOrEmpty() {
        //T1: str é null
        assertThat(substringsBetween(null, "a", "b")).isEqualTo(null);
        //T2: str é vazia
        assertThat(substringsBetween("", "a", "b")).isEqualTo(new String[]{});
    }

    @Test
    void openIsNullOrEmpty() {
        //T3: open é null
        assertThat(substringsBetween("abc", null, "b")).isEqualTo(null);
        //T4: open é vazia
        assertThat(substringsBetween("abc", "", "b")).isEqualTo(null);
    }

    @Test
    void closeIsNullOrEmpty() {
        //T5: close é null
        assertThat(substringsBetween("abc", "a", null)).isEqualTo(null);
        //T6: close is vazia
        assertThat(substringsBetween("abc", "a", "")).isEqualTo(null);
    }

    @Test
    void strOfLength1() {
        //T7: o único caractere em str corresponde a open
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
        //T8: o único caractere em str corresponde a close
        assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
        //T9: o único caractere em str não corresponde a open nem close
        assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
        //T10: o único caractere em str corresponde a ambas              as tags
        assertThat(substringsBetween("a", "a", "a")).isEqualTo(null);
    }

    @Test
    void openAndCloseOfLength1() {
        //T11: str não contém nem open nem close
        assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
        //T12: str contém open, mas não contém close
        assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
        //T13: str contém a close, mas não contém open
        assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
        //T14: str contém ambas as tags
        assertThat(substringsBetween("abc", "a", "c")).
                isEqualTo(new String[]{"b"});
        //T15: str contém ambas as tags, múltiplas vezes
        assertThat(substringsBetween("abcabc", "a", "c")).
                isEqualTo(new String[]{"b", "b"});
        assertThat(substringsBetween("abcabyt byrc", "a", "c")).
                isEqualTo(new String[]{"b", "byt byr"});
    }

    @Test
    void openAndCloseTagsOfDifferentSizes() {
        //T16: str não contém nem open, nem close
        assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
        //T17: str contém open, mas não contém close
        assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
        //T18: str contém close, mas não contém open
        assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
        //T19: str contém ambas as tags
        assertThat(substringsBetween("aabbcc", "aa", "cc")).
                isEqualTo(new String[]{"bb"});
        //T20: str contém ambas as tags, múltiplas vezes
        assertThat(substringsBetween("aabbccaaeecc", "aa", "cc")).
                isEqualTo(new String[]{"bb", "ee"});
        assertThat(substringsBetween("a abb ddc ca abbcc", "a a", "c c")).
                isEqualTo(new String[]{"bb dd"});
    }

    @Test
    void noSubstringBetweenOpenAndCloseTags() {
        //T21: str contém ambas as tags com nenhum caractere entre elas
        assertThat(substringsBetween("aabb", "aa", "bb")).
                isEqualTo(new String[]{""});
    }
}