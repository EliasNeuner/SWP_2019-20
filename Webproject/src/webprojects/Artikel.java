package webprojects;

public class Artikel {
	int id;
	String headline;
	String text;
	
	public Artikel(int id, String headline, String text) {
		this.id = id;
		this.headline = headline;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
