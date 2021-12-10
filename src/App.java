
import Controller.ProductController;
import View.ProductView;
import java.awt.EventQueue;

/**
 *
 * @author Pham Van Cuong - KTPM K17A
 */
public class App {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductView view = new ProductView();

                ProductController controller = new ProductController(view);

                controller.showProductView();
            }
        });
    }
}
