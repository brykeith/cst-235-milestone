package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import controllers.DatabaseService;

@ManagedBean
public class Movies {
	ArrayList<Movie> movies = new ArrayList<Movie>();
	DatabaseService ds = new DatabaseService();
	
	
	public Movies() throws SQLException, Exception {
		//movies = ds.readAllMovies();
		
		movies.addAll(ds.readAllMovies());
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	
	
}
