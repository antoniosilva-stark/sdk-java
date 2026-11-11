package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class InvoicePullRequest extends Resource {
    /**
     * InvoicePullRequest object
     * <p>
     * When you initialize an InvoicePullRequest, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * subscriptionId [string]: Unique of the InvoicePullSubscription related to the invoice. ex: "5656565656565656"
     * invoiceId [string]: Id of the invoice previously created to be sent for payment. ex: "5656565656565656"
     * due [string]: payment scheduled date in UTC ISO format. ex: "2023-10-28T17:59:26.249976+00:00"
     * attemptType [string]: attempt type for the payment. Options: "default", "retry".
     * tags [list of strings]: list of strings for tagging
     * externalId [string]: a string that must be unique among all your InvoicePullRequests. Duplicated externalIds will cause failures. ex: "my-external-id"
     * displayDescription [string]: Description to be shown to the payer. ex: "Payment for services"
     * id [string]: unique id returned when InvoicePullRequest is created. ex: "5656565656565656"
     * status [string]: current InvoicePullRequest status. ex: "pending", "scheduled", "success", "failed", "canceled"
     * installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     * created [string]: creation datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(InvoicePullRequest.class, "InvoicePullRequest");

    public String subscriptionId;
    public String invoiceId;
    public String due;
    public String attemptType;
    public String[] tags;
    public String externalId;
    public String displayDescription;
    public String status;
    public String installmentId;
    public String created;
    public String updated;


    /**
     * InvoicePullRequest object
     * <p>
     * When you initialize an InvoicePullRequest, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param subscriptionId [string]: Unique of the InvoicePullSubscription related to the invoice. ex: "5656565656565656"
     * @param invoiceId [string]: Id of the invoice previously created to be sent for payment. ex: "5656565656565656"
     * @param due [string]: payment scheduled date in UTC ISO format. ex: "2023-10-28T17:59:26.249976+00:00"
     * @param attemptType [string]: attempt type for the payment. Options: "default", "retry".
     * @param tags [list of strings]: list of strings for tagging
     * @param externalId [string]: a string that must be unique among all your InvoicePullRequests. Duplicated externalIds will cause failures. ex: "my-external-id"
     * @param displayDescription [string]: Description to be shown to the payer. ex: "Payment for services"
     * @param id [string]: unique id returned when InvoicePullRequest is created. ex: "5656565656565656"
     * @param status [string]: current InvoicePullRequest status. ex: "pending", "scheduled", "success", "failed", "canceled"
     * @param installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     * @param created [string]: creation datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public InvoicePullRequest(String subscriptionId, String invoiceId, String due, String attemptType, String[] tags, String externalId, String displayDescription, String id, String status, String installmentId, String created, String updated) {
        super(id);
        this.subscriptionId = subscriptionId;
        this.invoiceId = invoiceId;
        this.due = due;
        this.attemptType = attemptType;
        this.tags = tags;
        this.externalId = externalId;
        this.displayDescription = displayDescription;
        this.status = status;
        this.installmentId = installmentId;
        this.created = created;
        this.updated = updated;
    }

    /**
     * InvoicePullRequest object
     * <p>
     * When you initialize an InvoicePullRequest, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the InvoicePullRequest
     * subscriptionId [string]: Unique of the InvoicePullSubscription related to the invoice. ex: "5656565656565656"
     * invoiceId [string]: Id of the invoice previously created to be sent for payment. ex: "5656565656565656"
     * due [string]: payment scheduled date in UTC ISO format. ex: "2023-10-28T17:59:26.249976+00:00"
     * attemptType [string]: attempt type for the payment. Options: "default", "retry".
     * tags [list of strings]: list of strings for tagging
     * externalId [string]: a string that must be unique among all your InvoicePullRequests. Duplicated externalIds will cause failures. ex: "my-external-id"
     * displayDescription [string]: Description to be shown to the payer. ex: "Payment for services"
     * <p>
     * Attributes (return-only):
     * status [string]: current InvoicePullRequest status. ex: "pending", "scheduled", "success", "failed", "canceled"
     * installmentId [string]: unique id of the installment related to this request. ex: "5656565656565656"
     * created [string]: creation datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the InvoicePullRequest. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public InvoicePullRequest(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.subscriptionId = (String) dataCopy.remove("subscriptionId");
        this.invoiceId = (String) dataCopy.remove("invoiceId");
        this.due = (String) dataCopy.remove("due");
        this.attemptType = (String) dataCopy.remove("attemptType");
        this.tags = (String[]) dataCopy.remove("tags");
        this.externalId = (String) dataCopy.remove("externalId");
        this.displayDescription = (String) dataCopy.remove("displayDescription");
        this.status = null;
        this.installmentId = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public InvoicePullRequest() {
        super(null);
    }

    /**
     * Retrieve a specific InvoicePullRequest
     * <p>
     * Receive a single InvoicePullRequest object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return InvoicePullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static InvoicePullRequest get(String id) throws Exception {
        return InvoicePullRequest.get(id, null);
    }

    /**
     * Retrieve a specific InvoicePullRequest
     * <p>
     * Receive a single InvoicePullRequest object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullRequest object with updated attributes
     * @throws Exception error in the request
     */
    public static InvoicePullRequest get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve InvoicePullRequests
     * <p>
     * Receive a generator of InvoicePullRequest objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["success", "failed"]
     * invoiceIds [list of strings, default null]: list of Invoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullRequest> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve InvoicePullRequests
     * <p>
     * Receive a generator of InvoicePullRequest objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["success", "failed"]
     * invoiceIds [list of strings, default null]: list of Invoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullRequest> query(Map<String, Object> params) throws Exception {
        return InvoicePullRequest.query(params, null);
    }

    /**
     * Retrieve InvoicePullRequests
     * <p>
     * Receive a generator of InvoicePullRequest objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullRequest> query(User user) throws Exception {
        return InvoicePullRequest.query(new HashMap<>(), user);
    }

    /**
     * Retrieve InvoicePullRequests
     * <p>
     * Receive a generator of InvoicePullRequest objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<InvoicePullRequest> query() throws Exception {
        return InvoicePullRequest.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<InvoicePullRequest> requests;
        public String cursor;

        public Page(List<InvoicePullRequest> requests, String cursor) {
            this.requests = requests;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged InvoicePullRequests
     * <p>
     * Receive a list of up to 100 InvoicePullRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["success", "failed"]
     * invoiceIds [list of strings, default null]: list of Invoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return InvoicePullRequest.Page object:
     * InvoicePullRequest.Page.requests: list of InvoicePullRequest objects with updated attributes
     * InvoicePullRequest.Page.cursor: cursor to retrieve the next page of InvoicePullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return InvoicePullRequest.page(params, null);
    }

    /**
     * Retrieve paged InvoicePullRequests
     * <p>
     * Receive a list of up to 100 InvoicePullRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullRequest.Page object:
     * InvoicePullRequest.Page.requests: list of InvoicePullRequest objects with updated attributes
     * InvoicePullRequest.Page.cursor: cursor to retrieve the next page of InvoicePullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return InvoicePullRequest.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged InvoicePullRequests
     * <p>
     * Receive a list of up to 100 InvoicePullRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return InvoicePullRequest.Page object:
     * InvoicePullRequest.Page.requests: list of InvoicePullRequest objects with updated attributes
     * InvoicePullRequest.Page.cursor: cursor to retrieve the next page of InvoicePullRequest objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return InvoicePullRequest.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged InvoicePullRequests
     * <p>
     * Receive a list of up to 100 InvoicePullRequest objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [list of strings, default null]: filter for status of retrieved objects. ex: ["success", "failed"]
     * invoiceIds [list of strings, default null]: list of Invoice ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * subscriptionIds [list of strings, default null]: list of InvoicePullSubscription ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * externalIds [list of strings, default null]: list of externalIds to filter retrieved objects. ex: ["my-external-id-1", "my-external-id-2"]
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return InvoicePullRequest.Page object:
     * InvoicePullRequest.Page.requests: list of InvoicePullRequest objects with updated attributes
     * InvoicePullRequest.Page.cursor: cursor to retrieve the next page of InvoicePullRequest objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<InvoicePullRequest> requests = new ArrayList<>();
        for (SubResource invoicePullRequest: page.entities) {
            requests.add((InvoicePullRequest) invoicePullRequest);
        }
        return new Page(requests, page.cursor);
    }

    /**
     * Create InvoicePullRequests
     * <p>
     * Send a list of InvoicePullRequest objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param invoicePullRequests [list of InvoicePullRequest objects or HashMaps]: list of InvoicePullRequest objects to be created in the API
     * <p>
     * Return:
     * @return list of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<InvoicePullRequest> create(List<?> invoicePullRequests) throws Exception {
        return InvoicePullRequest.create(invoicePullRequests, null);
    }

    /**
     * Create InvoicePullRequests
     * <p>
     * Send a list of InvoicePullRequest objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param invoicePullRequests [list of InvoicePullRequest objects or HashMaps]: list of InvoicePullRequest objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of InvoicePullRequest objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<InvoicePullRequest> create(List<?> invoicePullRequests, User user) throws Exception {
        List<InvoicePullRequest> invoicePullRequestList = new ArrayList<>();
        for (Object invoicePullRequest : invoicePullRequests) {
            if (invoicePullRequest instanceof Map) {
                invoicePullRequestList.add(new InvoicePullRequest((Map<String, Object>) invoicePullRequest));
                continue;
            }
            if (invoicePullRequest instanceof InvoicePullRequest) {
                invoicePullRequestList.add((InvoicePullRequest) invoicePullRequest);
                continue;
            }
            throw new Exception("Unknown type \"" + invoicePullRequest.getClass() + "\", use InvoicePullRequest or HashMap");
        }
        return Rest.post(data, invoicePullRequestList, user);
    }

    /**
     * Cancel an InvoicePullRequest entity
     * <p>
     * Cancel an InvoicePullRequest entity previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param id [string]: InvoicePullRequest unique id. ex: '5656565656565656'
     * <p>
     * Return:
     * @return canceled InvoicePullRequest object
     * @throws Exception error in the request
     */
    public static InvoicePullRequest cancel(String id) throws Exception {
        return InvoicePullRequest.cancel(id, null);
    }

    /**
     * Cancel an InvoicePullRequest entity
     * <p>
     * Cancel an InvoicePullRequest entity previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param id [string]: InvoicePullRequest unique id. ex: '5656565656565656'
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return canceled InvoicePullRequest object
     * @throws Exception error in the request
     */
    public static InvoicePullRequest cancel(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "InvoicePullRequestLog");

        public String created;
        public String type;
        public String[] errors;
        public InvoicePullRequest request;

        /**
         * InvoicePullRequest Log object
         * <p>
         * Every time a InvoicePullRequest entity is updated, a corresponding InvoicePullRequest Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the InvoicePullRequest.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param request [InvoicePullRequest]: InvoicePullRequest entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this InvoicePullRequest event
         * @param type [string]: type of the InvoicePullRequest event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, InvoicePullRequest request, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.request = request;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific InvoicePullRequest Log
         * <p>
         * Receive a single InvoicePullRequest Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return InvoicePullRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific InvoicePullRequest Log
         * <p>
         * Receive a single InvoicePullRequest Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullRequest Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve InvoicePullRequest Logs
         * <p>
         * Receive a generator of InvoicePullRequest Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["success" or "failed"]
         * requestIds [list of strings, default null]: list of InvoicePullRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of InvoicePullRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve InvoicePullRequest Logs
         * <p>
         * Receive a generator of InvoicePullRequest Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of InvoicePullRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve InvoicePullRequest Logs
         * <p>
         * Receive a generator of InvoicePullRequest Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of InvoicePullRequest Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve InvoicePullRequest Logs
         * <p>
         * Receive a generator of InvoicePullRequest Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["success" or "failed"]
         * requestIds [list of strings, default null]: list of InvoicePullRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of InvoicePullRequest Log objects with updated attributes
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
         * Retrieve paged InvoicePullRequest.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullRequest Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["success" or "failed"]
         * requestIds [list of strings, default null]: list of InvoicePullRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return InvoicePullRequest.Log.Page object:
         * InvoicePullRequest.Log.Page.logs: list of InvoicePullRequest Log objects with updated attributes
         * InvoicePullRequest.Log.Page.cursor: cursor to retrieve the next page of InvoicePullRequest Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged InvoicePullRequest.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullRequest Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullRequest.Log.Page object:
         * InvoicePullRequest.Log.Page.logs: list of InvoicePullRequest Log objects with updated attributes
         * InvoicePullRequest.Log.Page.cursor: cursor to retrieve the next page of InvoicePullRequest Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged InvoicePullRequest.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullRequest Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return InvoicePullRequest.Log.Page object:
         * InvoicePullRequest.Log.Page.logs: list of InvoicePullRequest Log objects with updated attributes
         * InvoicePullRequest.Log.Page.cursor: cursor to retrieve the next page of InvoicePullRequest Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged InvoicePullRequest.Logs
         * <p>
         * Receive a list of up to 100 InvoicePullRequest Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: ["success" or "failed"]
         * requestIds [list of strings, default null]: list of InvoicePullRequest ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return InvoicePullRequest.Log.Page object:
         * InvoicePullRequest.Log.Page.logs: list of InvoicePullRequest Log objects with updated attributes
         * InvoicePullRequest.Log.Page.cursor: cursor to retrieve the next page of InvoicePullRequest Log objects
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

