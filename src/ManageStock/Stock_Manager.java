package ManageStock;

import DatabaseManager.DataReader;
import Objects.Stock;

import java.io.IOException;

/**
 * Created by Jason.
 */
public class Stock_Manager implements Sinter
{
    //private ArrayList<Stock> stock = new ArrayList<>();
    DataReader e = new DataReader();
    private boolean NF;

    public Stock_Manager() throws IOException {
    }

    public String addStock(String iId, String quant)
    {
        for (Stock s: e.stock)
        {
            try {
                if (s.getStockNum() == Integer.parseInt(iId))
                {
                    s.setQuantity(Integer.parseInt(quant) + s.getQuantity());
                    NF = false;
                    e.update();
                    break;
                } else { NF = true; }
            } catch (NumberFormatException exc) {
                return "Failed to convert ItemID to int.";
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (NF)
            return "Failed to find an Item with id: " + iId;
        else {
            return "Succeeded the quantity update.";
        }
    }

    public String remStock(String iId, String quant)
    {
        for (Stock s: e.stock)
        {
            try {
                if (s.getStockNum() == Integer.parseInt(iId))
                {
                    s.setQuantity(s.getQuantity() - Integer.parseInt(quant));
                    NF = false;
                    e.update();
                    break;
                }
            } catch (NumberFormatException exc) {
                return "Failed to convert to an Int.";
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (NF)
            return "Failed to find an Item with id: " + iId;
        else
            return "Succeeded removing the quantity.";
    }

    public String getAllStock()
    {
        String str = "";
        for (Stock s : e.stock)
        {
            str += "ID: " + s.getStockNum() + ", Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n";
        }
        return str;
    }

    public String getStockItem(String iId)
    {
        if (iId.matches("[0-9]+")) {
            try {
                int inputNum = Integer.parseInt(iId);
                for (Stock s : e.stock) {
                    if (s.getStockNum() == inputNum) {
                        return "Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n";
                    }
                }
            } catch (NumberFormatException exc) {
                return "ERROR";
            }
        }
        return "ERROR";
    }
}
