package br.unipar.pdvtrabalho.dtos;

import br.unipar.pdvtrabalho.models.Cliente;
import br.unipar.pdvtrabalho.models.ItemVenda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendaRequest {
    private String observacao;
    private Date dtVenda;
    private double vlTotal;
    private Cliente cliente;
    private List<ItemVenda> listaProdutos;
}
