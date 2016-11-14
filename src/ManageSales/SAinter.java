package ManageSales;

import java.io.IOException;

interface SAinter {
    boolean addToCart(int num, int quan) throws IOException;

    void invoice() throws IOException;

    void updates();

    String currentDate();
}
