package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Movie {

	public String title;
	public String director;
	public String duration;
	public String releaseDate;
	public String contentRating; // this is the audience rating. Example: R, PG, PG-13

	public Movie() {
		this.title = this.getTitle();
		this.director = this.getDirector();
		this.duration = this.getDuration();
		this.releaseDate = this.getReleaseDate();
		this.contentRating = this.getContentRating();
	}

	public Movie(String title, String director, String duration, String releaseDate, String contentRating) {
		this.title = title;
		this.director = director;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.contentRating = contentRating;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
}
