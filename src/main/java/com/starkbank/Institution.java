package com.starkbank;

import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Institution extends SubResource {
    /**
     * Institution object
     * <p>
     * This resource is used to get information on the institutions that are recognized by the Brazilian Central Bank. Besides the display name and full name, they also include the STR code (used for TEDs) and the SPI Code (used for Pix) for the institutions. Either of these codes may be empty if the institution is not registered on that Central Bank service.
     * <p>
     * Parameters:
     * displayName [string]: short version of the institution name that should be displayed to end users. ex: "Stark Bank"
     * name [string]: full version of the institution name. ex: "Stark Bank S.A."
     * spiCode [string]: SPI code used to identify the institution on Pix transactions. ex: "20018183"
     * strCode [string]: STR code used to identify the institution on TED transactions. ex: "123"
     */
    static ClassData data = new ClassData(Institution.class, "Institution");

    public String displayName;
    public String name;
    public String spiCode;
    public String strCode;


    /**
     * Institution object
     * <p>
     * This resource is used to get information on the institutions that are recognized by the Brazilian Central Bank. Besides the display name and full name, they also include the STR code (used for TEDs) and the SPI Code (used for Pix) for the institutions. Either of these codes may be empty if the institution is not registered on that Central Bank service.
     * <p>
     * Parameters:
     * @param displayName [string]: short version of the institution name that should be displayed to end users. ex: "Stark Bank"
     * @param name [string]: full version of the institution name. ex: "Stark Bank S.A."
     * @param spiCode [string]: SPI code used to identify the institution on Pix transactions. ex: "20018183"
     * @param strCode [string]: STR code used to identify the institution on TED transactions. ex: "123"
     */
    public Institution(String displayName, String name, String spiCode, String strCode) {
        this.displayName = displayName;
        this.name = name;
        this.spiCode = spiCode;
        this.strCode = strCode;
    }

    /**
     * Institution object
     * <p>
     * This resource is used to get information on the institutions that are recognized by the Brazilian Central Bank. Besides the display name and full name, they also include the STR code (used for TEDs) and the SPI Code (used for Pix) for the institutions. Either of these codes may be empty if the institution is not registered on that Central Bank service.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the Institution
     * <p>
     * Attributes (return-only):
     * displayName [string]: short version of the institution name that should be displayed to end users. ex: "Stark Bank"
     * name [string]: full version of the institution name. ex: "Stark Bank S.A."
     * spiCode [string]: SPI code used to identify the institution on Pix transactions. ex: "20018183"
     * strCode [string]: STR code used to identify the institution on TED transactions. ex: "123"
     * @throws Exception error in the request
     */
    public Institution(Map<String, Object> data) throws Exception {
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.displayName = null;
        this.name = null;
        this.spiCode = null;
        this.strCode = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Institution() {
    }

    /**
     * Retrieve Institutions
     * <p>
     * Receive a list of Institution objects that are recognized by the Brazilian Central bank for Pix and TED transactions
     * <p>
     * Return:
     * @return list of Institution objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Institution> query() throws Exception {
        return Institution.query(new HashMap<>(), null);
    }

    /**
     * Retrieve Institutions
     * <p>
     * Receive a list of Institution objects that are recognized by the Brazilian Central bank for Pix and TED transactions
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * search [string, default null]: part of the institution name to be searched. ex: "stark"
     * spiCodes [list of strings, default null]: list of SPI (Pix) codes to be searched. ex: ["20018183"]
     * strCodes [list of strings, default null]: list of STR (TED) codes to be searched. ex: ["260"]
     * <p>
     * Return:
     * @return list of Institution objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Institution> query(Map<String, Object> params) throws Exception {
        return Institution.query(params, null);
    }

    /**
     * Retrieve Institutions
     * <p>
     * Receive a list of Institution objects that are recognized by the Brazilian Central bank for Pix and TED transactions
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of Institution objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Institution> query(User user) throws Exception {
        return Institution.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Institutions
     * <p>
     * Receive a list of Institution objects that are recognized by the Brazilian Central bank for Pix and TED transactions
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * search [string, default null]: part of the institution name to be searched. ex: "stark"
     * spiCodes [list of strings, default null]: list of SPI (Pix) codes to be searched. ex: ["20018183"]
     * strCodes [list of strings, default null]: list of STR (TED) codes to be searched. ex: ["260"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of Institution objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Institution> query(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Institution> institutions = new ArrayList<>();
        for (SubResource institution: page.entities) {
            institutions.add((Institution) institution);
        }
        return new Page(institutions, page.cursor).institutions;
    }

    private final static class Page {
        public List<Institution> institutions;
        public String cursor;

        public Page(List<Institution> institutions, String cursor) {
            this.institutions = institutions;
            this.cursor = cursor;
        }
    }
}

