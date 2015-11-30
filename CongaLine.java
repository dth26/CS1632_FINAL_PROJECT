
public class CongaLine {
	private LinkedList<String> line= new LinkedList<String>();
	
	
	/*
	 * 	Make personA hold the hips of personB
	 * 
	 * */
//	public void switchHips(String personA, String personB){
//		
//	}
	
	
	/*
	 * 	Remove person from the conga line
	 * */
	public void leave(String name){
		line.remove(name);
	}
	
	
	/*	Add a person to back of line
	 * 
	 * */
	public void enter(String name){
		line.addFirst(name);
	}
	
	/*
	 * 	Add a person to the conga line
	 *  so that newPerson should now hold the hips of partner
	 * */
	public void enterBehind(String newPerson, String partner){
		
		int positionOfpartner = line.indexOf(partner);
		line.addAtIndex(newPerson, positionOfpartner);
	}

	
	/*
	 * 	Get the person whose hips are being help by personA
	 * */
	public String holdingHipsOf(String personA){
		String partner = "";
		
		int positionOfPersonA = line.indexOf(personA);
		int positionOfPartner = positionOfPersonA + 1;
		
		if(positionOfPartner >= line.size()){
			partner = "No Partner!";
		}else{
			partner = (String)line.get(positionOfPartner);
		}
		
		return partner;
	}
	
	/*
	 *  Reverse everyone's position so that each person is now holding
	 *  the hips of of the person that was holding their hips
	 * */
	public void reverse(){
		
	}
	
}
