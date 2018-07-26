package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class Hospital implements Parcelable {
    private int id;
    private String name;
    private String address;
    private String city;
    private String description;
    private String[] specifications;

    public Hospital(int id) {
        this.id = id;
    }

    protected Hospital(Parcel in) {
        id = in.readInt();
        name = in.readString();
        address = in.readString();
        city = in.readString();
        description = in.readString();
        specifications = in.createStringArray();
    }

    public static final Creator<Hospital> CREATOR = new Creator<Hospital>() {
        @Override
        public Hospital createFromParcel(Parcel in) {
            return new Hospital(in);
        }

        @Override
        public Hospital[] newArray(int size) {
            return new Hospital[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String[] specifications) {
        this.specifications = specifications;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(description);
        dest.writeStringArray(specifications);
    }
}
