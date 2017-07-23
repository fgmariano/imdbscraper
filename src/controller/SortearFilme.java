package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JList;
import javax.swing.JTextField;

import model.Movie;

public class SortearFilme implements ActionListener {
	
	private JTextField filme;
	private JList<Movie> list;
	private Random rand = new Random();
	
	public SortearFilme(JTextField filme, JList<Movie> list) {
		this.filme = filme;
		this.list = list;
	}
	
	public int sortearPosicao() {
		return rand.nextInt(250);
	}
	
	public void getSorteado() {
		int i = sortearPosicao();
		list.setSelectedIndex(i);
		list.ensureIndexIsVisible(i);
		filme.setText( list.getSelectedValue().getName() );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getSorteado();
		
	}
	
}
