package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JList;

import model.Movie;

public class AbrirFilme implements ActionListener {
	private JList<Movie> list;
	
	public AbrirFilme(JList<Movie> list) {
		this.list = list;
	}
	
//	Open with default browser
	public void abrir(String link) {
		Desktop desktop = Desktop.getDesktop();  
		URI uri = null;  
		try {  
			uri = new URI(link);
		    desktop.browse(uri);  
		} catch(IOException ioe) {  
		    ioe.printStackTrace();  
		} catch(URISyntaxException use) {  
			use.printStackTrace();  
		}
	}
	
//	Open with custom browser
//	public void abrir(String link) {
//		Runtime run = Runtime.getRuntime();
//		try {
//			run.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + link);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public String prepareLink() {
		return "http://www.imdb.com" + list.getSelectedValue().getUrl();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		abrir(prepareLink());
		
	}
}
