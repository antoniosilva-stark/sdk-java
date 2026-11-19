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


public class MerchantPurchase extends Resource {
    /**
     * MerchantPurchase object
     * <p>
     * When you initialize a MerchantPurchase, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * amount [integer]: MerchantPurchase value in cents. ex: 1234 (= R$ 12.34)
     * cardId [string]: unique id of the MerchantCard or MerchantSession Purchase used. ex: "5656565656565656"
     * fundingType [string]: type of funding used. ex: "credit", "debit"
     * installmentCount [integer]: number of installments the purchase is split into. ex: 1
     * cardExpiration [string]: card and holder data, required only when not created through a MerchantSession.
     * cardNumber [string]: card and holder data, required only when not created through a MerchantSession.
     * cardSecurityCode [string]: card and holder data, required only when not created through a MerchantSession.
     * holderName [string]: card and holder data, required only when not created through a MerchantSession.
     * holderEmail [string]: card and holder data, required only when not created through a MerchantSession.
     * holderPhone [string]: card and holder data, required only when not created through a MerchantSession.
     * holderId [string]: card and holder data, required only when not created through a MerchantSession.
     * billingCountryCode [string]: billing address data.
     * billingCity [string]: billing address data.
     * billingStateCode [string]: billing address data.
     * billingStreetLine1 [string]: billing address data.
     * billingStreetLine2 [string]: billing address data.
     * billingZipCode [string]: billing address data.
     * metadata [Map of String: Object]: additional 3DS metadata sent by the merchant's browser/app.
     * softDescriptor [string]: text that will be shown in the holder's bank statement. ex: "my-store"
     * tags [list of strings]: list of strings for tagging
     * id [string]: unique id returned when MerchantPurchase is created. ex: "5656565656565656"
     * cardEnding [string]: last 4 digits of the card used. ex: "1234"
     * challengeMode [string]: whether 3DS holder verification was used. ex: "enabled", "disabled"
     * challengeUrl [string]: URL to the 3DS challenge, when applicable.
     * currencyCode [string]: currency of the purchase. ex: "BRL"
     * endToEndId [string]: unique transaction id for the acquirer network.
     * fee [integer]: fee charged when the MerchantPurchase is processed. ex: 200 (= R$ 2.00)
     * network [string]: card network flag. ex: "visa", "mastercard"
     * source [string]: locator of the entity that generated the purchase. ex: "merchant-session/{sessionId}"
     * status [string]: current MerchantPurchase status. ex: "approved", "confirmed", "canceled", "voided"
     * created [string]: creation datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * confirmationMode [string]
     */
    static ClassData data = new ClassData(MerchantPurchase.class, "MerchantPurchase");

    public long amount;
    public String cardId;
    public String fundingType;
    public int installmentCount;
    public String cardExpiration;
    public String cardNumber;
    public String cardSecurityCode;
    public String holderName;
    public String holderEmail;
    public String holderPhone;
    public String holderId;
    public String billingCountryCode;
    public String billingCity;
    public String billingStateCode;
    public String billingStreetLine1;
    public String billingStreetLine2;
    public String billingZipCode;
    public Map<String, Object> metadata;
    public String softDescriptor;
    public String[] tags;
    public String cardEnding;
    public String challengeMode;
    public String challengeUrl;
    public String currencyCode;
    public String endToEndId;
    public Integer fee;
    public String network;
    public String source;
    public String status;
    public String created;
    public String updated;
    public String confirmationMode;


