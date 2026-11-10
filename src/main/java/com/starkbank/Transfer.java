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


public final class Transfer extends Resource {
    /**
     * Transfer object
     * <p>
     * When you initialize a Transfer, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * amount [integer]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
     * name [string]: receiver full name. ex: "Anthony Edward Stark"
     * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * bankCode [string]: code of the receiver bank institution in Brazil. If an ISPB (8 digits) is informed, a PIX transfer will be created, else a TED will be issued. ex: "20018183" or "341"
     * branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
     * accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * accountType [string]: Receiver bank account type. Only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
     * externalId [string]: url safe string that must be unique among all your transfers. Duplicated external_ids will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * scheduled [string]: date or datetime when the transfer will be processed. Ted transfers scheduled for today are accepted until 16:00 (BRT) and pushed to the next business day afterwards; Pix transfers are available 24/7 and may be scheduled for any date and time.
     * description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * displayDescription [string]: optional description to be shown in the receiver bank interface. ex: 'Payment for service #1234'
     * tags [list of strings]: list of strings for reference when searching for transfers. All tags will be converted to lowercase. ex: ["employees", "monthly"]
     * rules [list of maps]: list of Transfer.Rule objects for modifying transfer behavior. ex: [Transfer.Rule(key="resendingLimit", value=5)]
     * id [string]: unique id returned when the transfer is created. ex: "5656565656565656"
     * fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
     * status [string]: current transfer status. ex: "success" or "failed"
     * transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
     * metadata [Map of String: Object]: dictionary object used to store additional information about the Transfer object.
     * created [string]: creation datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(Transfer.class, "Transfer");

    public long amount;
    public String name;
    public String taxId;
    public String bankCode;
    public String branchCode;
    public String accountNumber;
    public String accountType;
    public String externalId;
    public String scheduled;
    public String description;
    public String displayDescription;
    public String[] tags;
    public List<Rule> rules;
    public Integer fee;
    public String status;
    public String[] transactionIds;
    public HashMap<String, Object> metadata;
    public String created;
    public String updated;


    /**
     * Transfer object
     * <p>
     * When you initialize a Transfer, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param amount [integer]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
     * @param name [string]: receiver full name. ex: "Anthony Edward Stark"
     * @param taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * @param bankCode [string]: code of the receiver bank institution in Brazil. If an ISPB (8 digits) is informed, a PIX transfer will be created, else a TED will be issued. ex: "20018183" or "341"
     * @param branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
     * @param accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * @param accountType [string]: Receiver bank account type. Only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
     * @param externalId [string]: url safe string that must be unique among all your transfers. Duplicated external_ids will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * @param scheduled [string]: date or datetime when the transfer will be processed. Ted transfers scheduled for today are accepted until 16:00 (BRT) and pushed to the next business day afterwards; Pix transfers are available 24/7 and may be scheduled for any date and time.
     * @param description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * @param displayDescription [string]: optional description to be shown in the receiver bank interface. ex: 'Payment for service #1234'
     * @param tags [list of strings]: list of strings for reference when searching for transfers. All tags will be converted to lowercase. ex: ["employees", "monthly"]
     * @param rules [list of maps]: list of Transfer.Rule objects for modifying transfer behavior. ex: [Transfer.Rule(key="resendingLimit", value=5)]
     * @param id [string]: unique id returned when the transfer is created. ex: "5656565656565656"
     * @param fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
     * @param status [string]: current transfer status. ex: "success" or "failed"
     * @param transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
     * @param metadata [Map of String: Object]: dictionary object used to store additional information about the Transfer object.
     * @param created [string]: creation datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     * @param updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public Transfer(long amount, String name, String taxId, String bankCode, String branchCode, String accountNumber, String accountType, String externalId, String scheduled, String description, String displayDescription, String[] tags, List<Rule> rules, String id, Integer fee, String status, String[] transactionIds, HashMap<String, Object> metadata, String created, String updated) {
        super(id);
        this.amount = amount;
        this.name = name;
        this.taxId = taxId;
        this.bankCode = bankCode;
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.externalId = externalId;
        this.scheduled = scheduled;
        this.description = description;
        this.displayDescription = displayDescription;
        this.tags = tags;
        this.rules = rules;
        this.fee = fee;
        this.status = status;
        this.transactionIds = transactionIds;
        this.metadata = metadata;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Transfer object
     * <p>
     * When you initialize a Transfer, the entity will not be automatically created in the Stark Bank API. The 'create' function sends the objects to the Stark Bank API and returns the list of created objects.
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the Transfer
     * amount [integer]: amount in cents to be transferred. ex: 1234 (= R$ 12.34)
     * name [string]: receiver full name. ex: "Anthony Edward Stark"
     * taxId [string]: receiver tax ID (CPF or CNPJ) with or without formatting. ex: "01234567890" or "20.018.183/0001-80"
     * bankCode [string]: code of the receiver bank institution in Brazil. If an ISPB (8 digits) is informed, a PIX transfer will be created, else a TED will be issued. ex: "20018183" or "341"
     * branchCode [string]: receiver bank account branch. Use '-' in case there is a verifier digit. ex: "1357-9"
     * accountNumber [string]: receiver bank account number. Use '-' before the verifier digit. ex: "876543-2"
     * accountType [string]: Receiver bank account type. Only has effect on Pix Transfers. ex: "checking", "savings", "salary" or "payment"
     * externalId [string]: url safe string that must be unique among all your transfers. Duplicated external_ids will cause failures. By default, this parameter will block any transfer that repeats amount and receiver information on the same date. ex: "my-internal-id-123456"
     * scheduled [string]: date or datetime when the transfer will be processed. Ted transfers scheduled for today are accepted until 16:00 (BRT) and pushed to the next business day afterwards; Pix transfers are available 24/7 and may be scheduled for any date and time.
     * description [string]: optional description to override default description to be shown in the bank statement. ex: "Payment for service #1234"
     * displayDescription [string]: optional description to be shown in the receiver bank interface. ex: 'Payment for service #1234'
     * tags [list of strings]: list of strings for reference when searching for transfers. All tags will be converted to lowercase. ex: ["employees", "monthly"]
     * rules [list of maps]: list of Transfer.Rule objects for modifying transfer behavior. ex: [Transfer.Rule(key="resendingLimit", value=5)]
     * <p>
     * Attributes (return-only):
     * fee [integer]: fee charged when the Transfer is processed. ex: 200 (= R$ 2.00)
     * status [string]: current transfer status. ex: "success" or "failed"
     * transactionIds [list of strings]: ledger Transaction IDs linked to this Transfer (if there are two, the second is the chargeback). ex: ["19827356981273"]
     * metadata [Map of String: Object]: dictionary object used to store additional information about the Transfer object.
     * created [string]: creation datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     * updated [string]: latest update datetime for the transfer. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public Transfer(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.amount = ((Number) dataCopy.remove("amount")).longValue();
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.bankCode = (String) dataCopy.remove("bankCode");
        this.branchCode = (String) dataCopy.remove("branchCode");
        this.accountNumber = (String) dataCopy.remove("accountNumber");
        this.accountType = (String) dataCopy.remove("accountType");
        this.externalId = (String) dataCopy.remove("externalId");
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.description = (String) dataCopy.remove("description");
        this.displayDescription = (String) dataCopy.remove("displayDescription");
        this.tags = (String[]) dataCopy.remove("tags");
        this.rules = parseRules((List<Object>) dataCopy.remove("rules"));
        this.fee = null;
        this.status = null;
        this.transactionIds = null;
        this.metadata = null;
        this.created = null;
        this.updated = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Transfer() {
        super(null);
    }

    @SuppressWarnings("unchecked")
    private static List<Rule> parseRules(List<Object> items) throws Exception {
        if (items == null) {
            return null;
        }
        List<Rule> parsed = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Rule) {
                parsed.add((Rule) item);
                continue;
            }
            if (item instanceof Map) {
                parsed.add(new Rule((Map<String, Object>) item));
                continue;
            }
            throw new Exception("Unknown type \"" + item.getClass() + "\", use Rule or HashMap");
        }
        return parsed;
    }

    /**
     * Retrieve a specific Transfer
     * <p>
     * Receive a single Transfer object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Transfer object with updated attributes
     * @throws Exception error in the request
     */
    public static Transfer get(String id) throws Exception {
        return Transfer.get(id, null);
    }

