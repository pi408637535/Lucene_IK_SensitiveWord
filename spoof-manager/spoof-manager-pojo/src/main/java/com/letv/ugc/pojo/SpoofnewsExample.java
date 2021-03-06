package com.letv.ugc.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpoofnewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpoofnewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNull() {
            addCriterion("is_parent is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("is_parent is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(Integer value) {
            addCriterion("is_parent =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(Integer value) {
            addCriterion("is_parent <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(Integer value) {
            addCriterion("is_parent >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_parent >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(Integer value) {
            addCriterion("is_parent <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(Integer value) {
            addCriterion("is_parent <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<Integer> values) {
            addCriterion("is_parent in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            addCriterion("is_parent not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(Integer value1, Integer value2) {
            addCriterion("is_parent between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_parent not between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageUrl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageUrl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageUrl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageUrl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageUrl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageUrl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageUrl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageUrl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageUrl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageUrl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageUrl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageUrl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageUrl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTargeturlIsNull() {
            addCriterion("targetUrl is null");
            return (Criteria) this;
        }

        public Criteria andTargeturlIsNotNull() {
            addCriterion("targetUrl is not null");
            return (Criteria) this;
        }

        public Criteria andTargeturlEqualTo(String value) {
            addCriterion("targetUrl =", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlNotEqualTo(String value) {
            addCriterion("targetUrl <>", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlGreaterThan(String value) {
            addCriterion("targetUrl >", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlGreaterThanOrEqualTo(String value) {
            addCriterion("targetUrl >=", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlLessThan(String value) {
            addCriterion("targetUrl <", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlLessThanOrEqualTo(String value) {
            addCriterion("targetUrl <=", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlLike(String value) {
            addCriterion("targetUrl like", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlNotLike(String value) {
            addCriterion("targetUrl not like", value, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlIn(List<String> values) {
            addCriterion("targetUrl in", values, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlNotIn(List<String> values) {
            addCriterion("targetUrl not in", values, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlBetween(String value1, String value2) {
            addCriterion("targetUrl between", value1, value2, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargeturlNotBetween(String value1, String value2) {
            addCriterion("targetUrl not between", value1, value2, "targeturl");
            return (Criteria) this;
        }

        public Criteria andTargetcontentIsNull() {
            addCriterion("targetContent is null");
            return (Criteria) this;
        }

        public Criteria andTargetcontentIsNotNull() {
            addCriterion("targetContent is not null");
            return (Criteria) this;
        }

        public Criteria andTargetcontentEqualTo(String value) {
            addCriterion("targetContent =", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentNotEqualTo(String value) {
            addCriterion("targetContent <>", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentGreaterThan(String value) {
            addCriterion("targetContent >", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentGreaterThanOrEqualTo(String value) {
            addCriterion("targetContent >=", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentLessThan(String value) {
            addCriterion("targetContent <", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentLessThanOrEqualTo(String value) {
            addCriterion("targetContent <=", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentLike(String value) {
            addCriterion("targetContent like", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentNotLike(String value) {
            addCriterion("targetContent not like", value, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentIn(List<String> values) {
            addCriterion("targetContent in", values, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentNotIn(List<String> values) {
            addCriterion("targetContent not in", values, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentBetween(String value1, String value2) {
            addCriterion("targetContent between", value1, value2, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andTargetcontentNotBetween(String value1, String value2) {
            addCriterion("targetContent not between", value1, value2, "targetcontent");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryIsNull() {
            addCriterion("targetSummary is null");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryIsNotNull() {
            addCriterion("targetSummary is not null");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryEqualTo(String value) {
            addCriterion("targetSummary =", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryNotEqualTo(String value) {
            addCriterion("targetSummary <>", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryGreaterThan(String value) {
            addCriterion("targetSummary >", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryGreaterThanOrEqualTo(String value) {
            addCriterion("targetSummary >=", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryLessThan(String value) {
            addCriterion("targetSummary <", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryLessThanOrEqualTo(String value) {
            addCriterion("targetSummary <=", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryLike(String value) {
            addCriterion("targetSummary like", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryNotLike(String value) {
            addCriterion("targetSummary not like", value, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryIn(List<String> values) {
            addCriterion("targetSummary in", values, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryNotIn(List<String> values) {
            addCriterion("targetSummary not in", values, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryBetween(String value1, String value2) {
            addCriterion("targetSummary between", value1, value2, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andTargetsummaryNotBetween(String value1, String value2) {
            addCriterion("targetSummary not between", value1, value2, "targetsummary");
            return (Criteria) this;
        }

        public Criteria andParentTitileIsNull() {
            addCriterion("parent_titile is null");
            return (Criteria) this;
        }

        public Criteria andParentTitileIsNotNull() {
            addCriterion("parent_titile is not null");
            return (Criteria) this;
        }

        public Criteria andParentTitileEqualTo(String value) {
            addCriterion("parent_titile =", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileNotEqualTo(String value) {
            addCriterion("parent_titile <>", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileGreaterThan(String value) {
            addCriterion("parent_titile >", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileGreaterThanOrEqualTo(String value) {
            addCriterion("parent_titile >=", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileLessThan(String value) {
            addCriterion("parent_titile <", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileLessThanOrEqualTo(String value) {
            addCriterion("parent_titile <=", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileLike(String value) {
            addCriterion("parent_titile like", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileNotLike(String value) {
            addCriterion("parent_titile not like", value, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileIn(List<String> values) {
            addCriterion("parent_titile in", values, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileNotIn(List<String> values) {
            addCriterion("parent_titile not in", values, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileBetween(String value1, String value2) {
            addCriterion("parent_titile between", value1, value2, "parentTitile");
            return (Criteria) this;
        }

        public Criteria andParentTitileNotBetween(String value1, String value2) {
            addCriterion("parent_titile not between", value1, value2, "parentTitile");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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