
public class ArrayExercise {
	public static int max(int[] m) {
		int tmp = 0;
		for(tmp = 0;tmp<m.length-1;tmp++){
			if(m[tmp]>m[tmp+1]){
				m[tmp+1]=m[tmp]+m[tmp+1];
				m[tmp]=m[tmp+1]-m[tmp];
				m[tmp+1]=m[tmp+1]-m[tmp];
			}
		}
	       return m[m.length-1];
	   }
	   public static void main(String[] args) {
	      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
	      max(numbers);
	      System.out.print(max(numbers));
	   }
}
