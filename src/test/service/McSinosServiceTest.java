package test.service;

import mcsinos.service.McSinosService;
import mcsinos.entity.Order;
import mcsinos.enumerator.MenuItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class McSinosServiceTest {

    @Test
    public void shouldDeliveredFirst(){
        McSinosService service = new McSinosService();

        Order orderOne = new Order(1,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.SODA);
        Order orderTwo = new Order(2,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.ICE_CREAM);
        service.order(orderOne);
        service.order(orderTwo);
        Order delivered = service.delivery();
        assertEquals(orderOne, delivered);
    }

    @Test
    public void shouldShowQueue(){
        McSinosService service = new McSinosService();
        Order orderOne = new Order(1,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.SODA);
        Order orderTwo = new Order(2,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.ICE_CREAM);
        service.order(orderOne);
        service.order(orderTwo);
        service.delivery();
        String queue = service.showOrderQueue();
        assertEquals("2 → Hamburguer, French fries, Ice cream", queue);
    }

    @Test
    public void shouldShowQueueWithMoreThanOneProduct(){
        McSinosService service = new McSinosService();
        Order orderOne = new Order(1,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.SODA);
        Order orderTwo = new Order(2,MenuItem.HAMBURGUER, MenuItem.FRENCH_FRIES, MenuItem.ICE_CREAM);
        service.order(orderOne);
        service.order(orderTwo);
        String queue = service.showOrderQueue();
        assertEquals("1 → Hamburguer, French fries, Soda\n2 → Hamburguer, French fries, Ice cream", queue);
    }
}
