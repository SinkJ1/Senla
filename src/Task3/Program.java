package Task3;
import java.util.ArrayList;


public class Program {

	public static void main(String[] args) {
		ArrayList<Song> disc = new ArrayList<Song>();
		int duration = 0;
		int b = 0;
		int max = 0;
		String genre =" ";
		String str = " ";
		disc.add(new FirstSong("First", 3 ,"classic"));
		disc.add(new FirstSong("Two", 2 ,"classic"));
		disc.add(new FirstSong("three", 3 ,"classic"));
		disc.add(new TwoSong("four", 2 ,"pop"));
		disc.add(new TwoSong("five", 3 ,"pop"));
		disc.add(new FirstSong("three", 3 ,"classic"));
		disc.add(new TwoSong("five", 3 ,"pop"));
		
		for(int i = 0; i < disc.size(); i ++) {
			genre =  disc.get(i).getGenre();
			duration += disc.get(i).getDuration();
			for(int j = i; j < disc.size(); j ++) {
				if(genre == disc.get(j).getGenre()) {
					b++;
				}
			}
			if(max < b) {
				max = b;
				str = genre;
			}
			b = 0;
		}
		

		System.out.println("Общая длительность " + duration + " ," +"Общий жанр музыки - " + str);
	}
}

