package br.unipar.pdvtrabalho.models;

import br.unipar.pdvtrabalho.dtos.ProdutoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String descricao;

    @NotNull
    private Double valor;

    @NotNull
    @NotBlank
    @NotEmpty
    private String categoria;

    public static Produto requestToProduto(ProdutoRequest dto){
        return new Produto(0, dto.getDescricao(),dto.getValor(), dto.getCategoria());
    }
}

