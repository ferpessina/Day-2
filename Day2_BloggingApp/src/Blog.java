import java.util.*;

public class Blog{
	private List<Entry> entries = new ArrayList<>();
	private Map<String,Integer> allTags = new HashMap<>();
	
	public void addEntry(String title,String text,Date date,String[] tags){
		entries.add(new Entry(title, text, date, tags));
		this.addTags(tags);
	}
	
	private void addTag(String tag){
		if(allTags.containsKey(tag)){
			int k = allTags.get(tag);
			allTags.put(tag, k+1);
		}else{
			allTags.put(tag, 1);
		}
	}
	
	private void addTags(String[] tags){
		for(int i=0;i<tags.length;i++){
			this.addTag(tags[i]);
		}
	}
	
	private void removeTag(String tag){
		if(allTags.containsKey(tag)){
			int k = allTags.get(tag);
			if(k<=1){
				allTags.remove(tag);
			}else{
				allTags.put(tag, k-1);
			}
		}
	}
	
	public void printEntriesByTag(String tag){
		if(allTags.containsKey(tag)){
			for(int i=0;i<entries.size();i++){
				if(entries.get(entries.size()-1-i).hasTag(tag)){
					this.printEntry(entries.size()-1-i);
				}
			}
		}else{
			System.out.println("No posts found with that tag.");
		}
	}
	
	private void removeTags(String[] tags){
		for(int i=0;i<tags.length;i++){
			this.removeTag(tags[i]);
		}
	}
	
	public void deleteEntryByTitle(String _title){
		for(int i=0;i<entries.size();i++){
			if(_title.equals(entries.get(i).getTitle())){
				removeTags(entries.get(i).getTagsArray());
				entries.remove(i);
			}
		}
	}
	
	public Entry getEntry(String _title){
		Entry entry = new Entry();
		for(int i=0;i<entries.size();i++){
			if(_title.equals(entries.get(i).getTitle())){
				return entries.get(i);
			}
		}
		return entry;
	}
	
	public Entry getEntry(int idx){
		Entry entry = new Entry();
		if(idx<entries.size()){
			return entries.get(idx);
		}
		return entry;
	}
	
	public void printEntry(String _title){
		boolean not_found = true;
		for(int i=0;i<entries.size();i++){
			if(_title.equals(entries.get(i).getTitle())){
				entries.get(i).print();
				not_found = false;
			}
		}
		if(not_found){
			System.out.println("No posts found with that title.");
		}
	}
	
	public void printEntry(int idx){
		if(idx<entries.size()){
			entries.get(idx).print();;
		}
	}
	
	public void printAllTags(){
		System.out.println("Tags: "+allTags.keySet());
	}
	
	public Entry getLastEntry(){
		return entries.get(entries.size()-1);
	}
	
	public void showLastEntries(int n){
		if(entries.size() == 0){
			System.out.println("No recent posts to show.");
		}
		if(n>entries.size()){
			n = entries.size();
		}
		for(int i=0;i<n;i++){
			this.printEntry(entries.size()-1-i);
		}
	}
	
}
