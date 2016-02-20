package com.example.zervis.koijabo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zarvis on 16/02/2016.
 */
public class Review {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("FoodRating")
    @Expose
    private Integer FoodRating;
    @SerializedName("ServiceRating")
    @Expose
    private Integer ServiceRating;
    @SerializedName("AmbienceRating")
    @Expose
    private Integer AmbienceRating;
    @SerializedName("CleanlinesRating")
    @Expose
    private Integer CleanlinesRating;
    @SerializedName("OverAllRating")
    @Expose
    private Integer OverAllRating;
    @SerializedName("TextReview")
    @Expose
    private String TextReview;
    @SerializedName("Tips")
    @Expose
    private String Tips;
    @SerializedName("Verified")
    @Expose
    private Boolean Verified;
    @SerializedName("UserId")
    @Expose
    private String UserId;
    @SerializedName("RestaurantId")
    @Expose
    private String RestaurantId;

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The FoodRating
     */
    public Integer getFoodRating() {
        return FoodRating;
    }

    /**
     *
     * @param FoodRating
     * The FoodRating
     */
    public void setFoodRating(Integer FoodRating) {
        this.FoodRating = FoodRating;
    }

    /**
     *
     * @return
     * The ServiceRating
     */
    public Integer getServiceRating() {
        return ServiceRating;
    }

    /**
     *
     * @param ServiceRating
     * The ServiceRating
     */
    public void setServiceRating(Integer ServiceRating) {
        this.ServiceRating = ServiceRating;
    }

    /**
     *
     * @return
     * The AmbienceRating
     */
    public Integer getAmbienceRating() {
        return AmbienceRating;
    }

    /**
     *
     * @param AmbienceRating
     * The AmbienceRating
     */
    public void setAmbienceRating(Integer AmbienceRating) {
        this.AmbienceRating = AmbienceRating;
    }

    /**
     *
     * @return
     * The CleanlinesRating
     */
    public Integer getCleanlinesRating() {
        return CleanlinesRating;
    }

    /**
     *
     * @param CleanlinesRating
     * The CleanlinesRating
     */
    public void setCleanlinesRating(Integer CleanlinesRating) {
        this.CleanlinesRating = CleanlinesRating;
    }

    /**
     *
     * @return
     * The OverAllRating
     */
    public Integer getOverAllRating() {
        return OverAllRating;
    }

    /**
     *
     * @param OverAllRating
     * The OverAllRating
     */
    public void setOverAllRating(Integer OverAllRating) {
        this.OverAllRating = OverAllRating;
    }

    /**
     *
     * @return
     * The TextReview
     */
    public String getTextReview() {
        return TextReview;
    }

    /**
     *
     * @param TextReview
     * The TextReview
     */
    public void setTextReview(String TextReview) {
        this.TextReview = TextReview;
    }

    /**
     *
     * @return
     * The Tips
     */
    public String getTips() {
        return Tips;
    }

    /**
     *
     * @param Tips
     * The Tips
     */
    public void setTips(String Tips) {
        this.Tips = Tips;
    }

    /**
     *
     * @return
     * The Verified
     */
    public Boolean getVerified() {
        return Verified;
    }

    /**
     *
     * @param Verified
     * The Verified
     */
    public void setVerified(Boolean Verified) {
        this.Verified = Verified;
    }

    /**
     *
     * @return
     * The UserId
     */
    public String getUserId() {
        return UserId;
    }

    /**
     *
     * @param UserId
     * The UserId
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    /**
     *
     * @return
     * The RestaurantId
     */
    public String getRestaurantId() {
        return RestaurantId;
    }

    /**
     *
     * @param RestaurantId
     * The RestaurantId
     */
    public void setRestaurantId(String RestaurantId) {
        this.RestaurantId = RestaurantId;
    }
}
