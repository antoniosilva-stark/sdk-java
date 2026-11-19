package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class CorporateHolder extends Resource {
    /**
     * CorporateHolder object
     * <p>
     * The CorporateHolder describes a card holder that may group several cards. When you initialize a CorporateHolder, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * name [string]: cardholder name. ex: "Tony Stark"
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * permissions [list of maps]: list of Permission object representing access granted to an user for a particular cardholder.
     * rules [list of maps]: [EXPANDABLE] list of holder spending rules
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * id [string]: unique id returned when CorporateHolder is created. ex: "5656565656565656"
     * status [string]: current CorporateHolder status. ex: "active", "blocked", "canceled"
     * updated [string]: latest update datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(CorporateHolder.class, "CorporateHolder");

    public String name;
    public String centerId;
    public List<Permission> permissions;
    public List<CorporateRule> rules;
    public String[] tags;
    public String status;
    public String updated;
    public String created;


    /**
     * CorporateHolder object
     * <p>
     * The CorporateHolder describes a card holder that may group several cards. When you initialize a CorporateHolder, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param name [string]: cardholder name. ex: "Tony Stark"
     * @param centerId [string]: target cost center ID. ex: "5656565656565656"
     * @param permissions [list of maps]: list of Permission object representing access granted to an user for a particular cardholder.
     * @param rules [list of maps]: [EXPANDABLE] list of holder spending rules
     * @param tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * @param id [string]: unique id returned when CorporateHolder is created. ex: "5656565656565656"
     * @param status [string]: current CorporateHolder status. ex: "active", "blocked", "canceled"
     * @param updated [string]: latest update datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public CorporateHolder(String id, String name, String centerId, List<Permission> permissions, String status, List<CorporateRule> rules, String[] tags, String updated, String created) {
        super(id);
        this.name = name;
        this.centerId = centerId;
        this.permissions = permissions;
        this.status = status;
        this.rules = rules;
        this.tags = tags;
        this.updated = updated;
        this.created = created;
    }

    /**
     * CorporateHolder object
     * <p>
     * The CorporateHolder describes a card holder that may group several cards. When you initialize a CorporateHolder, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the CorporateHolder
     * name [string]: cardholder name. ex: "Tony Stark"
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * permissions [list of maps]: list of Permission object representing access granted to an user for a particular cardholder.
     * rules [list of maps]: [EXPANDABLE] list of holder spending rules
     * tags [list of strings]: list of strings for tagging. ex: ["travel", "food"]
     * <p>
     * Attributes (return-only):
     * status [string]: current CorporateHolder status. ex: "active", "blocked", "canceled"
     * updated [string]: latest update datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CorporateHolder. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public CorporateHolder(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.name = (String) dataCopy.remove("name");
        this.centerId = (String) dataCopy.remove("centerId");
        this.permissions = parsePermissions((List<Object>) dataCopy.remove("permissions"));
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public CorporateHolder() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<Permission> parsePermissions(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Permission> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Permission) {
                parsed.add((Permission) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new Permission((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Permission or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<CorporateRule> parseRules(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<CorporateRule> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof CorporateRule) {
                parsed.add((CorporateRule) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new CorporateRule((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use CorporateRule or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific CorporateHolder
     * <p>
     * Receive a single CorporateHolder object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. Options: ["rules"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder get(String id, Map<String, Object> params, User user) throws Exception {
        return Rest.getId(data, id, params, user);
    }

    /**
     * Retrieve a specific CorporateHolder
     * <p>
     * Receive a single CorporateHolder object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. Options: ["rules"]
     * <p>
     * Return:
     * @return CorporateHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder get(String id, Map<String, Object> params) throws Exception {
        return CorporateHolder.get(id, params, null);
    }

    /**
     * Retrieve a specific CorporateHolder
     * <p>
     * Receive a single CorporateHolder object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder get(String id, User user) throws Exception {
        return CorporateHolder.get(id, null, user);
    }

    /**
     * Retrieve a specific CorporateHolder
     * <p>
     * Receive a single CorporateHolder object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return CorporateHolder object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder get(String id) throws Exception {
        return CorporateHolder.get(id, null, null);
    }

    /**
     * Retrieve CorporateHolders
     * <p>
     * Receive a generator of CorporateHolder objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "blocked", "canceled"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * expand [string, default null]: fields to expand information. Options: ["rules"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateHolder> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CorporateHolders
     * <p>
     * Receive a generator of CorporateHolder objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "blocked", "canceled"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * expand [string, default null]: fields to expand information. Options: ["rules"]
     * <p>
     * Return:
     * @return generator of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateHolder> query(Map<String, Object> params) throws Exception {
        return CorporateHolder.query(params, null);
    }

    /**
     * Retrieve CorporateHolders
     * <p>
     * Receive a generator of CorporateHolder objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateHolder> query(User user) throws Exception {
        return CorporateHolder.query(new HashMap<>(), user);
    }

    /**
     * Retrieve CorporateHolders
     * <p>
     * Receive a generator of CorporateHolder objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateHolder> query() throws Exception {
        return CorporateHolder.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<CorporateHolder> holders;
        public String cursor;

        public Page(List<CorporateHolder> holders, String cursor) {
            this.holders = holders;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged CorporateHolders
     * <p>
     * Receive a list of up to 100 CorporateHolder objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "blocked", "canceled"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * expand [string, default null]: fields to expand information. Options: ["rules"]
     * <p>
     * Return:
     * @return CorporateHolder.Page object:
     * CorporateHolder.Page.holders: list of CorporateHolder objects with updated attributes
     * CorporateHolder.Page.cursor: cursor to retrieve the next page of CorporateHolder objects
     * @throws Exception error in the request
     */
    public static CorporateHolder.Page page(Map<String, Object> params) throws Exception {
        return CorporateHolder.page(params, null);
    }

    /**
     * Retrieve paged CorporateHolders
     * <p>
     * Receive a list of up to 100 CorporateHolder objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateHolder.Page object:
     * CorporateHolder.Page.holders: list of CorporateHolder objects with updated attributes
     * CorporateHolder.Page.cursor: cursor to retrieve the next page of CorporateHolder objects
     * @throws Exception error in the request
     */
    public static CorporateHolder.Page page(User user) throws Exception {
        return CorporateHolder.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged CorporateHolders
     * <p>
     * Receive a list of up to 100 CorporateHolder objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return CorporateHolder.Page object:
     * CorporateHolder.Page.holders: list of CorporateHolder objects with updated attributes
     * CorporateHolder.Page.cursor: cursor to retrieve the next page of CorporateHolder objects
     * @throws Exception error in the request
     */
    public static CorporateHolder.Page page() throws Exception {
        return CorporateHolder.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged CorporateHolders
     * <p>
     * Receive a list of up to 100 CorporateHolder objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "blocked", "canceled"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * expand [string, default null]: fields to expand information. Options: ["rules"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateHolder.Page object:
     * CorporateHolder.Page.holders: list of CorporateHolder objects with updated attributes
     * CorporateHolder.Page.cursor: cursor to retrieve the next page of CorporateHolder objects
     * @throws Exception error in the request
     */
    public static CorporateHolder.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<CorporateHolder> holders = new ArrayList<>();
        for (SubResource corporateHolder: page.entities) {
            holders.add((CorporateHolder) corporateHolder);
        }
        return new Page(holders, page.cursor);
    }

    /**
     * Create CorporateHolders
     * <p>
     * Send a list of CorporateHolder objects for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param corporateHolders [list of CorporateHolder objects or HashMaps]: list of CorporateHolder objects to be created in the API
     * <p>
     * Return:
     * @return list of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CorporateHolder> create(List<?> corporateHolders) throws Exception {
        return CorporateHolder.create(corporateHolders, null, null);
    }

    /**
     * Create CorporateHolders
     * <p>
     * Send a list of CorporateHolder objects for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param corporateHolders [list of CorporateHolder objects or HashMaps]: list of CorporateHolder objects to be created in the API
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. Options: ["rules"]
     * <p>
     * Return:
     * @return list of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CorporateHolder> create(List<?> corporateHolders, Map<String, Object> params) throws Exception {
        return CorporateHolder.create(corporateHolders, params, null);
    }

    /**
     * Create CorporateHolders
     * <p>
     * Send a list of CorporateHolder objects for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param corporateHolders [list of CorporateHolder objects or HashMaps]: list of CorporateHolder objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<CorporateHolder> create(List<?> corporateHolders, User user) throws Exception {
        return CorporateHolder.create(corporateHolders, null, user);
    }

    /**
     * Create CorporateHolders
     * <p>
     * Send a list of CorporateHolder objects for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param corporateHolders [list of CorporateHolder objects or HashMaps]: list of CorporateHolder objects to be created in the API
     * @param params map of parameters
     * expand [list of strings, default null]: fields to expand information. Options: ["rules"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of CorporateHolder objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<CorporateHolder> create(List<?> corporateHolders, Map<String, Object> params, User user) throws Exception {
        List<CorporateHolder> corporateHolderList = new ArrayList<>();
        for (Object corporateHolder : corporateHolders) {
            if (corporateHolder instanceof Map) {
                corporateHolderList.add(new CorporateHolder((Map<String, Object>) corporateHolder));
                continue;
            }
            if (corporateHolder instanceof CorporateHolder) {
                corporateHolderList.add((CorporateHolder) corporateHolder);
                continue;
            }
            throw new Exception("Unknown type \"" + corporateHolder.getClass() + "\", use CorporateHolder or HashMap");
        }
        return Rest.post(data, corporateHolderList, params, user);
    }

    /**
     * Update CorporateHolder entity
     * <p>
     * Update a CorporateHolder by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: CorporateHolder id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * centerId [string, default null]: target cost center ID. ex: "5656565656565656"
     * permissions [list of Permission object, default null]: list of Permission object representing access granted to an user for a particular cardholder.
     * status [string, default null]: You may block the CorporateHolder by passing 'blocked' in the status
     * name [string, default null]: card holder name.
     * tags [list of strings, default null]: list of strings for tagging
     * rules [list of dictionaries, default null]: list of dictionaries with "amount": int, "currencyCode": string, "id": string, "interval": string, "name": string pairs
     * <p>
     * Return:
     * @return target CorporateHolder with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder update(String id, Map<String, Object> patchData) throws Exception {
        return CorporateHolder.update(id, patchData, null);
    }

    /**
     * Update CorporateHolder entity
     * <p>
     * Update a CorporateHolder by passing its id.
     * <p>
     * Parameters:
     * @param id [string]: CorporateHolder id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * centerId [string, default null]: target cost center ID. ex: "5656565656565656"
     * permissions [list of Permission object, default null]: list of Permission object representing access granted to an user for a particular cardholder.
     * status [string, default null]: You may block the CorporateHolder by passing 'blocked' in the status
     * name [string, default null]: card holder name.
     * tags [list of strings, default null]: list of strings for tagging
     * rules [list of dictionaries, default null]: list of dictionaries with "amount": int, "currencyCode": string, "id": string, "interval": string, "name": string pairs
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return target CorporateHolder with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateHolder update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Cancel a CorporateHolder entity
     * <p>
     * Cancel a CorporateHolder entity previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param id [string]: CorporateHolder unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return canceled CorporateHolder object
     * @throws Exception error in the request
     */
    public static CorporateHolder cancel(String id) throws Exception {
        return CorporateHolder.cancel(id, null);
    }

    /**
     * Cancel a CorporateHolder entity
     * <p>
     * Cancel a CorporateHolder entity previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param id [string]: CorporateHolder unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled CorporateHolder object
     * @throws Exception error in the request
     */
    public static CorporateHolder cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(CorporateHolder.Log.class, "CorporateHolderLog");

        public String created;
        public String type;
        public CorporateHolder holder;

        /**
         * CorporateHolder Log object
         * <p>
         * Every time a CorporateHolder entity is updated, a corresponding CorporateHolder Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the CorporateHolder.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param holder [CorporateHolder]: CorporateHolder entity to which the log refers to
         * @param type [string]: type of the CorporateHolder event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, CorporateHolder holder, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.holder = holder;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific CorporateHolder Log
         * <p>
         * Receive a single CorporateHolder Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return CorporateHolder Log object with updated attributes
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific CorporateHolder Log
         * <p>
         * Receive a single CorporateHolder Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return CorporateHolder Log object with updated attributes
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve CorporateHolder Logs
         * <p>
         * Receive a generator of CorporateHolder Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "blocked"]
         * holderIds [list of strings, default null]: list of CorporateHolder ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of CorporateHolder Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<CorporateHolder.Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve CorporateHolder Logs
         * <p>
         * Receive a generator of CorporateHolder Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CorporateHolder Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<CorporateHolder.Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve CorporateHolder Logs
         * <p>
         * Receive a generator of CorporateHolder Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of CorporateHolder Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<CorporateHolder.Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve CorporateHolder Logs
         * <p>
         * Receive a generator of CorporateHolder Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "blocked"]
         * holderIds [list of strings, default null]: list of CorporateHolder ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of CorporateHolder Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<CorporateHolder.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<CorporateHolder.Log> logs;
            public String cursor;

            public Page(List<CorporateHolder.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged CorporateHolder.Logs
         * <p>
         * Receive a list of up to 100 CorporateHolder Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "blocked"]
         * holderIds [list of strings, default null]: list of CorporateHolder ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return CorporateHolder.Log.Page object:
         * CorporateHolder.Log.Page.logs: list of CorporateHolder Log objects with updated attributes
         * CorporateHolder.Log.Page.cursor: cursor to retrieve the next page of CorporateHolder Log objects
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged CorporateHolder.Logs
         * <p>
         * Receive a list of up to 100 CorporateHolder Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return CorporateHolder.Log.Page object:
         * CorporateHolder.Log.Page.logs: list of CorporateHolder Log objects with updated attributes
         * CorporateHolder.Log.Page.cursor: cursor to retrieve the next page of CorporateHolder Log objects
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged CorporateHolder.Logs
         * <p>
         * Receive a list of up to 100 CorporateHolder Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return CorporateHolder.Log.Page object:
         * CorporateHolder.Log.Page.logs: list of CorporateHolder Log objects with updated attributes
         * CorporateHolder.Log.Page.cursor: cursor to retrieve the next page of CorporateHolder Log objects
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged CorporateHolder.Logs
         * <p>
         * Receive a list of up to 100 CorporateHolder Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["created", "blocked"]
         * holderIds [list of strings, default null]: list of CorporateHolder ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return CorporateHolder.Log.Page object:
         * CorporateHolder.Log.Page.logs: list of CorporateHolder Log objects with updated attributes
         * CorporateHolder.Log.Page.cursor: cursor to retrieve the next page of CorporateHolder Log objects
         * @throws Exception error in the request
         */
        public static CorporateHolder.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<CorporateHolder.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

    public final static class Permission extends SubResource {
        public String ownerId;
        public String ownerType;
        public String ownerEmail;
        public String ownerName;
        public String ownerPictureUrl;
        public String ownerStatus;
        public String created;

        public Permission(String ownerId, String ownerType, String ownerEmail, String ownerName, String ownerPictureUrl, String ownerStatus, String created) {
            this.ownerId = ownerId;
            this.ownerType = ownerType;
            this.ownerEmail = ownerEmail;
            this.ownerName = ownerName;
            this.ownerPictureUrl = ownerPictureUrl;
            this.ownerStatus = ownerStatus;
            this.created = created;
        }

        public Permission(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.ownerId = (String) dataCopy.remove("ownerId");
            this.ownerType = (String) dataCopy.remove("ownerType");
            this.ownerEmail = null;
            this.ownerName = null;
            this.ownerPictureUrl = null;
            this.ownerStatus = null;
            this.created = null;

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}

