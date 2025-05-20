package br.com.fiap.winery;

import jakarta.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    public String getMenu() {
        Map<String, List<String>> menu = new LinkedHashMap<>();

        menu.put("Cabernet Sauvignon", List.of("Cabernet Reserva 2018", "Cabernet Classic 2020"));
        menu.put("Merlot", List.of("Merlot Envelhecido 2019", "Merlot Jovem 2021"));
        menu.put("Chardonnay", List.of("Chardonnay Ouro 2022", "Chardonnay Leve 2023"));
        menu.put("Pinot Noir", List.of("Pinot Noir Premium 2017", "Pinot Noir Suave 2021"));

        StringBuilder menuString = new StringBuilder("Menu de Vinhos por Tipo de Uva:\n");

        for (Map.Entry<String, List<String>> entry : menu.entrySet()) {
            menuString.append("\n").append(entry.getKey()).append(":\n");
            for (String wine : entry.getValue()) {
                menuString.append(" - ").append(wine).append("\n");
            }
        }

        return menuString.toString();
    }

    @Override
    public String placeOrder(String name, int quantity) {
        return "Pedido confirmado";
    }
}
