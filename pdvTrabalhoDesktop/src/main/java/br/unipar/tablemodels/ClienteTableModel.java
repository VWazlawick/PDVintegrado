package br.unipar.tablemodels;

import br.unipar.models.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClienteTableModel extends DefaultTableModel {

    public ClienteTableModel() {
        this.addColumn("ID");
        this.addColumn("Nome");
        this.addColumn("Telefone");
    }

    public ClienteTableModel(List<Cliente> lista) {
        this();

        for(Cliente cliente : lista){
            this.addRow(new String[]{
                    String.valueOf(cliente.getId()),
                    cliente.getNome(),
                    cliente.getTelefone()});
        }
    }

    public Cliente getSelectedItem(JTable jTable, List<Cliente> lista){
        int itemSelected = jTable.getSelectedRow();

        if(itemSelected != -1){
            return lista.get(itemSelected);
        }else{
            return null;
        }

    }
}
