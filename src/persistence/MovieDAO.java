package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Movie;

public class MovieDAO {
	
	public void adicionar( Movie movie ) {
		try {
			Connection con = GenericDAO.getInstance().getCon();
			PreparedStatement ps = con.prepareStatement( "INSERT INTO movie VALUES (?, ?);" );
			ps.setString(1, movie.getName());
			ps.setString(2, movie.getUrl());
			ps.execute();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Movie> listar() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		
		try {
			Connection con = GenericDAO.getInstance().getCon();
			PreparedStatement ps = con.prepareStatement( "SELECT * FROM movie;" );
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Movie m = new Movie();
				m.setName( rs.getString("name") );
				m.setUrl( rs.getString("url") );
				list.add( m );
			}
			rs.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void delete() {
		try {
			Connection con = GenericDAO.getInstance().getCon();
			PreparedStatement ps = con.prepareStatement( "DELETE FROM movie;" );
			ps.execute();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
