package com.starkbank;

import com.starkbank.utils.Rest;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Generator;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
 * externalId [String], optional: Unique id provided by the user to avoid duplicates
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
    public String externalId;
    public String created;
    public String updated;


    public SplitProfile(String interval, Integer delay, List<String> tags, String status, String externalId, String created, String updated) {
        super(null);
        this.interval = interval;
        this.delay = delay;
        this.tags = tags;
        this.status = status;
        this.externalId = externalId;
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
        this.externalId = (String) dataCopy.remove("externalId");
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
     * Create or update SplitProfiles
     * <p>
     * Send a list of SplitProfile objects for creation/update in the Stark Bank API
     * <p>
     * Parameters:
     * @param splitProfiles [list of SplitProfile objects or HashMaps]: list of SplitProfile objects to be created/updated in the API
     * <p>
     * Return:
     * @return list of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<SplitProfile> put(List<?> splitProfiles) throws Exception {
        return SplitProfile.put(splitProfiles, null);
    }

    /**
     * Create or update SplitProfiles
     * <p>
     * Send a list of SplitProfile objects for creation/update in the Stark Bank API
     * <p>
     * Parameters:
     * @param splitProfiles [list of SplitProfile objects or HashMaps]: list of SplitProfile objects to be created/updated in the API
     * @param user [Organization/Project object]: Organization or Project object. Not necessary if starkbank.User.defaultUser was set before function call
     * <p>
     * Return:
     * @return list of SplitProfile objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<SplitProfile> put(List<?> splitProfiles, User user) throws Exception {
        List<SplitProfile> splitProfileList = new ArrayList<>();
        for (Object splitProfile : splitProfiles) {
            if (splitProfile instanceof Map)
                splitProfileList.add(new SplitProfile((Map<String, Object>) splitProfile));
            else if (splitProfile instanceof SplitProfile)
                splitProfileList.add((SplitProfile) splitProfile);
            else
                throw new Exception("Unknown type \"" + splitProfile.getClass() + "\", use SplitProfile or HashMap");
        }
        return Rest.put(data, splitProfileList, user);
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
}

