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


public final class BrcodePayment extends Resource {
    /**
     * BrcodePayment object
     * <p>
     * When you initialize a BrcodePayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * brcode [string]: String loaded directly from the QR Code or copied from the invoice. ex: "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * amount [integer]: If the BRCode does not provide an amount, this parameter is mandatory, else it is optional. ex: 23456 (= R$ 234.56)
     * scheduled [string]: payment scheduled date or datetime. ex: "2020-03-10 15:17:03.000000+00:00"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * rules [list of maps]: list of BrcodePayment.Rule objects for modifying payment behavior. ex: [Rule(key="resendingLimit", value=5)]
     * id [string]: unique id returned when payment is created. ex: "5656565656565656"
     * name [string]: receiver name. ex: "Jon Snow"
     * status [string]: current payment status. ex: "success" or "failed"
     * type [string]: brcode type. ex: "static" or "dynamic"
     * transactionIds [list of strings]: ledger transaction ids linked to this payment. ex: ["19827356981273"]
     * fee [integer]: fee charged by this brcode payment. ex: 50 (= R$ 0.50)
     * updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(BrcodePayment.class, "BrcodePayment");

    public String brcode;
    public String taxId;
    public String description;
    public Number amount;
    public String scheduled;
    public String[] tags;
    public List<BrcodePayment.Rule> rules;
    public String name;
    public String status;
    public String type;
    public String[] transactionIds;
    public Integer fee;
    public String updated;
    public String created;


    /**
     * BrcodePayment object
     * <p>
     * When you initialize a BrcodePayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param brcode [string]: String loaded directly from the QR Code or copied from the invoice. ex: "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * @param taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * @param amount [integer]: If the BRCode does not provide an amount, this parameter is mandatory, else it is optional. ex: 23456 (= R$ 234.56)
     * @param scheduled [string]: payment scheduled date or datetime. ex: "2020-03-10 15:17:03.000000+00:00"
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param rules [list of maps]: list of BrcodePayment.Rule objects for modifying payment behavior. ex: [Rule(key="resendingLimit", value=5)]
     * @param id [string]: unique id returned when payment is created. ex: "5656565656565656"
     * @param name [string]: receiver name. ex: "Jon Snow"
     * @param status [string]: current payment status. ex: "success" or "failed"
     * @param type [string]: brcode type. ex: "static" or "dynamic"
     * @param transactionIds [list of strings]: ledger transaction ids linked to this payment. ex: ["19827356981273"]
     * @param fee [integer]: fee charged by this brcode payment. ex: 50 (= R$ 0.50)
     * @param updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public BrcodePayment(String brcode, String taxId, String description, Number amount, String scheduled, String name, String[] tags, List<BrcodePayment.Rule> rules, String id, String status, String type, String[] transactionIds, Integer fee, String updated, String created) {
        super(id);
        this.brcode = brcode;
        this.taxId = taxId;
        this.description = description;
        this.amount = amount;
        this.scheduled = scheduled;
        this.name = name;
        this.tags = tags;
        this.rules = rules;
        this.status = status;
        this.type = type;
        this.transactionIds = transactionIds;
        this.fee = fee;
        this.updated = updated;
        this.created = created;
    }

    /**
     * BrcodePayment object
     * <p>
     * When you initialize a BrcodePayment, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the BrcodePayment
     * brcode [string]: String loaded directly from the QR Code or copied from the invoice. ex: "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * description [string]: Text to be displayed in your statement (min. 10 characters). ex: "payment ABC"
     * amount [integer]: If the BRCode does not provide an amount, this parameter is mandatory, else it is optional. ex: 23456 (= R$ 234.56)
     * scheduled [string]: payment scheduled date or datetime. ex: "2020-03-10 15:17:03.000000+00:00"
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * rules [list of maps]: list of BrcodePayment.Rule objects for modifying payment behavior. ex: [Rule(key="resendingLimit", value=5)]
     * <p>
     * Attributes (return-only):
     * name [string]: receiver name. ex: "Jon Snow"
     * status [string]: current payment status. ex: "success" or "failed"
     * type [string]: brcode type. ex: "static" or "dynamic"
     * transactionIds [list of strings]: ledger transaction ids linked to this payment. ex: ["19827356981273"]
     * fee [integer]: fee charged by this brcode payment. ex: 50 (= R$ 0.50)
     * updated [string]: latest update datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the payment. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public BrcodePayment(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.brcode = (String) dataCopy.remove("brcode");
        this.taxId = (String) dataCopy.remove("taxId");
        this.description = (String) dataCopy.remove("description");
        this.amount = (Number) dataCopy.remove("amount");
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.tags = (String[]) dataCopy.remove("tags");
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.name = null;
        this.status = null;
        this.type = null;
        this.transactionIds = null;
        this.fee = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public BrcodePayment() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<BrcodePayment.Rule> parseRules(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<BrcodePayment.Rule> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof BrcodePayment.Rule) {
                parsed.add((BrcodePayment.Rule) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new BrcodePayment.Rule((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use BrcodePayment.Rule or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific BrcodePayment
     * <p>
     * Receive a single BrcodePayment object previously created by the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BrcodePayment object with updated attributes
     * @throws Exception error in the request
     */
    public static BrcodePayment get(String id) throws Exception {
        return BrcodePayment.get(id, null);
    }

