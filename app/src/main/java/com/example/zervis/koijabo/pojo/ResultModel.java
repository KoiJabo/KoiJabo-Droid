package com.example.zervis.koijabo.pojo;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Zarvis on 09/02/2016.
 */
public class ResultModel {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("IsOpenNow")
    @Expose
    private Boolean IsOpenNow;
    @SerializedName("Distance")
    @Expose
    private Integer Distance;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Area")
    @Expose
    private String Area;
    @SerializedName("TitleImageUrl")
    @Expose
    private String TitleImageUrl;
    @SerializedName("Cuisines")
    @Expose
    private List<String> Cuisines = new ArrayList<String>();
    @SerializedName("GeneralRatingRating")
    @Expose
    private Integer GeneralRatingRating;
    @SerializedName("AmbienceRating")
    @Expose
    private Integer AmbienceRating;
    @SerializedName("ServiceRating")
    @Expose
    private Integer ServiceRating;
    @SerializedName("FoodRating")
    @Expose
    private Integer FoodRating;
    @SerializedName("CostRating")
    @Expose
    private Integer CostRating;

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
     * The IsOpenNow
     */
    public Boolean getIsOpenNow() {
        return IsOpenNow;
    }

    /**
     *
     * @param IsOpenNow
     * The IsOpenNow
     */
    public void setIsOpenNow(Boolean IsOpenNow) {
        this.IsOpenNow = IsOpenNow;
    }

    /**
     *
     * @return
     * The Distance
     */
    public Integer getDistance() {
        return Distance;
    }

    /**
     *
     * @param Distance
     * The Distance
     */
    public void setDistance(Integer Distance) {
        this.Distance = Distance;
    }

    /**
     *
     * @return
     * The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     * The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     * The Area
     */
    public String getArea() {
        return Area;
    }

    /**
     *
     * @param Area
     * The Area
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     *
     * @return
     * The TitleImageUrl
     */
    public String getTitleImageUrl() {
        return TitleImageUrl;
    }

    /**
     *
     * @param TitleImageUrl
     * The TitleImageUrl
     */
    public void setTitleImageUrl(String TitleImageUrl) {
        this.TitleImageUrl = TitleImageUrl;
    }

    /**
     *
     * @return
     * The Cuisines
     */
    public List<String> getCuisines() {
        return Cuisines;
    }

    /**
     *
     * @param Cuisines
     * The Cuisines
     */
    public void setCuisines(List<String> Cuisines) {
        this.Cuisines = Cuisines;
    }

    /**
     *
     * @return
     * The GeneralRatingRating
     */
    public Integer getGeneralRatingRating() {
        return GeneralRatingRating;
    }

    /**
     *
     * @param GeneralRatingRating
     * The GeneralRatingRating
     */
    public void setGeneralRatingRating(Integer GeneralRatingRating) {
        this.GeneralRatingRating = GeneralRatingRating;
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
     * The CostRating
     */
    public Integer getCostRating() {
        return CostRating;
    }

    /**
     *
     * @param CostRating
     * The CostRating
     */
    public void setCostRating(Integer CostRating) {
        this.CostRating = CostRating;
    }

}