    /**
     * Retrieve a specific Transfer
     * <p>
     * Receive a single Transfer object previously created in the Stark Bank API by its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Transfer object with updated attributes
     * @throws Exception error in the request
     */
    public static Transfer get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Transfers
     * <p>
     * Receive a generator of Transfer objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * transactionIds [list of strings, default null]: list of transaction IDs linked to the desired transfers. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * taxId [string, default null]: filter for transfers sent to the specified tax ID. ex: "012.345.678-90"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "created", "-created", "updated" or "-updated".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Transfer> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve Transfers
     * <p>
     * Receive a generator of Transfer objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * transactionIds [list of strings, default null]: list of transaction IDs linked to the desired transfers. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * taxId [string, default null]: filter for transfers sent to the specified tax ID. ex: "012.345.678-90"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "created", "-created", "updated" or "-updated".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Transfer> query(Map<String, Object> params) throws Exception {
        return Transfer.query(params, null);
    }

    /**
     * Retrieve Transfers
     * <p>
     * Receive a generator of Transfer objects previously created in the Stark Bank API
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Transfer> query(User user) throws Exception {
        return Transfer.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Transfers
     * <p>
     * Receive a generator of Transfer objects previously created in the Stark Bank API
     * <p>
     * Return:
     * @return generator of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Transfer> query() throws Exception {
        return Transfer.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<Transfer> transfers;
        public String cursor;

        public Page(List<Transfer> transfers, String cursor) {
            this.transfers = transfers;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Transfers
     * <p>
     * Receive a list of up to 100 Transfer objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * transactionIds [list of strings, default null]: list of transaction IDs linked to the desired transfers. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * taxId [string, default null]: filter for transfers sent to the specified tax ID. ex: "012.345.678-90"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "created", "-created", "updated" or "-updated".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return Transfer.Page object:
     * Transfer.Page.transfers: list of Transfer objects with updated attributes
     * Transfer.Page.cursor: cursor to retrieve the next page of Transfer objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return Transfer.page(params, null);
    }

    /**
     * Retrieve paged Transfers
     * <p>
     * Receive a list of up to 100 Transfer objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Transfer.Page object:
     * Transfer.Page.transfers: list of Transfer objects with updated attributes
     * Transfer.Page.cursor: cursor to retrieve the next page of Transfer objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return Transfer.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Transfers
     * <p>
     * Receive a list of up to 100 Transfer objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Transfer.Page object:
     * Transfer.Page.transfers: list of Transfer objects with updated attributes
     * Transfer.Page.cursor: cursor to retrieve the next page of Transfer objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return Transfer.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Transfers
     * <p>
     * Receive a list of up to 100 Transfer objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * after [string, default null] date filter for objects created or updated only after specified date. ex: "2020-03-10"
     * before [string, default null] date filter for objects created or updated only before specified date. ex: "2020-03-10"
     * transactionIds [list of strings, default null]: list of transaction IDs linked to the desired transfers. ex: ["5656565656565656", "4545454545454545"]
     * status [string, default null]: filter for status of retrieved objects. ex: "success" or "failed"
     * taxId [string, default null]: filter for transfers sent to the specified tax ID. ex: "012.345.678-90"
     * sort [string, default "-created"]: sort order considered in response. Valid options are "created", "-created", "updated" or "-updated".
     * tags [list of strings, default null]: tags to filter retrieved objects. ex: ["tony", "stark"]
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Transfer.Page object:
     * Transfer.Page.transfers: list of Transfer objects with updated attributes
     * Transfer.Page.cursor: cursor to retrieve the next page of Transfer objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Transfer> transfers = new ArrayList<>();
        for (SubResource transfer: page.entities) {
            transfers.add((Transfer) transfer);
        }
        return new Page(transfers, page.cursor);
    }

    /**
     * Create Transfers
     * <p>
     * Send a list of Transfer objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param transfers [list of Transfer objects or HashMaps]: list of Transfer objects to be created in the API
     * <p>
     * Return:
     * @return list of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<Transfer> create(List<?> transfers) throws Exception {
        return Transfer.create(transfers, null);
    }

    /**
     * Create Transfers
     * <p>
     * Send a list of Transfer objects for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param transfers [list of Transfer objects or HashMaps]: list of Transfer objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of Transfer objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<Transfer> create(List<?> transfers, User user) throws Exception {
        List<Transfer> transferList = new ArrayList<>();
        for (Object transfer : transfers) {
            if (transfer instanceof Map) {
                transferList.add(new Transfer((Map<String, Object>) transfer));
                continue;
            }
            if (transfer instanceof Transfer) {
                transferList.add((Transfer) transfer);
                continue;
            }
            throw new Exception("Unknown type \"" + transfer.getClass() + "\", use Transfer or HashMap");
        }
        return Rest.post(data, transferList, user);
    }

    /**
     * Retrieve a specific Transfer pdf file
     * <p>
     * Receive a single Transfer pdf receipt file generated in the Stark Bank API by its id.
     * Only valid for transfers with "processing" and "success" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Transfer pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id) throws Exception {
        return Transfer.pdf(id, null);
    }

    /**
     * Retrieve a specific Transfer pdf file
     * <p>
     * Receive a single Transfer pdf receipt file generated in the Stark Bank API by its id.
     * Only valid for transfers with "processing" and "success" status.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Transfer pdf file
     * @throws Exception error in the request
     */
    public static InputStream pdf(String id, User user) throws Exception {
        return Rest.getContent(data, id, "pdf", user, new HashMap<>());
    }

