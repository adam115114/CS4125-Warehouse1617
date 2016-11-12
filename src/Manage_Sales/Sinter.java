package Manage_Sales;

import java.io.IOException;

interface Sinter {
    boolean addToCart(int num, int quan) throws IOException;

    void invoice() throws IOException;

    void updates();

    String currentDate();
}
