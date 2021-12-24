package com.jether.wirentiuserapp.Model;

public class ModelReview {

    public ModelReview() {
    }

    String UserRemark,PostingDate,FullName;

    public ModelReview(String userRemark, String postingDate, String fullName) {

        UserRemark = userRemark;
        PostingDate = postingDate;
        FullName = fullName;
    }

    public String getUserRemark() {
        return UserRemark;
    }

    public void setUserRemark(String userRemark) {
        UserRemark = userRemark;
    }

    public String getPostingDate() {
        return PostingDate;
    }

    public void setPostingDate(String postingDate) {
        PostingDate = postingDate;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
