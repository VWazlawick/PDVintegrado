package br.unipar.pdvtrabalho.dtos;

import br.unipar.pdvtrabalho.models.Produto;
import br.unipar.pdvtrabalho.models.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemVendaRequest {
    private int quantidade;
    private double vlUnitario;
    private double vlTotal;
    private Venda venda;
    private Produto produto;
}
