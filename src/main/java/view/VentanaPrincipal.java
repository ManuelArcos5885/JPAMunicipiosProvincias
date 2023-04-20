package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMunicipio;
import controller.ControladorProvincia;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_municipio;
	private static JTextField textField_1;
	private static List<Municipio> listaMunicipios = new ArrayList<Municipio>();
	private static JComboBox<Municipio> comboBox_Municipios = new JComboBox<Municipio>();
	private static JComboBox comboBox_Provincias = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		textField_municipio = new JTextField();
		GridBagConstraints gbc_textField_municipio = new GridBagConstraints();
		gbc_textField_municipio.gridwidth = 6;
		gbc_textField_municipio.insets = new Insets(0, 0, 5, 5);
		gbc_textField_municipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_municipio.gridx = 0;
		gbc_textField_municipio.gridy = 0;
		contentPane.add(textField_municipio, gbc_textField_municipio);
		textField_municipio.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaMunicipios = ControladorMunicipio.findLikeNombre(textField_municipio.getText());
				rellenarcomboMunicipios(listaMunicipios);
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		comboBox_Municipios = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 6;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox_Municipios, gbc_comboBox);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Municipio m = (Municipio) comboBox_Municipios.getSelectedItem();
				
				m = ControladorMunicipio.findById(m.getId());
				
				mostrarDatosMunicipio(m);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Municipio Seleccionado:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_panel.columnWidths = new int[]{0};
//		gbl_panel.rowHeights = new int[]{0};
//		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 9;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 0;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia del municipio: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox_Provincias = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridwidth = 9;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 1;
		panel.add(comboBox_Provincias, gbc_comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.gridx = 11;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 13;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		
		cargarTodasProvincias();
	}
	
	
	/**
	 * 
	 * 
	 */
	
	public static void limpiarMunicipios() {
		comboBox_Municipios.removeAllItems();
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void rellenarcomboMunicipios(List<Municipio> municipios) {
		limpiarMunicipios();
		
		
		for (Municipio municipio : municipios) {
			comboBox_Municipios.addItem(municipio);
		}
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void mostrarDatosMunicipio(Municipio m) {
		textField_1.setText(m.getNombre());
		List<Provincia> ps = ControladorProvincia.findAllProvincias();
		
		Municipio mu = (Municipio) comboBox_Municipios.getSelectedItem();
		
		for (int i = 0; i < ps.size(); i++) {
			Provincia provincia = (Provincia) comboBox_Provincias.getItemAt(i);
			
			if (provincia.getId() == mu.getProvincia().getId()) {
				comboBox_Provincias.setSelectedIndex(i);
			}
		}
	}
	
		
	
	
	/**
	 * 
	 * 
	 * 
	 */
	public static void cargarTodasProvincias() {
		limpiarMunicipios();
		
		List<Provincia> provincias = ControladorProvincia.findAllProvincias();
		for (Provincia p : provincias) {
			comboBox_Provincias.addItem(p);
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public static void guardar() {
		
		Provincia p = (Provincia) comboBox_Provincias.getSelectedItem();
		
		Municipio mu = (Municipio) comboBox_Municipios.getSelectedItem();
		
		
		mu.setNombre(textField_1.getText());
		mu.setProvincia(p);
		
		ControladorMunicipio.guardar(mu);
		
		JOptionPane.showMessageDialog(null, "Se ha guadado los datos con exito");
		
	}
}
