package com.jether.wirentiuserapp.Model;

public class ModelInquiryAnswer {

    public ModelInquiryAnswer() {
    }

    String ID,PropertyID,EnquiryNumber,Remark,RemarkDate;

    public ModelInquiryAnswer(String ID, String propertyID, String enquiryNumber, String remark, String remarkDate) {
        this.ID = ID;
        PropertyID = propertyID;
        EnquiryNumber = enquiryNumber;
        Remark = remark;
        RemarkDate = remarkDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(String propertyID) {
        PropertyID = propertyID;
    }

    public String getEnquiryNumber() {
        return EnquiryNumber;
    }

    public void setEnquiryNumber(String enquiryNumber) {
        EnquiryNumber = enquiryNumber;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getRemarkDate() {
        return RemarkDate;
    }

    public void setRemarkDate(String remarkDate) {
        RemarkDate = remarkDate;
    }
}
