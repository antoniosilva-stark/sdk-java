package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;
import com.starkbank.error.ErrorElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MerchantInstallment extends Resource {
    /**
     * MerchantInstallment object
     * <p>
     * Represents one installment of a MerchantPurchase, generated automatically by the Stark Bank API when the purchase is split.
     * <p>
     * Parameters:
     * id [string]: unique id returned when MerchantInstallment is created. ex: "5656565656565656"
     * amount [integer]: MerchantInstallment value in cents. ex: 1234 (= R$ 12.34)
     * due [string]: MerchantInstallment due date. ex: "2020-03-10 10:30:00.000000+00:00"
     * fee [integer]: fee charged when the MerchantInstallment is processed. ex: 200 (= R$ 2.00)
     * fundingType [string]: installment funding type. ex: "credit"
     * network [string]: card network flag. ex: "visa", "mastercard"
     * purchaseId [string]: unique id of the MerchantPurchase to which this installment belongs. ex: "5656565656565656"
     * status [string]: current MerchantInstallment status. ex: "created", "success", "failed"
     * tags [list of strings]: list of strings for tagging
     * transactionIds [list of strings]: ledger transaction ids linked to this MerchantInstallment
     * created [string]: creation datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(MerchantInstallment.class, "MerchantInstallment");

    public long amount;
    public String due;
    public int fee;
    public String fundingType;
    public String network;
    public String purchaseId;
    public String status;
    public String[] tags;
    public List<String> transactionIds;
    public String created;
    public String updated;


    /**
     * MerchantInstallment object
     * <p>
     * Represents one installment of a MerchantPurchase, generated automatically by the Stark Bank API when the purchase is split.
     * <p>
     * Parameters:
     * @param id [string]: unique id returned when MerchantInstallment is created. ex: "5656565656565656"
     * @param amount [integer]: MerchantInstallment value in cents. ex: 1234 (= R$ 12.34)
     * @param due [string]: MerchantInstallment due date. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param fee [integer]: fee charged when the MerchantInstallment is processed. ex: 200 (= R$ 2.00)
     * @param fundingType [string]: installment funding type. ex: "credit"
     * @param network [string]: card network flag. ex: "visa", "mastercard"
     * @param purchaseId [string]: unique id of the MerchantPurchase to which this installment belongs. ex: "5656565656565656"
     * @param status [string]: current MerchantInstallment status. ex: "created", "success", "failed"
     * @param tags [list of strings]: list of strings for tagging
     * @param transactionIds [list of strings]: ledger transaction ids linked to this MerchantInstallment
     * @param created [string]: creation datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public MerchantInstallment(String id, long amount, String created, String due, int fee, String fundingType, String network, String purchaseId, String status, String[] tags, List<String> transactionIds, String updated) {
        super(id);
        this.amount = amount;
        this.created = created;
        this.due = due;
        this.fee = fee;
        this.fundingType = fundingType;
        this.network = network;
        this.purchaseId = purchaseId;
        this.status = status;
        this.tags = tags;
        this.transactionIds = transactionIds;
        this.updated = updated;
    }

    /**
     * MerchantInstallment object
     * <p>
     * Represents one installment of a MerchantPurchase, generated automatically by the Stark Bank API when the purchase is split.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the MerchantInstallment
     * <p>
     * Attributes (return-only):
     * amount [integer]: MerchantInstallment value in cents. ex: 1234 (= R$ 12.34)
     * due [string]: MerchantInstallment due date. ex: "2020-03-10 10:30:00.000000+00:00"
     * fee [integer]: fee charged when the MerchantInstallment is processed. ex: 200 (= R$ 2.00)
     * fundingType [string]: installment funding type. ex: "credit"
     * network [string]: card network flag. ex: "visa", "mastercard"
     * purchaseId [string]: unique id of the MerchantPurchase to which this installment belongs. ex: "5656565656565656"
     * status [string]: current MerchantInstallment status. ex: "created", "success", "failed"
     * tags [list of strings]: list of strings for tagging
     * transactionIds [list of strings]: ledger transaction ids linked to this MerchantInstallment
     * created [string]: creation datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantInstallment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public MerchantInstallment(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.amount = 0;
        this.due = null;
        this.fee = 0;
        this.fundingType = null;
        this.network = null;
        this.purchaseId = null;
        this.status = null;
        this.tags = null;
        this.transactionIds = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public MerchantInstallment() {
        super(null);
    }

    /**
     * Retrieve a specific MerchantInstallment
     * <p>
     * Receive a single MerchantInstallment object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantInstallment object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantInstallment get(String id) throws Exception {
        return MerchantInstallment.get(id, null);
    }

    /**
     * Retrieve a specific MerchantInstallment
     * <p>
     * Receive a single MerchantInstallment object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantInstallment object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantInstallment get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve MerchantInstallments
     * <p>
     * Receive a generator of MerchantInstallment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantInstallment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantInstallment> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve MerchantInstallments
     * <p>
     * Receive a generator of MerchantInstallment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of MerchantInstallment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantInstallment> query(Map<String, Object> params) throws Exception {
        return MerchantInstallment.query(params, null);
    }

    /**
     * Retrieve MerchantInstallments
     * <p>
     * Receive a generator of MerchantInstallment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantInstallment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantInstallment> query(User user) throws Exception {
        return MerchantInstallment.query(new HashMap<>(), user);
    }

    /**
     * Retrieve MerchantInstallments
     * <p>
     * Receive a generator of MerchantInstallment objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of MerchantInstallment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantInstallment> query() throws Exception {
        return MerchantInstallment.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<MerchantInstallment> merchantInstallments;
        public String cursor;

        public Page(List<MerchantInstallment> merchantInstallments, String cursor) {
            this.merchantInstallments = merchantInstallments;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged MerchantInstallments
     * <p>
     * Receive a list of up to 100 MerchantInstallment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return MerchantInstallment.Page object:
     * MerchantInstallment.Page.merchantInstallments: list of MerchantInstallment objects with updated attributes
     * MerchantInstallment.Page.cursor: cursor to retrieve the next page of MerchantInstallment objects
     * @throws Exception error in the request
     */
    public static MerchantInstallment.Page page(Map<String, Object> params) throws Exception {
        return MerchantInstallment.page(params, null);
    }

    /**
     * Retrieve paged MerchantInstallments
     * <p>
     * Receive a list of up to 100 MerchantInstallment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantInstallment.Page object:
     * MerchantInstallment.Page.merchantInstallments: list of MerchantInstallment objects with updated attributes
     * MerchantInstallment.Page.cursor: cursor to retrieve the next page of MerchantInstallment objects
     * @throws Exception error in the request
     */
    public static MerchantInstallment.Page page(User user) throws Exception {
        return MerchantInstallment.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged MerchantInstallments
     * <p>
     * Receive a list of up to 100 MerchantInstallment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return MerchantInstallment.Page object:
     * MerchantInstallment.Page.merchantInstallments: list of MerchantInstallment objects with updated attributes
     * MerchantInstallment.Page.cursor: cursor to retrieve the next page of MerchantInstallment objects
     * @throws Exception error in the request
     */
    public static MerchantInstallment.Page page() throws Exception {
        return MerchantInstallment.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged MerchantInstallments
     * <p>
     * Receive a list of up to 100 MerchantInstallment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "success"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantInstallment.Page object:
     * MerchantInstallment.Page.merchantInstallments: list of MerchantInstallment objects with updated attributes
     * MerchantInstallment.Page.cursor: cursor to retrieve the next page of MerchantInstallment objects
     * @throws Exception error in the request
     */
    public static MerchantInstallment.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<MerchantInstallment> merchantInstallments = new ArrayList<>();
        for (SubResource merchantInstallment: page.entities) {
            merchantInstallments.add((MerchantInstallment) merchantInstallment);
        }
        return new Page(merchantInstallments, page.cursor);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(MerchantInstallment.Log.class, "MerchantInstallmentLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public MerchantInstallment installment;

        /**
         * MerchantInstallment Log object
         * <p>
         * Every time a MerchantInstallment entity is updated, a corresponding MerchantInstallment Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the MerchantInstallment.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param installment [MerchantInstallment]: MerchantInstallment entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this MerchantInstallment event
         * @param type [string]: type of the MerchantInstallment event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, List<ErrorElement> errors, MerchantInstallment installment, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.installment = installment;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific MerchantInstallment Log
         * <p>
         * Receive a single MerchantInstallmentLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return MerchantInstallmentLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific MerchantInstallment Log
         * <p>
         * Receive a single MerchantInstallmentLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantInstallmentLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve MerchantInstallment Logs
         * <p>
         * Receive a generator of MerchantInstallmentLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * installmentIds [list of strings, default null]: list of MerchantInstallment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of MerchantInstallmentLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantInstallment.Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve MerchantInstallment Logs
         * <p>
         * Receive a generator of MerchantInstallmentLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantInstallmentLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantInstallment.Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve MerchantInstallment Logs
         * <p>
         * Receive a generator of MerchantInstallmentLog objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of MerchantInstallmentLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantInstallment.Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve MerchantInstallment Logs
         * <p>
         * Receive a generator of MerchantInstallmentLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * installmentIds [list of strings, default null]: list of MerchantInstallment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantInstallmentLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantInstallment.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<MerchantInstallment.Log> logs;
            public String cursor;

            public Page(List<MerchantInstallment.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged MerchantInstallment.Logs
         * <p>
         * Receive a list of up to 100 MerchantInstallmentLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * installmentIds [list of strings, default null]: list of MerchantInstallment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return MerchantInstallment.Log.Page object:
         * MerchantInstallment.Log.Page.logs: list of MerchantInstallmentLog objects with updated attributes
         * MerchantInstallment.Log.Page.cursor: cursor to retrieve the next page of MerchantInstallmentLog objects
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged MerchantInstallment.Logs
         * <p>
         * Receive a list of up to 100 MerchantInstallmentLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantInstallment.Log.Page object:
         * MerchantInstallment.Log.Page.logs: list of MerchantInstallmentLog objects with updated attributes
         * MerchantInstallment.Log.Page.cursor: cursor to retrieve the next page of MerchantInstallmentLog objects
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged MerchantInstallment.Logs
         * <p>
         * Receive a list of up to 100 MerchantInstallmentLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return MerchantInstallment.Log.Page object:
         * MerchantInstallment.Log.Page.logs: list of MerchantInstallmentLog objects with updated attributes
         * MerchantInstallment.Log.Page.cursor: cursor to retrieve the next page of MerchantInstallmentLog objects
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged MerchantInstallment.Logs
         * <p>
         * Receive a list of up to 100 MerchantInstallmentLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * installmentIds [list of strings, default null]: list of MerchantInstallment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantInstallment.Log.Page object:
         * MerchantInstallment.Log.Page.logs: list of MerchantInstallmentLog objects with updated attributes
         * MerchantInstallment.Log.Page.cursor: cursor to retrieve the next page of MerchantInstallmentLog objects
         * @throws Exception error in the request
         */
        public static MerchantInstallment.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<MerchantInstallment.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}

