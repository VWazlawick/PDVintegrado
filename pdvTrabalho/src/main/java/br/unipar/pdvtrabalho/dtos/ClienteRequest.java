package br.unipar.pdvtrabalho.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    private String nome;
    private String email;
    private String telefone;
}
