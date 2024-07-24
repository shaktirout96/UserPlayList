import java.security.KeyPair;
import java.security.interfaces.DSAKeyPairGenerator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class AddSongsPerUesr {
	public Map<String, Stack<String>> songUser = new HashMap<String, Stack<String>>();
	public Map<String, Stack<String>> finalSongUser = new HashMap<String, Stack<String>>();

	int value=0;
	
	public Stack<String> addSongs(String songs) {
		Stack<String> song = new Stack<String>();
		Stack<String> song2 = new Stack<String>();
		song.push(songs);
		
		if (song.size() <= 3) {
			song2 = song;
		}
		for (Map.Entry<String, Stack<String>> item : songUser.entrySet()) {
			Stack<String> count=songUser.get(item.getKey());
			if (count.size() == 3 && value==0) {
				for (int i = 2; i >= 1; i--) {
					song2.push(item.getValue().elementAt(i));
					value+=1;
				}
			}
				else if (count.size() >= 3) {
					for (int i = 0; i <= 1; i++) {
						song2.push(item.getValue().elementAt(i));
					}
			}
			return song2;
		}
		return song2;
	}

	public void userPlayList(String user, Stack<String> userSong) {

		Stack<String> list = new Stack<String>();
		if (songUser.size() != 0) {
			for (Map.Entry<String, Stack<String>> item : songUser.entrySet()) {
				if (item.getKey() == user) {
					Stack<String> count=songUser.get(item.getKey());
					
					if (count.size() >= 3) {
						for (int i = 0; i <= 2; i++) {
							songUser.get(item.getKey()).pop();

						}
					}
					for (int i = 0; i <= userSong.size() - 1; i++) {
						songUser.get(item.getKey()).push( userSong.elementAt(i));
					}
				} else {
					songUser.put(user, userSong);
				}

			}
		} else {
			songUser.put(user, userSong);
		}
	}

	public boolean checkNewUser(String user) {
		boolean value = false;
		for (Map.Entry<String, Stack<String>> item1 : finalSongUser.entrySet()) {
			if (item1.getKey() == user) {
				value = false;
			} else {
				value = true;
			}
		}
		return value;
	}

	public boolean checkUserExits(String user) {
		boolean value = false;
		if (finalSongUser.size() != 0) {

			for (Map.Entry<String, Stack<String>> item1 : finalSongUser.entrySet()) {
				if (item1.getKey() == user) {
					value = false;
				} else {
					value = true;
				}
			}
		} else {
			value = true;
		}
		return value;
	}

	public void finalMethod(String user, String song) {
		if (checkNewUser(user)) {
			songUser = new HashMap<String, Stack<String>>();

		}
		userPlayList(user, addSongs(song));
		for (Map.Entry<String, Stack<String>> item : songUser.entrySet()) {
			if (checkUserExits(user)) {
				finalSongUser.put(item.getKey(), item.getValue());
			}

		}
	}
}
