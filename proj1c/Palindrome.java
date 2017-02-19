public class Palindrome {

    public static Deque<Character> wordToDeque(String word) {
        LinkedListDequeSolution<Character> llds = new LinkedListDequeSolution<Character>();
        int length = word.length();
        for(int index =0; index<length; index++) {
            llds.addLast(word.charAt(index));//addLast every char in the word from begin to the end.
        }
        return llds;
    }

    public static boolean isPalindrome(String word) {
        if(word.length()<2) {
            return true;
        }
        if(word.charAt(0)!=word.charAt(word.length()-1)) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length()-1));
      }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if(word.length()<2) {
            return true;
        }
        if(!cc.equalChars(word.charAt(0),word.charAt(word.length()-1))) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length()-1),cc);
    }

    public static boolean isOffByOne(String word,CharacterComparator cc) {
        if(word.length()<2) {
            return true;
        }
        if(!cc.equalChars(word.charAt(0),word.charAt(word.length()-1))) {
            return false;
        }
        return isOffByOne(word.substring(1, word.length()-1),cc);
    }


}
