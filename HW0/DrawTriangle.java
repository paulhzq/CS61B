
public class DrawTriangle {
	public static void drawTriangle(int N){
		for(int row = 1;row<=N;row++){
			int n =1;
			while(n <= row){
			System.out.print('*');
			n = n + 1;
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		drawTriangle(10);
		
		
	}

}
