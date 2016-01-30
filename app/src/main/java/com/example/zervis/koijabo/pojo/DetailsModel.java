package com.example.zervis.koijabo.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsModel {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("IsOpenNow")
    @Expose
    private Boolean IsOpenNow;
    @SerializedName("Distance")
    @Expose
    private Integer Distance;
    @SerializedName("CostPerPerson")
    @Expose
    private Object CostPerPerson;
    @SerializedName("CostRating")
    @Expose
    private Integer CostRating;
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Area")
    @Expose
    private String Area;
    @SerializedName("Address")
    @Expose
    private String Address;
    @SerializedName("GeoPoint")
    @Expose
    private com.example.zervis.koijabo.pojo.GeoPoint GeoPoint;
    @SerializedName("TitleImageUrl")
    @Expose
    private String TitleImageUrl;
    @SerializedName("TimeTable")
    @Expose
    private List<com.example.zervis.koijabo.pojo.TimeTable> TimeTable = new ArrayList<com.example.zervis.koijabo.pojo.TimeTable>();
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
    @SerializedName("PhoneNumber")
    @Expose
    private String PhoneNumber;
    @SerializedName("CostUpperLimit")
    @Expose
    private Integer CostUpperLimit;
    @SerializedName("CostLowerLimit")
    @Expose
    private Integer CostLowerLimit;
    @SerializedName("CreditCards")
    @Expose
    private List<String> CreditCards = new ArrayList<String>();
    @SerializedName("GoodFor")
    @Expose
    private List<String> GoodFor = new ArrayList<String>();
    @SerializedName("Cuisines")
    @Expose
    private List<String> Cuisines = new ArrayList<String>();
    @SerializedName("EstablishmentType")
    @Expose
    private List<String> EstablishmentType = new ArrayList<String>();
    @SerializedName("Parking")
    @Expose
    private String Parking;
    @SerializedName("Attire")
    @Expose
    private String Attire;
    @SerializedName("NoiseLevel")
    @Expose
    private String NoiseLevel;
    @SerializedName("Rooftop")
    @Expose
    private Boolean Rooftop;
    @SerializedName("Reservation")
    @Expose
    private Boolean Reservation;
    @SerializedName("Delivery")
    @Expose
    private Boolean Delivery;
    @SerializedName("TakeOut")
    @Expose
    private Boolean TakeOut;
    @SerializedName("OutDoor")
    @Expose
    private Boolean OutDoor;
    @SerializedName("Wifi")
    @Expose
    private Boolean Wifi;
    @SerializedName("Tv")
    @Expose
    private Boolean Tv;
    @SerializedName("CandleLight")
    @Expose
    private Boolean CandleLight;
    @SerializedName("LuxuryDining")
    @Expose
    private Boolean LuxuryDining;
    @SerializedName("Washroom")
    @Expose
    private Boolean Washroom;
    @SerializedName("Toilet")
    @Expose
    private Boolean Toilet;

    /**
     *
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     *     The IsOpenNow
     */
    public Boolean getIsOpenNow() {
        return IsOpenNow;
    }

    /**
     *
     * @param IsOpenNow
     *     The IsOpenNow
     */
    public void setIsOpenNow(Boolean IsOpenNow) {
        this.IsOpenNow = IsOpenNow;
    }

    /**
     *
     * @return
     *     The Distance
     */
    public Integer getDistance() {
        return Distance;
    }

    /**
     *
     * @param Distance
     *     The Distance
     */
    public void setDistance(Integer Distance) {
        this.Distance = Distance;
    }

    /**
     *
     * @return
     *     The CostPerPerson
     */
    public Object getCostPerPerson() {
        return CostPerPerson;
    }

    /**
     *
     * @param CostPerPerson
     *     The CostPerPerson
     */
    public void setCostPerPerson(Object CostPerPerson) {
        this.CostPerPerson = CostPerPerson;
    }

    /**
     *
     * @return
     *     The CostRating
     */
    public Integer getCostRating() {
        return CostRating;
    }

    /**
     *
     * @param CostRating
     *     The CostRating
     */
    public void setCostRating(Integer CostRating) {
        this.CostRating = CostRating;
    }

    /**
     *
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     *     The Area
     */
    public String getArea() {
        return Area;
    }

    /**
     *
     * @param Area
     *     The Area
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     *
     * @return
     *     The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     *     The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     *     The GeoPoint
     */
    public com.example.zervis.koijabo.pojo.GeoPoint getGeoPoint() {
        return GeoPoint;
    }

    /**
     *
     * @param GeoPoint
     *     The GeoPoint
     */
    public void setGeoPoint(com.example.zervis.koijabo.pojo.GeoPoint GeoPoint) {
        this.GeoPoint = GeoPoint;
    }

    /**
     *
     * @return
     *     The TitleImageUrl
     */
    public String getTitleImageUrl() {
        return TitleImageUrl;
    }

    /**
     *
     * @param TitleImageUrl
     *     The TitleImageUrl
     */
    public void setTitleImageUrl(String TitleImageUrl) {
        this.TitleImageUrl = TitleImageUrl;
    }

    /**
     *
     * @return
     *     The TimeTable
     */
    public List<com.example.zervis.koijabo.pojo.TimeTable> getTimeTable() {
        return TimeTable;
    }

    /**
     *
     * @param TimeTable
     *     The TimeTable
     */
    public void setTimeTable(List<com.example.zervis.koijabo.pojo.TimeTable> TimeTable) {
        this.TimeTable = TimeTable;
    }

    /**
     *
     * @return
     *     The GeneralRatingRating
     */
    public Integer getGeneralRatingRating() {
        return GeneralRatingRating;
    }

    /**
     *
     * @param GeneralRatingRating
     *     The GeneralRatingRating
     */
    public void setGeneralRatingRating(Integer GeneralRatingRating) {
        this.GeneralRatingRating = GeneralRatingRating;
    }

    /**
     *
     * @return
     *     The AmbienceRating
     */
    public Integer getAmbienceRating() {
        return AmbienceRating;
    }

    /**
     *
     * @param AmbienceRating
     *     The AmbienceRating
     */
    public void setAmbienceRating(Integer AmbienceRating) {
        this.AmbienceRating = AmbienceRating;
    }

    /**
     *
     * @return
     *     The ServiceRating
     */
    public Integer getServiceRating() {
        return ServiceRating;
    }

    /**
     *
     * @param ServiceRating
     *     The ServiceRating
     */
    public void setServiceRating(Integer ServiceRating) {
        this.ServiceRating = ServiceRating;
    }

    /**
     *
     * @return
     *     The FoodRating
     */
    public Integer getFoodRating() {
        return FoodRating;
    }

    /**
     *
     * @param FoodRating
     *     The FoodRating
     */
    public void setFoodRating(Integer FoodRating) {
        this.FoodRating = FoodRating;
    }

    /**
     *
     * @return
     *     The PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     *
     * @param PhoneNumber
     *     The PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     *
     * @return
     *     The CostUpperLimit
     */
    public Integer getCostUpperLimit() {
        return CostUpperLimit;
    }

    /**
     *
     * @param CostUpperLimit
     *     The CostUpperLimit
     */
    public void setCostUpperLimit(Integer CostUpperLimit) {
        this.CostUpperLimit = CostUpperLimit;
    }

    /**
     *
     * @return
     *     The CostLowerLimit
     */
    public Integer getCostLowerLimit() {
        return CostLowerLimit;
    }

    /**
     *
     * @param CostLowerLimit
     *     The CostLowerLimit
     */
    public void setCostLowerLimit(Integer CostLowerLimit) {
        this.CostLowerLimit = CostLowerLimit;
    }

    /**
     *
     * @return
     *     The CreditCards
     */
    public List<String> getCreditCards() {
        return CreditCards;
    }

    /**
     *
     * @param CreditCards
     *     The CreditCards
     */
    public void setCreditCards(List<String> CreditCards) {
        this.CreditCards = CreditCards;
    }

    /**
     *
     * @return
     *     The GoodFor
     */
    public List<String> getGoodFor() {
        return GoodFor;
    }

    /**
     *
     * @param GoodFor
     *     The GoodFor
     */
    public void setGoodFor(List<String> GoodFor) {
        this.GoodFor = GoodFor;
    }

    /**
     *
     * @return
     *     The Cuisines
     */
    public List<String> getCuisines() {
        return Cuisines;
    }

    /**
     *
     * @param Cuisines
     *     The Cuisines
     */
    public void setCuisines(List<String> Cuisines) {
        this.Cuisines = Cuisines;
    }

    /**
     *
     * @return
     *     The EstablishmentType
     */
    public List<String> getEstablishmentType() {
        return EstablishmentType;
    }

    /**
     *
     * @param EstablishmentType
     *     The EstablishmentType
     */
    public void setEstablishmentType(List<String> EstablishmentType) {
        this.EstablishmentType = EstablishmentType;
    }

    /**
     *
     * @return
     *     The Parking
     */
    public String getParking() {
        return Parking;
    }

    /**
     *
     * @param Parking
     *     The Parking
     */
    public void setParking(String Parking) {
        this.Parking = Parking;
    }

    /**
     *
     * @return
     *     The Attire
     */
    public String getAttire() {
        return Attire;
    }

    /**
     *
     * @param Attire
     *     The Attire
     */
    public void setAttire(String Attire) {
        this.Attire = Attire;
    }

    /**
     *
     * @return
     *     The NoiseLevel
     */
    public String getNoiseLevel() {
        return NoiseLevel;
    }

    /**
     *
     * @param NoiseLevel
     *     The NoiseLevel
     */
    public void setNoiseLevel(String NoiseLevel) {
        this.NoiseLevel = NoiseLevel;
    }

    /**
     *
     * @return
     *     The Rooftop
     */
    public Boolean getRooftop() {
        return Rooftop;
    }

    /**
     *
     * @param Rooftop
     *     The Rooftop
     */
    public void setRooftop(Boolean Rooftop) {
        this.Rooftop = Rooftop;
    }

    /**
     *
     * @return
     *     The Reservation
     */
    public Boolean getReservation() {
        return Reservation;
    }

    /**
     *
     * @param Reservation
     *     The Reservation
     */
    public void setReservation(Boolean Reservation) {
        this.Reservation = Reservation;
    }

    /**
     *
     * @return
     *     The Delivery
     */
    public Boolean getDelivery() {
        return Delivery;
    }

    /**
     *
     * @param Delivery
     *     The Delivery
     */
    public void setDelivery(Boolean Delivery) {
        this.Delivery = Delivery;
    }

    /**
     *
     * @return
     *     The TakeOut
     */
    public Boolean getTakeOut() {
        return TakeOut;
    }

    /**
     *
     * @param TakeOut
     *     The TakeOut
     */
    public void setTakeOut(Boolean TakeOut) {
        this.TakeOut = TakeOut;
    }

    /**
     *
     * @return
     *     The OutDoor
     */
    public Boolean getOutDoor() {
        return OutDoor;
    }

    /**
     *
     * @param OutDoor
     *     The OutDoor
     */
    public void setOutDoor(Boolean OutDoor) {
        this.OutDoor = OutDoor;
    }

    /**
     *
     * @return
     *     The Wifi
     */
    public Boolean getWifi() {
        return Wifi;
    }

    /**
     *
     * @param Wifi
     *     The Wifi
     */
    public void setWifi(Boolean Wifi) {
        this.Wifi = Wifi;
    }

    /**
     *
     * @return
     *     The Tv
     */
    public Boolean getTv() {
        return Tv;
    }

    /**
     *
     * @param Tv
     *     The Tv
     */
    public void setTv(Boolean Tv) {
        this.Tv = Tv;
    }

    /**
     *
     * @return
     *     The CandleLight
     */
    public Boolean getCandleLight() {
        return CandleLight;
    }

    /**
     *
     * @param CandleLight
     *     The CandleLight
     */
    public void setCandleLight(Boolean CandleLight) {
        this.CandleLight = CandleLight;
    }

    /**
     *
     * @return
     *     The LuxuryDining
     */
    public Boolean getLuxuryDining() {
        return LuxuryDining;
    }

    /**
     *
     * @param LuxuryDining
     *     The LuxuryDining
     */
    public void setLuxuryDining(Boolean LuxuryDining) {
        this.LuxuryDining = LuxuryDining;
    }

    /**
     *
     * @return
     *     The Washroom
     */
    public Boolean getWashroom() {
        return Washroom;
    }

    /**
     *
     * @param Washroom
     *     The Washroom
     */
    public void setWashroom(Boolean Washroom) {
        this.Washroom = Washroom;
    }

    /**
     *
     * @return
     *     The Toilet
     */
    public Boolean getToilet() {
        return Toilet;
    }

    /**
     *
     * @param Toilet
     *     The Toilet
     */
    public void setToilet(Boolean Toilet) {
        this.Toilet = Toilet;
    }

}
