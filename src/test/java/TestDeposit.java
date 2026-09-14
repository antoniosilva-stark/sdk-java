import com.starkbank.Deposit;
import com.starkbank.Settings;
import com.starkbank.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestDeposit {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<Deposit> deposits = Deposit.query(params);

        int i = 0;
        for (Deposit deposit : deposits) {
            i += 1;
            Assert.assertNotNull(deposit.id);
        }
        System.out.println(i);
    }


    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<Deposit> deposits = Deposit.query(params);

        for (Deposit deposit : deposits) {
            Deposit found = Deposit.get(deposit.id);
            Assert.assertNotNull(found.id);
            Assert.assertEquals(found.id, deposit.id);
        }
    }


    @Test
    public void testPage() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 2);
        params.put("cursor", null);

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Deposit.Page page = Deposit.page(params);
            for (Deposit deposit : page.deposits) {
                if (ids.contains(deposit.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(deposit.id);
            }
            if (page.cursor == null) {
                break;
            }
            params.put("cursor", page.cursor);
        }
    }

    @Test
    public void testLogQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<Deposit.Log> logs = Deposit.Log.query(params);

        for (Deposit.Log log : logs) {
            Assert.assertNotNull(log.id);
        }
    }
}

