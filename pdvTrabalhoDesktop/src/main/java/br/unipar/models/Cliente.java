package br.unipar.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    @Override
    public String toString() {
        return "Cliente:" +
                "\nid=" + id +
                ", \nnome='" + nome +
                ", \nemail='" + email +
                ", \ntelefone='" + telefone;
    }

    public static Cliente fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Cliente cliente = mapper.readValue(json, Cliente.class);
        return cliente;
    }

    public static List<Cliente> unmarshallFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Cliente> clientes = mapper.readValue(json, new TypeReference<List<Cliente>>(){});

        return clientes;
    }

    public static String marshallToJson(Cliente cliente) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cliente);
    }
}
