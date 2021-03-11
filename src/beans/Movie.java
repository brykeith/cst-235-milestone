package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Movie {

	public int movieID;
	public String title;
	public String director;
	public String duration;
	public String releaseDate;
	public String contentRating; // this is the audience rating. Example: R, PG, PG-13
	public String synopsis;

	public Movie() {
		this.movieID = this.getMovieID();
		this.title = this.getTitle();
		this.director = this.getDirector();
		this.duration = this.getDuration();
		this.releaseDate = this.getReleaseDate();
		this.contentRating = this.getContentRating();
		this.synopsis = this.getSynopsis();
	}

	public Movie(int movieID, String title, String director, String duration, String releaseDate, String contentRating,
			String synopsis) {
		this.movieID = movieID;
		this.title = title;
		this.director = director;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.contentRating = contentRating;
		this.synopsis = synopsis;

	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
}
