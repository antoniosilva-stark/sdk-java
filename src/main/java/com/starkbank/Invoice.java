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


public final class Invoice extends Resource {
    /**
     * Invoice object
     * <p>
     * When you initialize an Invoice, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. To create scheduled Invoices, which will display the discount, interest, etc. on the final users banking interface, use dates instead of datetimes on the "due" and "discounts" fields.
     * <p>
     * Parameters:
     * amount [integer]: Invoice value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34). If amount = 0, the Invoice will accept any amount paid by the customer; otherwise, only the exact amount will be accepted. When paid, this attribute is updated with the amount actually paid.
     * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * name [string]: payer name. ex: "Iron Bank S.A."
     * due [string]: Invoice due date in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
     * expiration [integer]: time interval in seconds between due date and expiration date. After the expiration, the Invoice can no longer be paid. ex 123456789
     * fine [number]: Invoice fine for overdue payment in %. ex: 2.5
     * interest [number]: Invoice monthly interest for overdue payment in %. ex: 5.2
     * discounts [list of maps]: list of up to 5 dictionaries with "percentage":float and "due":string pairs
     * rules [list of maps]: list of Invoice.Rule objects for modifying invoice behavior. ex: [Invoice.Rule(key="allowedTaxIds", value=[ "012.345.678-90", "45.059.493/0001-73" ])]
     * splits [list of maps]: list of Split.Splits objects to indicate payment receivers. ex: [Invoice.Split(amount=141, receiverId="5706627130851328")]
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * descriptions [list of maps]: list of up to 15 dictionaries with "key":string and (optional) "value":string pairs
     * pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
     * link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
     * nominalAmount [integer]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
     * fineAmount [integer]: Invoice fine value calculated over nominalAmount. ex: 20000
     * interestAmount [integer]: Invoice interest value calculated over nominalAmount. ex: 10000
     * discountAmount [integer]: Invoice discount value calculated over nominalAmount. ex: 3000
     * id [string]: unique id returned when Invoice is created. ex: "5656565656565656"
     * brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
     * status [string]: current Invoice status. ex: "registered" or "paid"
     * fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
     * transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
     * created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(Invoice.class, "Invoice");

    public Number amount;
    public String taxId;
    public String name;
    public String due;
    public Number expiration;
    public Number fine;
    public Number interest;
    public List<Invoice.Discount> discounts;
    public List<Invoice.Rule> rules;
    public List<Split> splits;
    public String[] tags;
    public List<Invoice.Description> descriptions;
    public String pdf;
    public String link;
    public Number nominalAmount;
    public Number fineAmount;
    public Number interestAmount;
    public Number discountAmount;
    public String brcode;
    public String status;
    public Integer fee;
    public String[] transactionIds;
    public String created;
    public String updated;


    /**
     * Invoice object
     * <p>
     * When you initialize an Invoice, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. To create scheduled Invoices, which will display the discount, interest, etc. on the final users banking interface, use dates instead of datetimes on the "due" and "discounts" fields.
     * <p>
     * Parameters:
     * @param amount [integer]: Invoice value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34). If amount = 0, the Invoice will accept any amount paid by the customer; otherwise, only the exact amount will be accepted. When paid, this attribute is updated with the amount actually paid.
     * @param taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param name [string]: payer name. ex: "Iron Bank S.A."
     * @param due [string]: Invoice due date in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
     * @param expiration [integer]: time interval in seconds between due date and expiration date. After the expiration, the Invoice can no longer be paid. ex 123456789
     * @param fine [number]: Invoice fine for overdue payment in %. ex: 2.5
     * @param interest [number]: Invoice monthly interest for overdue payment in %. ex: 5.2
     * @param discounts [list of maps]: list of up to 5 dictionaries with "percentage":float and "due":string pairs
     * @param rules [list of maps]: list of Invoice.Rule objects for modifying invoice behavior. ex: [Invoice.Rule(key="allowedTaxIds", value=[ "012.345.678-90", "45.059.493/0001-73" ])]
     * @param splits [list of maps]: list of Split.Splits objects to indicate payment receivers. ex: [Invoice.Split(amount=141, receiverId="5706627130851328")]
     * @param tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * @param descriptions [list of maps]: list of up to 15 dictionaries with "key":string and (optional) "value":string pairs
     * @param pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
     * @param link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
     * @param nominalAmount [integer]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
     * @param fineAmount [integer]: Invoice fine value calculated over nominalAmount. ex: 20000
     * @param interestAmount [integer]: Invoice interest value calculated over nominalAmount. ex: 10000
     * @param discountAmount [integer]: Invoice discount value calculated over nominalAmount. ex: 3000
     * @param id [string]: unique id returned when Invoice is created. ex: "5656565656565656"
     * @param brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
     * @param status [string]: current Invoice status. ex: "registered" or "paid"
     * @param fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
     * @param transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
     * @param created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public Invoice(Number amount, String due, String taxId, String name, Number expiration, Number fine, Number interest, List<Invoice.Description> descriptions, List<Invoice.Discount> discounts, List<Invoice.Rule> rules, List<Split> splits, String pdf, String link, String[] tags, Number nominalAmount, Number fineAmount, Number interestAmount, Number discountAmount, String id, String brcode, Integer fee, String[] transactionIds, String status, String created, String updated) {
        super(id);
        this.amount = amount;
        this.due = due;
        this.taxId = taxId;
        this.name = name;
        this.expiration = expiration;
        this.fine = fine;
        this.interest = interest;
        this.descriptions = descriptions;
        this.discounts = discounts;
        this.rules = rules;
        this.splits = splits;
        this.pdf = pdf;
        this.link = link;
        this.tags = tags;
        this.nominalAmount = nominalAmount;
        this.fineAmount = fineAmount;
        this.interestAmount = interestAmount;
        this.discountAmount = discountAmount;
        this.brcode = brcode;
        this.fee = fee;
        this.transactionIds = transactionIds;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Invoice object
     * <p>
     * When you initialize an Invoice, the entity will not be automatically sent to the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects. To create scheduled Invoices, which will display the discount, interest, etc. on the final users banking interface, use dates instead of datetimes on the "due" and "discounts" fields.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the Invoice
     * amount [integer]: Invoice value in cents. Minimum = 0 (any value will be accepted). ex: 1234 (= R$ 12.34). If amount = 0, the Invoice will accept any amount paid by the customer; otherwise, only the exact amount will be accepted. When paid, this attribute is updated with the amount actually paid.
     * taxId [string]: payer tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * name [string]: payer name. ex: "Iron Bank S.A."
     * due [string]: Invoice due date in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00" for immediate invoices and "2020-10-28" for scheduled invoices
     * expiration [integer]: time interval in seconds between due date and expiration date. After the expiration, the Invoice can no longer be paid. ex 123456789
     * fine [number]: Invoice fine for overdue payment in %. ex: 2.5
     * interest [number]: Invoice monthly interest for overdue payment in %. ex: 5.2
     * discounts [list of maps]: list of up to 5 dictionaries with "percentage":float and "due":string pairs
     * rules [list of maps]: list of Invoice.Rule objects for modifying invoice behavior. ex: [Invoice.Rule(key="allowedTaxIds", value=[ "012.345.678-90", "45.059.493/0001-73" ])]
     * splits [list of maps]: list of Split.Splits objects to indicate payment receivers. ex: [Invoice.Split(amount=141, receiverId="5706627130851328")]
     * tags [list of strings]: list of strings for tagging. All tags will be converted to lowercase.
     * descriptions [list of maps]: list of up to 15 dictionaries with "key":string and (optional) "value":string pairs
     * <p>
     * Attributes (return-only):
     * pdf [string]: public Invoice PDF URL. ex: "https://invoice.starkbank.com/pdf/d454fa4e524441c1b0c1a729457ed9d8"
     * link [string]: public Invoice webpage URL. ex: "https://my-workspace.sandbox.starkbank.com/invoicelink/d454fa4e524441c1b0c1a729457ed9d8"
     * nominalAmount [integer]: Invoice emission value in cents (will change if invoice is updated, but not if it's paid). ex: 400000
     * fineAmount [integer]: Invoice fine value calculated over nominalAmount. ex: 20000
     * interestAmount [integer]: Invoice interest value calculated over nominalAmount. ex: 10000
     * discountAmount [integer]: Invoice discount value calculated over nominalAmount. ex: 3000
     * brcode [string]: BR Code for the Invoice payment. ex: "00020101021226800014br.gov.bcb.pix2558invoice.starkbank.com/f5333103-3279-4db2-8389-5efe335ba93d5204000053039865802BR5913Arya Stark6009Sao Paulo6220051656565656565656566304A9A0"
     * status [string]: current Invoice status. ex: "registered" or "paid"
     * fee [integer]: fee charged by this Invoice. ex: 200 (= R$ 2.00)
     * transactionIds [list of strings]: ledger transaction ids linked to this Invoice (if there are more than one, all but the first are reversals or failed reversal chargebacks). ex: ["19827356981273"]
     * created [string]: creation datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the Invoice. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public Invoice(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.amount = (Number) dataCopy.remove("amount");
        this.taxId = (String) dataCopy.remove("taxId");
        this.name = (String) dataCopy.remove("name");
        this.due = (String) dataCopy.remove("due");
        this.expiration = (Number) dataCopy.remove("expiration");
        this.fine = (Number) dataCopy.remove("fine");
        this.interest = (Number) dataCopy.remove("interest");
        this.discounts = parseDiscounts((List<Object>) dataCopy.remove("discounts"));
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.splits = parseSplits((List<Object>) dataCopy.remove("splits"));
        this.tags = (String[]) dataCopy.remove("tags");
        this.descriptions = parseDescriptions((List<Object>) dataCopy.remove("descriptions"));
        this.pdf = null;
        this.link = null;
        this.nominalAmount = null;
        this.fineAmount = null;
        this.interestAmount = null;
        this.discountAmount = null;
        this.brcode = null;
        this.status = null;
        this.fee = null;
        this.transactionIds = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Invoice() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<Invoice.Discount> parseDiscounts(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Invoice.Discount> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Invoice.Discount) {
                parsed.add((Invoice.Discount) item);
                continue;
            }
            if (item instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) item;
                parsed.add(new Invoice.Discount(
                    (Number) map.get("percentage"),
                    (String) map.get("due")
                ));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Invoice.Discount or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<Invoice.Rule> parseRules(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Invoice.Rule> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Invoice.Rule) {
                parsed.add((Invoice.Rule) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new Invoice.Rule((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Invoice.Rule or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<Split> parseSplits(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Split> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Split) {
                parsed.add((Split) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new Split((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Split or HashMap");
        }
        return parsed;
    }

    @SuppressWarnings("unchecked")
    private static List<Invoice.Description> parseDescriptions(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Invoice.Description> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Invoice.Description) {
                parsed.add((Invoice.Description) item);
                continue;
            }
            if (item instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) item;
                parsed.add(new Invoice.Description(
                    (String) map.get("key"),
                    (String) map.get("value")
                ));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Invoice.Description or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific Invoice
     * <p>
     * Receive a single Invoice object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Invoice object with updated attributes
     * @throws Exception error in the request
     */
    public static Invoice get(String id) throws Exception {
        return Invoice.get(id, null);
    }

