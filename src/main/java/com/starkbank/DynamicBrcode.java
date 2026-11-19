package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class DynamicBrcode extends Resource {
    /**
     * DynamicBrcode object
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. When a Dynamic Brcode is paid, a Deposit is created with a tag containing "dynamic-brcode/{uuid}" for conciliation.
     * <p>
     * Parameters:
     * amount [integer]: amount in cents to be received. ex: 100 (= R$ 1.00)
     * expiration [integer]: time interval in seconds counted from creation until the brcode expires. After expiration, the brcode cannot be paid anymore.
     * displayDescription [string]: description shown in the payer's bank interface. ex: "Payment for service #1234"
     * rules [list of maps]: list of DynamicBrcode.Rule objects for modifying brcode behavior.
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * id [string]: unique ids returned when the DynamicBrcode is created.
     * uuid [string]: unique ids returned when the DynamicBrcode is created.
     * pictureUrl [string]: public QR Code image URL.
     * updated [string]: update/creation datetimes.
     * created [string]: update/creation datetimes.
     */
    static ClassData data = new ClassData(DynamicBrcode.class, "DynamicBrcode");

    public Number amount;
    public Number expiration;
    public String displayDescription;
    public List<DynamicBrcode.Rule> rules;
    public String[] tags;
    public String uuid;
    public String pictureUrl;
    public String updated;
    public String created;


    /**
     * DynamicBrcode object
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. When a Dynamic Brcode is paid, a Deposit is created with a tag containing "dynamic-brcode/{uuid}" for conciliation.
     * <p>
     * Parameters:
     * @param amount [integer]: amount in cents to be received. ex: 100 (= R$ 1.00)
     * @param expiration [integer]: time interval in seconds counted from creation until the brcode expires. After expiration, the brcode cannot be paid anymore.
     * @param displayDescription [string]: description shown in the payer's bank interface. ex: "Payment for service #1234"
     * @param rules [list of maps]: list of DynamicBrcode.Rule objects for modifying brcode behavior.
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param id [string]: unique ids returned when the DynamicBrcode is created.
     * @param uuid [string]: unique ids returned when the DynamicBrcode is created.
     * @param pictureUrl [string]: public QR Code image URL.
     * @param updated [string]: update/creation datetimes.
     * @param created [string]: update/creation datetimes.
     */
    public DynamicBrcode(Number amount, Number expiration, String[] tags, String id, String uuid, String pictureUrl, String displayDescription, List<DynamicBrcode.Rule> rules, String updated, String created) {
        super(id);
        this.amount = amount;
        this.expiration = expiration;
        this.tags = tags;
        this.uuid = uuid;
        this.pictureUrl = pictureUrl;
        this.displayDescription = displayDescription;
        this.rules = rules;
        this.updated = updated;
        this.created = created;
    }

    /**
     * DynamicBrcode object
     * <p>
     * When you initialize a DynamicBrcode, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. When a Dynamic Brcode is paid, a Deposit is created with a tag containing "dynamic-brcode/{uuid}" for conciliation.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the DynamicBrcode
     * amount [integer]: amount in cents to be received. ex: 100 (= R$ 1.00)
     * expiration [integer]: time interval in seconds counted from creation until the brcode expires. After expiration, the brcode cannot be paid anymore.
     * displayDescription [string]: description shown in the payer's bank interface. ex: "Payment for service #1234"
     * rules [list of maps]: list of DynamicBrcode.Rule objects for modifying brcode behavior.
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * <p>
     * Attributes (return-only):
     * uuid [string]: unique ids returned when the DynamicBrcode is created.
     * pictureUrl [string]: public QR Code image URL.
     * updated [string]: update/creation datetimes.
     * created [string]: update/creation datetimes.
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public DynamicBrcode(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.amount = (Number) dataCopy.remove("amount");
        this.expiration = (Number) dataCopy.remove("expiration");
        this.displayDescription = (String) dataCopy.remove("displayDescription");
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.tags = (String[]) dataCopy.remove("tags");
        this.uuid = null;
        this.pictureUrl = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public DynamicBrcode() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<DynamicBrcode.Rule> parseRules(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<DynamicBrcode.Rule> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof DynamicBrcode.Rule) {
                parsed.add((DynamicBrcode.Rule) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new DynamicBrcode.Rule((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use DynamicBrcode.Rule or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific DynamicBrcode
     * <p>
     * Receive a single DynamicBrcode object previously created in the Stark Bank API by its uuid
     * <p>
     * Parameters:
     * @param id [string]: object unique id
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static DynamicBrcode get(String id) throws Exception {
        return DynamicBrcode.get(id, null);
    }

    /**
     * Retrieve a specific DynamicBrcode
     * <p>
     * Receive a single DynamicBrcode object previously created in the Stark Bank API by its uuid
     * <p>
     * Parameters:
     * @param id [string]: object unique id
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode object with updated attributes
     * @throws Exception error in the request
     */
    public static DynamicBrcode get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(Map<String, Object> params) throws Exception {
        return DynamicBrcode.query(params, null);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query(User user) throws Exception {
        return DynamicBrcode.query(new HashMap<>(), user);
    }

    /**
     * Retrieve DynamicBrcodes
     * <p>
     * Receive a generator of DynamicBrcode objects previously created by this user in the Stark Bank API
     * <p>
     * Return:
     * @return generator of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<DynamicBrcode> query() throws Exception {
        return DynamicBrcode.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<DynamicBrcode> brcodes;
        public String cursor;

        public Page(List<DynamicBrcode> brcodes, String cursor) {
            this.brcodes = brcodes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your brcodes.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return DynamicBrcode.page(params, null);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your brcodes.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return DynamicBrcode.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your brcodes.
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return DynamicBrcode.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged DynamicBrcodes
     * <p>
     * Receive a list of up to 100 DynamicBrcode objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your brcodes.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * uuids [list of strings, default null]: list of uuids to filter retrieved objects. ex: ["901e71f2447c43c886f58366a5432c4b", "4e2eab725ddd495f9c98ffd97440702d"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return DynamicBrcode.Page object:
     * DynamicBrcode.Page.brcodes: list of DynamicBrcode objects with updated attributes
     * DynamicBrcode.Page.cursor: cursor to retrieve the next page of DynamicBrcode objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<DynamicBrcode> brcodes = new ArrayList<>();
        for (SubResource dynamicBrcode: page.entities) {
            brcodes.add((DynamicBrcode) dynamicBrcode);
        }
        return new Page(brcodes, page.cursor);
    }

    /**
     * Create DynamicBrcodes
     * <p>
     * Send a list of DynamicBrcode objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param dynamicBrcodes [list of DynamicBrcode objects or HashMaps]: list of DynamicBrcode objects to be created in the API
     * <p>
     * Return:
     * @return list of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<DynamicBrcode> create(List<?> dynamicBrcodes) throws Exception {
        return DynamicBrcode.create(dynamicBrcodes, null);
    }

    /**
     * Create DynamicBrcodes
     * <p>
     * Send a list of DynamicBrcode objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param dynamicBrcodes [list of DynamicBrcode objects or HashMaps]: list of DynamicBrcode objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of DynamicBrcode objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<DynamicBrcode> create(List<?> dynamicBrcodes, User user) throws Exception {
        List<DynamicBrcode> dynamicBrcodeList = new ArrayList<>();
        for (Object dynamicBrcode : dynamicBrcodes) {
            if (dynamicBrcode instanceof Map) {
                dynamicBrcodeList.add(new DynamicBrcode((Map<String, Object>) dynamicBrcode));
                continue;
            }
            if (dynamicBrcode instanceof DynamicBrcode) {
                dynamicBrcodeList.add((DynamicBrcode) dynamicBrcode);
                continue;
            }
            throw new Exception("Unknown type \"" + dynamicBrcode.getClass() + "\", use DynamicBrcode or HashMap");
        }
        return Rest.post(data, dynamicBrcodeList, user);
    }

    public final static class Rule extends SubResource {
        public String key;
        public String[] value;

        public Rule(String key, String[] value) {
            this.key = key;
            this.value = value;
        }

        public Rule() {
        }

        public Rule(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.key = (String) dataCopy.remove("key");
            this.value = (String[]) dataCopy.remove("value");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}

