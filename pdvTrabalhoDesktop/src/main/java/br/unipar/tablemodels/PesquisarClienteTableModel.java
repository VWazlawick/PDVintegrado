package br.unipar.tablemodels;

import br.unipar.frame.PesquisarClienteFrame;
import br.unipar.models.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PesquisarClienteTableModel extends DefaultTableModel {

    public PesquisarClienteTableModel() {
        this.addColumn("Nome Cliente");
    }

    public PesquisarClienteTableModel(List<Cliente> lista) {
        this();

        for(Cliente cliente : lista){
            this.addRow(new String[]{
                    cliente.getNome()
            });
        }
    }

    public Cliente getSelectedItem(JTable jTable, List<Cliente> lista){
        int itemSelected = jTable.getSelectedRow();

        if(itemSelected != -1){
            return lista.get(itemSelected);
        }
        else{
            return null;
        }
    }
}
