package in.gov.rajasthan.bhamashah.bhamashah.home;

import android.support.annotation.DrawableRes;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class ServiceHolder {
    @DrawableRes
    private int imageId;
    private String serviceTitle;

    public ServiceHolder(String serviceTitle, int imageId) {
        this.imageId = imageId;
        this.serviceTitle = serviceTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }
}
