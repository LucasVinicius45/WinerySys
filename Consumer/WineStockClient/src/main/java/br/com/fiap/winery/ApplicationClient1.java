package br.com.fiap.winery;

import br.com.fiap.client.generated.WineStockService;
import br.com.fiap.client.generated.WineStockServiceImplementationService;

public class ApplicationClient1 {
    public static void main(String[] args) {
        try {

            WineStockServiceImplementationService service = new WineStockServiceImplementationService();
            WineStockService wineStockService = service.getWineStockServiceImplementationPort();

            String menu = wineStockService.getMenu();
            System.out.println("Menu recebido do serviço: " + menu);

            String resposta = wineStockService.placeOrder("Cabernet Reserva 2018", 2);
            System.out.println("Resposta do pedido: " + resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
