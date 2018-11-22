package com.chenyou.pojo;

import java.util.Date;

public class BizGame {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.id
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.code
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.name
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.publisher
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private String publisher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.created
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column biz_game.modified
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    private Date modified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.id
     *
     * @return the value of biz_game.id
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.id
     *
     * @param id the value for biz_game.id
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.code
     *
     * @return the value of biz_game.code
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.code
     *
     * @param code the value for biz_game.code
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.name
     *
     * @return the value of biz_game.name
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.name
     *
     * @param name the value for biz_game.name
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.publisher
     *
     * @return the value of biz_game.publisher
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.publisher
     *
     * @param publisher the value for biz_game.publisher
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.created
     *
     * @return the value of biz_game.created
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.created
     *
     * @param created the value for biz_game.created
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column biz_game.modified
     *
     * @return the value of biz_game.modified
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column biz_game.modified
     *
     * @param modified the value for biz_game.modified
     *
     * @mbggenerated Thu Nov 22 14:14:24 CST 2018
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "BizGame{" + "id=" + id + ", code='" + code + '\'' + ", name='" + name + '\'' + ", publisher='" + publisher + '\'' + ", created=" + created + ", modified=" + modified + '}';
    }
}