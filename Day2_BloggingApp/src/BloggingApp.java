import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class BloggingApp {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		// TODO Auto-generated method stub
		Blog blog = new Blog();
		System.out.println("Welcome to my blogging app!");
		System.out.println("Enter a command...");
		System.out.println("(Enter 'h' for help)");
		String comm = "";
		while(!comm.equals("q")){
			System.out.println();
			System.out.println("Enter a command...");
			comm = in.nextLine();
			comm = comm.toLowerCase();
			String _aux;
			switch(comm){
			case "h":
				System.out.println("N -> New entry");
				System.out.println("A -> Show all tags");
				System.out.println("T -> Search by tag");
				System.out.println("S -> Show entry");
				System.out.println("R -> Recent entries");
				System.out.println("X -> Delete entry");
				System.out.println("Q -> Quit");
				break;
			case "n":
				createEntry(blog);
				break;
			case "a":
				blog.printAllTags();
				break;
			case "t":
				System.out.println("Enter tag you wish to search by...");
				_aux = in.nextLine();
				blog.printEntriesByTag(_aux);
				break;
			case "s":
				System.out.println("Enter the title of the post you wish to see...");
				_aux = in.nextLine();
				blog.printEntry(_aux);
				break;
			case "x":
				System.out.println("Enter the title of the post you wish to delete...");
				_aux = in.nextLine();
				blog.deleteEntryByTitle(_aux);
				break;
			case "r":
				System.out.println("Enter the number of recent posts you wish to see...");
				int n = in.nextInt();
				in.nextLine();
				blog.showLastEntries(n);
				break;
			case "q":
				System.out.println("Exiting...");				
				break;
			}
		}
		in.close();
	}

	static void createEntry(Blog _blog){
		System.out.println();
		System.out.println("Creating new entry...");		
		System.out.println("Enter title:");
		String title = in.nextLine();
		System.out.println("Enter text:");
		String text = in.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println("Entry date: "+dateFormat.format(date)); //2014/08/06 15:59:48
		System.out.println("Add tags to your post:");
		String aux = in.nextLine();
		String[] split = aux.split("\\s+");
		_blog.addEntry(title, text, date, split);
	}
}

