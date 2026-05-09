package nuisance;

public class Friend extends Person {
	private Hobby hobby;
	
	/**
	 * @param name
	 * @param age
	 * @param hobby
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		this.hobby = hobby;
	}
	
	/**
	 * 
	 * @return
	 */
	public String chill() {
		return this.getName() + " is chilling";
	}
	
	/**
	 * 
	 * @param friends
	 * @return
	 */
	public String play(Friend[] friends) {
		String playingHobby = "playing " + hobby;
		
		if (friends.length == 0) { // alone
			return playingHobby;
		}
		else if (friends.length == 1) { // with one friend
			return playingHobby + " with " + friends[0].getName();
		}
		else if (friends.length == 2) { // with two friends
			return playingHobby + " with " + friends[0].getName() + " and " + friends[1].getName();
		}
		else if (friends.length > 2) { // with more than two friends
			StringBuilder multipleFriendsString = new StringBuilder(playingHobby + " with ");
			for (Friend friend : friends) {
				if (friend == friends[friends.length - 1]) { // if last friend in array
					multipleFriendsString.append("and " + friend.getName() + ".");
				}
				else {
					multipleFriendsString.append(friend.getName() + ", ");
				}
			}
			return new String(multipleFriendsString);
		}
		else { // this shouldn't happen
			return null;
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return super.toString() + " " + hobby;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Person otherFriend) {
		if (otherFriend instanceof Friend) {
			otherFriend = (Friend)otherFriend; // this didn't seem to do anything, but I kept it so I wouldn't have to redo as much
		}
		else {
			return false;
		}
		
		if (this == otherFriend) { // if referencing the same object twice
			return true;
		}
		else if (this.getName() == otherFriend.getName() && this.getAge() == otherFriend.getAge() && this.hobby == ((Friend)otherFriend).hobby) {
			return true; // if same name, age, and hobby
		}
		else {
			return false;
		}
	}
}
