package br.unipar.pdvtrabalho.models;

import br.unipar.pdvtrabalho.dtos.ClienteRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Length(min = 3, max = 128)
    private String nome;

    @Pattern(regexp = "^$|^(?:\\(?\\d{2,3}\\)?[- ]?)?(?:\\d{4,5})[- ]?(?:\\d{4})?$" , message = "Formato inválido para telefone")
    @Length( max = 14)
    private String telefone;

    @Length(max = 128)
    private String email;

    public static Cliente requestToCliente(ClienteRequest dto){
        return new Cliente(0, dto.getNome(), dto.getTelefone(), dto.getEmail());
    }
}
