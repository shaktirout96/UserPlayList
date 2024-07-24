import java.util.Map;
import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario {
@Test
public void testScenario1(){
	AddSongsPerUesr userSongs=new AddSongsPerUesr();
	userSongs.finalMethod("user1", "song1");
	userSongs.finalMethod("user1", "song2");
	userSongs.finalMethod("user1", "song3");
	userSongs.finalMethod("user1", "song4");
	userSongs.finalMethod("user1", "song5");
	userSongs.finalMethod("user1", "song6");
	
	userSongs.finalMethod("user2", "song15");
	userSongs.finalMethod("user2", "song16");
	userSongs.finalMethod("user2", "song17");
	userSongs.finalMethod("user2", "song18");
	userSongs.finalMethod("user2", "song19");
	userSongs.finalMethod("user2", "song20");
	
	userSongs.finalMethod("user3", "song40");
	userSongs.finalMethod("user3", "song41");
	userSongs.finalMethod("user3", "song42");
	userSongs.finalMethod("user3", "song43");
	userSongs.finalMethod("user3", "song44");
	userSongs.finalMethod("user3", "song45");
	for(Map.Entry<String, Stack<String>> item:userSongs.finalSongUser.entrySet()) {
		if(item.getKey()=="user1") {
		Assert.assertEquals("song6", item.getValue().elementAt(0));
		Assert.assertEquals("song5", item.getValue().elementAt(1));
		Assert.assertEquals("song4", item.getValue().elementAt(2));
	}
		else if(item.getKey()=="user2") {
			Assert.assertEquals("song20", item.getValue().elementAt(0));
			Assert.assertEquals("song19", item.getValue().elementAt(1));
			Assert.assertEquals("song18", item.getValue().elementAt(2));
			
		}
		else if(item.getKey()=="user3") {
			Assert.assertEquals("song45", item.getValue().elementAt(0));
			Assert.assertEquals("song44", item.getValue().elementAt(1));
			Assert.assertEquals("song43", item.getValue().elementAt(2));
		}
	}
}

}
