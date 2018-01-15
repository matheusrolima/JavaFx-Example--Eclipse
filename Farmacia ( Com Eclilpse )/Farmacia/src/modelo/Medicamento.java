package modelo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Medicamento {
    
    private  SimpleIntegerProperty id;
    private  SimpleStringProperty nome;
    private  SimpleDoubleProperty qtdEstoque;
    private  SimpleDoubleProperty valor;

    public Medicamento(Integer id, String nome, Double qtdEstoque, Double valor) {
        this.id = new SimpleIntegerProperty (id);
        this.nome = new SimpleStringProperty (nome);
        this.qtdEstoque = new SimpleDoubleProperty (qtdEstoque);
        this.valor = new SimpleDoubleProperty (valor);
    }
    
    public Integer getId(){
        return this.id.get();
    }
    
    public void setId(Integer id){
        this.id.set(id);
    }
    
    public String getNome()
    {
        return this.nome.get();
    }
    
    public void setNome(String nome){
        this.nome.set(nome);
    }
    
    public Double getQtdEstoque(){
        return this.qtdEstoque.get();
    }
    
    public void setQtdEstoque(Double qtd)
    {
        this.qtdEstoque.set(qtd);
    }
    
    public Double getValor(){
        return this.valor.get();
    }
    
    public void setValor(Double valor){
        this.valor.set(valor);
    }
    
    
}
