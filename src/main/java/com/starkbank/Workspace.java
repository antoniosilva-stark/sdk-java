package com.starkbank;

import com.starkbank.utils.Generator;
import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;
import com.starkcore.utils.SubResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Workspace extends Resource {
    /**
     * Workspace object
     * <p>
     * Workspaces are bank accounts. They have independent balances, statements, operations and permissions. The only property that is shared between your workspaces is that they are linked to your organization, which carries your basic informations, such as tax ID, name, etc..
     * <p>
     * Parameters:
     * username [string]: Simplified, URL-safe name that defines the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * name [string]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * id [string]: unique id returned when the workspace is created. ex: "5656565656565656"
     * status [string]: current Workspace status. Options: "active", "closed", "frozen" or "blocked"
     * organizationId [string]: unique organization id returned when the organization is created. ex: "5656565656565656"
     * pictureUrl [string]: public workspace image (png) URL. ex: "https://storage.googleapis.com/api-ms-workspace-sbx.appspot.com/pictures/workspace/6284441752174592.png?20230208220551"
     * created [string]: creation datetime of the workspace. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    static ClassData data = new ClassData(Workspace.class, "Workspace");

    public String username;
    public String name;
    public List<String> allowedTaxIds;
    public String status;
    public String organizationId;
    public String pictureUrl;
    public String created;


    /**
     * Workspace object
     * <p>
     * Workspaces are bank accounts. They have independent balances, statements, operations and permissions. The only property that is shared between your workspaces is that they are linked to your organization, which carries your basic informations, such as tax ID, name, etc..
     * <p>
     * Parameters:
     * @param username [string]: Simplified, URL-safe name that defines the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * @param name [string]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * @param allowedTaxIds [list of strings]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * @param id [string]: unique id returned when the workspace is created. ex: "5656565656565656"
     * @param status [string]: current Workspace status. Options: "active", "closed", "frozen" or "blocked"
     * @param organizationId [string]: unique organization id returned when the organization is created. ex: "5656565656565656"
     * @param pictureUrl [string]: public workspace image (png) URL. ex: "https://storage.googleapis.com/api-ms-workspace-sbx.appspot.com/pictures/workspace/6284441752174592.png?20230208220551"
     * @param created [string]: creation datetime of the workspace. ex: "2020-03-10 10:30:00.000000+00:00"
     */
    public Workspace(String username, String name, List<String> allowedTaxIds, String status, String id, String organizationId, String pictureUrl, String created) {
        super(id);
        this.username = username;
        this.name = name;
        this.allowedTaxIds = allowedTaxIds;
        this.status = status;
        this.organizationId = organizationId;
        this.pictureUrl = pictureUrl;
        this.created = created;
    }

    /**
     * Workspace object
     * <p>
     * Workspaces are bank accounts. They have independent balances, statements, operations and permissions. The only property that is shared between your workspaces is that they are linked to your organization, which carries your basic informations, such as tax ID, name, etc..
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the Workspace
     * username [string]: Simplified, URL-safe name that defines the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * name [string]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * <p>
     * Attributes (return-only):
     * status [string]: current Workspace status. Options: "active", "closed", "frozen" or "blocked"
     * organizationId [string]: unique organization id returned when the organization is created. ex: "5656565656565656"
     * pictureUrl [string]: public workspace image (png) URL. ex: "https://storage.googleapis.com/api-ms-workspace-sbx.appspot.com/pictures/workspace/6284441752174592.png?20230208220551"
     * created [string]: creation datetime of the workspace. ex: "2020-03-10 10:30:00.000000+00:00"
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public Workspace(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.username = (String) dataCopy.remove("username");
        this.name = (String) dataCopy.remove("name");
        this.allowedTaxIds = (List<String>) dataCopy.remove("allowedTaxIds");
        this.status = null;
        this.organizationId = null;
        this.pictureUrl = null;
        this.created = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public Workspace() {
        super(null);
    }

    /**
     * Retrieve a specific Workspace
     * <p>
     * Receive a single Workspace object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * <p>
     * Return:
     * @return Workspace object with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace get(String id) throws Exception {
        return Workspace.get(id, null);
    }

    /**
     * Retrieve a specific Workspace
     * <p>
     * Receive a single Workspace object previously created in the Stark Bank API by passing its id
     * <p>
     * Parameters:
     * @param id [string]: object unique id. ex: "5656565656565656"
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Workspace object with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace get(String id, User user) throws Exception {
        return Rest.getId(data, id, user);
    }

    /**
     * Retrieve Workspaces
     * <p>
     * Receive a generator of Workspace objects previously created in the Stark Bank API.
     * If no filters are passed and the user is an Organization, all of the Organization Workspaces
     * will be retrieved.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * username [string, default null]: query by the simplified name that defines the workspace URL. This name is always unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Workspace objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Workspace> query(Map<String, Object> params, User user) throws Exception {
        return Rest.getStream(data, params, user);
    }

    /**
     * Retrieve Workspaces
     * <p>
     * Receive a generator of Workspace objects previously created in the Stark Bank API.
     * If no filters are passed and the user is an Organization, all of the Organization Workspaces
     * will be retrieved.
     * <p>
     * Parameters:
     * @param params map of parameters for the query
     * limit [integer, default null]: maximum number of objects to be retrieved. Unlimited if null. ex: 35
     * username [string, default null]: query by the simplified name that defines the workspace URL. This name is always unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return generator of Workspace objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Workspace> query(Map<String, Object> params) throws Exception {
        return Workspace.query(params, null);
    }

    /**
     * Retrieve Workspaces
     * <p>
     * Receive a generator of Workspace objects previously created in the Stark Bank API.
     * If no filters are passed and the user is an Organization, all of the Organization Workspaces
     * will be retrieved.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return generator of Workspace objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Workspace> query(User user) throws Exception {
        return Workspace.query(new HashMap<>(), user);
    }

    /**
     * Retrieve Workspaces
     * <p>
     * Receive a generator of Workspace objects previously created in the Stark Bank API.
     * If no filters are passed and the user is an Organization, all of the Organization Workspaces
     * will be retrieved.
     * <p>
     * Return:
     * @return generator of Workspace objects with updated attributes
     * @throws Exception error in the request
     */
    public static Generator<Workspace> query() throws Exception {
        return Workspace.query(new HashMap<>(), null);
    }

    public final static class Page {
        public List<Workspace> workspaces;
        public String cursor;

        public Page(List<Workspace> workspaces, String cursor) {
            this.workspaces = workspaces;
            this.cursor = cursor;
        }
    }

    /**
     * Retrieve paged Workspaces
     * <p>
     * Receive a list of up to 100 Workspace objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * username [string, default null]: query by the simplified name that defines the workspace URL. This name is always unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * <p>
     * Return:
     * @return Workspace.Page object:
     * Workspace.Page.workspaces: list of Workspace objects with updated attributes
     * Workspace.Page.cursor: cursor to retrieve the next page of Workspace objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params) throws Exception {
        return Workspace.page(params, null);
    }

    /**
     * Retrieve paged Workspaces
     * <p>
     * Receive a list of up to 100 Workspace objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Workspace.Page object:
     * Workspace.Page.workspaces: list of Workspace objects with updated attributes
     * Workspace.Page.cursor: cursor to retrieve the next page of Workspace objects
     * @throws Exception error in the request
     */
    public static Page page(User user) throws Exception {
        return Workspace.page(new HashMap<>(), user);
    }

    /**
     * Retrieve paged Workspaces
     * <p>
     * Receive a list of up to 100 Workspace objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Return:
     * @return Workspace.Page object:
     * Workspace.Page.workspaces: list of Workspace objects with updated attributes
     * Workspace.Page.cursor: cursor to retrieve the next page of Workspace objects
     * @throws Exception error in the request
     */
    public static Page page() throws Exception {
        return Workspace.page(new HashMap<>(), null);
    }

    /**
     * Retrieve paged Workspaces
     * <p>
     * Receive a list of up to 100 Workspace objects previously created in the Stark Bank API and the cursor to the next page.
     * Use this function instead of query if you want to manually page your requests.
     * <p>
     * Parameters:
     * @param params parameters of the query
     * cursor [string, default null]: cursor returned on the previous page function call
     * limit [integer, default 100]: maximum number of objects to be retrieved. It must be an integer between 1 and 100. ex: 50
     * username [string, default null]: query by the simplified name that defines the workspace URL. This name is always unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * ids [list of strings, default null]: list of ids to filter retrieved objects. ex: ["5656565656565656", "4545454545454545"]
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Workspace.Page object:
     * Workspace.Page.workspaces: list of Workspace objects with updated attributes
     * Workspace.Page.cursor: cursor to retrieve the next page of Workspace objects
     * @throws Exception error in the request
     */
    public static Page page(Map<String, Object> params, User user) throws Exception {
        com.starkcore.utils.Page page = Rest.getPage(data, params, user);
        List<Workspace> workspaces = new ArrayList<>();
        for (SubResource workspace: page.entities) {
            workspaces.add((Workspace) workspace);
        }
        return new Page(workspaces, page.cursor);
    }

    /**
     * Create Workspace
     * <p>
     * Send a Workspace for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param workspaceData parameters for the creation of the workspace
     * username [string]: Simplified name to define the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * name [string]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings, default null]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * <p>
     * Return:
     * @return Workspace object with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace create(Map<String, Object> workspaceData) throws Exception {
        return Workspace.create(workspaceData, null);
    }

    /**
     * Create Workspace
     * <p>
     * Send a Workspace for creation in the Stark Bank API
     * <p>
     * Parameters:
     * @param workspaceData parameters for the creation of the workspace
     * username [string]: Simplified name to define the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbankworkspace"
     * name [string]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings, default null]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * @param user [Organization object, default null]: Organization object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return Workspace object with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace create(Map<String, Object> workspaceData, Organization user) throws Exception {
        return Rest.postSingle(data, new Workspace(workspaceData), user);
    }

    /**
     * Update Workspace entity
     * <p>
     * Update a Workspace by passing its ID.
     * <p>
     * Parameters:
     * @param id [string]: Workspace ID. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * pictureType [string]: picture MIME type. This parameter will be required if the picture parameter is informed ex: "image/png" or "image/jpeg"
     * username [string, default null]: Simplified name to define the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbank-workspace"
     * name [string, default null]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings, default null]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * status [string, default null]: current Workspace status. Options: "active" or "blocked"
     * picture [bytes, default null]: Binary buffer of the picture. ex: open("/path/to/file.png", "rb").read()
     * <p>
     * Return:
     * @return target Workspace with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace update(String id, Map<String, Object> patchData) throws Exception {
        return Workspace.update(id, patchData, null);
    }

    /**
     * Update Workspace entity
     * <p>
     * Update a Workspace by passing its ID.
     * <p>
     * Parameters:
     * @param id [string]: Workspace ID. ex: '5656565656565656'
     * @param patchData map of parameters to patch
     * pictureType [string]: picture MIME type. This parameter will be required if the picture parameter is informed ex: "image/png" or "image/jpeg"
     * username [string, default null]: Simplified name to define the workspace URL. This name must be unique across all Stark Bank Workspaces. ex: "starkbank-workspace"
     * name [string, default null]: Full name that identifies the Workspace. This name will appear when people access the Workspace on our platform, for example. ex: "Stark Bank Workspace"
     * allowedTaxIds [list of strings, default null]: list of tax IDs that will be allowed to send Deposits to this Workspace. If empty, all are allowed. ex: ["012.345.678-90", "20.018.183/0001-80"]
     * status [string, default null]: current Workspace status. Options: "active" or "blocked"
     * picture [bytes, default null]: Binary buffer of the picture. ex: open("/path/to/file.png", "rb").read()
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return target Workspace with updated attributes
     * @throws Exception error in the request
     */
    public static Workspace update(String id, Map<String, Object> patchData, User user) throws Exception {
        return Rest.patch(data, id, patchData, user);
    }
}

