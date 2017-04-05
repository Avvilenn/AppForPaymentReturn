import com.avvilenn.student.domain.PersonAdult;
import com.avvilenn.student.managers.LogInManager;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

/**
 * Created by просто on 05.04.2017.
 */
public class testForDao {

    @Test
    public void testAddPerson() throws Exception {
        PersonAdult person = new PersonAdult();
        person.setEmail("email");
        person.setPassword("password");
        LogInManager manager = LogInManager.getInstance();
        Long id = manager.addPersonLogIn(person);
        System.out.print(id);

    }
}
