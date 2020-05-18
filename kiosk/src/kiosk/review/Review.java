package kiosk.review;

public class Review {
	private int num;
	private String name;
	private String title;
	private String santance;

	public Review() {
	}

	public Review(int num, String name, String title, String santance) {
		this.num = num;
		this.name = name;
		this.title = title;
		this.santance = santance;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSantance() {
		return santance;
	}

	public void setSantance(String santance) {
		this.santance = santance;
	}

	@Override
	public String toString() {
		return "글번호=" + num + ", 사용자ID=" + name + ", 제목=" + title;
	}

}
