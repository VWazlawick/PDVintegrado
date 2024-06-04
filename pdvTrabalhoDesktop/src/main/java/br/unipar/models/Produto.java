package br.unipar.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private Long id;
    private String descricao;
    private double valor;
    private String categoria;

    @Override
    public String toString() {
        return "Produto{" +
                "\nid=" + id +
                ", \ndescricao='" + descricao + '\'' +
                ", \nvalor=" + valor +
                ", \ncategoria='" + categoria + '\'' +
                '}';
    }

    public static Produto fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Produto produto = mapper.readValue(json, Produto.class);
        return produto;
    }

    public static List<Produto> unmarshallFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Produto> produtos = mapper.readValue(json, new TypeReference<List<Produto>>() {});
        return produtos;
    }

    public static String marshallToJson(Produto produto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(produto);
    }
}
