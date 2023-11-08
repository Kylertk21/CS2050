package pack0;

public class Album {
	private boolean stringTest = false; 
	private static String title; 
	private static String performer;
	private static String genre;
	private String upperString; 
	private static int numberSongs; 
	
	public Album() { 
		
	}
	
	public Album(String title, String performer, String genre, String numberSongs) {
		
	}
	
	public void setTitle(String str) { //setters \/\/\/
		
		title = str.toUpperCase();
	}
	
	public void setPerformer(String str) {
        
		performer = str.toUpperCase();
		
	}
	
	public void setGenre(String str) {
         
		String defGenre = "easy listening";
		
		 upperString = str.toUpperCase();
		
		 stringTest = upperString.equals("HIP-HOP") || upperString.equals("EASY LISTENING") || upperString.equals("ORCHESTRAL")
		     || upperString.equals("YOUR PARENTS") || upperString.equals("THEATRE");
		
		 if (stringTest == true) {
        
			genre = upperString; 
			
		} else {
			
			genre = defGenre;
			
		}
		 
	}
	
	
	public void setNumberSongs(int x) {
         
		if (x >= 10) {
			
        	numberSongs = x;
        	 
		} else {
			
			numberSongs = 10;
		}
		
	}
	
     public boolean isLong() {
		
		if (numberSongs > 50 ) {
		
		return true; 
		
		} else {
			
			return false;
			
		}
	}
	
    public static String getTitle() { //getters \/\/\/
		
    	return title;
	}
	
	public static String getPerformer() {
		
		return performer;
	}
	
	public static String getGenre() {
		
		return genre;
	}
	
	public static int getNumberSongs() {
		
		return numberSongs;
	}
	
	
	
	public String toString() {
		String myString = "Title: " + title + "\n" + "Performer: " 
	                    +  performer + "\n" + "Genre: " + genre + "\n" 
				        + "Number of Songs: " + numberSongs + "\n" 
				        + "Songs Greater Than 50? (T/F): "; 
		return myString; 
		
	}
	
	public int parseInt(int x) {
		
		return x;
	}
	
}
