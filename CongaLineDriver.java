
public class CongaLineDriver {
	
	public static void main(String[]args){
		
		CongaLine line = new CongaLine();
		
		System.out.println("Dan Enters the Conga Line");
		line.enter("Dan");
		line.seeLine();
		
		System.out.println("Charlotte Enters the Conga Line");
		line.enter("Charlotte");
		line.seeLine();
		
		System.out.println("AJ Enters the Conga Line");
		line.enter("AJ");
		line.seeLine();
		
		System.out.println("Ashley Enters behind Charlotte");
		line.enterBehind("Ashley", "Charlotte");
		line.seeLine();
		
		
		System.out.println("Dan Leaves the line");
		line.leave("Dan");
		line.seeLine();
		
		
		System.out.println("Shuqi Enters behind Charlotte");
		line.enterBehind("Shuqi", "Charlotte");
		line.seeLine();
		
		System.out.println("Everyone but Shuqi leaves the line");
		line.leave("Charlotte");
		line.leave("AJ");
		line.leave("Ashley");
		line.seeLine();
		
	}
}
