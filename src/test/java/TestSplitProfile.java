import com.starkbank.SplitProfile;
import com.starkbank.Settings;
import com.starkbank.utils.Generator;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestSplitProfile {

    @Test
    public void testQuery() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        Generator<SplitProfile> splitProfiles = SplitProfile.query(params);

        int i = 0;
        for (SplitProfile splitProfile : splitProfiles) {
            i += 1;
            Assert.assertNotNull(splitProfile.id);
        }
        System.out.println(i);
    }


    @Test
    public void testGet() throws Exception {
        Settings.user = utils.User.defaultProject();

        HashMap<String, Object> params = new HashMap<>();
        params.put("limit", 1);
        Generator<SplitProfile> splitProfiles = SplitProfile.query(params);

        for (SplitProfile splitProfile : splitProfiles) {
            SplitProfile found = SplitProfile.get(splitProfile.id);
            Assert.assertNotNull(found.id);
            Assert.assertEquals(found.id, splitProfile.id);
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
            SplitProfile.Page page = SplitProfile.page(params);
            for (SplitProfile splitProfile : page.splitProfiles) {
                if (ids.contains(splitProfile.id)) {
                    throw new Exception("repeated id");
                }
                ids.add(splitProfile.id);
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
        Generator<SplitProfile.Log> logs = SplitProfile.Log.query(params);

        for (SplitProfile.Log log : logs) {
            Assert.assertNotNull(log.id);
        }
    }
}

