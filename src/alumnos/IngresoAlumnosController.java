/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author luiscruz
 */
public class IngresoAlumnosController implements Initializable {
    
    @FXML
    TextField matriculaF,cedulaF,nombreF,fechaF,direccionF,telefonosF,discapacidadF,generoF,padreF,madreF,repF,repTelF,institucionF;
    @FXML
    ComboBox cursoBox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Conexion.statement=Conexion.connection.createStatement();
            Conexion.result=Conexion.statement.executeQuery("Select nombreC,paralelo FROM Curso WHERE estado=\"ACTIVO\"");
            while(Conexion.result.next()){
                cursoBox.getItems().add(Conexion.result.getString("nombreC")+" "+Conexion.result.getString("paralelo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoAlumnosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Conexion.result.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngresoAlumnosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Conexion.statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(IngresoAlumnosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    public void ingresarAlumno(ActionEvent event) throws SQLException{
        Conexion.statement=Conexion.connection.createStatement();
        String matricula=matriculaF.getText();
        String cedula=cedulaF.getText();
        String nombre=nombreF.getText();
        String fecha=fechaF.getText();
        String direccion=direccionF.getText();
        String telefonos=telefonosF.getText();
        String discapacidad=discapacidadF.getText();
        String genero=generoF.getText();
        String padre=padreF.getText();
        String madre=madreF.getText();
        String rep=repF.getText();
        String repTel=repTelF.getText();
        String institucion=institucionF.getText();
        Conexion.result=Conexion.statement.executeQuery("Select NO_Matricula From Matricula");
        
    }
}
