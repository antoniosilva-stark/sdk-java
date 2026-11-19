package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class InvoicePullSubscription extends Resource {
    /**
     * InvoicePullSubscription object
     * <p>
     * When you initialize an InvoicePullSubscription, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * start [string]: subscription start date. ex: "2022-04-01"
     * interval [string]: subscription installment interval. Options: "week", "month", "quarter", "semester", "year"
     * pullMode [string]: subscription pull mode. Options: "manual", "automatic". Automatic mode will create the Invoice Pull Requests automatically
     * pullRetryLimit [integer]: subscription pull retry limit. Options: 0, 3
     * type [string]: subscription type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * amount [integer]: subscription amount in cents. Required if an amountMinLimit is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * amountMinLimit [integer]: subscription minimum amount in cents. Required if an amount is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * displayDescription [string]: Invoice description to be shown to the payer. ex: "Subscription payment"
     * due [string]: date by which the payer must approve or deny the subscription; defaults to 2 days after creation if not informed. Applies to every subscription type. ex: "2022-04-08"
     * externalId [string]: string that must be unique among all your InvoicePullSubscriptions. Duplicated externalIds will cause failures. ex: "my-external-id"
     * referenceCode [string]: reference code for reconciliation. ex: "REF123456"
     * end [string]: subscription end date. ex: "2023-04-01"
     * data [Map of String: Object]: additional data for the subscription, required for types "push" (payer's account details), "qrcodeAndPayment" and "paymentAndOrQrcode" (immediate payment parameters); not required for type "qrcode"
     * name [string]: subscription debtor name. ex: "Iron Bank S.A."
     * taxId [string]: subscription debtor tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * tags [list of strings]: list of strings for tagging
     * id [string]: unique id returned when InvoicePullSubscription is created. ex: "5656565656565656"
     * status [string]: current InvoicePullSubscription status. ex: "active", "canceled"
     * bacenId [string]: unique authentication id at the Central Bank. ex: "RR2001818320250616dtsPkBVaBYs"
     * brcode [string]: Brcode string for the InvoicePullSubscription. ex: "00020101021126580014br.gov.bcb.pix0114+5599999999990210starkbank.com.br520400005303986540410000000000005802BR5913Stark Bank S.A.6009SAO PAULO62070503***6304D2B1"
     * created [string]: creation datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     */
    static ClassData classData = new ClassData(InvoicePullSubscription.class, "InvoicePullSubscription");

    public String start;
    public String interval;
    public String pullMode;
    public Long pullRetryLimit;
    public String type;
    public Long amount;
    public Long amountMinLimit;
    public String displayDescription;
    public String due;
    public String externalId;
    public String referenceCode;
    public String end;
    public Map<String, Object> data;
    public String name;
    public String taxId;
    public String[] tags;
    public String status;
    public String bacenId;
    public String brcode;
    public String created;
    public String updated;
    public String installmentId;


    /**
     * InvoicePullSubscription object
     * <p>
     * When you initialize an InvoicePullSubscription, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param start [string]: subscription start date. ex: "2022-04-01"
     * @param interval [string]: subscription installment interval. Options: "week", "month", "quarter", "semester", "year"
     * @param pullMode [string]: subscription pull mode. Options: "manual", "automatic". Automatic mode will create the Invoice Pull Requests automatically
     * @param pullRetryLimit [integer]: subscription pull retry limit. Options: 0, 3
     * @param type [string]: subscription type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * @param amount [integer]: subscription amount in cents. Required if an amountMinLimit is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * @param amountMinLimit [integer]: subscription minimum amount in cents. Required if an amount is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * @param displayDescription [string]: Invoice description to be shown to the payer. ex: "Subscription payment"
     * @param due [string]: date by which the payer must approve or deny the subscription; defaults to 2 days after creation if not informed. Applies to every subscription type. ex: "2022-04-08"
     * @param externalId [string]: string that must be unique among all your InvoicePullSubscriptions. Duplicated externalIds will cause failures. ex: "my-external-id"
     * @param referenceCode [string]: reference code for reconciliation. ex: "REF123456"
     * @param end [string]: subscription end date. ex: "2023-04-01"
     * @param data [Map of String: Object]: additional data for the subscription, required for types "push" (payer's account details), "qrcodeAndPayment" and "paymentAndOrQrcode" (immediate payment parameters); not required for type "qrcode"
     * @param name [string]: subscription debtor name. ex: "Iron Bank S.A."
     * @param taxId [string]: subscription debtor tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param tags [list of strings]: list of strings for tagging
     * @param id [string]: unique id returned when InvoicePullSubscription is created. ex: "5656565656565656"
     * @param status [string]: current InvoicePullSubscription status. ex: "active", "canceled"
     * @param bacenId [string]: unique authentication id at the Central Bank. ex: "RR2001818320250616dtsPkBVaBYs"
     * @param brcode [string]: Brcode string for the InvoicePullSubscription. ex: "00020101021126580014br.gov.bcb.pix0114+5599999999990210starkbank.com.br520400005303986540410000000000005802BR5913Stark Bank S.A.6009SAO PAULO62070503***6304D2B1"
     * @param created [string]: creation datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     */
    public InvoicePullSubscription(String start, String interval, String pullMode, Long pullRetryLimit, String type, Long amount, Long amountMinLimit, String displayDescription, String due, String externalId, String referenceCode, String end, Map<String, Object> data, String name, String taxId, String[] tags, String status, String bacenId, String installmentId, String brcode, String created, String updated, String id) {
        super(id);
        this.start = start;
        this.interval = interval;
        this.pullMode = pullMode;
        this.pullRetryLimit = pullRetryLimit;
        this.type = type;
        this.amount = amount;
        this.amountMinLimit = amountMinLimit;
        this.displayDescription = displayDescription;
        this.due = due;
        this.externalId = externalId;
        this.referenceCode = referenceCode;
        this.end = end;
        this.data = data;
        this.name = name;
        this.taxId = taxId;
        this.tags = tags;
        this.status = status;
        this.bacenId = bacenId;
        this.installmentId = installmentId;
        this.brcode = brcode;
        this.created = created;
        this.updated = updated;
    }

    /**
     * InvoicePullSubscription object
     * <p>
     * When you initialize an InvoicePullSubscription, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param classData map of properties for the creation of the InvoicePullSubscription
     * start [string]: subscription start date. ex: "2022-04-01"
     * interval [string]: subscription installment interval. Options: "week", "month", "quarter", "semester", "year"
     * pullMode [string]: subscription pull mode. Options: "manual", "automatic". Automatic mode will create the Invoice Pull Requests automatically
     * pullRetryLimit [integer]: subscription pull retry limit. Options: 0, 3
     * type [string]: subscription type. Options: "push", "qrcode", "qrcodeAndPayment", "paymentAndOrQrcode"
     * amount [integer]: subscription amount in cents. Required if an amountMinLimit is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * amountMinLimit [integer]: subscription minimum amount in cents. Required if an amount is not informed. Minimum = 1 (R$ 0.01). ex: 100 (= R$ 1.00)
     * displayDescription [string]: Invoice description to be shown to the payer. ex: "Subscription payment"
     * due [string]: date by which the payer must approve or deny the subscription; defaults to 2 days after creation if not informed. Applies to every subscription type. ex: "2022-04-08"
     * externalId [string]: string that must be unique among all your InvoicePullSubscriptions. Duplicated externalIds will cause failures. ex: "my-external-id"
     * referenceCode [string]: reference code for reconciliation. ex: "REF123456"
     * end [string]: subscription end date. ex: "2023-04-01"
     * data [Map of String: Object]: additional data for the subscription, required for types "push" (payer's account details), "qrcodeAndPayment" and "paymentAndOrQrcode" (immediate payment parameters); not required for type "qrcode"
     * name [string]: subscription debtor name. ex: "Iron Bank S.A."
     * taxId [string]: subscription debtor tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * tags [list of strings]: list of strings for tagging
     * installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     * <p>
     * Attributes (return-only):
     * status [string]: current InvoicePullSubscription status. ex: "active", "canceled"
     * bacenId [string]: unique authentication id at the Central Bank. ex: "RR2001818320250616dtsPkBVaBYs"
     * brcode [string]: Brcode string for the InvoicePullSubscription. ex: "00020101021126580014br.gov.bcb.pix0114+5599999999990210starkbank.com.br520400005303986540410000000000005802BR5913Stark Bank S.A.6009SAO PAULO62070503***6304D2B1"
     * created [string]: creation datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the InvoicePullSubscription. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public InvoicePullSubscription(Map<String, Object> classData) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(classData);
        this.start = (String) dataCopy.remove("start");
        this.interval = (String) dataCopy.remove("interval");
        this.pullMode = (String) dataCopy.remove("pullMode");
        Number pullRetryLimit = (Number) dataCopy.remove("pullRetryLimit");
        this.pullRetryLimit = pullRetryLimit == null ? null : pullRetryLimit.longValue();
        this.type = (String) dataCopy.remove("type");
        Number amount = (Number) dataCopy.remove("amount");
        this.amount = amount == null ? null : amount.longValue();
        Number amountMinLimit = (Number) dataCopy.remove("amountMinLimit");
        this.amountMinLimit = amountMinLimit == null ? null : amountMinLimit.longValue();
        this.displayDescription = (String) dataCopy.remove("displayDescription");
        this.due = (String) dataCopy.remove("due");
        this.externalId = (String) dataCopy.remove("externalId");
        this.referenceCode = (String) dataCopy.remove("referenceCode");
        this.end = (String) dataCopy.remove("end");
        this.data = (Map<String, Object>) dataCopy.remove("data");
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.status = null;
        this.bacenId = null;
        this.brcode = null;
        this.created = null;
        this.updated = null;
        this.installmentId = (String) dataCopy.remove("installmentId");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public InvoicePullSubscription() {
        super(null);
    }

    /**
     * Retrieve a specific InvoicePullSubscription
     * <p>
     * Receive a single InvoicePullSubscription object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return InvoicePullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static InvoicePullSubscription get(String id) throws Exception {
        return InvoicePullSubscription.get(id, null);
    }

    /**
     * Retrieve a specific InvoicePullSubscription
     * <p>
     * Receive a single InvoicePullSubscription object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullSubscription object with updated attributes
     * @throws Exception error in the request
     */
    public static InvoicePullSubscription get(String id, User user) throws Exception {
        return Rest.getId(classData, id, user);
    }

    /**
     * Retrieve InvoicePullSubscriptions
     * <p>
     * Receive a generator of InvoicePullSubscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * invoiceIds [list of strings, default null]: list of Invoice ids linked to the subscriptions. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullSubscription> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(classData, params, user);
    }

    /**
     * Retrieve InvoicePullSubscriptions
     * <p>
     * Receive a generator of InvoicePullSubscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * invoiceIds [list of strings, default null]: list of Invoice ids linked to the subscriptions. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullSubscription> query(Map<String, Object> params) throws Exception {
        return InvoicePullSubscription.query(params, null);
    }

    /**
     * Retrieve InvoicePullSubscriptions
     * <p>
     * Receive a generator of InvoicePullSubscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullSubscription> query(User user) throws Exception {
        return InvoicePullSubscription.query(new HashMap<>(), user);
    }

    /**
     * Retrieve InvoicePullSubscriptions
     * <p>
     * Receive a generator of InvoicePullSubscription objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullSubscription> query() throws Exception {
        return InvoicePullSubscription.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<InvoicePullSubscription> subscriptions;
        public String cursor;

        public Page(List<InvoicePullSubscription> subscriptions, String cursor) {
            this.subscriptions = subscriptions;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged InvoicePullSubscriptions
     * <p>
     * Receive a list of up to 100 InvoicePullSubscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * invoiceIds [list of strings, default null]: list of Invoice ids linked to the subscriptions. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return InvoicePullSubscription.Page object:
     * InvoicePullSubscription.Page.subscriptions: list of InvoicePullSubscription objects with updated attributes
     * InvoicePullSubscription.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return InvoicePullSubscription.page(params, null);
    }

    /**
     * Retrieve paged InvoicePullSubscriptions
     * <p>
     * Receive a list of up to 100 InvoicePullSubscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullSubscription.Page object:
     * InvoicePullSubscription.Page.subscriptions: list of InvoicePullSubscription objects with updated attributes
     * InvoicePullSubscription.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return InvoicePullSubscription.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged InvoicePullSubscriptions
     * <p>
     * Receive a list of up to 100 InvoicePullSubscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return InvoicePullSubscription.Page object:
     * InvoicePullSubscription.Page.subscriptions: list of InvoicePullSubscription objects with updated attributes
     * InvoicePullSubscription.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return InvoicePullSubscription.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged InvoicePullSubscriptions
     * <p>
     * Receive a list of up to 100 InvoicePullSubscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["active", "canceled"]
     * invoiceIds [list of strings, default null]: list of Invoice ids linked to the subscriptions. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullSubscription.Page object:
     * InvoicePullSubscription.Page.subscriptions: list of InvoicePullSubscription objects with updated attributes
     * InvoicePullSubscription.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(classData, params, user);
        List<InvoicePullSubscription> subscriptions = new ArrayList<>();
        for (SubResource invoicePullSubscription: page.entities) {
            subscriptions.add((InvoicePullSubscription) invoicePullSubscription);
        }
        return new Page(subscriptions, page.cursor);
    }

    /**
     * Create InvoicePullSubscriptions
     * <p>
     * Send a list of InvoicePullSubscription objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param invoicePullSubscriptions [list of InvoicePullSubscription objects or HashMaps]: list of InvoicePullSubscription objects to be created in the API
     * <p>
     * Return:
     * @return list of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<InvoicePullSubscription> create(List<?> invoicePullSubscriptions) throws Exception {
        return InvoicePullSubscription.create(invoicePullSubscriptions, null);
    }

    /**
     * Create InvoicePullSubscriptions
     * <p>
     * Send a list of InvoicePullSubscription objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param invoicePullSubscriptions [list of InvoicePullSubscription objects or HashMaps]: list of InvoicePullSubscription objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of InvoicePullSubscription objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<InvoicePullSubscription> create(List<?> invoicePullSubscriptions, User user) throws Exception {
        List<InvoicePullSubscription> invoicePullSubscriptionList = new ArrayList<>();
        for (Object invoicePullSubscription : invoicePullSubscriptions) {
            if (invoicePullSubscription instanceof Map) {
                invoicePullSubscriptionList.add(new InvoicePullSubscription((Map<String, Object>) invoicePullSubscription));
                continue;
            }
            if (invoicePullSubscription instanceof InvoicePullSubscription) {
                invoicePullSubscriptionList.add((InvoicePullSubscription) invoicePullSubscription);
                continue;
            }
            throw new Exception("Unknown type \"" + invoicePullSubscription.getClass() + "\", use InvoicePullSubscription or HashMap");
        }
        return Rest.post(classData, invoicePullSubscriptionList, user);
    }

    /**
     * Cancel an InvoicePullSubscription entity
     * <p>
     * Cancel an InvoicePullSubscription entity previously created in the Stark Bank API. The subscription must currently be in "active" status to be canceled.
     * <p>
     * Parameters:
     * @param id [string]: InvoicePullSubscription unique id. ex: '5656565656565656'
     * <p>
     * Return:
     * @return canceled InvoicePullSubscription object
     * @throws Exception error in the request
     */
    public static InvoicePullSubscription cancel(String id) throws Exception {
        return InvoicePullSubscription.cancel(id, null);
    }

    /**
     * Cancel an InvoicePullSubscription entity
     * <p>
     * Cancel an InvoicePullSubscription entity previously created in the Stark Bank API. The subscription must currently be in "active" status to be canceled.
     * <p>
     * Parameters:
     * @param id [string]: InvoicePullSubscription unique id. ex: '5656565656565656'
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled InvoicePullSubscription object
     * @throws Exception error in the request
     */
    public static InvoicePullSubscription cancel(String id, User user) throws Exception {
        return Rest.delete(classData, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "InvoicePullSubscriptionLog");

        public String created;
        public String type;
        public String[] errors;
        public InvoicePullSubscription subscription;

        /**
         * InvoicePullSubscription Log object
         * <p>
         * Every time a InvoicePullSubscription entity is updated, a corresponding InvoicePullSubscription Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the InvoicePullSubscription.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param subscription [InvoicePullSubscription]: InvoicePullSubscription entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this InvoicePullSubscription event
         * @param type [string]: type of the InvoicePullSubscription event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, InvoicePullSubscription subscription, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.subscription = subscription;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific InvoicePullSubscription Log
         * <p>
         * Receive a single InvoicePullSubscription Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return InvoicePullSubscription Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific InvoicePullSubscription Log
         * <p>
         * Receive a single InvoicePullSubscription Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullSubscription Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve InvoicePullSubscription Logs
         * <p>
         * Receive a generator of InvoicePullSubscription Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["active" or "canceled"]
         * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of InvoicePullSubscription Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve InvoicePullSubscription Logs
         * <p>
         * Receive a generator of InvoicePullSubscription Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of InvoicePullSubscription Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve InvoicePullSubscription Logs
         * <p>
         * Receive a generator of InvoicePullSubscription Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of InvoicePullSubscription Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve InvoicePullSubscription Logs
         * <p>
         * Receive a generator of InvoicePullSubscription Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["active" or "canceled"]
         * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of InvoicePullSubscription Log objects with updated attributes
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
         * Retrieve paged InvoicePullSubscription.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullSubscription Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["active" or "canceled"]
         * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return InvoicePullSubscription.Log.Page object:
         * InvoicePullSubscription.Log.Page.logs: list of InvoicePullSubscription Log objects with updated attributes
         * InvoicePullSubscription.Log.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged InvoicePullSubscription.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullSubscription Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullSubscription.Log.Page object:
         * InvoicePullSubscription.Log.Page.logs: list of InvoicePullSubscription Log objects with updated attributes
         * InvoicePullSubscription.Log.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged InvoicePullSubscription.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullSubscription Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return InvoicePullSubscription.Log.Page object:
         * InvoicePullSubscription.Log.Page.logs: list of InvoicePullSubscription Log objects with updated attributes
         * InvoicePullSubscription.Log.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged InvoicePullSubscription.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullSubscription Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["active" or "canceled"]
         * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullSubscription.Log.Page object:
         * InvoicePullSubscription.Log.Page.logs: list of InvoicePullSubscription Log objects with updated attributes
         * InvoicePullSubscription.Log.Page.cursor: cursor to retrieve the next page of InvoicePullSubscription Log objects
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

