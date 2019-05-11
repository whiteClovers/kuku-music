package com.xq.serviceadmin.entity.comment;




public class VipRights {

    private Associator associator;
    private String musicPackage;
    private int redVipAnnualCount;

    public Associator getAssociator() {
        return associator;
    }

    public void setAssociator(Associator associator) {
        this.associator = associator;
    }

    public String getMusicPackage() {
        return musicPackage;
    }

    public void setMusicPackage(String musicPackage) {
        this.musicPackage = musicPackage;
    }

    public int getRedVipAnnualCount() {
        return redVipAnnualCount;
    }

    public void setRedVipAnnualCount(int redVipAnnualCount) {
        this.redVipAnnualCount = redVipAnnualCount;
    }
}