    /**
     * Retrieve a specific Invoice
     * <p>
     * Receive a single Invoice object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice object with updated attributes
     * @throws Exception error in the request
     */
    public static Invoice get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Invoices
     * <p>
     * Receive a generator of Invoice objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Invoice> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve Invoices
     * <p>
     * Receive a generator of Invoice objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Invoice> query(Map<String, Object> params) throws Exception {
        return Invoice.query(params, null);
    }

    /**
     * Retrieve Invoices
     * <p>
     * Receive a generator of Invoice objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Invoice> query(User user) throws Exception {
        return Invoice.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Invoices
     * <p>
     * Receive a generator of Invoice objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Invoice> query() throws Exception {
        return Invoice.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<Invoice> invoices;
        public String cursor;

        public Page(List<Invoice> invoices, String cursor) {
            this.invoices = invoices;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Invoices
     * <p>
     * Receive a list of up to 100 Invoice objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return Invoice.page(params, null);
    }

    /**
     * Retrieve paged Invoices
     * <p>
     * Receive a list of up to 100 Invoice objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return Invoice.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Invoices
     * <p>
     * Receive a list of up to 100 Invoice objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return Invoice.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Invoices
     * <p>
     * Receive a list of up to 100 Invoice objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
     * status [string, default null]: filter for status of retrieved objects. ex: "paid" or "registered"
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice.Page object:
     * Invoice.Page.invoices: list of Invoice objects with updated attributes
     * Invoice.Page.cursor: cursor to retrieve the next page of Invoice objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Invoice> invoices = new ArrayList<>();
        for (SubResource invoice: page.entities) {
            invoices.add((Invoice) invoice);
        }
        return new Page(invoices, page.cursor);
    }

    /**
     * Create Invoices
     * <p>
     * Send a list of Invoice objects for creation in the Stark Bank API. You can create up to 100 Invoices per call.
     * <p>
     * Parameters:
     * @param invoices [list of Invoice objects or HashMaps]: list of Invoice objects to be created in the API
     * <p>
     * Return:
     * @return list of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Invoice> create(List<?> invoices) throws Exception {
        return Invoice.create(invoices, null);
    }

    /**
     * Create Invoices
     * <p>
     * Send a list of Invoice objects for creation in the Stark Bank API. You can create up to 100 Invoices per call.
     * <p>
     * Parameters:
     * @param invoices [list of Invoice objects or HashMaps]: list of Invoice objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of Invoice objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<Invoice> create(List<?> invoices, User user) throws Exception {
        List<Invoice> invoiceList = new ArrayList<>();
        for (Object invoice : invoices) {
            if (invoice instanceof Map) {
                invoiceList.add(new Invoice((Map<String, Object>) invoice));
                continue;
            }
            if (invoice instanceof Invoice) {
                invoiceList.add((Invoice) invoice);
                continue;
            }
            throw new Exception("Unknown type \"" + invoice.getClass() + "\", use Invoice or HashMap");
        }
        return Rest.post(data, invoiceList, user);
    }

    /**
     * Update Invoice entity
     * <p>
     * Update an Invoice by passing its id. If the invoice hasn't been paid yet, you can adjust parameters such as the amount, due date and expiration; if it has already been paid, you may only decrease the amount, which triggers a payment reversal.
     * <p>
     * Parameters:
     * @param id [string]: Invoice id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * status [string]: You may cancel the invoice by passing 'canceled' in the status
     * amount [string, default null]: new amount to be charged. If the Invoice has already been paid, this is the final amount after reversal. ex: 100 (R$1.00)
     * due [string, default now + 2 days]: Invoice due date in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00"
     * expiration [integer, default null]: time interval in seconds between the due date and the expiration date. ex 123456789
     * <p>
     * Return:
     * @return target Invoice with updated attributes
     * @throws Exception error in the request
     */
    public static Invoice update(String id, Map<String, Object> patchData) throws Exception {
        return Invoice.update(id, patchData, null);
    }

