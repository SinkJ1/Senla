package Task3;

public  class Song {

	private String name;
	private int duration;
	private String genre;
	
	public Song(String name,String genre,int duration){
		this.name = name;
		this.genre = genre;
		this.duration = duration;
	}
	public String getName(){
		return name;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public String getGenre(){
		return genre;
	}
}
