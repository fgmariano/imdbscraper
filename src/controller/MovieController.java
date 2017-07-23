package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Movie;
import persistence.MovieDAO;

public class MovieController {
	
	private String url = "http://www.imdb.com/chart/top";
	private DefaultListModel<Movie> model;
	private ArrayList<Movie> list = new ArrayList<Movie>();
	private MovieDAO dao = new MovieDAO();
	
	public MovieController(DefaultListModel<Movie> model) {
		this.model = model;
	}
	
	public void arrayToList() {
		list = dao.listar();
		
		for ( Movie m : list ) {
			model.addElement(m);
		}
	}
	
	public void updateList() {
		dao.delete();
		
		try {
			Document doc = Jsoup.connect(url).get();
	        Elements movie = doc.getElementsByClass("titleColumn");
	        for (Element element : movie) {
	        	Movie m = new Movie();
	        	m.setName( element.getElementsByTag("a").text() );
	        	m.setUrl( element.getElementsByTag("a").attr("href") );
	        	dao.adicionar(m);
	        }
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	}
	    
}
