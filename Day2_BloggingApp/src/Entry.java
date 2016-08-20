// Implements Blog entries
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Entry {
	private String title;
	private String text;
	private Date date = new Date();
	private Set<String> tags = new HashSet<>();
	Entry(){
		title = "";
		text = "";
		date = new Date();
	}
	
	Entry(String new_title,String new_text,Date new_date,String[] new_tags){
		title = new_title;
		text = new_text;
		date = new_date;
		for(int i=0;i<new_tags.length;i++){
			tags.add(new_tags[i]);
		}
	}
	
	public void setTitle(String new_title){
		title = new_title;
	}
	
	public void setText(String new_text){
		text = new_text;
	}
	
	public void setDate(Date new_date){
		date = new_date;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getText(){
		return text;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void addTag(String tag){
		tags.add(tag);
	}
	
	public boolean hasTag(String tag){
		boolean res = false;
		res = tags.contains(tag);
		return res;
	}
	
	public void removeTag(String tag){
		tags.remove(tag);
	}
	
	public ArrayList<String> getTags(){
		ArrayList<String> list = new ArrayList<String>(tags);
		return list;
	}
	
	public String[] getTagsArray(){
		return tags.toArray(new String[tags.size()]);
	}
	
	public void clearAllTags(){
		tags.clear();
	}
	
	public void print(){
		System.out.println();
		System.out.println(title);
		System.out.println(text);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Created: "+dateFormat.format(date));
		System.out.println("Tags: "+tags);
	}
}
