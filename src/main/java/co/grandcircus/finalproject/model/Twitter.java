package co.grandcircus.finalproject.model;

/*   Twitter model is used to get the messages from the twitter
 * 
 */
public class Twitter {
	private String user;
	private long id;
	private String text;
	private long hashtag;
	private String screenName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getHashtag() {
		return hashtag;
	}

	public void setHashtag(long hashtag) {
		this.hashtag = hashtag;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
