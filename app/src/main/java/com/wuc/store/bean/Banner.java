package com.wuc.store.bean;

/**
 * @author: wuchao
 * @date: 2018/10/29 10:32
 * @desciption:
 */
public class Banner {

    /**
     * thumbnail : http://t4.market.mi-img.com/thumbnail/jpeg/l750/AppStore/0ff69546de24355c8a484aafc27222e230f41f76f
     * action : subject
     * id : 169136
     */

    private String thumbnail;
    private String action;
    private String id;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