    /**
     * Update Invoice entity
     * <p>
     * Update an Invoice by passing its id. If the invoice hasn't been paid yet, you can adjust parameters such as the amount, due date and expiration; if it has already been paid, you may only decrease the amount, which triggers a payment reversal.
     * <p>
     * Parameters:
     * @param id [string]: Invoice id. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * status [string]: You may cancel the invoice by passing 'canceled' in the status
     * amount [string, default null]: new amount to be charged. If the Invoice has already been paid, this is the final amount after reversal. ex: 100 (R$1.00)
     * due [string, default now + 2 days]: Invoice due date in UTC ISO format. ex: "2020-10-28T17:59:26.249976+00:00"
     * expiration [integer, default null]: time interval in seconds between the due date and the expiration date. ex 123456789
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return target Invoice with updated attributes
     * @throws Exception error in the request
     */
    public static Invoice update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    /**
     * Retrieve a specific Invoice pdf file
     * <p>
     * Receive a single Invoice pdf receipt file generated in the Stark Bank API by its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Invoice pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return Invoice.pdf(id, null);
    }

    /**
     * Retrieve a specific Invoice pdf file
     * <p>
     * Receive a single Invoice pdf receipt file generated in the Stark Bank API by its id.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }

    /**
     * Retrieve a specific Invoice QR Code png
     * <p>
     * Receive a single Invoice QR Code in png format generated in the Stark Bank API by the invoice ID.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Invoice png blob
     * @throws Exception error in the request
     */
    public static InputStream qrcode(String id) throws Exception {
        return Invoice.qrcode(id, null, null);
    }

