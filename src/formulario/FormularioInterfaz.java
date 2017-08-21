/**
 * @author: Miranda Sanchez Maria Fernanda
 * Grupo: 5IM8
 *  
*/

package formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormularioInterfaz extends JFrame implements ActionListener {
    
    JTextField TNombreUsuario, TApellidoP, TApellidoM, TEscuela;
    JLabel LNombreUsuario, LApellidoP, LApellidoM, LEscuela, Bienvenida;
    JButton BotonGuardar; 
    
    Validaciones val = new Validaciones();
    public FormularioInterfaz(){
        InicializarVentana();
        InicializarComponentes();
    }
    
    public void InicializarVentana(){
        setTitle("FORMULARIO");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    public void InicializarComponentes(){
       
        //JTextField
        TNombreUsuario = new JTextField();
        TApellidoP = new JTextField();
        TApellidoM = new JTextField();
        TEscuela = new JTextField();
        //JLabel
        Bienvenida = new JLabel("BIENVENIDOS");
        LNombreUsuario = new JLabel("Introduce tu nombre: ");
        LApellidoP = new JLabel("Apellido paterno");
        LApellidoM = new JLabel("Apellido materno");
        LEscuela = new JLabel("Escuela");
        //Botones
        BotonGuardar = new JButton("GUARDAR");
        
        setLayout(new BorderLayout());
        add(Bienvenida, BorderLayout.NORTH);
        add(UbicacionCentro(), BorderLayout.CENTER);
        add(BotonGuardar, BorderLayout.SOUTH);
   
        
        BotonGuardar.addActionListener(this);
         val.SLetras(TNombreUsuario);
        val.SLetras(TApellidoP);
        val.SLetras(TApellidoM);
        val.SLetras(TEscuela);
        
    }
    
    private JPanel UbicacionCentro(){
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(LNombreUsuario);
        centro.add(TNombreUsuario);
        centro.add(LApellidoP);
        centro.add(TApellidoP);
        centro.add(LApellidoM);
        centro.add(TApellidoM);
        centro.add(LEscuela);
        centro.add(TEscuela);
        return centro;
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BotonGuardar){
            Conexion ObjetoConexion = new Conexion();
            ObjetoConexion.getConexion();
            String Nombre = TNombreUsuario.getText();
            String APP = TApellidoP.getText();
            String APM = TApellidoM.getText();
            String Escuela = TEscuela.getText();
            
            ObjetoConexion.SubirDatos(Nombre, APP, APM, Escuela);
            JOptionPane.showMessageDialog(null, "ALTA COMPLETADA");
        }
    }        
}