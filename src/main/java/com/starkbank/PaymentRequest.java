package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class PaymentRequest extends Resource {
    /**
     * PaymentRequest object
     * <p>
     * A PaymentRequest is an indirect request to access a specific cash-out service (such as Transfers, BoletoPayments, etc.) which goes through the cost center approval flow on our website. To emit a PaymentRequest, you must direct it to a specific cost center by its ID, which can be retrieved on our website at the cost center page.
     * <p>
     * Parameters:
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * payment [Map of String: Object]: payment entity that should be approved and executed. Do not set a "scheduled" value on this entity -- the PaymentRequest's own due date serves that purpose.
     * type [string]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * due [string]: suggested payment target date in ISO format; the cost center's controllers may alter it during approval. ex: 2020-04-30
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * id [string]: unique id returned when a PaymentRequest is created. ex: "5656565656565656"
     * amount [integer]: PaymentRequest amount. ex: 100000 = R$1.000,00
     * description [string]: payment request description. ex: "Tony Stark's Suit"
     * status [string]: current PaymentRequest status. ex: "pending" or "approved"
     * actions [list of maps]: list of actions that are affecting this PaymentRequest. ex: [{"type": "member", "id": "56565656565656, "action": "requested"}]
     * updated [string]: latest update datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(PaymentRequest.class, "PaymentRequest");

    public String centerId;
    public Resource payment;
    public String type;
    public String due;
    public String[] tags;
    public Long amount;
    public String description;
    public String status;
    public List<PaymentRequest.Action> actions;
    public String updated;
    public String created;


    /**
     * PaymentRequest object
     * <p>
     * A PaymentRequest is an indirect request to access a specific cash-out service (such as Transfers, BoletoPayments, etc.) which goes through the cost center approval flow on our website. To emit a PaymentRequest, you must direct it to a specific cost center by its ID, which can be retrieved on our website at the cost center page.
     * <p>
     * Parameters:
     * @param centerId [string]: target cost center ID. ex: "5656565656565656"
     * @param payment [Map of String: Object]: payment entity that should be approved and executed. Do not set a "scheduled" value on this entity -- the PaymentRequest's own due date serves that purpose.
     * @param type [string]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * @param due [string]: suggested payment target date in ISO format; the cost center's controllers may alter it during approval. ex: 2020-04-30
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param id [string]: unique id returned when a PaymentRequest is created. ex: "5656565656565656"
     * @param amount [integer]: PaymentRequest amount. ex: 100000 = R$1.000,00
     * @param description [string]: payment request description. ex: "Tony Stark's Suit"
     * @param status [string]: current PaymentRequest status. ex: "pending" or "approved"
     * @param actions [list of maps]: list of actions that are affecting this PaymentRequest. ex: [{"type": "member", "id": "56565656565656, "action": "requested"}]
     * @param updated [string]: latest update datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public PaymentRequest(String id, String centerId, Resource payment, String type, String due, String[] tags, Long amount, String description, String status, List<PaymentRequest.Action> actions, String updated, String created) throws Exception {
        super(id);
        this.centerId = centerId;
        this.payment = payment;
        this.type = type;
        this.due = due;
        this.tags = tags;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.actions = actions;
        this.updated = updated;
        this.created = created;
        if (this.type == null) {
            this.type = getType(payment);
        }
    }

    /**
     * PaymentRequest object
     * <p>
     * A PaymentRequest is an indirect request to access a specific cash-out service (such as Transfers, BoletoPayments, etc.) which goes through the cost center approval flow on our website. To emit a PaymentRequest, you must direct it to a specific cost center by its ID, which can be retrieved on our website at the cost center page.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PaymentRequest
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * payment [Map of String: Object]: payment entity that should be approved and executed. Do not set a "scheduled" value on this entity -- the PaymentRequest's own due date serves that purpose.
     * type [string]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * due [string]: suggested payment target date in ISO format; the cost center's controllers may alter it during approval. ex: 2020-04-30
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * <p>
     * Attributes (return-only):
     * amount [integer]: PaymentRequest amount. ex: 100000 = R$1.000,00
     * description [string]: payment request description. ex: "Tony Stark's Suit"
     * status [string]: current PaymentRequest status. ex: "pending" or "approved"
     * actions [list of maps]: list of actions that are affecting this PaymentRequest. ex: [{"type": "member", "id": "56565656565656, "action": "requested"}]
     * updated [string]: latest update datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the PaymentRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public PaymentRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.centerId = (String) dataCopy.remove("centerId");
        this.payment = (Resource) dataCopy.remove("payment");
        this.type = (String) dataCopy.remove("type");
        this.due = (String) dataCopy.remove("due");
        this.tags = (String[]) dataCopy.remove("tags");
        this.amount = null;
        this.description = null;
        this.status = null;
        this.actions = null;
        this.updated = null;
        this.created = null;

        if (this.type == null) {
            this.type = getType(payment);
        }

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public PaymentRequest() {
        super(null);
    }

    /**
     * Retrieve PaymentRequests
     * <p>
     * Receive a generator of PaymentRequest objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "-created" or "-due".
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * type [string, default null]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PaymentRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve PaymentRequests
     * <p>
     * Receive a generator of PaymentRequest objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "-created" or "-due".
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * type [string, default null]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PaymentRequest> query(Map<String, Object> params) throws Exception {
        return PaymentRequest.query(params, null);
    }

    /**
     * Retrieve PaymentRequests
     * <p>
     * Receive a generator of PaymentRequest objects previously created by this user in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PaymentRequest> query(User user) throws Exception {
        return PaymentRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve PaymentRequests
     * <p>
     * Receive a generator of PaymentRequest objects previously created by this user in the Stark Bank API
     * <p>
     * Return:
     * @return generator of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<PaymentRequest> query() throws Exception {
        return PaymentRequest.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<PaymentRequest> requests;
        public String cursor;

        public Page(List<PaymentRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged PaymentRequests
     * <p>
     * Receive a list of up to 100 PaymentRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "-created" or "-due".
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * type [string, default null]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return PaymentRequest.Page object:
     * PaymentRequest.Page.requests: list of PaymentRequest objects with updated attributes
     * PaymentRequest.Page.cursor: cursor to retrieve the next page of PaymentRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return PaymentRequest.page(params, null);
    }

    /**
     * Retrieve paged PaymentRequests
     * <p>
     * Receive a list of up to 100 PaymentRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return PaymentRequest.Page object:
     * PaymentRequest.Page.requests: list of PaymentRequest objects with updated attributes
     * PaymentRequest.Page.cursor: cursor to retrieve the next page of PaymentRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return PaymentRequest.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged PaymentRequests
     * <p>
     * Receive a list of up to 100 PaymentRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return PaymentRequest.Page object:
     * PaymentRequest.Page.requests: list of PaymentRequest objects with updated attributes
     * PaymentRequest.Page.cursor: cursor to retrieve the next page of PaymentRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return PaymentRequest.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged PaymentRequests
     * <p>
     * Receive a list of up to 100 PaymentRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * centerId [string]: target cost center ID. ex: "5656565656565656"
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "-created" or "-due".
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * type [string, default null]: payment type, inferred from the payment parameter if it is not a dictionary. ex: "transfer", "boleto-payment"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return PaymentRequest.Page object:
     * PaymentRequest.Page.requests: list of PaymentRequest objects with updated attributes
     * PaymentRequest.Page.cursor: cursor to retrieve the next page of PaymentRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<PaymentRequest> requests = new ArrayList<>();
        for (SubResource paymentRequest: page.entities) {
            requests.add((PaymentRequest) paymentRequest);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create PaymentRequests
     * <p>
     * Send a list of PaymentRequest objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param paymentRequests [list of PaymentRequest objects or HashMaps]: list of PaymentRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<PaymentRequest> create(List<?> paymentRequests) throws Exception {
        return PaymentRequest.create(paymentRequests, null);
    }

    /**
     * Create PaymentRequests
     * <p>
     * Send a list of PaymentRequest objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param paymentRequests [list of PaymentRequest objects or HashMaps]: list of PaymentRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PaymentRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<PaymentRequest> create(List<?> paymentRequests, User user) throws Exception {
        List<PaymentRequest> paymentRequestList = new ArrayList<>();
        for (Object paymentRequest : paymentRequests) {
            if (paymentRequest instanceof Map) {
                paymentRequestList.add(new PaymentRequest((Map<String, Object>) paymentRequest));
                continue;
            }
            if (paymentRequest instanceof PaymentRequest) {
                paymentRequestList.add((PaymentRequest) paymentRequest);
                continue;
            }
            throw new Exception("Unknown type \"" + paymentRequest.getClass() + "\", use PaymentRequest or HashMap");
        }
        return Rest.post(data, paymentRequestList, user);
    }

    private static String getType(Resource payment) throws Exception {
        if (payment instanceof Transfer) {
            return "transfer";
        }
        if (payment instanceof Transaction) {
            return "transaction";
        }
        if (payment instanceof BoletoPayment) {
            return "boleto-payment";
        }
        if (payment instanceof UtilityPayment) {
            return "utility-payment";
        }
        if (payment instanceof TaxPayment) {
            return "tax-payment";
        }
        if (payment instanceof DarfPayment) {
            return "darf-payment";
        }
        if (payment instanceof BrcodePayment) {
            return "brcode-payment";
        }
        throw new Exception("Payment must either be a Transfer, a Transaction, a BoletoPayment, a BrcodePayment, a UtilityPayment, a TaxPayment or a DarfPayment.");
    }

    public final static class Action extends SubResource {
        public String name;
        public String action;
        public String type;
        public String id;

        public Action(String name, String action, String type, String id) {
            this.name = name;
            this.action = action;
            this.type = type;
            this.id = id;
        }

        public Action() {
        }
    }

    public final static class Log extends Resource {
        public String created;
        public String updated;
        public String type;
        public String[] errors;
        public PaymentRequest request;
        public PaymentRequest.Log.User user;

        static ClassData data = new ClassData(Log.class, "PaymentRequestLog");

        public Log(String created, String updated, String type, String[] errors, PaymentRequest request, PaymentRequest.Log.User user, String id) {
            super(id);
            this.created = created;
            this.updated = updated;
            this.type = type;
            this.errors = errors;
            this.request = request;
            this.user = user;
        }

        public Log() {
            super(null);
        }

        public final static class User extends SubResource {
            public String email;
            public String id;
            public String name;
            public String pictureUrl;
            public String status;
            public String type;

            public User(String email, String id, String name, String pictureUrl, String status, String type) {
                this.email = email;
                this.id = id;
                this.name = name;
                this.pictureUrl = pictureUrl;
                this.status = status;
                this.type = type;
            }

            public User() {
            }
        }
    }
}

