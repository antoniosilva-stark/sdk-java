package com.starkbank;

import com.starkbank.utils.Resource;
import com.starkbank.utils.Rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PaymentPreview extends Resource {
    /**
     * PaymentPreview object
     * <p>
     * A PaymentPreview is used to get information from a payment code before confirming the payment. This resource can be used to preview BR Codes and bar codes of boleto, tax and utility payments
     * <p>
     * Parameters:
     * id [string]: Main identification of the payment. This should be the BR Code for Pix payments and lines or bar codes for payment slips. ex: "34191.09008 63571.277308 71444.640008 5 81960000000062", "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * scheduled [string]: intended payment date. Right now, this parameter only has effect on BrcodePreviews. ex: "2020-03-10"
     * type [string]: Payment type. ex: "brcode-payment", "boleto-payment", "utility-payment" or "tax-payment"
     * payment [string]: Information preview of the informed payment.
     */
    static ClassData data = new ClassData(PaymentPreview.class, "PaymentPreview");

    public String scheduled;
    public String type;
    public Object payment;


    /**
     * PaymentPreview object
     * <p>
     * A PaymentPreview is used to get information from a payment code before confirming the payment. This resource can be used to preview BR Codes and bar codes of boleto, tax and utility payments
     * <p>
     * Parameters:
     * @param id [string]: Main identification of the payment. This should be the BR Code for Pix payments and lines or bar codes for payment slips. ex: "34191.09008 63571.277308 71444.640008 5 81960000000062", "00020126580014br.gov.bcb.pix0136a629532e-7693-4846-852d-1bbff817b5a8520400005303986540510.005802BR5908T'Challa6009Sao Paulo62090505123456304B14A"
     * @param scheduled [string]: intended payment date. Right now, this parameter only has effect on BrcodePreviews. ex: "2020-03-10"
     * @param type [string]: Payment type. ex: "brcode-payment", "boleto-payment", "utility-payment" or "tax-payment"
     * @param payment [string]: Information preview of the informed payment.
     */
    public PaymentPreview(String id, String scheduled, String type, String payment) {
        super(id);
        this.scheduled = scheduled;
        this.type = type;
        this.payment = payment;
    }

    /**
     * PaymentPreview object
     * <p>
     * A PaymentPreview is used to get information from a payment code before confirming the payment. This resource can be used to preview BR Codes and bar codes of boleto, tax and utility payments
     * <p>
     * Parameters:
     * @param data map of properties for the creation of the PaymentPreview
     * scheduled [string]: intended payment date. Right now, this parameter only has effect on BrcodePreviews. ex: "2020-03-10"
     * <p>
     * Attributes (return-only):
     * type [string]: Payment type. ex: "brcode-payment", "boleto-payment", "utility-payment" or "tax-payment"
     * payment [string]: Information preview of the informed payment.
     * @throws Exception error in the request
     */
    public PaymentPreview(Map<String, Object> data) throws Exception {
        super(null);
        HashMap<String, Object> dataCopy = new HashMap<>(data);
        this.scheduled = (String) dataCopy.remove("scheduled");
        this.type = null;
        this.payment = null;

        if (!dataCopy.isEmpty()) {
            throw new Exception("Unknown parameters used in constructor: [" + String.join(", ", dataCopy.keySet()) + "]");
        }
    }

    public PaymentPreview() {
        super(null);
    }

    /**
     * Create PaymentPreviews
     * <p>
     * Send a list of PaymentPreviews objects for processing in the Stark Bank API
     * <p>
     * Parameters:
     * @param previews [list of PaymentPreview objects or HashMaps]: list of PaymentPreviews objects to be created in the API
     * <p>
     * Return:
     * @return list of PaymentPreviews objects with updated attributes
     * @throws Exception error in the request
     */
    public static List<?> create(List<?> previews) throws Exception {
        return PaymentPreview.create(previews, null);
    }

    /**
     * Create PaymentPreviews
     * <p>
     * Send a list of PaymentPreviews objects for processing in the Stark Bank API
     * <p>
     * Parameters:
     * @param previews [list of PaymentPreview objects or HashMaps]: list of PaymentPreviews objects to be created in the API
     * @param user [Organization/Project object, default null]: Organization or Project object. Not necessary if starkbank.Settings.user was set before function call
     * <p>
     * Return:
     * @return list of PaymentPreviews objects with updated attributes
     * @throws Exception error in the request
     */
    @SuppressWarnings("unchecked")
    public static List<?> create(List<?> previews, User user) throws Exception {
        List<PaymentPreview> paymentPreviewList = new ArrayList<>();
        for (Object paymentPreview : previews) {
            if (paymentPreview instanceof Map) {
                paymentPreviewList.add(new PaymentPreview((Map<String, Object>) paymentPreview));
                continue;
            }
            if (paymentPreview instanceof PaymentPreview) {
                paymentPreviewList.add((PaymentPreview) paymentPreview);
                continue;
            }
            throw new Exception("Unknown type \"" + paymentPreview.getClass() + "\", use PaymentPreview or HashMap");
        }
        return Rest.post(data, paymentPreviewList, user);
    }
}

