package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class CorporateWithdrawal extends Resource {
    /**
     * CorporateWithdrawal object
     * <p>
     * The CorporateWithdrawal objects created in your Workspace return cash from your Corporate balance to your Banking balance.
     * <p>
     * Parameters:
     * amount [integer]: CorporateWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId [string]: CorporateWithdrawal external ID. ex: "12345"
     * tags [list of strings]: list of strings for tagging. ex: ["tony", "stark"]
     * id [string]: unique id returned when CorporateWithdrawal is created. ex: "5656565656565656"
     * transactionId [string]: Stark Bank ledger transaction ids linked to this CorporateWithdrawal
     * corporateTransactionId [string]: corporate ledger transaction ids linked to this CorporateWithdrawal
     * updated [string]: latest update datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(CorporateWithdrawal.class, "CorporateWithdrawal");

    public Long amount;
    public String externalId;
    public String[] tags;
    public String transactionId;
    public String corporateTransactionId;
    public String updated;
    public String created;


    /**
     * CorporateWithdrawal object
     * <p>
     * The CorporateWithdrawal objects created in your Workspace return cash from your Corporate balance to your Banking balance.
     * <p>
     * Parameters:
     * @param amount [integer]: CorporateWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * @param externalId [string]: CorporateWithdrawal external ID. ex: "12345"
     * @param tags [list of strings]: list of strings for tagging. ex: ["tony", "stark"]
     * @param id [string]: unique id returned when CorporateWithdrawal is created. ex: "5656565656565656"
     * @param transactionId [string]: Stark Bank ledger transaction ids linked to this CorporateWithdrawal
     * @param corporateTransactionId [string]: corporate ledger transaction ids linked to this CorporateWithdrawal
     * @param updated [string]: latest update datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param created [string]: creation datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public CorporateWithdrawal(Long amount, String externalId, String[] tags, String id, String transactionId, String corporateTransactionId, String updated, String created) {
        super(id);
        this.amount = amount;
        this.externalId = externalId;
        this.tags = tags;
        this.transactionId = transactionId;
        this.corporateTransactionId = corporateTransactionId;
        this.updated = updated;
        this.created = created;
    }

    /**
     * CorporateWithdrawal object
     * <p>
     * The CorporateWithdrawal objects created in your Workspace return cash from your Corporate balance to your Banking balance.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the CorporateWithdrawal
     * amount [integer]: CorporateWithdrawal value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34)
     * externalId [string]: CorporateWithdrawal external ID. ex: "12345"
     * tags [list of strings]: list of strings for tagging. ex: ["tony", "stark"]
     * <p>
     * Attributes (return-only):
     * transactionId [string]: Stark Bank ledger transaction ids linked to this CorporateWithdrawal
     * corporateTransactionId [string]: corporate ledger transaction ids linked to this CorporateWithdrawal
     * updated [string]: latest update datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * created [string]: creation datetime for the CorporateWithdrawal. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    public CorporateWithdrawal(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        Number amount = (Number) dataCopy.remove("amount");
        this.amount = amount == null ? null : amount.longValue();
        this.externalId = (String) dataCopy.remove("externalId");
        this.tags = (String[]) dataCopy.remove("tags");
        this.transactionId = null;
        this.corporateTransactionId = null;
        this.updated = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public CorporateWithdrawal() {
        super(null);
    }

    /**
     * Retrieve a specific CorporateWithdrawal
     * <p>
     * Receive a single CorporateWithdrawal object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return CorporateWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal get(String id) throws Exception {
        return CorporateWithdrawal.get(id, null);
    }

    /**
     * Retrieve a specific CorporateWithdrawal
     * <p>
     * Receive a single CorporateWithdrawal object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve CorporateWithdrawals
     * <p>
     * Receive a generator of CorporateWithdrawal objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * externalIds [list of strings, default null]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CorporateWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateWithdrawal> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CorporateWithdrawals
     * <p>
     * Receive a generator of CorporateWithdrawal objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * externalIds [list of strings, default null]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * <p>
     * Return:
     * @return generator of CorporateWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateWithdrawal> query(Map<String, Object> params) throws Exception {
        return CorporateWithdrawal.query(params, null);
    }

    /**
     * Retrieve CorporateWithdrawals
     * <p>
     * Receive a generator of CorporateWithdrawal objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CorporateWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateWithdrawal> query(User user) throws Exception {
        return CorporateWithdrawal.query(new HashMap<>(), user);
    }

    /**
     * Retrieve CorporateWithdrawals
     * <p>
     * Receive a generator of CorporateWithdrawal objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of CorporateWithdrawal objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CorporateWithdrawal> query() throws Exception {
        return CorporateWithdrawal.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<CorporateWithdrawal> withdrawals;
        public String cursor;

        public Page(List<CorporateWithdrawal> withdrawals, String cursor) {
            this.withdrawals = withdrawals;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged CorporateWithdrawals
     * <p>
     * Receive a list of up to 100 CorporateWithdrawal objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default null]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return CorporateWithdrawal.Page object:
     * CorporateWithdrawal.Page.withdrawals: list of CorporateWithdrawal objects with updated attributes
     * CorporateWithdrawal.Page.cursor: cursor to retrieve the next page of CorporateWithdrawal objects
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal.Page page(Map<String, Object> params) throws Exception {
        return CorporateWithdrawal.page(params, null);
    }

    /**
     * Retrieve paged CorporateWithdrawals
     * <p>
     * Receive a list of up to 100 CorporateWithdrawal objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateWithdrawal.Page object:
     * CorporateWithdrawal.Page.withdrawals: list of CorporateWithdrawal objects with updated attributes
     * CorporateWithdrawal.Page.cursor: cursor to retrieve the next page of CorporateWithdrawal objects
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal.Page page(User user) throws Exception {
        return CorporateWithdrawal.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged CorporateWithdrawals
     * <p>
     * Receive a list of up to 100 CorporateWithdrawal objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return CorporateWithdrawal.Page object:
     * CorporateWithdrawal.Page.withdrawals: list of CorporateWithdrawal objects with updated attributes
     * CorporateWithdrawal.Page.cursor: cursor to retrieve the next page of CorporateWithdrawal objects
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal.Page page() throws Exception {
        return CorporateWithdrawal.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged CorporateWithdrawals
     * <p>
     * Receive a list of up to 100 CorporateWithdrawal objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. Max = 100. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * externalIds [list of strings, default null]: external IDs. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateWithdrawal.Page object:
     * CorporateWithdrawal.Page.withdrawals: list of CorporateWithdrawal objects with updated attributes
     * CorporateWithdrawal.Page.cursor: cursor to retrieve the next page of CorporateWithdrawal objects
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<CorporateWithdrawal> withdrawals = new ArrayList<>();
        for (SubResource corporateWithdrawal: page.entities) {
            withdrawals.add((CorporateWithdrawal) corporateWithdrawal);
        }
        return new Page(withdrawals, page.cursor);
    }

    /**
     * Create a CorporateWithdrawal
     * <p>
     * Send a single CorporateWithdrawal object for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param withdrawal [CorporateWithdrawal object]: CorporateWithdrawal object to be created in the API.
     * <p>
     * Return:
     * @return CorporateWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal create(CorporateWithdrawal withdrawal) throws Exception {
        return CorporateWithdrawal.create(withdrawal, null);
    }

    /**
     * Create a CorporateWithdrawal
     * <p>
     * Send a single CorporateWithdrawal object for creation at the Stark Bank API
     * <p>
     * Parameters:
     * @param withdrawal [CorporateWithdrawal object]: CorporateWithdrawal object to be created in the API.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return CorporateWithdrawal object with updated attributes
     * @throws Exception error in the request
     */
    public static CorporateWithdrawal create(CorporateWithdrawal withdrawal, User user) throws Exception {
        return Rest.postSingle(data, withdrawal, user);
    }
}

