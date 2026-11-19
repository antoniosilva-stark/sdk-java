package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class TaxPayment extends Resource {
    /**
     * TaxPayment object
     * <p>
     * When you initialize a TaxPayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * line [string]: Number sequence that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "85800000003 0 28960328203 1 56072020190 5 22109674804 0"
     * barCode [string]: Bar code number that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "83660000001084301380074119002551100010601813"
     * description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * scheduled [string]: payment scheduled date. ex: "2020-03-10"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * id [string]: unique id returned when payment is created. ex: "5656565656565656"
     * type [string]: tax type. ex: "das"
     * status [string]: current payment status. ex: "success" or "failed"
     * amount [integer]: amount automatically calculated from line or barCode. ex: 23456 (= R$ 234.56)
     * fee [integer]: fee charged when tax payment is created. ex: 200 (= R$ 2.00)
     * transactionIds [list of strings]: ledger transaction ids linked to this TaxPayment. ex: ["19827356981273"]
     * updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(TaxPayment.class, "TaxPayment");

    public String line;
    public String barCode;
    public String description;
    public String scheduled;
    public String[] tags;
    public String type;
    public String status;
    public String amount;
    public String fee;
    public String[] transactionIds;
    public String updated;
    public String created;


    /**
     * TaxPayment object
     * <p>
     * When you initialize a TaxPayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param line [string]: Number sequence that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "85800000003 0 28960328203 1 56072020190 5 22109674804 0"
     * @param barCode [string]: Bar code number that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "83660000001084301380074119002551100010601813"
     * @param description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * @param scheduled [string]: payment scheduled date. ex: "2020-03-10"
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param id [string]: unique id returned when payment is created. ex: "5656565656565656"
     * @param type [string]: tax type. ex: "das"
     * @param status [string]: current payment status. ex: "success" or "failed"
     * @param amount [integer]: amount automatically calculated from line or barCode. ex: 23456 (= R$ 234.56)
     * @param fee [integer]: fee charged when tax payment is created. ex: 200 (= R$ 2.00)
     * @param transactionIds [list of strings]: ledger transaction ids linked to this TaxPayment. ex: ["19827356981273"]
     * @param updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public TaxPayment(String id, String line, String barCode, String description, String[] tags, String scheduled, String status, String amount, String fee, String[] transactionIds, String type, String updated, String created) {
        super(id);
        this.line = line;
        this.barCode = barCode;
        this.description = description;
        this.tags = tags;
        this.scheduled = scheduled;
        this.status = status;
        this.amount = amount;
        this.fee = fee;
        this.transactionIds = transactionIds;
        this.type = type;
        this.updated = updated;
        this.created = created;
    }

    /**
     * TaxPayment object
     * <p>
     * When you initialize a TaxPayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the TaxPayment
     * line [string]: Number sequence that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "85800000003 0 28960328203 1 56072020190 5 22109674804 0"
     * barCode [string]: Bar code number that describes the payment. Either 'line' or 'barCode' parameters are required. If both are sent, they must match. ex: "83660000001084301380074119002551100010601813"
     * description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * scheduled [string]: payment scheduled date. ex: "2020-03-10"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * <p>
     * Attributes (return-only):
     * type [string]: tax type. ex: "das"
     * status [string]: current payment status. ex: "success" or "failed"
     * amount [integer]: amount automatically calculated from line or barCode. ex: 23456 (= R$ 234.56)
     * fee [integer]: fee charged when tax payment is created. ex: 200 (= R$ 2.00)
     * transactionIds [list of strings]: ledger transaction ids linked to this TaxPayment. ex: ["19827356981273"]
     * updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public TaxPayment(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.line = (String) dataCopy.remove("line");
        this.barCode = (String) dataCopy.remove("barCode");
        this.description = (String) dataCopy.remove("description");
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.tags = (String[]) dataCopy.remove("tags");
        this.type = null;
        this.status = null;
        this.amount = null;
        this.fee = null;
        this.transactionIds = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public TaxPayment() {
        super(null);
    }

    /**
     * Retrieve a specific TaxPayment
     * <p>
     * Receive a single TaxPayment object previously created by the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return TaxPayment object with updated attributes
     * @throws Exception error in the request
     */
    public static TaxPayment get(String id) throws Exception {
        return TaxPayment.get(id, null);
    }

    /**
     * Retrieve a specific TaxPayment
     * <p>
     * Receive a single TaxPayment object previously created by the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return TaxPayment object with updated attributes
     * @throws Exception error in the request
     */
    public static TaxPayment get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve TaxPayments
     * <p>
     * Receive a generator of TaxPayment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<TaxPayment> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve TaxPayments
     * <p>
     * Receive a generator of TaxPayment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * <p>
     * Return:
     * @return generator of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<TaxPayment> query(Map<String, Object> params) throws Exception {
        return TaxPayment.query(params, null);
    }

    /**
     * Retrieve TaxPayments
     * <p>
     * Receive a generator of TaxPayment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<TaxPayment> query(User user) throws Exception {
        return TaxPayment.query(new HashMap<>(), user);
    }

    /**
     * Retrieve TaxPayments
     * <p>
     * Receive a generator of TaxPayment objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<TaxPayment> query() throws Exception {
        return TaxPayment.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<TaxPayment> payments;
        public String cursor;

        public Page(List<TaxPayment> payments, String cursor) {
            this.payments = payments;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged TaxPayments
     * <p>
     * Receive a list of up to 100 TaxPayment objects previously created in the Stark Bank API and the cursor to the next page.
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
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * <p>
     * Return:
     * @return TaxPayment.Page object:
     * TaxPayment.Page.payments: list of TaxPayment objects with updated attributes
     * TaxPayment.Page.cursor: cursor to retrieve the next page of TaxPayment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return TaxPayment.page(params, null);
    }

    /**
     * Retrieve paged TaxPayments
     * <p>
     * Receive a list of up to 100 TaxPayment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return TaxPayment.Page object:
     * TaxPayment.Page.payments: list of TaxPayment objects with updated attributes
     * TaxPayment.Page.cursor: cursor to retrieve the next page of TaxPayment objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return TaxPayment.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged TaxPayments
     * <p>
     * Receive a list of up to 100 TaxPayment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return TaxPayment.Page object:
     * TaxPayment.Page.payments: list of TaxPayment objects with updated attributes
     * TaxPayment.Page.cursor: cursor to retrieve the next page of TaxPayment objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return TaxPayment.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged TaxPayments
     * <p>
     * Receive a list of up to 100 TaxPayment objects previously created in the Stark Bank API and the cursor to the next page.
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
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return TaxPayment.Page object:
     * TaxPayment.Page.payments: list of TaxPayment objects with updated attributes
     * TaxPayment.Page.cursor: cursor to retrieve the next page of TaxPayment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<TaxPayment> payments = new ArrayList<>();
        for (SubResource taxPayment: page.entities) {
            payments.add((TaxPayment) taxPayment);
        }
        return new Page(payments, page.cursor);
    }

    /**
     * Create TaxPayments
     * <p>
     * Send a list of TaxPayment objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param taxPayments [list of TaxPayment objects or HashMaps]: list of TaxPayment objects to be created in the API
     * <p>
     * Return:
     * @return list of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<TaxPayment> create(List<?> taxPayments) throws Exception {
        return TaxPayment.create(taxPayments, null);
    }

    /**
     * Create TaxPayments
     * <p>
     * Send a list of TaxPayment objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param taxPayments [list of TaxPayment objects or HashMaps]: list of TaxPayment objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of TaxPayment objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<TaxPayment> create(List<?> taxPayments, User user) throws Exception {
        List<TaxPayment> taxPaymentList = new ArrayList<>();
        for (Object taxPayment : taxPayments) {
            if (taxPayment instanceof Map) {
                taxPaymentList.add(new TaxPayment((Map<String, Object>) taxPayment));
                continue;
            }
            if (taxPayment instanceof TaxPayment) {
                taxPaymentList.add((TaxPayment) taxPayment);
                continue;
            }
            throw new Exception("Unknown type \"" + taxPayment.getClass() + "\", use TaxPayment or HashMap");
        }
        return Rest.post(data, taxPaymentList, user);
    }

    /**
     * Retrieve a specific TaxPayment pdf file
     * <p>
     * Receive a single TaxPayment pdf file generated in the Stark Bank API by passing its id.
     * Only valid for tax payments with "success", "processing" or "created" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return TaxPayment pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return TaxPayment.pdf(id, null);
    }

    /**
     * Retrieve a specific TaxPayment pdf file
     * <p>
     * Receive a single TaxPayment pdf file generated in the Stark Bank API by passing its id.
     * Only valid for tax payments with "success", "processing" or "created" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return TaxPayment pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }

    /**
     * Delete a TaxPayment entity
     * <p>
     * Delete a TaxPayment entity previously created in the Stark Bank API. This only cancels payments that have not yet started processing; payments already processed can still be deleted, but are not reversed.
     * <p>
     * Parameters:
     * @param id [string]: TaxPayment unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted TaxPayment object
     * @throws Exception error in the request
     */
    public static TaxPayment delete(String id) throws Exception {
        return TaxPayment.delete(id, null);
    }

    /**
     * Delete a TaxPayment entity
     * <p>
     * Delete a TaxPayment entity previously created in the Stark Bank API. This only cancels payments that have not yet started processing; payments already processed can still be deleted, but are not reversed.
     * <p>
     * Parameters:
     * @param id [string]: TaxPayment unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted TaxPayment object
     * @throws Exception error in the request
     */
    public static TaxPayment delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(TaxPayment.Log.class, "TaxPaymentLog");

        public String created;
        public String type;
        public String[] errors;
        public TaxPayment payment;

        /**
         * TaxPayment Log object
         * <p>
         * Every time a TaxPayment entity is updated, a corresponding TaxPayment Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the TaxPayment.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param payment [TaxPayment]: TaxPayment entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this TaxPayment event
         * @param type [string]: type of the TaxPayment event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, TaxPayment payment, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.payment = payment;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific TaxPayment Log
         * <p>
         * Receive a single TaxPayment Log object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return TaxPayment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific TaxPayment Log
         * <p>
         * Receive a single TaxPayment Log object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return TaxPayment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve TaxPayment Logs
         * <p>
         * Receive a generator of TaxPayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of TaxPayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return list of TaxPayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve TaxPayment Logs
         * <p>
         * Receive a generator of TaxPayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return list of TaxPayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve TaxPayment Logs
         * <p>
         * Receive a generator of TaxPayment Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return list of TaxPayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve TaxPayment Logs
         * <p>
         * Receive a generator of TaxPayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of TaxPayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return list of TaxPayment Log objects with updated attributes
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
         * Retrieve paged TaxPayment.Logs
         * <p>
         * Receive a list of up to 100 TaxPayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * paymentIds [list of strings, default null]: list of TaxPayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return TaxPayment.Log.Page object:
         * TaxPayment.Log.Page.logs: list of TaxPayment Log objects with updated attributes
         * TaxPayment.Log.Page.cursor: cursor to retrieve the next page of TaxPayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged TaxPayment.Logs
         * <p>
         * Receive a list of up to 100 TaxPayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return TaxPayment.Log.Page object:
         * TaxPayment.Log.Page.logs: list of TaxPayment Log objects with updated attributes
         * TaxPayment.Log.Page.cursor: cursor to retrieve the next page of TaxPayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged TaxPayment.Logs
         * <p>
         * Receive a list of up to 100 TaxPayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return TaxPayment.Log.Page object:
         * TaxPayment.Log.Page.logs: list of TaxPayment Log objects with updated attributes
         * TaxPayment.Log.Page.cursor: cursor to retrieve the next page of TaxPayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged TaxPayment.Logs
         * <p>
         * Receive a list of up to 100 TaxPayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * paymentIds [list of strings, default null]: list of TaxPayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return TaxPayment.Log.Page object:
         * TaxPayment.Log.Page.logs: list of TaxPayment Log objects with updated attributes
         * TaxPayment.Log.Page.cursor: cursor to retrieve the next page of TaxPayment Log objects
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

