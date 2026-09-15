package com.starkbank;


import com.starkbank.utils.Rest;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Generator;
import com.starkcore.utils.SubResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SplitProfile object
 * <p>
 * When you create a Split, the entity SplitProfile will be automatically created. If you haven't created a Split yet, you can use put to create your SplitProfile. 
 * <p>
 * Parameters:
 * id [String]: Unique ID returned when the SplitProfile is created
 * interval [String]: Frequency of transfer
 * delay [Integer]: How long the amount will stay at the workspace, in milliseconds. Example: 604800
 * tags [List<String>], optional: 
 * status [String]: Current SplitProfile status. Example: 'created'
 * created [String]: Creation timestamp
 * updated [String]: Latest update timestamp
 *
 */
public class SplitProfile extends Resource {
    static ClassData data = new ClassData(SplitProfile.class, "SplitProfile");

    public String interval;
    public Integer delay;
    public List<String> tags;
    public String status;
    public String created;
    public String updated;


    public SplitProfile(String interval, Integer delay, List<String> tags, String status, String created, String updated) {
        super(null);
        this.interval = interval;
        this.delay = delay;
        this.tags = tags;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    @SuppressWarnings("unchecked")
    public SplitProfile(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.interval = (String) dataCopy.remove("interval");
        this.delay = (Integer) dataCopy.remove("delay");
        this.tags = (List<String>) dataCopy.remove("tags");
        this.status = (String) dataCopy.remove("status");
        this.created = (String) dataCopy.remove("created");
        this.updated = (String) dataCopy.remove("updated");

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public SplitProfile() {
        super(null);
    }

    /**
     * Retrieve a specific SplitProfile
     * <p>
     * Receive a single SplitProfile object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return SplitProfile object with updated attributes
     * @throws Exception error in the request
     */
    public static SplitProfile get(String id) throws Exception {
        return SplitProfile.get(id, null);
    }

    /**
     * Retrieve a specific SplitProfile
     * <p>
     * Receive a single SplitProfile object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return SplitProfile object with updated attributes
     * @throws Exception error in the request
     */
    public static SplitProfile get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve SplitProfiles
     * <p>
     * Receive a generator of SplitProfile objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Return:
     * @return generator of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<SplitProfile> query() throws Exception {
        return SplitProfile.query(new HashMap<>(), null);
    }

    /**
     * Retrieve SplitProfiles
     * <p>
     * Receive a generator of SplitProfile objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<SplitProfile> query(User user) throws Exception {
        return SplitProfile.query(new HashMap<>(), user);
    }

    /**
     * Retrieve SplitProfiles
     * <p>
     * Receive a generator of SplitProfile objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * <p>
     * Return:
     * @return generator of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<SplitProfile> query(Map<String, Object> params) throws Exception {
        return SplitProfile.query(params, null);
    }

    /**
     * Retrieve SplitProfiles
     * <p>
     * Receive a generator of SplitProfile objects previously created in the Stark Bank API.
     * Use this function instead of page if you want to stream the objects without worrying about cursors and pagination.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return generator of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<SplitProfile> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    public final static class Page {
        public List<SplitProfile> splitProfiles;
        public String cursor;

        public Page(List<SplitProfile> splitProfiles, String cursor) {
            this.splitProfiles = splitProfiles;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged SplitProfiles
     * <p>
     * Receive a list of up to 100 SplitProfile objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return SplitProfile.Page object with splitProfiles list and cursor
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return SplitProfile.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged SplitProfiles
     * <p>
     * Receive a list of up to 100 SplitProfile objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return SplitProfile.Page object with splitProfiles list and cursor
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return SplitProfile.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged SplitProfiles
     * <p>
     * Receive a list of up to 100 SplitProfile objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * <p>
     * Return:
     * @return SplitProfile.Page object with splitProfiles list and cursor
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return SplitProfile.page(params, null);
    }

    /**
     * Retrieve paged SplitProfiles
     * <p>
     * Receive a list of up to 100 SplitProfile objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return SplitProfile.Page object with splitProfiles list and cursor
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<SplitProfile> splitProfiles = new ArrayList<>();
        for (SubResource splitProfile: page.entities)
            splitProfiles.add((SplitProfile) splitProfile);
        return new Page(splitProfiles, page.cursor);
    }

    public final static class Log extends Resource {
        static ClassData data = new ClassData(Log.class, "SplitProfileLog");

        public String created;
        public String type;
        public String[] errors;
        public SplitProfile splitProfile;

        /**
         * SplitProfile Log object
         * <p>
         * Every time a SplitProfile entity is updated, a corresponding SplitProfile Log
         * is generated for the entity. This log is never generated by the user,
         * but it can be retrieved to check additional information on the SplitProfile.
         * <p>
         * Attributes (return-only):
         * @param id [string]: unique id returned when the log is created
         * @param splitProfile [SplitProfile]: SplitProfile entity to which the log refers to
         * @param errors [list of strings]: list of errors linked to this SplitProfile event
         * @param type [string]: type of the SplitProfile event which triggered the log creation
         * @param created [string]: creation datetime for the log
         */
        public Log(String created, String type, String[] errors, SplitProfile splitProfile, String id) {
            super(id);
            this.created = created;
            this.type = type;
            this.errors = errors;
            this.splitProfile = splitProfile;
        }

        public Log() {
            super(null);
        }

        /**
         * Retrieve a specific SplitProfile Log
         * <p>
         * Parameters:
         * @param id [string]: object unique id
         * <p>
         * Return:
         * @return SplitProfile Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id) throws Exception {
            return Log.get(id, null);
        }

        /**
         * Retrieve a specific SplitProfile Log
         * <p>
         * Parameters:
         * @param id [string]: object unique id
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return SplitProfile Log object with updated attributes
         * @throws Exception error in the request
         */
        public static Log get(String id, User user) throws Exception {
            return Rest.getId(data, id, user);
        }

        /**
         * Retrieve SplitProfile Logs
         * <p>
         * Return:
         * @return generator of SplitProfile Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query() throws Exception {
            return Log.query(new HashMap<>(), null);
        }

        /**
         * Retrieve SplitProfile Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * <p>
         * Return:
         * @return generator of SplitProfile Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(Map<String, Object> params) throws Exception {
            return Log.query(params, null);
        }

        /**
         * Retrieve SplitProfile Logs
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return generator of SplitProfile Log objects with updated attributes
         * @throws Exception error in the request
         */
        public static Generator<Log> query(User user) throws Exception {
            return Log.query(new HashMap<>(), user);
        }

        /**
         * Retrieve SplitProfile Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return generator of SplitProfile Log objects with updated attributes
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
         * Retrieve paged SplitProfile Logs
         * <p>
         * Return:
         * @return SplitProfile.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page() throws Exception {
            return Log.page(new HashMap<>(), null);
        }

        /**
         * Retrieve paged SplitProfile Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * <p>
         * Return:
         * @return SplitProfile.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params) throws Exception {
            return Log.page(params, null);
        }

        /**
         * Retrieve paged SplitProfile Logs
         * <p>
         * Parameters:
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return SplitProfile.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(User user) throws Exception {
            return Log.page(new HashMap<>(), user);
        }

        /**
         * Retrieve paged SplitProfile Logs
         * <p>
         * Parameters:
         * @param params parameters of the query
         * @param user [Organization/Project object]: Organization or Project object
         * <p>
         * Return:
         * @return SplitProfile.Log.Page object with logs list and cursor
         * @throws Exception error in the request
         */
        public static Log.Page page(Map<String, Object> params, User user) throws Exception {
            com.starkcore.utils.Page page = Rest.getPage(data, params, user);
            List<Log> logs = new ArrayList<>();
            for (SubResource log: page.entities)
                logs.add((Log) log);
            return new Page(logs, page.cursor);
        }
    }
}

