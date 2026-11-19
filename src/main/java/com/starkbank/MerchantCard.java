package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MerchantCard extends Resource {
    /**
     * MerchantCard object
     * <p>
     * Stores information about a card used in an approved purchase, so it can be reused in new purchases without a new MerchantSession.
     * <p>
     * Parameters:
     * id [string]
     * ending [string]
     * fundingType [string]
     * holderName [string]
     * network [string]
     * status [string]: current status. ex: "active", "expired", "canceled" or "blocked"
     * tags [list of strings]
     * expiration [string]
     * created [string]
     * updated [string]
     */
    static ClassData data = new ClassData(MerchantCard.class, "MerchantCard");

    public String ending;
    public String fundingType;
    public String holderName;
    public String network;
    public String status;
    public List<String> tags;
    public String expiration;
    public String created;
    public String updated;


    /**
     * MerchantCard object
     * <p>
     * Stores information about a card used in an approved purchase, so it can be reused in new purchases without a new MerchantSession.
     * <p>
     * Parameters:
     * @param id [string]
     * @param ending [string]
     * @param fundingType [string]
     * @param holderName [string]
     * @param network [string]
     * @param status [string]: current status. ex: "active", "expired", "canceled" or "blocked"
     * @param tags [list of strings]
     * @param expiration [string]
     * @param created [string]
     * @param updated [string]
     */
    public MerchantCard(String id, String ending, String fundingType, String holderName, String network, String status, List<String> tags, String expiration, String created, String updated) {
        super(id);
        this.ending = ending;
        this.fundingType = fundingType;
        this.holderName = holderName;
        this.network = network;
        this.status = status;
        this.tags = tags;
        this.expiration = expiration;
        this.created = created;
        this.updated = updated;
    }

    /**
     * MerchantCard object
     * <p>
     * Stores information about a card used in an approved purchase, so it can be reused in new purchases without a new MerchantSession.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the MerchantCard
     * <p>
     * Attributes (return-only):
     * ending [string]
     * fundingType [string]
     * holderName [string]
     * network [string]
     * status [string]: current status. ex: "active", "expired", "canceled" or "blocked"
     * tags [list of strings]
     * expiration [string]
     * created [string]
     * updated [string]
     * @throws Exception error in the request
     */
    public MerchantCard(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.ending = null;
        this.fundingType = null;
        this.holderName = null;
        this.network = null;
        this.status = null;
        this.tags = null;
        this.expiration = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public MerchantCard() {
        super(null);
    }

    /**
     * Retrieve a specific MerchantCard
     * <p>
     * Receive a single MerchantCard object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantCard object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantCard get(String id) throws Exception {
        return MerchantCard.get(id, null);
    }

    /**
     * Retrieve a specific MerchantCard
     * <p>
     * Receive a single MerchantCard object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantCard object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantCard get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve MerchantCards
     * <p>
     * Receive a generator of MerchantCard objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "active"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantCard objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantCard> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve MerchantCards
     * <p>
     * Receive a generator of MerchantCard objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "active"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of MerchantCard objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantCard> query(Map<String, Object> params) throws Exception {
        return MerchantCard.query(params, null);
    }

    /**
     * Retrieve MerchantCards
     * <p>
     * Receive a generator of MerchantCard objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantCard objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantCard> query(User user) throws Exception {
        return MerchantCard.query(new HashMap<>(), user);
    }

    /**
     * Retrieve MerchantCards
     * <p>
     * Receive a generator of MerchantCard objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of MerchantCard objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantCard> query() throws Exception {
        return MerchantCard.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<MerchantCard> merchantCards;
        public String cursor;

        public Page(List<MerchantCard> merchantCards, String cursor) {
            this.merchantCards = merchantCards;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged MerchantCards
     * <p>
     * Receive a list of up to 100 MerchantCard objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "active"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return MerchantCard.Page object:
     * MerchantCard.Page.merchantCards: list of MerchantCard objects with updated attributes
     * MerchantCard.Page.cursor: cursor to retrieve the next page of MerchantCard objects
     * @throws Exception error in the request
     */
    public static MerchantCard.Page page(Map<String, Object> params) throws Exception {
        return MerchantCard.page(params, null);
    }

    /**
     * Retrieve paged MerchantCards
     * <p>
     * Receive a list of up to 100 MerchantCard objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantCard.Page object:
     * MerchantCard.Page.merchantCards: list of MerchantCard objects with updated attributes
     * MerchantCard.Page.cursor: cursor to retrieve the next page of MerchantCard objects
     * @throws Exception error in the request
     */
    public static MerchantCard.Page page(User user) throws Exception {
        return MerchantCard.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged MerchantCards
     * <p>
     * Receive a list of up to 100 MerchantCard objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return MerchantCard.Page object:
     * MerchantCard.Page.merchantCards: list of MerchantCard objects with updated attributes
     * MerchantCard.Page.cursor: cursor to retrieve the next page of MerchantCard objects
     * @throws Exception error in the request
     */
    public static MerchantCard.Page page() throws Exception {
        return MerchantCard.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged MerchantCards
     * <p>
     * Receive a list of up to 100 MerchantCard objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "active"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantCard.Page object:
     * MerchantCard.Page.merchantCards: list of MerchantCard objects with updated attributes
     * MerchantCard.Page.cursor: cursor to retrieve the next page of MerchantCard objects
     * @throws Exception error in the request
     */
    public static MerchantCard.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<MerchantCard> merchantCards = new ArrayList<>();
        for (SubResource merchantCard: page.entities) {
            merchantCards.add((MerchantCard) merchantCard);
        }
        return new Page(merchantCards, page.cursor);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(MerchantCard.Log.class, "MerchantCardLog");

        public String created;
        public String type;
        public String[] errors;
        public MerchantCard card;

        /**
         * MerchantCard Log object
         * <p>
         * Every time a MerchantCard entity is updated, a corresponding MerchantCard Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the MerchantCard.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param card [MerchantCard]: MerchantCard entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this MerchantCard event
         * @param type [string]: type of the MerchantCard event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, MerchantCard card, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.card = card;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific MerchantCard Log
         * <p>
         * Receive a single MerchantCardLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return MerchantCardLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantCard.Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific MerchantCard Log
         * <p>
         * Receive a single MerchantCardLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantCardLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantCard.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve MerchantCard Logs
         * <p>
         * Receive a generator of MerchantCardLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * cardIds [list of strings, default null]: list of MerchantCard ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * <p>
         * Return:
         * @return generator of MerchantCardLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantCard.Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve MerchantCard Logs
         * <p>
         * Receive a generator of MerchantCardLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantCardLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantCard.Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve MerchantCard Logs
         * <p>
         * Receive a generator of MerchantCardLog objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of MerchantCardLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantCard.Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve MerchantCard Logs
         * <p>
         * Receive a generator of MerchantCardLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * cardIds [list of strings, default null]: list of MerchantCard ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantCardLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantCard.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<MerchantCard.Log> logs;
            public String cursor;

            public Page(List<MerchantCard.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged MerchantCard.Logs
         * <p>
         * Receive a list of up to 100 MerchantCardLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * cardIds [list of strings, default null]: list of MerchantCard ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * <p>
         * Return:
         * @return MerchantCard.Log.Page object:
         * MerchantCard.Log.Page.logs: list of MerchantCardLog objects with updated attributes
         * MerchantCard.Log.Page.cursor: cursor to retrieve the next page of MerchantCardLog objects
         * @throws Exception error in the request
         */
        public static MerchantCard.Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged MerchantCard.Logs
         * <p>
         * Receive a list of up to 100 MerchantCardLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantCard.Log.Page object:
         * MerchantCard.Log.Page.logs: list of MerchantCardLog objects with updated attributes
         * MerchantCard.Log.Page.cursor: cursor to retrieve the next page of MerchantCardLog objects
         * @throws Exception error in the request
         */
        public static MerchantCard.Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged MerchantCard.Logs
         * <p>
         * Receive a list of up to 100 MerchantCardLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return MerchantCard.Log.Page object:
         * MerchantCard.Log.Page.logs: list of MerchantCardLog objects with updated attributes
         * MerchantCard.Log.Page.cursor: cursor to retrieve the next page of MerchantCardLog objects
         * @throws Exception error in the request
         */
        public static MerchantCard.Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged MerchantCard.Logs
         * <p>
         * Receive a list of up to 100 MerchantCardLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * cardIds [list of strings, default null]: list of MerchantCard ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantCard.Log.Page object:
         * MerchantCard.Log.Page.logs: list of MerchantCardLog objects with updated attributes
         * MerchantCard.Log.Page.cursor: cursor to retrieve the next page of MerchantCardLog objects
         * @throws Exception error in the request
         */
        public static MerchantCard.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<MerchantCard.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}