    /**
     * MerchantPurchase object
     * <p>
     * When you initialize a MerchantPurchase, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param amount [integer]: MerchantPurchase value in cents. ex: 1234 (= R$ 12.34)
     * @param cardId [string]: unique id of the MerchantCard or MerchantSession Purchase used. ex: "5656565656565656"
     * @param fundingType [string]: type of funding used. ex: "credit", "debit"
     * @param installmentCount [integer]: number of installments the purchase is split into. ex: 1
     * @param cardExpiration [string]: card and holder data, required only when not created through a MerchantSession.
     * @param cardNumber [string]: card and holder data, required only when not created through a MerchantSession.
     * @param cardSecurityCode [string]: card and holder data, required only when not created through a MerchantSession.
     * @param holderName [string]: card and holder data, required only when not created through a MerchantSession.
     * @param holderEmail [string]: card and holder data, required only when not created through a MerchantSession.
     * @param holderPhone [string]: card and holder data, required only when not created through a MerchantSession.
     * @param holderId [string]: card and holder data, required only when not created through a MerchantSession.
     * @param billingCountryCode [string]: billing address data.
     * @param billingCity [string]: billing address data.
     * @param billingStateCode [string]: billing address data.
     * @param billingStreetLine1 [string]: billing address data.
     * @param billingStreetLine2 [string]: billing address data.
     * @param billingZipCode [string]: billing address data.
     * @param metadata [Map of String: Object]: additional 3DS metadata sent by the merchant's browser/app.
     * @param softDescriptor [string]: text that will be shown in the holder's bank statement. ex: "my-store"
     * @param tags [list of strings]: list of strings for tagging
     * @param id [string]: unique id returned when MerchantPurchase is created. ex: "5656565656565656"
     * @param cardEnding [string]: last 4 digits of the card used. ex: "1234"
     * @param challengeMode [string]: whether 3DS holder verification was used. ex: "enabled", "disabled"
     * @param challengeUrl [string]: URL to the 3DS challenge, when applicable.
     * @param currencyCode [string]: currency of the purchase. ex: "BRL"
     * @param endToEndId [string]: unique transaction id for the acquirer network.
     * @param fee [integer]: fee charged when the MerchantPurchase is processed. ex: 200 (= R$ 2.00)
     * @param network [string]: card network flag. ex: "visa", "mastercard"
     * @param source [string]: locator of the entity that generated the purchase. ex: "merchant-session/{sessionId}"
     * @param status [string]: current MerchantPurchase status. ex: "approved", "confirmed", "canceled", "voided"
     * @param created [string]: creation datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param confirmationMode [string]
     */
    public MerchantPurchase(long amount, String cardId, String fundingType, int installmentCount, String cardExpiration, String cardNumber, String cardSecurityCode, String holderName, String holderEmail, String holderPhone, String holderId, String billingCountryCode, String billingCity, String billingStateCode, String billingStreetLine1, String billingStreetLine2, String billingZipCode, Map<String, Object> metadata, String softDescriptor, String[] tags, String id, String cardEnding, String challengeMode, String challengeUrl, String currencyCode, String endToEndId, Integer fee, String network, String source, String status, String created, String updated, String confirmationMode) {
        super(id);
        this.amount = amount;
        this.cardId = cardId;
        this.fundingType = fundingType;
        this.installmentCount = installmentCount;
        this.cardExpiration = cardExpiration;
        this.cardNumber = cardNumber;
        this.cardSecurityCode = cardSecurityCode;
        this.holderName = holderName;
        this.holderEmail = holderEmail;
        this.holderPhone = holderPhone;
        this.holderId = holderId;
        this.billingCountryCode = billingCountryCode;
        this.billingCity = billingCity;
        this.billingStateCode = billingStateCode;
        this.billingStreetLine1 = billingStreetLine1;
        this.billingStreetLine2 = billingStreetLine2;
        this.billingZipCode = billingZipCode;
        this.metadata = metadata;
        this.softDescriptor = softDescriptor;
        this.tags = tags;
        this.cardEnding = cardEnding;
        this.challengeMode = challengeMode;
        this.challengeUrl = challengeUrl;
        this.currencyCode = currencyCode;
        this.endToEndId = endToEndId;
        this.fee = fee;
        this.network = network;
        this.source = source;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.confirmationMode = confirmationMode;
    }