    /**
     * Retrieve a specific Invoice QR Code png
     * <p>
     * Receive a single Invoice QR Code in png format generated in the Stark Bank API by the invoice ID.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param options [Map of String: Object]: QR code generation options
     * size [integer, default 7]: number of pixels in each "box" of the QR code. Minimum = 1, maximum = 50. ex: 12
     * <p>
     * Return:
     * @return Invoice png blob
     * @throws Exception error in the request
     */
    public static InputStream qrcode(String id, Map<String, Object> options) throws Exception {
        return Invoice.qrcode(id, options, null);
    }

    /**
     * Retrieve a specific Invoice QR Code png
     * <p>
     * Receive a single Invoice QR Code in png format generated in the Stark Bank API by the invoice ID.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice png blob
     * @throws Exception error in the request
     */
    public static InputStream qrcode(String id, User user) throws Exception {
        return Invoice.qrcode(id, null, user);
    }

    /**
     * Retrieve a specific Invoice QR Code png
     * <p>
     * Receive a single Invoice QR Code in png format generated in the Stark Bank API by the invoice ID.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param options [Map of String: Object]: QR code generation options
     * size [integer, default 7]: number of pixels in each "box" of the QR code. Minimum = 1, maximum = 50. ex: 12
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Invoice png blob
     * @throws Exception error in the request
     */
    public static InputStream qrcode(String id, Map<String, Object> options, User user) throws Exception {
        return Rest.getContent(data, id, "qrcode", user, options);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "InvoiceLog");

