package br.unipar.tablemodels;

import br.unipar.models.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProdutoTableModel extends DefaultTableModel {

    public ProdutoTableModel(){
        this.addColumn("ID");
        this.addColumn("Descrição");
        this.addColumn("Categoria");
    }

    public ProdutoTableModel(List<Produto> lista){
        this();

        for(Produto produto : lista){
            this.addRow(new String[]{
                    String.valueOf(produto.getId()),
                    produto.getDescricao(),
                    produto.getCategoria()});
        }
    }

    public Produto getSelectedItem(JTable jtable, List<Produto> lista){
        int itemSelected = jtable.getSelectedRow();

        if(itemSelected!=-1){
            return lista.get(itemSelected);
        }
        else{
            return null;
        }
    }
}