    /**
     * Delete a Transfer entity
     * <p>
     * Cancel a scheduled Transfer entity, previously created in the Stark Bank API, before it starts being processed. Canceled transfers still appear in later queries.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return deleted Transfer object
     * @throws Exception error in the request
     */
    public static Transfer delete(String id) throws Exception {
        return Transfer.delete(id, null);
    }

    /**
     * Delete a Transfer entity
     * <p>
     * Cancel a scheduled Transfer entity, previously created in the Stark Bank API, before it starts being processed. Canceled transfers still appear in later queries.
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return deleted Transfer object
     * @throws Exception error in the request
     */
    public static Transfer delete(String id, User user) throws Exception {
        return Rest.delete(data, id, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "TransferLog");

        public String created;
        public String type;
        public String[] errors;
        public Transfer transfer;

        /**
         * Transfer Log object
         * <p>
         * Every time a Transfer entity is updated, a corresponding Transfer Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the Transfer.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param transfer [Transfer]: Transfer entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this Transfer event
         * @param type [string]: type of the Transfer event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, Transfer transfer, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.transfer = transfer;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific Transfer Log
         * <p>
         * Receive a single Transfer Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * <p>
         * Return:
         * @return Transfer Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific Transfer Log
         * <p>
         * Receive a single Transfer Log object previously created by the Stark Bank API by its id
         * <p>
         * Parameters:
         * @param id [string]: object unique id. ex: "5656565656565656"
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Transfer Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve Transfer Logs
         * <p>
         * Receive a generator of Transfer Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * transferIds [list of strings, default null]: list of Transfer ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return generator of Transfer Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve Transfer Logs
         * <p>
         * Receive a generator of Transfer Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Transfer Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve Transfer Logs
         * <p>
         * Receive a generator of Transfer Log objects previously created in the Stark Bank API
         * <p>
         * Return:
         * @return generator of Transfer Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve Transfer Logs
         * <p>
         * Receive a generator of Transfer Log objects previously created in the Stark Bank API
         * <p>
         * Parameters:
         * @param params map of parameters for the query
         * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * transferIds [list of strings, default null]: list of Transfer ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return generator of Transfer Log objects with updated attributes
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
         * Retrieve paged Transfer.Logs
         * <p>
         * Receive a list of up to 100 Transfer Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * transferIds [list of strings, default null]: list of Transfer ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * <p>
         * Return:
         * @return Transfer.Log.Page object:
         * Transfer.Log.Page.logs: list of Transfer Log objects with updated attributes
         * Transfer.Log.Page.cursor: cursor to retrieve the next page of Transfer Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged Transfer.Logs
         * <p>
         * Receive a list of up to 100 Transfer Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Transfer.Log.Page object:
         * Transfer.Log.Page.logs: list of Transfer Log objects with updated attributes
         * Transfer.Log.Page.cursor: cursor to retrieve the next page of Transfer Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged Transfer.Logs
         * <p>
         * Receive a list of up to 100 Transfer Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Return:
         * @return Transfer.Log.Page object:
         * Transfer.Log.Page.logs: list of Transfer Log objects with updated attributes
         * Transfer.Log.Page.cursor: cursor to retrieve the next page of Transfer Log objects
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged Transfer.Logs
         * <p>
         * Receive a list of up to 100 Transfer Log objects previously created in the Stark Bank API and the cursor to the next page.
         * Use this function instead of query if you want to manually page your requests.
         * <p>
         * Parameters:
         * @param params parameters of the query
         * cursor [string, default null]: cursor returned on the previous page function call
         * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
         * after [string, default null] date filter for objects created only after specified date. ex: "2020-03-10"
         * before [string, default null] date filter for objects created only before specified date. ex: "2020-03-10"
         * types [list of strings, default null]: filter retrieved objects by types. ex: "success" or "failed"
         * transferIds [list of strings, default null]: list of Transfer ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
         * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
         * <p>
         * Return:
         * @return Transfer.Log.Page object:
         * Transfer.Log.Page.logs: list of Transfer Log objects with updated attributes
         * Transfer.Log.Page.cursor: cursor to retrieve the next page of Transfer Log objects
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
        public Object value;

        public Rule(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Rule() {
        }

        public Rule(Map<String, Object> data) throws Exception {
            HashMap<String, Object> dataCopy = new HashMap<>(data);

            this.key = (String) dataCopy.remove("key");
            this.value = (Object) dataCopy.remove("value");

            if (!dataCopy.isEmpty()) {
                throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
            }
        }
    }
}

