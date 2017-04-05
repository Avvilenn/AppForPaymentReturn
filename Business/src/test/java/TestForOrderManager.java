import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.domain.PersonChild;
import com.avvilenn.student.domain.StudentOrder;
import com.avvilenn.student.managers.LogInManager;
import com.avvilenn.student.managers.OrderManager;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestForOrderManager {
    @Test
    public void testAddPerson() throws Exception {
        PersonAdult wife = new PersonAdult();
        PersonAdult husbant = new PersonAdult();
        PersonChild child = new PersonChild();
        PersonChild kid2 = new PersonChild();
        OrderManager manager = OrderManager.getInstance();
        StudentOrder order = new StudentOrder();


        husbant.setSurName("husband_surName");
        husbant.setGivenName("husband_givenName");
        husbant.setPatronymic("husband_patronymic");
        husbant.setPassportNumber("husband_passportNumber");
        husbant.setPassportSeria("husband_passportSeria");
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        husbant.setPassportDateIssue(formatter.parse("12-01-1800"));
        husbant.setPassportDateExpire(formatter.parse("12-01-1800"));
        husbant.setDateOfBirth(formatter.parse("12-01-1800"));


        wife.setSurName("wife_surName");
        wife.setGivenName("wife_givenName");
        wife.setPatronymic("wife_patronymic");
        wife.setPassportNumber("wife_passportNumber");
        wife.setPassportSeria("wife_passportSeria");
        wife.setPassportDateIssue(formatter.parse("12-01-1800"));
        wife.setPassportDateExpire(formatter.parse("12-01-1800"));
        wife.setDateOfBirth(formatter.parse("12-01-1800"));

        order.setWife(wife);
        order.setHusband(husbant);
        order.setEmail("email@mail.ru");

        child.setSurName("surName");
        child.setGivenName("givenName");
        child.setPatronymic("patronymic");
        child.setDateOfBirth(formatter.parse("12-01-1800"));
        child.setBirthDocument("birthDocument");

        kid2.setSurName("surName");
        kid2.setGivenName("givenName");
        kid2.setPatronymic("patronymic");
        kid2.setDateOfBirth(formatter.parse("12-01-1800"));
        kid2.setBirthDocument("birthDocument");

        List<PersonChild> children = new ArrayList<PersonChild>();
        children.add(child);
        children.add(kid2);
        order.setChildren(children);

        for (int i = 0; i <12; i++) {
            Long id = manager.addOrder(order);
            System.out.println(id);
        }

    }

}