    /**
     * Retrieve a specific BrcodePayment
     * <p>
     * Receive a single BrcodePayment object previously created by the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BrcodePayment object with updated attributes
     * @throws Exception error in the request
     */
    public static BrcodePayment get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve BrcodePayments
     * <p>
     * Receive a generator of BrcodePayment objects previously created in the Stark Bank API
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
     * @return generator of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodePayment> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve BrcodePayments
     * <p>
     * Receive a generator of BrcodePayment objects previously created in the Stark Bank API
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
     * @return generator of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodePayment> query(Map<String, Object> params) throws Exception {
        return BrcodePayment.query(params, null);
    }

    /**
     * Retrieve BrcodePayments
     * <p>
     * Receive a generator of BrcodePayment objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodePayment> query(User user) throws Exception {
        return BrcodePayment.query(new HashMap<>(), user);
    }

    /**
     * Retrieve BrcodePayments
     * <p>
     * Receive a generator of BrcodePayment objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<BrcodePayment> query() throws Exception {
        return BrcodePayment.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<BrcodePayment> payments;
        public String cursor;

        public Page(List<BrcodePayment> payments, String cursor) {
            this.payments = payments;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged BrcodePayments
     * <p>
     * Receive a list of up to 100 BrcodePayment objects previously created in the Stark Bank API and the cursor to the next page.
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
     * @return BrcodePayment.Page object:
     * BrcodePayment.Page.payments: list of BrcodePayment objects with updated attributes
     * BrcodePayment.Page.cursor: cursor to retrieve the next page of BrcodePayment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return BrcodePayment.page(params, null);
    }

    /**
     * Retrieve paged BrcodePayments
     * <p>
     * Receive a list of up to 100 BrcodePayment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BrcodePayment.Page object:
     * BrcodePayment.Page.payments: list of BrcodePayment objects with updated attributes
     * BrcodePayment.Page.cursor: cursor to retrieve the next page of BrcodePayment objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return BrcodePayment.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged BrcodePayments
     * <p>
     * Receive a list of up to 100 BrcodePayment objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return BrcodePayment.Page object:
     * BrcodePayment.Page.payments: list of BrcodePayment objects with updated attributes
     * BrcodePayment.Page.cursor: cursor to retrieve the next page of BrcodePayment objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return BrcodePayment.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged BrcodePayments
     * <p>
     * Receive a list of up to 100 BrcodePayment objects previously created in the Stark Bank API and the cursor to the next page.
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
     * @return BrcodePayment.Page object:
     * BrcodePayment.Page.payments: list of BrcodePayment objects with updated attributes
     * BrcodePayment.Page.cursor: cursor to retrieve the next page of BrcodePayment objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<BrcodePayment> payments = new ArrayList<>();
        for (SubResource brcodePayment: page.entities) {
            payments.add((BrcodePayment) brcodePayment);
        }
        return new Page(payments, page.cursor);
    }

    /**
     * Create BrcodePayments
     * <p>
     * Send a list of BrcodePayment objects for creation in the Stark Bank API. Because processing is asynchronous, the amount attribute of a freshly created BrcodePayment will initially be zero.
     * <p>
     * Parameters:
     * @param brcodePayments [list of BrcodePayment objects or HashMaps]: list of BrcodePayment objects to be created in the API
     * <p>
     * Return:
     * @return list of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<BrcodePayment> create(List<?> brcodePayments) throws Exception {
        return BrcodePayment.create(brcodePayments, null);
    }

    /**
     * Create BrcodePayments
     * <p>
     * Send a list of BrcodePayment objects for creation in the Stark Bank API. Because processing is asynchronous, the amount attribute of a freshly created BrcodePayment will initially be zero.
     * <p>
     * Parameters:
     * @param brcodePayments [list of BrcodePayment objects or HashMaps]: list of BrcodePayment objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of BrcodePayment objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<BrcodePayment> create(List<?> brcodePayments, User user) throws Exception {
        List<BrcodePayment> brcodePaymentList = new ArrayList<>();
        for (Object brcodePayment : brcodePayments) {
            if (brcodePayment instanceof Map) {
                brcodePaymentList.add(new BrcodePayment((Map<String, Object>) brcodePayment));
                continue;
            }
            if (brcodePayment instanceof BrcodePayment) {
                brcodePaymentList.add((BrcodePayment) brcodePayment);
                continue;
            }
            throw new Exception("Unknown type \"" + brcodePayment.getClass() + "\", use BrcodePayment or HashMap");
        }
        return Rest.post(data, brcodePaymentList, user);
    }

    /**
     * Update BrcodePayment entity
     * <p>
     * Update a BrcodePayment by passing its Id, if it hasn't been paid yet.
     * <p>
     * Parameters:
     * @param id [string]: BrcodePayment id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * status [string]: You may cancel the payment by passing 'canceled' in the status
     * <p>
     * Return:
     * @return target BrcodePayment with updated attributes
     * @throws Exception error in the request
     */
    public static BrcodePayment update(String id, Map<String, Object> patchData) throws Exception {
        return BrcodePayment.update(id, patchData, null);
    }

