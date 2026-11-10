package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MerchantSession extends Resource {
    /**
     * MerchantSession object
     * <p>
     * When you initialize a MerchantSession, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * allowedFundingTypes [list of strings]: funding types allowed for the purchase. Options: "credit", "debit"
     * allowedInstallments [list of maps]: amount/installment-count combinations allowed for the purchase
     * expiration [integer]: time in seconds from creation until the session expires; after expiration, no purchase can be created with it
     * allowedIps [list of strings]: IP addresses allowed to create a purchase with this session
     * challengeMode [string]: whether 3DS holder verification is used. Options: "enabled", "disabled"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * id [string]: unique id returned when MerchantSession is created. ex: "5656565656565656"
     * uuid [string]: unique uuid returned when MerchantSession is created, used to create a MerchantSession Purchase. ex: "901e71f2447c43c886f58366a5432c4b"
     * holderId [string]: unique id of the card holder associated with this session, when applicable.
     * softDescriptor [string]: text that will be shown in the holder's bank statement, when applicable.
     * status [string]: current MerchantSession status. ex: "created", "expired"
     * created [string]: creation datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * confirmationMode [string]
     */
    static ClassData data = new ClassData(MerchantSession.class, "MerchantSession");

    public List<String> allowedFundingTypes;
    public List<AllowedInstallment> allowedInstallments;
    public Number expiration;
    public List<String> allowedIps;
    public String challengeMode;
    public String[] tags;
    public String uuid;
    public String holderId;
    public String softDescriptor;
    public String status;
    public String created;
    public String updated;
    public String confirmationMode;


    /**
     * MerchantSession object
     * <p>
     * When you initialize a MerchantSession, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param allowedFundingTypes [list of strings]: funding types allowed for the purchase. Options: "credit", "debit"
     * @param allowedInstallments [list of maps]: amount/installment-count combinations allowed for the purchase
     * @param expiration [integer]: time in seconds from creation until the session expires; after expiration, no purchase can be created with it
     * @param allowedIps [list of strings]: IP addresses allowed to create a purchase with this session
     * @param challengeMode [string]: whether 3DS holder verification is used. Options: "enabled", "disabled"
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param id [string]: unique id returned when MerchantSession is created. ex: "5656565656565656"
     * @param uuid [string]: unique uuid returned when MerchantSession is created, used to create a MerchantSession Purchase. ex: "901e71f2447c43c886f58366a5432c4b"
     * @param holderId [string]: unique id of the card holder associated with this session, when applicable.
     * @param softDescriptor [string]: text that will be shown in the holder's bank statement, when applicable.
     * @param status [string]: current MerchantSession status. ex: "created", "expired"
     * @param created [string]: creation datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param confirmationMode [string]
     */
    public MerchantSession(String id, List<String> allowedFundingTypes, List<AllowedInstallment> allowedInstallments, List<String> allowedIps, String challengeMode, String confirmationMode, String holderId, String softDescriptor, String created, Number expiration, String status, String[] tags, String updated, String uuid) {
        super(id);
        this.allowedFundingTypes = allowedFundingTypes;
        this.allowedInstallments = allowedInstallments;
        this.allowedIps = allowedIps;
        this.challengeMode = challengeMode;
        this.confirmationMode = confirmationMode;
        this.holderId = holderId;
        this.softDescriptor = softDescriptor;
        this.created = created;
        this.expiration = expiration;
        this.status = status;
        this.tags = tags;
        this.updated = updated;
        this.uuid = uuid;
    }

    /**
     * MerchantSession object
     * <p>
     * When you initialize a MerchantSession, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the MerchantSession
     * allowedFundingTypes [list of strings]: funding types allowed for the purchase. Options: "credit", "debit"
     * allowedInstallments [list of maps]: amount/installment-count combinations allowed for the purchase
     * expiration [integer]: time in seconds from creation until the session expires; after expiration, no purchase can be created with it
     * allowedIps [list of strings]: IP addresses allowed to create a purchase with this session
     * challengeMode [string]: whether 3DS holder verification is used. Options: "enabled", "disabled"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * confirmationMode [string]
     * <p>
     * Attributes (return-only):
     * uuid [string]: unique uuid returned when MerchantSession is created, used to create a MerchantSession Purchase. ex: "901e71f2447c43c886f58366a5432c4b"
     * holderId [string]: unique id of the card holder associated with this session, when applicable.
     * softDescriptor [string]: text that will be shown in the holder's bank statement, when applicable.
     * status [string]: current MerchantSession status. ex: "created", "expired"
     * created [string]: creation datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantSession. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public MerchantSession(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.allowedFundingTypes = (List<String>) dataCopy.remove("allowedFundingTypes");
        this.allowedInstallments = parseAllowedInstallments((List<Object>) dataCopy.remove("allowedInstallments"));
        this.expiration = (Number) dataCopy.remove("expiration");
        this.allowedIps = (List<String>) dataCopy.remove("allowedIps");
        this.challengeMode = (String) dataCopy.remove("challengeMode");
        this.tags = (String[]) dataCopy.remove("tags");
        this.uuid = null;
        this.holderId = null;
        this.softDescriptor = null;
        this.status = null;
        this.created = null;
        this.updated = null;
        this.confirmationMode = (String) dataCopy.remove("confirmationMode");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public MerchantSession() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<AllowedInstallment> parseAllowedInstallments(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<AllowedInstallment> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof AllowedInstallment) {
                parsed.add((AllowedInstallment) item);
                continue;
            }
            if (item instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) item;
                parsed.add(new AllowedInstallment(
                    ((Number) map.get("totalAmount")).longValue(),
                    ((Number) map.get("count")).intValue()
                ));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use AllowedInstallment or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific MerchantSession
     * <p>
     * Receive a single MerchantSession object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantSession object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantSession get(String id) throws Exception {
        return MerchantSession.get(id, null);
    }

    /**
     * Retrieve a specific MerchantSession
     * <p>
     * Receive a single MerchantSession object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantSession object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantSession get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve MerchantSessions
     * <p>
     * Receive a generator of MerchantSession objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * holderId [string, default null]: filter for sessions belonging to a specific card holder. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantSession objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantSession> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve MerchantSessions
     * <p>
     * Receive a generator of MerchantSession objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * holderId [string, default null]: filter for sessions belonging to a specific card holder. ex: "5656565656565656"
     * <p>
     * Return:
     * @return generator of MerchantSession objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantSession> query(Map<String, Object> params) throws Exception {
        return MerchantSession.query(params, null);
    }

    /**
     * Retrieve MerchantSessions
     * <p>
     * Receive a generator of MerchantSession objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantSession objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantSession> query(User user) throws Exception {
        return MerchantSession.query(new HashMap<>(), user);
    }

    /**
     * Retrieve MerchantSessions
     * <p>
     * Receive a generator of MerchantSession objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of MerchantSession objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantSession> query() throws Exception {
        return MerchantSession.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<MerchantSession> merchantSessions;
        public String cursor;

        public Page(List<MerchantSession> merchantSessions, String cursor) {
            this.merchantSessions = merchantSessions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged MerchantSessions
     * <p>
     * Receive a list of up to 100 MerchantSession objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * holderId [string, default null]: filter for sessions belonging to a specific card holder. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantSession.Page object:
     * MerchantSession.Page.merchantSessions: list of MerchantSession objects with updated attributes
     * MerchantSession.Page.cursor: cursor to retrieve the next page of MerchantSession objects
     * @throws Exception error in the request
     */
    public static MerchantSession.Page page(Map<String, Object> params) throws Exception {
        return MerchantSession.page(params, null);
    }

    /**
     * Retrieve paged MerchantSessions
     * <p>
     * Receive a list of up to 100 MerchantSession objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantSession.Page object:
     * MerchantSession.Page.merchantSessions: list of MerchantSession objects with updated attributes
     * MerchantSession.Page.cursor: cursor to retrieve the next page of MerchantSession objects
     * @throws Exception error in the request
     */
    public static MerchantSession.Page page(User user) throws Exception {
        return MerchantSession.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged MerchantSessions
     * <p>
     * Receive a list of up to 100 MerchantSession objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return MerchantSession.Page object:
     * MerchantSession.Page.merchantSessions: list of MerchantSession objects with updated attributes
     * MerchantSession.Page.cursor: cursor to retrieve the next page of MerchantSession objects
     * @throws Exception error in the request
     */
    public static MerchantSession.Page page() throws Exception {
        return MerchantSession.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged MerchantSessions
     * <p>
     * Receive a list of up to 100 MerchantSession objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * status [string, default null]: filter for status of retrieved objects. ex: "created"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * holderId [string, default null]: filter for sessions belonging to a specific card holder. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantSession.Page object:
     * MerchantSession.Page.merchantSessions: list of MerchantSession objects with updated attributes
     * MerchantSession.Page.cursor: cursor to retrieve the next page of MerchantSession objects
     * @throws Exception error in the request
     */
    public static MerchantSession.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<MerchantSession> merchantSessions = new ArrayList<>();
        for (SubResource merchantSession: page.entities) {
            merchantSessions.add((MerchantSession) merchantSession);
        }
        return new Page(merchantSessions, page.cursor);
    }

    /**
     * Create a MerchantSession
     * <p>
     * Send a MerchantSession object for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param merchantSession [MerchantSession object]: MerchantSession object to be created in the API
     * <p>
     * Return:
     * @return MerchantSession object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantSession create(MerchantSession merchantSession) throws Exception {
        return MerchantSession.create(merchantSession, null);
    }

    /**
     * Create a MerchantSession
     * <p>
     * Send a MerchantSession object for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param merchantSession [MerchantSession object]: MerchantSession object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantSession object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantSession create(MerchantSession merchantSession, User user) throws Exception {
        return Rest.postSingle(data, merchantSession, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(MerchantSession.Log.class, "MerchantSessionLog");

        public String created;
        public String type;
        public String[] errors;
        public MerchantSession session;

        /**
         * MerchantSession Log object
         * <p>
         * Every time a MerchantSession entity is updated, a corresponding MerchantSession Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the MerchantSession.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param session [MerchantSession]: MerchantSession entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this MerchantSession event
         * @param type [string]: type of the MerchantSession event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, MerchantSession session, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.session = session;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific MerchantSession Log
         * <p>
         * Receive a single MerchantSessionLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return MerchantSessionLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantSession.Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific MerchantSession Log
         * <p>
         * Receive a single MerchantSessionLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantSessionLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantSession.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve MerchantSession Logs
         * <p>
         * Receive a generator of MerchantSessionLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * sessionIds [list of strings, default null]: list of MerchantSession ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of MerchantSessionLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantSession.Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve MerchantSession Logs
         * <p>
         * Receive a generator of MerchantSessionLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantSessionLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantSession.Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve MerchantSession Logs
         * <p>
         * Receive a generator of MerchantSessionLog objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of MerchantSessionLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantSession.Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve MerchantSession Logs
         * <p>
         * Receive a generator of MerchantSessionLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * sessionIds [list of strings, default null]: list of MerchantSession ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantSessionLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantSession.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<MerchantSession.Log> logs;
            public String cursor;

            public Page(List<MerchantSession.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged MerchantSession.Logs
         * <p>
         * Receive a list of up to 100 MerchantSessionLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * sessionIds [list of strings, default null]: list of MerchantSession ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return MerchantSession.Log.Page object:
         * MerchantSession.Log.Page.logs: list of MerchantSessionLog objects with updated attributes
         * MerchantSession.Log.Page.cursor: cursor to retrieve the next page of MerchantSessionLog objects
         * @throws Exception error in the request
         */
        public static MerchantSession.Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged MerchantSession.Logs
         * <p>
         * Receive a list of up to 100 MerchantSessionLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantSession.Log.Page object:
         * MerchantSession.Log.Page.logs: list of MerchantSessionLog objects with updated attributes
         * MerchantSession.Log.Page.cursor: cursor to retrieve the next page of MerchantSessionLog objects
         * @throws Exception error in the request
         */
        public static MerchantSession.Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged MerchantSession.Logs
         * <p>
         * Receive a list of up to 100 MerchantSessionLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return MerchantSession.Log.Page object:
         * MerchantSession.Log.Page.logs: list of MerchantSessionLog objects with updated attributes
         * MerchantSession.Log.Page.cursor: cursor to retrieve the next page of MerchantSessionLog objects
         * @throws Exception error in the request
         */
        public static MerchantSession.Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged MerchantSession.Logs
         * <p>
         * Receive a list of up to 100 MerchantSessionLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * sessionIds [list of strings, default null]: list of MerchantSession ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantSession.Log.Page object:
         * MerchantSession.Log.Page.logs: list of MerchantSessionLog objects with updated attributes
         * MerchantSession.Log.Page.cursor: cursor to retrieve the next page of MerchantSessionLog objects
         * @throws Exception error in the request
         */
        public static MerchantSession.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<MerchantSession.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }

    public static class AllowedInstallment extends SubResource {
        public long totalAmount;
        public int count;

        static SubResource.ClassData data = new SubResource.ClassData(AllowedInstallment.class, "AllowedInstallments");

        public AllowedInstallment(long totalAmount, int count) {
            this.totalAmount = totalAmount;
            this.count = count;
        }
    }
}

