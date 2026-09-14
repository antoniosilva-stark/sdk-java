package com.starkbank;


import com.starkbank.utils.Rest;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Generator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Deposit object
 * <p>
 * Deposits represent passive cash-in received by your account from external transfers
 * <p>
 * Parameters:
 * id [String]: unique id associated with a Deposit when it is created. ex: \"5656565656565656\"
 * name [String]: payer name. ex: \"Iron Bank S.A.\"
 * taxId [String]: payer tax ID (CPF or CNPJ). ex: \"012.345.678-90\" or \"20.018.183/0001-80\"
 * bankCode [String]: payer bank code in Brazil. ex: \"20018183\" or \"341\"
 * branchCode [String]: payer bank account branch. ex: \"1357-9\"
 * accountNumber [String]: payer bank account number. ex: \"876543-2\"
 * accountType [String]: payer bank account type. ex: \"checking\"
 * amount [Long]: Deposit value in cents. ex: 1234 (= R$ 12.34)
 * type [String]: Type of settlement that originated the deposit. ex: \"pix\" or \"ted\"
 * status [String]: current Deposit status. ex: \"created\"
 * tags [List<String>]: 
 * fee [Integer]: fee charged by this deposit. ex: 50 (= R$ 0.50)
 * transactionIds [List<String>]: 
 * created [String]: creation datetime for the Deposit. ex: datetime.datetime(2020, 12, 10, 10, 30, 0, 0)
 * updated [String]: latest update datetime for the Deposit. ex: datetime.datetime(2020, 12, 10, 10, 30, 0, 0)
 *
 */
public class Deposit extends Resource {
    static ClassData data = new ClassData(Deposit.class, "Deposit");

    public String name;
    public String taxId;
    public String bankCode;
    public String branchCode;
    public String accountNumber;
    public String accountType;
    public Long amount;
    public String type;
    public String status;
    public List<String> tags;
    public Integer fee;
    public List<String> transactionIds;
    public String created;
    public String updated;


    public Deposit(String name, String taxId, String bankCode, String branchCode, String accountNumber, String accountType, Long amount, String type, String status, List<String> tags, Integer fee, List<String> transactionIds, String created, String updated) {
        super(null);
        this.name = name;
        this.taxId = taxId;
        this.bankCode = bankCode;
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.tags = tags;
        this.fee = fee;
        this.transactionIds = transactionIds;
        this.created = created;
        this.updated = updated;
    }

    @SuppressWarnings("unchecked")
    public Deposit(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.name = (String) dataCopy.remove("name");
        this.taxId = (String) dataCopy.remove("taxId");
        this.bankCode = (String) dataCopy.remove("bankCode");
        this.branchCode = (String) dataCopy.remove("branchCode");
        this.accountNumber = (String) dataCopy.remove("accountNumber");
        this.accountType = (String) dataCopy.remove("accountType");
        this.amount = (Long) dataCopy.remove("amount");
        this.type = (String) dataCopy.remove("type");
        this.status = (String) dataCopy.remove("status");
        this.tags = (List<String>) dataCopy.remove("tags");
        this.fee = (Integer) dataCopy.remove("fee");
        this.transactionIds = (List<String>) dataCopy.remove("transactionIds");
        this.created = (String) dataCopy.remove("created");
        this.updated = (String) dataCopy.remove("updated");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Deposit() {
        super(null);
    }

    /**
     * Retrieve a specific Deposit
     * <p>
     * Receive a single Deposit object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Deposit object with updated attributes
     * @throws Exception error in the request
     */
    public static Deposit get(String id) throws Exception {
        return Deposit.get(id, null);
    }

    /**
     * Retrieve a specific Deposit
     * <p>
     * Receive a single Deposit object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return Deposit object with updated attributes
     * @throws Exception error in the request
     */
    public static Deposit get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Deposits
     * <p>
     * Receive a generator of Deposit objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of Deposit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Deposit> query() throws Exception {
        return Deposit.query(new HashMap<>(), null);
    }

    /**
     * Retrieve Deposits
     * <p>
     * Receive a generator of Deposit objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of Deposit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Deposit> query(User user) throws Exception {
        return Deposit.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Deposits
     * <p>
     * Receive a generator of Deposit objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * <p>
     * Return:
     * @return generator of Deposit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Deposit> query(Map<String, Object> params) throws Exception {
        return Deposit.query(params, null);
    }

    /**
     * Retrieve Deposits
     * <p>
     * Receive a generator of Deposit objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of Deposit objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Deposit> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<Deposit> deposits;
        public String cursor;

        public Page(List<Deposit> deposits, String cursor) {
            this.deposits = deposits;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Deposits
     * <p>
     * Receive a list of up to 100 Deposit objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Deposit.Page object with deposits list and cursor
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return Deposit.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Deposits
     * <p>
     * Receive a list of up to 100 Deposit objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return Deposit.Page object with deposits list and cursor
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return Deposit.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Deposits
     * <p>
     * Receive a list of up to 100 Deposit objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * <p>
     * Return:
     * @return Deposit.Page object with deposits list and cursor
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return Deposit.page(params, null);
    }

    /**
     * Retrieve paged Deposits
     * <p>
     * Receive a list of up to 100 Deposit objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return Deposit.Page object with deposits list and cursor
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Deposit> deposits = new ArrayList<>();
        for (com.starkcore.utils.SubResource deposit: page.entities)
            deposits.add((Deposit) deposit);
        return new Page(deposits, page.cursor);
    }

    /**
     * Update Deposit entity
     * <p>
     * Parameters:
     * @param id [string]: object unique id
     * @param patchData map of parameters to patch
     * <p>
     * Return:
     * @return updated Deposit object
     * @throws Exception error in the request
     */
    public static Deposit update(String id, Map<String, Object> patchData) throws Exception {
        return Deposit.update(id, patchData, null);
    }

    /**
     * Update Deposit entity
     * <p>
     * Parameters:
     * @param id [string]: object unique id
     * @param patchData map of parameters to patch
     * @param user [Organization/Project object]: Organization or Project object
     * <p>
     * Return:
     * @return updated Deposit object
     * @throws Exception error in the request
     */
    public static Deposit update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "DepositLog");

        public String created;
        public String type;
        public String[] errors;
        public Deposit deposit;

        /**
         * Deposit Log object
         * <p>
         * Every time a Deposit entity is updated, a corresponding Deposit Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the Deposit.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param deposit [Deposit]: Deposit entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this Deposit event
         * @param type [string]: type of the Deposit event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, Deposit deposit, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.deposit = deposit;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific Deposit Log
         * <p>
         * Parameters:
         * @param id [string]: object unique id
         * <p>
         * Return:
         * @return Deposit Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific Deposit Log
         * <p>
         * Parameters:
         * @param id [string]: object unique id
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return Deposit Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve Deposit Logs
         * <p>
         * Return:
         * @return generator of Deposit Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve Deposit Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * <p>
         * Return:
         * @return generator of Deposit Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve Deposit Logs
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return generator of Deposit Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve Deposit Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return generator of Deposit Log objects with updated attributes
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
         * Retrieve paged Deposit Logs
         * <p>
         * Return:
         * @return Deposit.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged Deposit Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * <p>
         * Return:
         * @return Deposit.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged Deposit Logs
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return Deposit.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged Deposit Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return Deposit.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (com.starkcore.utils.SubResource log: page.entities)
                logs.add((Log) log);
            return new Page(logs, page.cursor);
        }
    }
}

