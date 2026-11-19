package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.HashMap;
import java.util.Map;


public final class CardMethod extends SubResource {
    /**
     * CardMethod object
     * <p>
     * CardMethod's codes are used to define methods filters in CorporateRules.
     * <p>
     * Parameters:
     * code [string]: method's code. Options: "chip", "token", "server", "manual", "magstripe", "contactless"
     * name [string]: method's name. ex: "token"
     * number [string]: method's number. ex: "81"
     */
    static SubResource.ClassData data = new SubResource.ClassData(CardMethod.class, "CardMethod");

    public String code;
    public String name;
    public String number;


    /**
     * CardMethod object
     * <p>
     * CardMethod's codes are used to define methods filters in CorporateRules.
     * <p>
     * Parameters:
     * @param code [string]: method's code. Options: "chip", "token", "server", "manual", "magstripe", "contactless"
     * @param name [string]: method's name. ex: "token"
     * @param number [string]: method's number. ex: "81"
     */
    public CardMethod(String code, String name, String number) {
        this.code = code;
        this.name = name;
        this.number = number;
    }

    /**
     * CardMethod object
     * <p>
     * CardMethod's codes are used to define methods filters in CorporateRules.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the CardMethod
     * code [string]: method's code. Options: "chip", "token", "server", "manual", "magstripe", "contactless"
     * <p>
     * Attributes (return-only):
     * name [string]: method's name. ex: "token"
     * number [string]: method's number. ex: "81"
     * @throws Exception error in the request
     */
    public CardMethod(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.code = (String) dataCopy.remove("code");
        this.name = null;
        this.number = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public CardMethod() {
    }

    /**
     * Retrieve CardMethods
     * <p>
     * Receive a generator of CardMethod objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * search [string, default null]: keyword to search for code, name, number or short_code
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CardMethod objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CardMethod> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve CardMethods
     * <p>
     * Receive a generator of CardMethod objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * search [string, default null]: keyword to search for code, name, number or short_code
     * <p>
     * Return:
     * @return generator of CardMethod objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CardMethod> query(Map<String, Object> params) throws Exception {
        return CardMethod.query(params, null);
    }

    /**
     * Retrieve CardMethods
     * <p>
     * Receive a generator of CardMethod objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of CardMethod objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CardMethod> query(User user) throws Exception {
        return CardMethod.query(new HashMap<>(), user);
    }

    /**
     * Retrieve CardMethods
     * <p>
     * Receive a generator of CardMethod objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of CardMethod objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<CardMethod> query() throws Exception {
        return CardMethod.query(new HashMap<>(), null);
    }
}