    /**
     * Update BrcodePayment entity
     * <p>
     * Update a BrcodePayment by passing its Id, if it hasn't been paid yet.
     * <p>
     * Parameters:
     * @param id [string]: BrcodePayment id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * status [string]: You may cancel the payment by passing 'canceled' in the status
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return target BrcodePayment with updated attributes
     * @throws Exception error in the request
     */
    public static BrcodePayment update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Retrieve a specific BrcodePayment pdf file
     * <p>
     * Receive a single BrcodePayment pdf receipt file generated in the Stark Bank API by its id. Only valid for brcode payments with "success", "processing" or "created" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return BrcodePayment pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return BrcodePayment.pdf(id, null);
    }

    /**
     * Retrieve a specific BrcodePayment pdf file
     * <p>
     * Receive a single BrcodePayment pdf receipt file generated in the Stark Bank API by its id. Only valid for brcode payments with "success", "processing" or "created" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return BrcodePayment pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "BrcodePaymentLog");

        public String created;
        public String type;
        public String[] errors;
        public BrcodePayment payment;

        /**
         * BrcodePayment Log object
         * <p>
         * Every time a BrcodePayment entity is updated, a corresponding BrcodePayment Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the BrcodePayment.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param payment [BrcodePayment]: BrcodePayment entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this BrcodePayment event
         * @param type [string]: type of the BrcodePayment event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, BrcodePayment payment, String id) {
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
         * Retrieve a specific BrcodePayment Log
         * <p>
         * Receive a single BrcodePayment Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return BrcodePayment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific BrcodePayment Log
         * <p>
         * Receive a single BrcodePayment Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BrcodePayment Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve BrcodePayment Logs
         * <p>
         * Receive a generator of BrcodePayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of BrcodePayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of BrcodePayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve BrcodePayment Logs
         * <p>
         * Receive a generator of BrcodePayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BrcodePayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve BrcodePayment Logs
         * <p>
         * Receive a generator of BrcodePayment Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of BrcodePayment Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve BrcodePayment Logs
         * <p>
         * Receive a generator of BrcodePayment Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of BrcodePayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of BrcodePayment Log objects with updated attributes
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
         * Retrieve paged BrcodePayment.Logs
         * <p>
         * Receive a list of up to 100 BrcodePayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of BrcodePayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return BrcodePayment.Log.Page object:
         * BrcodePayment.Log.Page.logs: list of BrcodePayment Log objects with updated attributes
         * BrcodePayment.Log.Page.cursor: cursor to retrieve the next page of BrcodePayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged BrcodePayment.Logs
         * <p>
         * Receive a list of up to 100 BrcodePayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BrcodePayment.Log.Page object:
         * BrcodePayment.Log.Page.logs: list of BrcodePayment Log objects with updated attributes
         * BrcodePayment.Log.Page.cursor: cursor to retrieve the next page of BrcodePayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged BrcodePayment.Logs
         * <p>
         * Receive a list of up to 100 BrcodePayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return BrcodePayment.Log.Page object:
         * BrcodePayment.Log.Page.logs: list of BrcodePayment Log objects with updated attributes
         * BrcodePayment.Log.Page.cursor: cursor to retrieve the next page of BrcodePayment Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged BrcodePayment.Logs
         * <p>
         * Receive a list of up to 100 BrcodePayment Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: "processing" or "success"
         * paymentIds [list of strings, default null]: list of BrcodePayment ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return BrcodePayment.Log.Page object:
         * BrcodePayment.Log.Page.logs: list of BrcodePayment Log objects with updated attributes
         * BrcodePayment.Log.Page.cursor: cursor to retrieve the next page of BrcodePayment Log objects
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

    public final static class Rule extends SubResource {
        public String key;
        public Number value;

        public Rule(String key, Number value) {
            this.key = key;
            this.value = value;
        }

        public Rule() {
        }

        public Rule(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.key = (String) dataCopy.remove("key");
            this.value = (Number) dataCopy.remove("value");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}

