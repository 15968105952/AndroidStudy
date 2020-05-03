package com.lahm.learndaemon.entity;

import java.io.Serializable;

/**
 * Copyright (C), 2018-2018
 * FileName:
 * Author:       肖冲
 * Date:         2019/2/18 17:00
 * Description:  ${DESCRIPTION}
 */
public class ImpressTagEntity implements Serializable {
    /**
     * id : 1
     * enName : Charming
     * color : #2CC4EA
     */

    private long id;
    private String enName;
    private String color;
    private boolean isSelector = true;//标志是否选中此标签

    public boolean isSelector() {
        return isSelector;
    }

    public void setSelector(boolean selector) {
        isSelector = selector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}