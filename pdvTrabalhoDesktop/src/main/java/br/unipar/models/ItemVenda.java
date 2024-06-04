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
public class ItemVenda {
    private int id;
    private int quantidade;
    private double vlUnitario;
    private double vlTotal;
    private Venda venda;
    private Produto produto;

    @Override
    public String toString() {
        return "ItemVenda{" +
                "\nid=" + id +
                ", \nquantidade=" + quantidade +
                ", \nvlUnitario=" + vlUnitario +
                ", \nvlTotal=" + vlTotal +
                ", \nvenda=" + venda +
                ", \nproduto=" + produto +
                '}';
    }

    public static ItemVenda fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ItemVenda itemVenda = mapper.readValue(json, ItemVenda.class);
        return itemVenda;
    }

    public static List<ItemVenda> unmarshallFromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<ItemVenda> itemVendas = mapper.readValue(json, new TypeReference<List<ItemVenda>>() {});
        return itemVendas;
    }

    public static String marshallToJson(ItemVenda itemVenda) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(itemVenda);
    }
}
