package com.brown.quickpollapi.dto;

public class OptionCount{

private Long optionId;
private int count;

    public Long getOptionId() {
        return optionId;
    }

    public int getCount() {
        return count;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
