package Manage_Sales;

import java.io.IOException;

interface Sinter {
    void sale() throws IOException;

    void buy();

    void invoice() throws IOException;

    void cancel();
}
