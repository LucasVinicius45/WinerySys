package br.com.fiap.winery;

import br.com.fiap.client.generated.WineStockService;
import br.com.fiap.client.generated.WineStockServiceImplementationService;
import br.com.fiap.client.warning.WineWarningService;
import br.com.fiap.client.warning.WineWarningServiceImplementationService;
public class ApplicationClient2 {
    public static void main(String[] args) {
        try {
            // Serviço já existente para WineStockService
            WineStockServiceImplementationService service = new WineStockServiceImplementationService();
            WineStockService wineStockService = service.getWineStockServiceImplementationPort();

            String order = wineStockService.placeOrder("Merlot 2020", 3);
            System.out.println("Resposta do pedido: " + order);

            // Agora para o serviço de warning, só instanciar a classe gerada
            WineWarningServiceImplementationService warningService = new WineWarningServiceImplementationService();

            // Pegar o port para chamar os métodos do serviço
            WineWarningService wineWarningPort = warningService.getWineWarningServiceImplementationPort();

            // Chamar o método sendWarn
            String warn = wineWarningPort.sendWarning();

            System.out.println("Aviso do vinho: " + warn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
