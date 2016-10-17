package co.grandcircus.finalproject.model;
/*   Twitter model is used to get the messages from the twitter
 * 
 */
public class Twitter {
	private String user;
	private long id;
	private String text;
	
	

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
}
