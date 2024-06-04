package br.unipar.pdvtrabalho.models;

import br.unipar.pdvtrabalho.dtos.VendaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String observacao;

    @NotNull
    private Date dtVenda;

    @NotNull
    private Double vlTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;


    public static Venda requestToVenda(VendaRequest dto){
        return new Venda(0,dto.getObservacao(),dto.getDtVenda(),dto.getVlTotal(),dto.getCliente());
    }
}
