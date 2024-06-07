package br.unipar.tablemodels;

import br.unipar.frame.PesquisarProdutoFrame;
import br.unipar.models.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PesquisarProdutoTableModel extends DefaultTableModel {

    public PesquisarProdutoTableModel(){
        this.addColumn("Nome Produto");
    }

    public PesquisarProdutoTableModel(List<Produto> lista){
        this();

        for(Produto produto : lista){
            this.addRow(new String[]{
                    produto.getDescricao()
            });
        }
    }

    public Produto getItemSelected(JTable jTable, List<Produto> lista){
        int itemSelected = jTable.getSelectedRow();

        if(itemSelected != -1){
            return lista.get(itemSelected);
        }
        else{
            return null;
        }
    }
}
