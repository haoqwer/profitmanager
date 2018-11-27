package com.chenyou.pojo;

public class GameSubContract {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.id
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.channel_id
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private String channelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.new_add
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private Integer newAdd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.message_fee
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private Integer messageFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.AccountCleark
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private Double accountcleark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_game_subcontract.record_time
     *
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    private String recordTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.id
     *
     * @return the value of t_game_subcontract.id
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.id
     *
     * @param id the value for t_game_subcontract.id
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.channel_id
     *
     * @return the value of t_game_subcontract.channel_id
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.channel_id
     *
     * @param channelId the value for t_game_subcontract.channel_id
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.new_add
     *
     * @return the value of t_game_subcontract.new_add
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public Integer getNewAdd() {
        return newAdd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.new_add
     *
     * @param newAdd the value for t_game_subcontract.new_add
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setNewAdd(Integer newAdd) {
        this.newAdd = newAdd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.message_fee
     *
     * @return the value of t_game_subcontract.message_fee
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public Integer getMessageFee() {
        return messageFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.message_fee
     *
     * @param messageFee the value for t_game_subcontract.message_fee
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setMessageFee(Integer messageFee) {
        this.messageFee = messageFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.AccountCleark
     *
     * @return the value of t_game_subcontract.AccountCleark
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public Double getAccountcleark() {
        return accountcleark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.AccountCleark
     *
     * @param accountcleark the value for t_game_subcontract.AccountCleark
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setAccountcleark(Double accountcleark) {
        this.accountcleark = accountcleark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_game_subcontract.record_time
     *
     * @return the value of t_game_subcontract.record_time
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public String getRecordTime() {
        return recordTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_game_subcontract.record_time
     *
     * @param recordTime the value for t_game_subcontract.record_time
     * @mbggenerated Mon Nov 26 16:57:43 CST 2018
     */
    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "GameSubContract{" + "id=" + id + ", channelId='" + channelId + '\'' + ", newAdd=" + newAdd + ", messageFee=" + messageFee + ", accountcleark=" + accountcleark + ", recordTime='" + recordTime + '\'' + '}';
    }
}