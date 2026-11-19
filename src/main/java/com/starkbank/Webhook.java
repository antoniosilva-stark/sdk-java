package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Webhook extends Resource {
    /**
     * Webhook object
     * <p>
     * A Webhook is used to subscribe to notification events on a user-selected endpoint. Currently, available services for subscription are transfer, boleto, boleto-holmes, boleto-payment, brcode-payment, utility-payment, deposit, darf-payment, payment-request and invoice. Events are delivered with a digital signature (the 'Digital-Signature' response header), verifiable with starkbank.event.parse(). If your endpoint does not return HTTP 200, delivery is retried up to three times, at 5, 30 and 120 minute intervals, after which the event is no longer resent -- use starkbank.event.query(is_delivered=false) daily to catch anything missed. A Webhook only receives events from the API version it was registered under.
     * <p>
     * Parameters:
     * url [string]: Url that will be notified when an event occurs.
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "invoice", "deposit"]
     * id [string]: unique id returned when the webhook is created. ex: "5656565656565656"
     */
    static ClassData data = new ClassData(Webhook.class, "Webhook");

    public String url;
    public String[] subscriptions;


    /**
     * Webhook object
     * <p>
     * A Webhook is used to subscribe to notification events on a user-selected endpoint. Currently, available services for subscription are transfer, boleto, boleto-holmes, boleto-payment, brcode-payment, utility-payment, deposit, darf-payment, payment-request and invoice. Events are delivered with a digital signature (the 'Digital-Signature' response header), verifiable with starkbank.event.parse(). If your endpoint does not return HTTP 200, delivery is retried up to three times, at 5, 30 and 120 minute intervals, after which the event is no longer resent -- use starkbank.event.query(is_delivered=false) daily to catch anything missed. A Webhook only receives events from the API version it was registered under.
     * <p>
     * Parameters:
     * @param url [string]: Url that will be notified when an event occurs.
     * @param subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "invoice", "deposit"]
     * @param id [string]: unique id returned when the webhook is created. ex: "5656565656565656"
     */
    public Webhook(String url, String[] subscriptions, String id) {
        super(id);
        this.url = url;
        this.subscriptions = subscriptions;
    }

    /**
     * Webhook object
     * <p>
     * A Webhook is used to subscribe to notification events on a user-selected endpoint. Currently, available services for subscription are transfer, boleto, boleto-holmes, boleto-payment, brcode-payment, utility-payment, deposit, darf-payment, payment-request and invoice. Events are delivered with a digital signature (the 'Digital-Signature' response header), verifiable with starkbank.event.parse(). If your endpoint does not return HTTP 200, delivery is retried up to three times, at 5, 30 and 120 minute intervals, after which the event is no longer resent -- use starkbank.event.query(is_delivered=false) daily to catch anything missed. A Webhook only receives events from the API version it was registered under.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the Webhook
     * url [string]: Url that will be notified when an event occurs.
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "invoice", "deposit"]
     * @throws Exception error in the request
     */
    public Webhook(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.url = (String) dataCopy.remove("url");
        this.subscriptions = (String[]) dataCopy.remove("subscriptions");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Webhook() {
        super(null);
    }

    /**
     * Retrieve a specific Webhook
     * <p>
     * Receive a single Webhook subscription object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook get(String id) throws Exception {
        return Webhook.get(id, null);
    }

    /**
     * Retrieve a specific Webhook
     * <p>
     * Receive a single Webhook subscription object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Webhooks
     * <p>
     * Receive a generator of Webhook subscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve Webhooks
     * <p>
     * Receive a generator of Webhook subscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(Map<String, Object> params) throws Exception {
        return Webhook.query(params, null);
    }

    /**
     * Retrieve Webhooks
     * <p>
     * Receive a generator of Webhook subscription objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query(User user) throws Exception {
        return Webhook.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Webhooks
     * <p>
     * Receive a generator of Webhook subscription objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of Webhook objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Webhook> query() throws Exception {
        return Webhook.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<Webhook> webhooks;
        public String cursor;

        public Page(List<Webhook> webhooks, String cursor) {
            this.webhooks = webhooks;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook subscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return Webhook.page(params, null);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook subscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return Webhook.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook subscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return Webhook.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Webhooks
     * <p>
     * Receive a list of up to 100 Webhook subscription objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook.Page object:
     * Webhook.Page.webhooks: list of Webhook objects with updated attributes
     * Webhook.Page.cursor: cursor to retrieve the next page of Webhook objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Webhook> webhooks = new ArrayList<>();
        for (SubResource webhook: page.entities) {
            webhooks.add((Webhook) webhook);
        }
        return new Page(webhooks, page.cursor);
    }

    /**
     * Create Webhook subscription
     * <p>
     * Send a single Webhook subscription for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param webhookData parameters for the creation of the webhook
     * url [string]: url to which notification events will be sent to. ex: "https://webhook.site/60e9c18e-4b5c-4369-bda1-ab5fcd8e1b29"
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook create(Map<String, Object> webhookData) throws Exception {
        return Webhook.create(webhookData, null);
    }

    /**
     * Create Webhook subscription
     * <p>
     * Send a single Webhook subscription for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param webhookData parameters for the creation of the webhook
     * url [string]: url to which notification events will be sent to. ex: "https://webhook.site/60e9c18e-4b5c-4369-bda1-ab5fcd8e1b29"
     * subscriptions [list of strings]: list of any non-empty combination of the available services. ex: ["transfer", "boleto-payment"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Webhook object with updated attributes
     * @throws Exception error in the request
     */
    public static Webhook create(Map<String, Object> webhookData, User user) throws Exception {
        return Rest.postSingle(data, new Webhook(webhookData), user);
    }

    /**
     * Delete a Webhook entity
     * <p>
     * Delete a Webhook subscription entity previously created in the Stark Bank API. This action cannot be undone.
     * <p>
     * Parameters:
     * @param id [string]: Webhook unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted Webhook object
     * @throws Exception error in the request
     */
    public static Webhook delete(String id) throws Exception {
        return Webhook.delete(id, null);
    }

    /**
     * Delete a Webhook entity
     * <p>
     * Delete a Webhook subscription entity previously created in the Stark Bank API. This action cannot be undone.
     * <p>
     * Parameters:
     * @param id [string]: Webhook unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted Webhook object
     * @throws Exception error in the request
     */
    public static Webhook delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }
}

