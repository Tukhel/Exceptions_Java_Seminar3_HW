package Seminar_3_HW;

public class IsValidFIO {
    
    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.UnicodeBlock.of(s.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || 
                s.charAt(i) == '-') {
                return true;
            }
        }
        return false;
    }
}
