package Manage_Stock;

import java.io.IOException;

/**
 * Created by Jason.
 */
public interface Sinter
{
    String addStock(String iId, String quant);

    String remStock(String iId, String quant);

    String getAllStock();

    String getStockItem(String iId);

    void checkStock() throws IOException;
}
