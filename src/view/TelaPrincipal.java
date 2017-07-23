package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AbrirFilme;
import controller.MovieController;
import controller.SortearFilme;
import model.Movie;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel<Movie> model = new DefaultListModel<Movie>();
	private MovieController control;
	private AbrirFilme abrir;
	private SortearFilme sortear;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaPrincipal() {
		setTitle("IMBD's Movie Chooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 283);
		contentPane.add(scrollPane);
		
		JList<Movie> list = new JList<Movie>(model);
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(10, 303, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(177, 354, 89, 23);
		contentPane.add(btnAbrir);
		
		JButton btnSortear = new JButton("Sortear");
		btnSortear.setBounds(52, 354, 89, 23);
		contentPane.add(btnSortear);
		
		control = new MovieController(model);
		abrir = new AbrirFilme(list);
		sortear = new SortearFilme(textField, list);
//		control.updateList();
		control.arrayToList();
		
		btnAbrir.addActionListener( abrir );
		btnSortear.addActionListener( sortear );
		
		list.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Movie) {
                    ((JLabel) renderer).setText(((Movie) value).getName());
                }
                return renderer;
            }
        });
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(309, 354, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnAtualizar.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				control.updateList();
				
			}
			
		});
		
	}
}