    /**
     * MerchantPurchase object
     * <p>
     * When you initialize a MerchantPurchase, the entity will not be automatically to the Stark Bank API and returns the created object.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the MerchantPurchase
     * amount [integer]: MerchantPurchase value in cents. ex: 1234 (= R$ 12.34)
     * cardId [string]: unique id of the MerchantCard or MerchantSession Purchase used. ex: "5656565656565656"
     * fundingType [string]: type of funding used. ex: "credit", "debit"
     * installmentCount [integer]: number of installments the purchase is split into. ex: 1
     * cardExpiration [string]: card and holder data, required only when not created through a MerchantSession.
     * cardNumber [string]: card and holder data, required only when not created through a MerchantSession.
     * cardSecurityCode [string]: card and holder data, required only when not created through a MerchantSession.
     * holderName [string]: card and holder data, required only when not created through a MerchantSession.
     * holderEmail [string]: card and holder data, required only when not created through a MerchantSession.
     * holderPhone [string]: card and holder data, required only when not created through a MerchantSession.
     * holderId [string]: card and holder data, required only when not created through a MerchantSession.
     * billingCountryCode [string]: billing address data.
     * billingCity [string]: billing address data.
     * billingStateCode [string]: billing address data.
     * billingStreetLine1 [string]: billing address data.
     * billingStreetLine2 [string]: billing address data.
     * billingZipCode [string]: billing address data.
     * metadata [Map of String: Object]: additional 3DS metadata sent by the merchant's browser/app.
     * softDescriptor [string]: text that will be shown in the holder's bank statement. ex: "my-store"
     * tags [list of strings]: list of strings for tagging
     * confirmationMode [string]
     * <p>
     * Attributes (return-only):
     * cardEnding [string]: last 4 digits of the card used. ex: "1234"
     * challengeMode [string]: whether 3DS holder verification was used. ex: "enabled", "disabled"
     * challengeUrl [string]: URL to the 3DS challenge, when applicable.
     * currencyCode [string]: currency of the purchase. ex: "BRL"
     * endToEndId [string]: unique transaction id for the acquirer network.
     * fee [integer]: fee charged when the MerchantPurchase is processed. ex: 200 (= R$ 2.00)
     * network [string]: card network flag. ex: "visa", "mastercard"
     * source [string]: locator of the entity that generated the purchase. ex: "merchant-session/{sessionId}"
     * status [string]: current MerchantPurchase status. ex: "approved", "confirmed", "canceled", "voided"
     * created [string]: creation datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the MerchantPurchase. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public MerchantPurchase(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.cardId = (String) dataCopy.remove("cardId");
        this.fundingType = (String) dataCopy.remove("fundingType");
        this.installmentCount = ((Number) dataCopy.remove("installmentCount")).intValue();
        this.cardExpiration = (String) dataCopy.remove("cardExpiration");
        this.cardNumber = (String) dataCopy.remove("cardNumber");
        this.cardSecurityCode = (String) dataCopy.remove("cardSecurityCode");
        this.holderName = (String) dataCopy.remove("holderName");
        this.holderEmail = (String) dataCopy.remove("holderEmail");
        this.holderPhone = (String) dataCopy.remove("holderPhone");
        this.holderId = (String) dataCopy.remove("holderId");
        this.billingCountryCode = (String) dataCopy.remove("billingCountryCode");
        this.billingCity = (String) dataCopy.remove("billingCity");
        this.billingStateCode = (String) dataCopy.remove("billingStateCode");
        this.billingStreetLine1 = (String) dataCopy.remove("billingStreetLine1");
        this.billingStreetLine2 = (String) dataCopy.remove("billingStreetLine2");
        this.billingZipCode = (String) dataCopy.remove("billingZipCode");
        this.metadata = (Map<String, Object>) dataCopy.remove("metadata");
        this.softDescriptor = (String) dataCopy.remove("softDescriptor");
        this.tags = (String[]) dataCopy.remove("tags");
        this.cardEnding = null;
        this.challengeMode = null;
        this.challengeUrl = null;
        this.currencyCode = null;
        this.endToEndId = null;
        this.fee = null;
        this.network = null;
        this.source = null;
        this.status = null;
        this.created = null;
        this.updated = null;
        this.confirmationMode = (String) dataCopy.remove("confirmationMode");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public MerchantPurchase() {
        super(null);
    }

    /**
     * Retrieve a specific MerchantPurchase
     * <p>
     * Receive a single MerchantPurchase object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase get(String id) throws Exception {
        return MerchantPurchase.get(id, null);
    }

    /**
     * Retrieve a specific MerchantPurchase
     * <p>
     * Receive a single MerchantPurchase object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve MerchantPurchases
     * <p>
     * Receive a generator of MerchantPurchase objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "approved"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * holderId [string, default null]: filter for purchases made with cards belonging to a specific holder. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantPurchase> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve MerchantPurchases
     * <p>
     * Receive a generator of MerchantPurchase objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "approved"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * holderId [string, default null]: filter for purchases made with cards belonging to a specific holder. ex: "5656565656565656"
     * <p>
     * Return:
     * @return generator of MerchantPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantPurchase> query(Map<String, Object> params) throws Exception {
        return MerchantPurchase.query(params, null);
    }

    /**
     * Retrieve MerchantPurchases
     * <p>
     * Receive a generator of MerchantPurchase objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of MerchantPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantPurchase> query(User user) throws Exception {
        return MerchantPurchase.query(new HashMap<>(), user);
    }

    /**
     * Retrieve MerchantPurchases
     * <p>
     * Receive a generator of MerchantPurchase objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of MerchantPurchase objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<MerchantPurchase> query() throws Exception {
        return MerchantPurchase.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<MerchantPurchase> merchantPurchases;
        public String cursor;

        public Page(List<MerchantPurchase> merchantPurchases, String cursor) {
            this.merchantPurchases = merchantPurchases;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged MerchantPurchases
     * <p>
     * Receive a list of up to 100 MerchantPurchase objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "approved"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * holderId [string, default null]: filter for purchases made with cards belonging to a specific holder. ex: "5656565656565656"
     * <p>
     * Return:
     * @return MerchantPurchase.Page object:
     * MerchantPurchase.Page.merchantPurchases: list of MerchantPurchase objects with updated attributes
     * MerchantPurchase.Page.cursor: cursor to retrieve the next page of MerchantPurchase objects
     * @throws Exception error in the request
     */
    public static MerchantPurchase.Page page(Map<String, Object> params) throws Exception {
        return MerchantPurchase.page(params, null);
    }

