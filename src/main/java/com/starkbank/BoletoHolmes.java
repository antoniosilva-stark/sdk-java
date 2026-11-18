package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class BoletoHolmes extends Resource {
    /**
     * BoletoHolmes object
     * <p>
     * When you initialize a BoletoHolmes, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * boletoId [string]: investigated boleto entity ID. ex: "5656565656565656"
     * tags [list of strings]: list of strings for tagging
     * id [string]: unique id returned when holmes is created. ex: "5656565656565656"
     * status [string]: current holmes status. ex: "solving" or "solved"
     * result [string]: result of boleto status investigation. ex: "paid" or "cancelled"
     * created [string]: creation datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(BoletoHolmes.class, "BoletoHolmes");

    public String boletoId;
    public String[] tags;
    public String status;
    public String result;
    public String created;
    public String updated;


    /**
     * BoletoHolmes object
     * <p>
     * When you initialize a BoletoHolmes, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param boletoId [string]: investigated boleto entity ID. ex: "5656565656565656"
     * @param tags [list of strings]: list of strings for tagging
     * @param id [string]: unique id returned when holmes is created. ex: "5656565656565656"
     * @param status [string]: current holmes status. ex: "solving" or "solved"
     * @param result [string]: result of boleto status investigation. ex: "paid" or "cancelled"
     * @param created [string]: creation datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public BoletoHolmes(String boletoId, String[] tags, String id, String status, String result, String created, String updated) {
        super(id);
        this.boletoId = boletoId;
        this.tags = tags;
        this.status = status;
        this.result = result;
        this.created = created;
        this.updated = updated;
    }

    /**
     * BoletoHolmes object
     * <p>
     * When you initialize a BoletoHolmes, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the BoletoHolmes
     * boletoId [string]: investigated boleto entity ID. ex: "5656565656565656"
     * tags [list of strings]: list of strings for tagging
     * <p>
     * Attributes (return-only):
     * status [string]: current holmes status. ex: "solving" or "solved"
     * result [string]: result of boleto status investigation. ex: "paid" or "cancelled"
     * created [string]: creation datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the holmes. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public BoletoHolmes(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.boletoId = (String) dataCopy.remove("boletoId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.result = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public BoletoHolmes() {
        super(null);
    }

    /**
     * Retrieve a specific BoletoHolmes
     * <p>
     * Receive a single BoletoHolmes object previously created by the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BoletoHolmes object with updated attributes
     * @throws Exception error in the request
     */
    public static BoletoHolmes get(String id) throws Exception {
        return BoletoHolmes.get(id, null);
    }

    /**
     * Retrieve a specific BoletoHolmes
     * <p>
     * Receive a single BoletoHolmes object previously created by the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BoletoHolmes object with updated attributes
     * @throws Exception error in the request
     */
    public static BoletoHolmes get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve BoletoHolmes
     * <p>
     * Receive a generator of BoletoHolmes objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "solved"
     * boletoId [string, default null]: filter for holmes that investigate a specific boleto by its ID. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BoletoHolmes> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve BoletoHolmes
     * <p>
     * Receive a generator of BoletoHolmes objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "solved"
     * boletoId [string, default null]: filter for holmes that investigate a specific boleto by its ID. ex: "5656565656565656"
     * <p>
     * Return:
     * @return generator of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BoletoHolmes> query(Map<String, Object> params) throws Exception {
        return BoletoHolmes.query(params, null);
    }

    /**
     * Retrieve BoletoHolmes
     * <p>
     * Receive a generator of BoletoHolmes objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BoletoHolmes> query(User user) throws Exception {
        return BoletoHolmes.query(new HashMap<>(), user);
    }

    /**
     * Retrieve BoletoHolmes
     * <p>
     * Receive a generator of BoletoHolmes objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BoletoHolmes> query() throws Exception {
        return BoletoHolmes.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<BoletoHolmes> holmes;
        public String cursor;

        public Page(List<BoletoHolmes> holmes, String cursor) {
            this.holmes = holmes;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged BoletoHolmes
     * <p>
     * Receive a list of up to 100 BoletoHolmes objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "solved"
     * boletoId [string, default null]: filter for holmes that investigate a specific boleto by its ID. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BoletoHolmes.Page object:
     * BoletoHolmes.Page.holmes: list of BoletoHolmes objects with updated attributes
     * BoletoHolmes.Page.cursor: cursor to retrieve the next page of BoletoHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return BoletoHolmes.page(params, null);
    }

    /**
     * Retrieve paged BoletoHolmes
     * <p>
     * Receive a list of up to 100 BoletoHolmes objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BoletoHolmes.Page object:
     * BoletoHolmes.Page.holmes: list of BoletoHolmes objects with updated attributes
     * BoletoHolmes.Page.cursor: cursor to retrieve the next page of BoletoHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return BoletoHolmes.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged BoletoHolmes
     * <p>
     * Receive a list of up to 100 BoletoHolmes objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return BoletoHolmes.Page object:
     * BoletoHolmes.Page.holmes: list of BoletoHolmes objects with updated attributes
     * BoletoHolmes.Page.cursor: cursor to retrieve the next page of BoletoHolmes objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return BoletoHolmes.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged BoletoHolmes
     * <p>
     * Receive a list of up to 100 BoletoHolmes objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "solved"
     * boletoId [string, default null]: filter for holmes that investigate a specific boleto by its ID. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BoletoHolmes.Page object:
     * BoletoHolmes.Page.holmes: list of BoletoHolmes objects with updated attributes
     * BoletoHolmes.Page.cursor: cursor to retrieve the next page of BoletoHolmes objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<BoletoHolmes> holmes = new ArrayList<>();
        for (SubResource boletoHolmes: page.entities) {
            holmes.add((BoletoHolmes) boletoHolmes);
        }
        return new Page(holmes, page.cursor);
    }

    /**
     * Create BoletoHolmes
     * <p>
     * Send a list of BoletoHolmes objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param boletoHolmess [list of BoletoHolmes objects or HashMaps]: list of BoletoHolmes objects to be created in the API
     * <p>
     * Return:
     * @return list of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BoletoHolmes> create(List<?> boletoHolmess) throws Exception {
        return BoletoHolmes.create(boletoHolmess, null);
    }

    /**
     * Create BoletoHolmes
     * <p>
     * Send a list of BoletoHolmes objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param boletoHolmess [list of BoletoHolmes objects or HashMaps]: list of BoletoHolmes objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of BoletoHolmes objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BoletoHolmes> create(List<?> boletoHolmess, User user) throws Exception {
        List<BoletoHolmes> boletoHolmesList = new ArrayList<>();
        for (Object boletoHolmes : boletoHolmess) {
            if (boletoHolmes instanceof Map) {
                boletoHolmesList.add(new BoletoHolmes((Map<String, Object>) boletoHolmes));
                continue;
            }
            if (boletoHolmes instanceof BoletoHolmes) {
                boletoHolmesList.add((BoletoHolmes) boletoHolmes);
                continue;
            }
            throw new Exception("Unknown type \"" + boletoHolmes.getClass() + "\", use BoletoHolmes or HashMap");
        }
        return Rest.post(data, boletoHolmesList, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "BoletoHolmesLog");

        public String created;
        public String type;
        public BoletoHolmes holmes;
        public String updated;

        /**
         * BoletoHolmes Log object
         * <p>
         * Every time a BoletoHolmes entity is updated, a corresponding BoletoHolmes Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the BoletoHolmes.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param holmes [BoletoHolmes]: BoletoHolmes entity to which the log refers to
         * @param type [string]: type of the BoletoHolmes event which triggered the log creation
         * @param created [string]: creation datetime for the log
         * @param updated [string]: latest update datetime for the log
         */
        public Log(String created, String type, BoletoHolmes holmes, String id, String updated) {
            super(id);
            this.created = created;
            this.type = type;
            this.holmes = holmes;
            this.updated = updated;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific BoletoHolmes Log
         * <p>
         * Receive a single BoletoHolmes.Log object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return BoletoHolmes Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific BoletoHolmes Log
         * <p>
         * Receive a single BoletoHolmes.Log object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BoletoHolmes Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve BoletoHolmes Logs
         * <p>
         * Receive a generator of BoletoHolmes Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event type. ex: ["solving", "solved"]
         * holmesIds [list of strings, default null]: list of BoletoHolmes ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of BoletoHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve BoletoHolmes Logs
         * <p>
         * Receive a generator of BoletoHolmes Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BoletoHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve BoletoHolmes Logs
         * <p>
         * Receive a generator of BoletoHolmes Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of BoletoHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve BoletoHolmes Logs
         * <p>
         * Receive a generator of BoletoHolmes Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event type. ex: ["solving", "solved"]
         * holmesIds [list of strings, default null]: list of BoletoHolmes ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BoletoHolmes Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<Log> logs;
            public String cursor;

            public Page(List<Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged BoletoHolmes.Logs
         * <p>
         * Receive a list of up to 100 BoletoHolmes Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event type. ex: ["solving", "solved"]
         * holmesIds [list of strings, default null]: list of BoletoHolmes Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return BoletoHolmes.Log.Page object:
         * BoletoHolmes.Log.Page.logs: list of BoletoHolmes Log objects with updated attributes
         * BoletoHolmes.Log.Page.cursor: cursor to retrieve the next page of BoletoHolmes Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged BoletoHolmes.Logs
         * <p>
         * Receive a list of up to 100 BoletoHolmes Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BoletoHolmes.Log.Page object:
         * BoletoHolmes.Log.Page.logs: list of BoletoHolmes Log objects with updated attributes
         * BoletoHolmes.Log.Page.cursor: cursor to retrieve the next page of BoletoHolmes Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged BoletoHolmes.Logs
         * <p>
         * Receive a list of up to 100 BoletoHolmes Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return BoletoHolmes.Log.Page object:
         * BoletoHolmes.Log.Page.logs: list of BoletoHolmes Log objects with updated attributes
         * BoletoHolmes.Log.Page.cursor: cursor to retrieve the next page of BoletoHolmes Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged BoletoHolmes.Logs
         * <p>
         * Receive a list of up to 100 BoletoHolmes Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event type. ex: ["solving", "solved"]
         * holmesIds [list of strings, default null]: list of BoletoHolmes Log ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BoletoHolmes.Log.Page object:
         * BoletoHolmes.Log.Page.logs: list of BoletoHolmes Log objects with updated attributes
         * BoletoHolmes.Log.Page.cursor: cursor to retrieve the next page of BoletoHolmes Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Log.Page(logs, page.cursor);
        }
    }
}

