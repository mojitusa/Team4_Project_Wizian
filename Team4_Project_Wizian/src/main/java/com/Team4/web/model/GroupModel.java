package com.Team4.web.model;

public class GroupModel {
    private String PRGRM_NM;
    private String SCHDL_BGNG_YMD;
    private String SCHDL_END_YMD;
    private String GC_DT;
    private int NOPE;
    private String PRGRM_TYPE;
    private String GC_OG_NM;
    private String counselingContent;
    private String posterContent;

    public GroupModel() {
    }

    public GroupModel(String PRGRM_NM, String SCHDL_BGNG_YMD, String SCHDL_END_YMD, String GC_DT, int NOPE, String PRGRM_TYPE, String GC_OG_NM, String counselingContent, String posterContent) {
        this.PRGRM_NM = PRGRM_NM;
        this.SCHDL_BGNG_YMD = SCHDL_BGNG_YMD;
        this.SCHDL_END_YMD = SCHDL_END_YMD;
        this.GC_DT = GC_DT;
        this.NOPE = NOPE;
        this.PRGRM_TYPE = PRGRM_TYPE;
        this.GC_OG_NM = GC_OG_NM;
        this.counselingContent = counselingContent;
        this.posterContent = posterContent;
    }

    public String getPRGRM_NM() {
        return PRGRM_NM;
    }

    public void setPRGRM_NM(String PRGRM_NM) {
        this.PRGRM_NM = PRGRM_NM;
    }

    public String getSCHDL_BGNG_YMD() {
        return SCHDL_BGNG_YMD;
    }

    public void setSCHDL_BGNG_YMD(String SCHDL_BGNG_YMD) {
        this.SCHDL_BGNG_YMD = SCHDL_BGNG_YMD;
    }

    public String getSCHDL_END_YMD() {
        return SCHDL_END_YMD;
    }

    public void setSCHDL_END_YMD(String SCHDL_END_YMD) {
        this.SCHDL_END_YMD = SCHDL_END_YMD;
    }

    public String getGC_DT() {
        return GC_DT;
    }

    public void setGC_DT(String GC_DT) {
        this.GC_DT = GC_DT;
    }

    public int getNOPE() {
        return NOPE;
    }

    public void setNOPE(int NOPE) {
        this.NOPE = NOPE;
    }

    public String getPRGRM_TYPE() {
        return PRGRM_TYPE;
    }

    public void setPRGRM_TYPE(String PRGRM_TYPE) {
        this.PRGRM_TYPE = PRGRM_TYPE;
    }

    public String getGC_OG_NM() {
        return GC_OG_NM;
    }

    public void setGC_OG_NM(String GC_OG_NM) {
        this.GC_OG_NM = GC_OG_NM;
    }

    public String getCounselingContent() {
        return counselingContent;
    }

    public void setCounselingContent(String counselingContent) {
        this.counselingContent = counselingContent;
    }

	public String getPosterContent() {
		return posterContent;
	}

	public void setPosterContent(String posterContent) {
		this.posterContent = posterContent;
	}
}
