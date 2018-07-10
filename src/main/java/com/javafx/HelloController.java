package com.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;

import com.castillo.funciones.ClienteImpl;
import com.castillo.funciones.Clientes;
import com.castillo.jaxws.clientes.Cliente;

public class HelloController
{


    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField lastNameField;
    @FXML private Label messageLabel;

    public void sayHello() {

        String id = idField.getText();
        String nombre = nameField.getText();
        String lastName = lastNameField.getText();
       
        Cliente cliente = new Cliente();
        
        cliente.setId(Integer.parseInt(id));
        cliente.setNombre(nombre);
        cliente.setApellido(lastName);
        
        Clientes clientes = new ClienteImpl();
        
        clientes.addCliente(cliente);
        
        
        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(id)) {
            builder.append(id);
        }

        if (!StringUtils.isEmpty(nombre)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(nombre);
        }
        
        if(!StringUtils.isEmpty(lastName)){
        	builder.append(" ").append(lastName);
        }

        if (builder.length() > 0) {
            String name = builder.toString();

            messageLabel.setText("Hello " + name);
        } else {
            messageLabel.setText("Hello mysterious person");
        }
    }

}
