
public class CongaLine {
	private LinkedList<String> line= new LinkedList<String>();
	
	
	
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
	public boolean enterBehind(String newPerson, String partner){
		boolean success;
		
		if(newPerson == "" || partner =="" || newPerson==null || partner==null){
			success = false;
		}else{
			success = true;
			int positionOfpartner = line.indexOf(partner);
			
			if(positionOfpartner==-1){
				success = false;
			}else{
				line.addAtIndex(newPerson, positionOfpartner);
			}
		}
		
		return success;

	}

	
	/*
	 * 	Return name of person whose hips are being held by personA
	 * */
	public String holdingHipsOf(String personA){
		String partner = "";
		
		int positionOfPersonA = line.indexOf(personA);
		int positionOfPartner = positionOfPersonA + 1;

		if((positionOfPartner >= line.size()) || positionOfPersonA==-1){
			partner = "No Partner!";
		}else{
			partner = (String)line.get(positionOfPartner);
		}
		
		return partner;
	}
	
	/*
	 * 	Print line
	*/
	public String seeLine(){
		String lineSequence = line.printList();
		return lineSequence;
	}
	
	/*
	 * 	Get number of people in conga line
	 * */
	public int lineSize(){
		return line.size();
	}
	
}
