public class CharEqual implements CharacterComparator {
    public boolean equalChars(char x, char y) {
        if(x-y==0) {
          return true;
        }
        return false;
    }
}
