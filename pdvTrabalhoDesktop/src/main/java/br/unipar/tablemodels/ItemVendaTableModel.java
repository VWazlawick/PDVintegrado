package br.unipar.tablemodels;

import br.unipar.models.ItemVenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ItemVendaTableModel extends DefaultTableModel {

    public ItemVendaTableModel(){
        this.addColumn("Produto");
        this.addColumn("Quantidade");
        this.addColumn("Valor Unitário");
        this.addColumn("Valor total");
    }

    public ItemVendaTableModel(List<ItemVenda> lista){
        this();

        for(ItemVenda itemVenda : lista){
            this.addRow(new String[] {
                    itemVenda.getProduto().getDescricao(),
                    String.valueOf(itemVenda.getQuantidade()),
                    String.valueOf(itemVenda.getVlUnitario()),
                    String.valueOf(itemVenda.getVlTotal())
            });
        }
    }

    public ItemVenda getSelectedItem(JTable jTable, List<ItemVenda> lista){
        int itemSelected = jTable.getSelectedRow();

        if(itemSelected != -1){
            return lista.get(itemSelected);
        }
        else{
            return null;
        }
    }
}
