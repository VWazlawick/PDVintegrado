package br.unipar.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    private int id;
    private String observacao;
    private Date dtVenda;
    private Double vlTotal;
    private Cliente cliente;
    private List<ItemVenda> listaProdutos;

    @Override
    public String toString() {
        return "Venda{" +
                "\nid=" + id +
                ", \nobservacao='" + observacao + '\'' +
                ", \ndtVenda=" + dtVenda +
                ", \nvlTotal=" + vlTotal +
                ", \ncliente=" + cliente +
                ", \nitensVenda=" + listaProdutos +
                '}';
    }

    public static Venda fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Venda venda = mapper.readValue(json, Venda.class);
        return venda;
    }

    public static List<Venda> unmarshallFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Venda> vendas = mapper.readValue(json, List.class);
        return vendas;
    }

    public static String marshallToJson(Venda venda) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(venda);
    }
}
