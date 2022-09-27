package com.edimca.backedimca.models;

import java.util.List;

public class purchaseHeaderDetail{
    public purchaseHeader purchaseHeader;
    public List<purchaseDetail> purchaseDetail;
    public purchaseHeader getPurchaseHeader() {
        return purchaseHeader;
    }
    public List<purchaseDetail> getPurchaseDetail() {
        return purchaseDetail;
    }
    public void setPurchaseHeader(purchaseHeader purchaseHeader) {
        this.purchaseHeader = purchaseHeader;
    }
    public void setPurchaseDetail(List<purchaseDetail> purchaseDetail) {
        this.purchaseDetail = purchaseDetail;
    }
    public purchaseHeaderDetail() {
    }
    public purchaseHeaderDetail(com.edimca.backedimca.models.purchaseHeader purchaseHeader,
            List<com.edimca.backedimca.models.purchaseDetail> purchaseDetail) {
        this.purchaseHeader = purchaseHeader;
        this.purchaseDetail = purchaseDetail;
    }

}
