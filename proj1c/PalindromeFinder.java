/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words");

        // CharacterComparator cc = new CharEqual();
        // while (!in.isEmpty()) {
        //     String word = in.readString();
        //     if (word.length() >= minLength && Palindrome.isPalindrome(word,cc)) {
        //         System.out.println(word);
        //     }
        // }
        System.out.println("--------------------");
        //CharacterComparator cc2 = new OffByOne();
        CharacterComparator cc2 = new OffByN(5);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isOffByOne(word,cc2)) {
                System.out.println(word);
            }
        }
    }
}
