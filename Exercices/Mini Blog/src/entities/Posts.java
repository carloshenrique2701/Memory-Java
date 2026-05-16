package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Posts {
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comments> comments = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Posts () {
	}

	public Posts(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void addLikes(Integer likes) {
		this.likes += likes;
	}
	public void removeLikes(Integer likes) {
		this.likes -= likes;
	}
	public List<Comments> getComments() {
		return comments;
	}

	public void addComment(Comments comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comments comment) {
		comments.remove(comment);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Posted at " + sdf.format(moment));
		sb.append("\n " + title);
		sb.append("\n" + content);
		sb.append("\n 🤍​" + likes + " 💬 ​" + comments.size());
		
		for (Comments c : comments) {
			sb.append("\nComments: " + c.getComment());
		}
		
		return sb.toString();
	}
	
	
	
}
