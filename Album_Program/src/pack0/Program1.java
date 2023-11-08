package pack0;
import java.util.Scanner;
public class Program1 {
	public static void main(String[] args) {
    String userInput; 
    int numberSongs;
	Scanner keyboard = new Scanner(System.in);
	Album userAlbum = new Album(); 
	int counter = 0; 
	
	System.out.println("Enter details for 3 albums \n");
     		          
while(counter < 3) {
	
	
	
	try {
	
	System.out.println("Title: ");
	userInput = keyboard.nextLine(); 
	userAlbum.setTitle(userInput);
	
	}
    
	catch(Exception e) {
		System.out.println("Invalid response entered, try again");
	}
	
	System.out.println("Performer: ");
	
	try {
	userInput = keyboard.nextLine();
	userAlbum.setPerformer(userInput);
	}
    
	catch(Exception e) {
		System.out.println("Invalid response entered, try again");
		
	}
	
	System.out.println("Genre: ");
	
	try {
	
	userInput = keyboard.nextLine();
	userAlbum.setGenre(userInput);
	
	}
    
	catch(Exception e) {
		System.out.println("Invalid response entered, try again");
	}
	System.out.println("Number of Songs: ");
	
	try {
	
		numberSongs = keyboard.nextInt();
	    userAlbum.setNumberSongs(numberSongs);
	    
	
	}
	
	catch(Exception e) {
		
		System.out.println("out-of-bounds response entered, try again");
		
	}

	System.out.println(userAlbum.toString());
	System.out.println(userAlbum.isLong());
	keyboard.nextLine();
	
	
	counter++;
    }
	
	System.out.println("Successful Termination");
	
	keyboard.close();
	}
}
