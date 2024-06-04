package br.unipar.pdvtrabalho.models;

import br.unipar.pdvtrabalho.dtos.ItemVendaRequest;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private int quantidade;

    @NotNull
    private Double vlUnitario;

    @NotNull
    private Double vlTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "venda_id", referencedColumnName = "id")
    private Venda venda;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    public static ItemVenda requestToItemVenda(ItemVendaRequest dto){
        return new ItemVenda(0, dto.getQuantidade(), dto.getVlUnitario(), dto.getVlTotal(), dto.getVenda(), dto.getProduto());
    }
}
