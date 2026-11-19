package com.starkbank;

import com.starkbank.utils.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class CorporateRule extends Resource {
    /**
     * CorporateRule object
     * <p>
     * The CorporateRule object displays the spending rules of CorporateCards and CorporateHolders created in your Workspace.
     * <p>
     * Parameters:
     * name [string]: rule name. ex: "Travel" or "Food"
     * amount [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * schedule [string]: schedule time for user to spend. ex: "every monday, wednesday from 00:00 to 23:59 in America/Sao_Paulo"
     * purposes [list of strings]: list of strings representing the allowed purposes for card purchases, you can use this to restrict ATM withdrawals. ex: ["purchase", "withdrawal"]
     * currencyCode [string]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories [list of maps]: merchant categories accepted by the rule. ex: [MerchantCategory(code="fastFoodRestaurants")]
     * countries [list of maps]: countries accepted by the rule. ex: [MerchantCountry(code="BRA")]
     * methods [list of maps]: card purchase methods accepted by the rule. ex: [CardMethod(code="magstripe")]
     * id [string]: unique id returned when a CorporateRule is created, used to update a specific CorporateRule. ex: "5656565656565656"
     * counterAmount [integer]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName [string]: currency name. ex: "Brazilian Real"
     */
    static ClassData data = new ClassData(CorporateRule.class, "CorporateRule");

    public String name;
    public Long amount;
    public String interval;
    public String schedule;
    public String[] purposes;
    public String currencyCode;
    public List<MerchantCategory> categories;
    public List<MerchantCountry> countries;
    public List<CardMethod> methods;
    public Number counterAmount;
    public String currencySymbol;
    public String currencyName;


    /**
     * CorporateRule object
     * <p>
     * The CorporateRule object displays the spending rules of CorporateCards and CorporateHolders created in your Workspace.
     * <p>
     * Parameters:
     * @param name [string]: rule name. ex: "Travel" or "Food"
     * @param amount [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * @param interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * @param schedule [string]: schedule time for user to spend. ex: "every monday, wednesday from 00:00 to 23:59 in America/Sao_Paulo"
     * @param purposes [list of strings]: list of strings representing the allowed purposes for card purchases, you can use this to restrict ATM withdrawals. ex: ["purchase", "withdrawal"]
     * @param currencyCode [string]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * @param categories [list of maps]: merchant categories accepted by the rule. ex: [MerchantCategory(code="fastFoodRestaurants")]
     * @param countries [list of maps]: countries accepted by the rule. ex: [MerchantCountry(code="BRA")]
     * @param methods [list of maps]: card purchase methods accepted by the rule. ex: [CardMethod(code="magstripe")]
     * @param id [string]: unique id returned when a CorporateRule is created, used to update a specific CorporateRule. ex: "5656565656565656"
     * @param counterAmount [integer]: current rule spent amount. ex: 1000
     * @param currencySymbol [string]: currency symbol. ex: "R$"
     * @param currencyName [string]: currency name. ex: "Brazilian Real"
     */
    public CorporateRule(String id, String name, Long amount, String interval, String schedule, String[] purposes, String currencyCode, List<MerchantCategory> categories, List<MerchantCountry> countries, List<CardMethod> methods, Long counterAmount, String currencySymbol, String currencyName) {
        super(id);
        this.name = name;
        this.amount = amount;
        this.interval = interval;
        this.schedule = schedule;
        this.purposes = purposes;
        this.currencyCode = currencyCode;
        this.categories = categories;
        this.countries = countries;
        this.methods = methods;
        this.counterAmount = counterAmount;
        this.currencySymbol = currencySymbol;
        this.currencyName = currencyName;
    }

    /**
     * CorporateRule object
     * <p>
     * The CorporateRule object displays the spending rules of CorporateCards and CorporateHolders created in your Workspace.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the CorporateRule
     * name [string]: rule name. ex: "Travel" or "Food"
     * amount [integer]: maximum amount that can be spent in the informed interval. ex: 200000 (= R$ 2000.00)
     * interval [string]: interval after which the rule amount counter will be reset to 0. ex: "instant", "day", "week", "month", "year" or "lifetime"
     * schedule [string]: schedule time for user to spend. ex: "every monday, wednesday from 00:00 to 23:59 in America/Sao_Paulo"
     * purposes [list of strings]: list of strings representing the allowed purposes for card purchases, you can use this to restrict ATM withdrawals. ex: ["purchase", "withdrawal"]
     * currencyCode [string]: code of the currency that the rule amount refers to. ex: "BRL" or "USD"
     * categories [list of maps]: merchant categories accepted by the rule. ex: [MerchantCategory(code="fastFoodRestaurants")]
     * countries [list of maps]: countries accepted by the rule. ex: [MerchantCountry(code="BRA")]
     * methods [list of maps]: card purchase methods accepted by the rule. ex: [CardMethod(code="magstripe")]
     * <p>
     * Attributes (return-only):
     * counterAmount [integer]: current rule spent amount. ex: 1000
     * currencySymbol [string]: currency symbol. ex: "R$"
     * currencyName [string]: currency name. ex: "Brazilian Real"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public CorporateRule(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.name = (String) dataCopy.remove("name");
        Number amount = (Number) dataCopy.remove("amount");
        this.amount = amount == null ? null : amount.longValue();
        this.interval = (String) dataCopy.remove("interval");
        this.schedule = (String) dataCopy.remove("schedule");
        this.purposes = (String[]) dataCopy.remove("purposes");
        this.currencyCode = (String) dataCopy.remove("currencyCode");
        this.categories = parseCategories((List<Object>) dataCopy.remove("categories"));
        this.countries = parseCountries((List<Object>) dataCopy.remove("countries"));
        this.methods = parseMethods((List<Object>) dataCopy.remove("methods"));
        this.counterAmount = null;
        this.currencySymbol = null;
        this.currencyName = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public CorporateRule() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<MerchantCategory> parseCategories(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<MerchantCategory> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof MerchantCategory) {
                parsed.add((MerchantCategory) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new MerchantCategory((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use MerchantCategory or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<MerchantCountry> parseCountries(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<MerchantCountry> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof MerchantCountry) {
                parsed.add((MerchantCountry) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new MerchantCountry((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use MerchantCountry or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<CardMethod> parseMethods(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<CardMethod> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof CardMethod) {
                parsed.add((CardMethod) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new CardMethod((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use CardMethod or HashMap");
        }
        return parsed;
    }
}

