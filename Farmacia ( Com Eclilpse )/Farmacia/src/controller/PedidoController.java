
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import modelo.Medicamento;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class PedidoController implements Initializable {

    @FXML  
    private TableView<Medicamento> tabelaMedicamentos;
    
    @FXML 
    private TableColumn<Medicamento,Integer> id;
    
    @FXML 
    private TableColumn<Medicamento,String> nome;
    
    @FXML 
    private TableColumn<Medicamento,Double> qtdEstoque;
    
    @FXML 
    private TableColumn<Medicamento,Double> valor;
    
    
    
    private int number = 1;
    
    final ObservableList<Medicamento> data = FXCollections.observableArrayList(
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"Dipirona",1000.0,2.99),
            new Medicamento(number++,"DorFlex" ,500.0,3.45)
    );
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        id.setCellValueFactory(new PropertyValueFactory<Medicamento,Integer>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<Medicamento,String>("nome"));
        qtdEstoque.setCellValueFactory(new PropertyValueFactory<Medicamento,Double>("qtdEstoque"));
        valor.setCellValueFactory(new PropertyValueFactory<Medicamento,Double>("valor"));
        
        
        tabelaMedicamentos.setItems(data);
        addButtonToTable();
        
    }    
    
    private void addButtonToTable() {
        TableColumn<Medicamento, Void> colBtn = new TableColumn("Editar");

        Callback<TableColumn<Medicamento, Void>, TableCell<Medicamento, Void>> cellFactory;
        cellFactory = (final TableColumn<Medicamento, Void> param) -> {
            final TableCell<Medicamento, Void> cell = new TableCell<Medicamento, Void>() {
                
                private final Button btn = new Button("Editar");
                
                {
                    btn.setOnAction((ActionEvent event) -> {
                        Medicamento medicamento = getTableView().getItems().get(getIndex());
                        System.out.println("selectedData: " + data);
                    });
                }
                
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };

        colBtn.setCellFactory(cellFactory);

        tabelaMedicamentos.getColumns().add(colBtn);

    }
    
}