        public String created;
        public String type;
        public String[] errors;
        public Invoice invoice;

        /**
         * Invoice Log object
         * <p>
         * Every time a Invoice entity is updated, a corresponding Invoice Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the Invoice.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param invoice [Invoice]: Invoice entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this Invoice event
         * @param type [string]: type of the Invoice event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, Invoice invoice, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.invoice = invoice;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific Invoice Log
         * <p>
         * Receive a single Invoice Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Invoice Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific Invoice Log
         * <p>
         * Receive a single Invoice Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Invoice Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve Invoice Logs
         * <p>
         * Receive a generator of Invoice Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "paid" or "registered"
         * invoiceIds [list of strings, default null]: list of Invoice ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of Invoice Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve Invoice Logs
         * <p>
         * Receive a generator of Invoice Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Invoice Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve Invoice Logs
         * <p>
         * Receive a generator of Invoice Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of Invoice Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve Invoice Logs
         * <p>
         * Receive a generator of Invoice Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "paid" or "registered"
         * invoiceIds [list of strings, default null]: list of Invoice ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Invoice Log objects with updated attributes
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
         * Retrieve paged Invoice.Logs
         * <p>
         * Receive a list of up to 100 Invoice Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "paid" or "registered"
         * invoiceIds [list of strings, default null]: list of Invoice ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return Invoice.Log.Page object:
         * Invoice.Log.Page.logs: list of Invoice Log objects with updated attributes
         * Invoice.Log.Page.cursor: cursor to retrieve the next page of Invoice Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged Invoice.Logs
         * <p>
         * Receive a list of up to 100 Invoice Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Invoice.Log.Page object:
         * Invoice.Log.Page.logs: list of Invoice Log objects with updated attributes
         * Invoice.Log.Page.cursor: cursor to retrieve the next page of Invoice Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged Invoice.Logs
         * <p>
         * Receive a list of up to 100 Invoice Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return Invoice.Log.Page object:
         * Invoice.Log.Page.logs: list of Invoice Log objects with updated attributes
         * Invoice.Log.Page.cursor: cursor to retrieve the next page of Invoice Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged Invoice.Logs
         * <p>
         * Receive a list of up to 100 Invoice Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter for log event types. ex: "paid" or "registered"
         * invoiceIds [list of strings, default null]: list of Invoice ids to filter logs. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Invoice.Log.Page object:
         * Invoice.Log.Page.logs: list of Invoice Log objects with updated attributes
         * Invoice.Log.Page.cursor: cursor to retrieve the next page of Invoice Log objects
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

        /**
         * Retrieve a reversed Invoice Log pdf file
         * <p>
         * Receive a reversed Invoice Log pdf receipt file generated in the Stark Bank API by its id.
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Invoice pdf file
         * @throws Exception error in the request
         */
        public static InputStream pdf(String id) throws Exception {
            return Log.pdf(id, null);
        }

        /**
         * Retrieve a reversed Invoice Log pdf file
         * <p>
         * Receive a reversed Invoice Log pdf receipt file generated in the Stark Bank API by its id.
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Invoice pdf file
         * @throws Exception error in the request
         */
        public static InputStream pdf(String id, User user) throws Exception {
            return Rest.getContent(data, id, "pdf", user, new HashMap<>());
        }
    }

    public final static class Description extends SubResource {
        public String key;
        public String value;

        public Description(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Description() {
        }
    }

    public final static class Discount extends SubResource {
        public Number percentage;
        public String due;

        public Discount(Number percentage, String due) {
            this.percentage = percentage;
            this.due = due;
        }

        public Discount() {
        }
    }

    public final static class Payment extends SubResource {
        public Integer amount;
        public String name;
        public String taxId;
        public String bankCode;
        public String branchCode;
        public String accountNumber;
        public String accountType;
        public String endToEndId;
        public String method;

        static ClassData data = new ClassData(Payment.class, "Payment");

        public Payment(Integer amount, String name, String taxId, String bankCode, String branchCode, String accountNumber, String accountType, String endToEndId, String method) {
            this.amount = amount;
            this.name = name;
            this.taxId = taxId;
            this.bankCode = bankCode;
            this.branchCode = branchCode;
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.endToEndId = endToEndId;
            this.method = method;
        }

        public Payment() {
        }
    }

    public final static class Rule extends SubResource {
        public String key;
        public String[] value;

        public Rule(String key, String[] value) {
            this.key = key;
            this.value = value;
        }

        public Rule(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.key = (String) dataCopy.remove("key");
            this.value = (String[]) dataCopy.remove("value");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}

