package com.chenyou.pojo;

import java.util.ArrayList;
import java.util.List;

public class GameSubContractExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public GameSubContractExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andAddIsNull() {
            addCriterion("add is null");
            return (Criteria) this;
        }

        public Criteria andAddIsNotNull() {
            addCriterion("add is not null");
            return (Criteria) this;
        }

        public Criteria andAddEqualTo(Integer value) {
            addCriterion("add =", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddNotEqualTo(Integer value) {
            addCriterion("add <>", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddGreaterThan(Integer value) {
            addCriterion("add >", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("add >=", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddLessThan(Integer value) {
            addCriterion("add <", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddLessThanOrEqualTo(Integer value) {
            addCriterion("add <=", value, "add");
            return (Criteria) this;
        }

        public Criteria andAddIn(List<Integer> values) {
            addCriterion("add in", values, "add");
            return (Criteria) this;
        }

        public Criteria andAddNotIn(List<Integer> values) {
            addCriterion("add not in", values, "add");
            return (Criteria) this;
        }

        public Criteria andAddBetween(Integer value1, Integer value2) {
            addCriterion("add between", value1, value2, "add");
            return (Criteria) this;
        }

        public Criteria andAddNotBetween(Integer value1, Integer value2) {
            addCriterion("add not between", value1, value2, "add");
            return (Criteria) this;
        }

        public Criteria andMessageFeeIsNull() {
            addCriterion("message_fee is null");
            return (Criteria) this;
        }

        public Criteria andMessageFeeIsNotNull() {
            addCriterion("message_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMessageFeeEqualTo(Integer value) {
            addCriterion("message_fee =", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeNotEqualTo(Integer value) {
            addCriterion("message_fee <>", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeGreaterThan(Integer value) {
            addCriterion("message_fee >", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_fee >=", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeLessThan(Integer value) {
            addCriterion("message_fee <", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeLessThanOrEqualTo(Integer value) {
            addCriterion("message_fee <=", value, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeIn(List<Integer> values) {
            addCriterion("message_fee in", values, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeNotIn(List<Integer> values) {
            addCriterion("message_fee not in", values, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeBetween(Integer value1, Integer value2) {
            addCriterion("message_fee between", value1, value2, "messageFee");
            return (Criteria) this;
        }

        public Criteria andMessageFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("message_fee not between", value1, value2, "messageFee");
            return (Criteria) this;
        }

        public Criteria andAccountclearkIsNull() {
            addCriterion("AccountCleark is null");
            return (Criteria) this;
        }

        public Criteria andAccountclearkIsNotNull() {
            addCriterion("AccountCleark is not null");
            return (Criteria) this;
        }

        public Criteria andAccountclearkEqualTo(Integer value) {
            addCriterion("AccountCleark =", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkNotEqualTo(Integer value) {
            addCriterion("AccountCleark <>", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkGreaterThan(Integer value) {
            addCriterion("AccountCleark >", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkGreaterThanOrEqualTo(Integer value) {
            addCriterion("AccountCleark >=", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkLessThan(Integer value) {
            addCriterion("AccountCleark <", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkLessThanOrEqualTo(Integer value) {
            addCriterion("AccountCleark <=", value, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkIn(List<Integer> values) {
            addCriterion("AccountCleark in", values, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkNotIn(List<Integer> values) {
            addCriterion("AccountCleark not in", values, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkBetween(Integer value1, Integer value2) {
            addCriterion("AccountCleark between", value1, value2, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andAccountclearkNotBetween(Integer value1, Integer value2) {
            addCriterion("AccountCleark not between", value1, value2, "accountcleark");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(String value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(String value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(String value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(String value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(String value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(String value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLike(String value) {
            addCriterion("record_time like", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotLike(String value) {
            addCriterion("record_time not like", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<String> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<String> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(String value1, String value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(String value1, String value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_game_subcontract
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 22 20:36:59 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_game_subcontract
     *
     * @mbggenerated Thu Nov 22 20:36:59 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}