    /**
     * Retrieve paged MerchantPurchases
     * <p>
     * Receive a list of up to 100 MerchantPurchase objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantPurchase.Page object:
     * MerchantPurchase.Page.merchantPurchases: list of MerchantPurchase objects with updated attributes
     * MerchantPurchase.Page.cursor: cursor to retrieve the next page of MerchantPurchase objects
     * @throws Exception error in the request
     */
    public static MerchantPurchase.Page page(User user) throws Exception {
        return MerchantPurchase.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged MerchantPurchases
     * <p>
     * Receive a list of up to 100 MerchantPurchase objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return MerchantPurchase.Page object:
     * MerchantPurchase.Page.merchantPurchases: list of MerchantPurchase objects with updated attributes
     * MerchantPurchase.Page.cursor: cursor to retrieve the next page of MerchantPurchase objects
     * @throws Exception error in the request
     */
    public static MerchantPurchase.Page page() throws Exception {
        return MerchantPurchase.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged MerchantPurchases
     * <p>
     * Receive a list of up to 100 MerchantPurchase objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "approved"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * holderId [string, default null]: filter for purchases made with cards belonging to a specific holder. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantPurchase.Page object:
     * MerchantPurchase.Page.merchantPurchases: list of MerchantPurchase objects with updated attributes
     * MerchantPurchase.Page.cursor: cursor to retrieve the next page of MerchantPurchase objects
     * @throws Exception error in the request
     */
    public static MerchantPurchase.Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<MerchantPurchase> merchantPurchases = new ArrayList<>();
        for (SubResource merchantPurchase: page.entities) {
            merchantPurchases.add((MerchantPurchase) merchantPurchase);
        }
        return new Page(merchantPurchases, page.cursor);
    }

    /**
     * Create a MerchantPurchase
     * <p>
     * Send a MerchantPurchase object for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param merchantPurchase [MerchantPurchase object]: MerchantPurchase object to be created in the API
     * <p>
     * Return:
     * @return MerchantPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase create(MerchantPurchase merchantPurchase) throws Exception {
        return MerchantPurchase.create(merchantPurchase, null);
    }

    /**
     * Create a MerchantPurchase
     * <p>
     * Send a MerchantPurchase object for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param merchantPurchase [MerchantPurchase object]: MerchantPurchase object to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return MerchantPurchase object with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase create(MerchantPurchase merchantPurchase, User user) throws Exception {
        return Rest.postSingle(data, merchantPurchase, user);
    }

    /**
     * Update MerchantPurchase entity
     * <p>
     * Update a MerchantPurchase by its id. If the purchase is "approved", you may only cancel it by passing status="canceled" together with amount=0. If the purchase is "confirmed", you may pass status="reversed" with a lower amount to debit and reverse the difference, partially or totally; a partial reversal keeps status "confirmed", while a full reversal moves it to "voided".
     * <p>
     * Parameters:
     * @param id [string]: MerchantPurchase id.
     * @param patchData map of parameters to patch
     * status [string, default null]: "canceled" or "reversed", per the rules above.
     * amount [integer, default null]: new amount; 0 to cancel an approved purchase, or a lower value to partially/fully reverse a confirmed one.
     * <p>
     * Return:
     * @return target MerchantPurchase with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase update(String id, Map<String, Object> patchData) throws Exception {
        return MerchantPurchase.update(id, patchData, null);
    }

    /**
     * Update MerchantPurchase entity
     * <p>
     * Update a MerchantPurchase by its id. If the purchase is "approved", you may only cancel it by passing status="canceled" together with amount=0. If the purchase is "confirmed", you may pass status="reversed" with a lower amount to debit and reverse the difference, partially or totally; a partial reversal keeps status "confirmed", while a full reversal moves it to "voided".
     * <p>
     * Parameters:
     * @param id [string]: MerchantPurchase id.
     * @param patchData map of parameters to patch
     * status [string, default null]: "canceled" or "reversed", per the rules above.
     * amount [integer, default null]: new amount; 0 to cancel an approved purchase, or a lower value to partially/fully reverse a confirmed one.
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return target MerchantPurchase with updated attributes
     * @throws Exception error in the request
     */
    public static MerchantPurchase update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(MerchantPurchase.Log.class, "MerchantPurchaseLog");

        public String created;
        public String type;
        public List<ErrorElement> errors;
        public MerchantPurchase purchase;

        /**
         * MerchantPurchase Log object
         * <p>
         * Every time a MerchantPurchase entity is updated, a corresponding MerchantPurchase Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the MerchantPurchase.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param purchase [MerchantPurchase]: MerchantPurchase entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this MerchantPurchase event
         * @param type [string]: type of the MerchantPurchase event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, List<ErrorElement> errors, MerchantPurchase purchase, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.purchase = purchase;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific MerchantPurchase Log
         * <p>
         * Receive a single MerchantPurchaseLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return MerchantPurchaseLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific MerchantPurchase Log
         * <p>
         * Receive a single MerchantPurchaseLog object previously created by the Stark Bank API by passing its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantPurchaseLog object with updated attributes
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve MerchantPurchase Logs
         * <p>
         * Receive a generator of MerchantPurchaseLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of MerchantPurchaseLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantPurchase.Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve MerchantPurchase Logs
         * <p>
         * Receive a generator of MerchantPurchaseLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantPurchaseLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantPurchase.Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve MerchantPurchase Logs
         * <p>
         * Receive a generator of MerchantPurchaseLog objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of MerchantPurchaseLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantPurchase.Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve MerchantPurchase Logs
         * <p>
         * Receive a generator of MerchantPurchaseLog objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of MerchantPurchaseLog objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<MerchantPurchase.Log> query(Map<String, Object> params, User user) throws Exception {
            return Rest.getStream(data, params, user);
        }

        public final static class Page {
            public List<MerchantPurchase.Log> logs;
            public String cursor;

            public Page(List<MerchantPurchase.Log> logs, String cursor) {
                this.logs = logs;
                this.cursor = cursor;
            }
        }

        /**
         * Retrieve paged MerchantPurchase.Logs
         * <p>
         * Receive a list of up to 100 MerchantPurchaseLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return MerchantPurchase.Log.Page object:
         * MerchantPurchase.Log.Page.logs: list of MerchantPurchaseLog objects with updated attributes
         * MerchantPurchase.Log.Page.cursor: cursor to retrieve the next page of MerchantPurchaseLog objects
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged MerchantPurchase.Logs
         * <p>
         * Receive a list of up to 100 MerchantPurchaseLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantPurchase.Log.Page object:
         * MerchantPurchase.Log.Page.logs: list of MerchantPurchaseLog objects with updated attributes
         * MerchantPurchase.Log.Page.cursor: cursor to retrieve the next page of MerchantPurchaseLog objects
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged MerchantPurchase.Logs
         * <p>
         * Receive a list of up to 100 MerchantPurchaseLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return MerchantPurchase.Log.Page object:
         * MerchantPurchase.Log.Page.logs: list of MerchantPurchaseLog objects with updated attributes
         * MerchantPurchase.Log.Page.cursor: cursor to retrieve the next page of MerchantPurchaseLog objects
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged MerchantPurchase.Logs
         * <p>
         * Receive a list of up to 100 MerchantPurchaseLog objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by event types. ex: ["created", "updated"]
         * purchaseIds [list of strings, default null]: list of MerchantPurchase ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return MerchantPurchase.Log.Page object:
         * MerchantPurchase.Log.Page.logs: list of MerchantPurchaseLog objects with updated attributes
         * MerchantPurchase.Log.Page.cursor: cursor to retrieve the next page of MerchantPurchaseLog objects
         * @throws Exception error in the request
         */
        public static MerchantPurchase.Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<MerchantPurchase.Log> logs = new ArrayList<>();
            for (SubResource log: page.entities) {
                logs.add((Log) log);
            }
            return new Page(logs, page.cursor);
        }
    }
}

