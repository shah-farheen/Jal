package in.ac.iiitd.jal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by farheen on 7/23/17
 */

public class DataModel implements Parcelable{
    private String typeOfRequest;

    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String govtOrganization;

    private String email;
    private String mobile;
    private String homeNumber;
    private String officeNumber;

    private String employeeId;
    private String retirementYear;
    private String officeAddress;

    private String pinCode;
    private String locality;
    private String subLocality;
    private String houseNo;
    private String village;
    private String khasraNo;
    private String societyName;
    private boolean jjrColony;

    private String propertyType;
    private String areaType;
    private String floorCount;
    private String plotArea;
    private String builtUpArea;
    private String connectionType;

    private String zroLocation;
    private String modeOfPayment;
    private String childCount;
    private String adultCount;

    private String proofOfIdentity;
    private String proofOfProperty;
    private String proofOfResidence;

    private String bankName;
    private String bankBranch;
    private String ifscCode;
    private String bankAccountNo;

    public DataModel() {

    }

    protected DataModel(Parcel in) {
        typeOfRequest = in.readString();
        firstName = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        fatherName = in.readString();
        govtOrganization = in.readString();
        email = in.readString();
        mobile = in.readString();
        homeNumber = in.readString();
        officeNumber = in.readString();
        employeeId = in.readString();
        retirementYear = in.readString();
        officeAddress = in.readString();
        pinCode = in.readString();
        locality = in.readString();
        subLocality = in.readString();
        houseNo = in.readString();
        village = in.readString();
        khasraNo = in.readString();
        societyName = in.readString();
        jjrColony = in.readByte() != 0;
        propertyType = in.readString();
        areaType = in.readString();
        floorCount = in.readString();
        plotArea = in.readString();
        builtUpArea = in.readString();
        connectionType = in.readString();
        zroLocation = in.readString();
        modeOfPayment = in.readString();
        childCount = in.readString();
        adultCount = in.readString();
        proofOfIdentity = in.readString();
        proofOfProperty = in.readString();
        proofOfResidence = in.readString();
        bankName = in.readString();
        bankBranch = in.readString();
        ifscCode = in.readString();
        bankAccountNo = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGovtOrganization() {
        return govtOrganization;
    }

    public void setGovtOrganization(String govtOrganization) {
        this.govtOrganization = govtOrganization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRetirementYear() {
        return retirementYear;
    }

    public void setRetirementYear(String retirementYear) {
        this.retirementYear = retirementYear;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getSubLocality() {
        return subLocality;
    }

    public void setSubLocality(String subLocality) {
        this.subLocality = subLocality;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getKhasraNo() {
        return khasraNo;
    }

    public void setKhasraNo(String khasraNo) {
        this.khasraNo = khasraNo;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public boolean isJjrColony() {
        return jjrColony;
    }

    public void setJjrColony(boolean jjrColony) {
        this.jjrColony = jjrColony;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(String floorCount) {
        this.floorCount = floorCount;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(String builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getZroLocation() {
        return zroLocation;
    }

    public void setZroLocation(String zroLocation) {
        this.zroLocation = zroLocation;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getChildCount() {
        return childCount;
    }

    public void setChildCount(String childCount) {
        this.childCount = childCount;
    }

    public String getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(String adultCount) {
        this.adultCount = adultCount;
    }

    public String getProofOfIdentity() {
        return proofOfIdentity;
    }

    public void setProofOfIdentity(String proofOfIdentity) {
        this.proofOfIdentity = proofOfIdentity;
    }

    public String getProofOfProperty() {
        return proofOfProperty;
    }

    public void setProofOfProperty(String proofOfProperty) {
        this.proofOfProperty = proofOfProperty;
    }

    public String getProofOfResidence() {
        return proofOfResidence;
    }

    public void setProofOfResidence(String proofOfResidence) {
        this.proofOfResidence = proofOfResidence;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(typeOfRequest);
        parcel.writeString(firstName);
        parcel.writeString(middleName);
        parcel.writeString(lastName);
        parcel.writeString(fatherName);
        parcel.writeString(govtOrganization);
        parcel.writeString(email);
        parcel.writeString(mobile);
        parcel.writeString(homeNumber);
        parcel.writeString(officeNumber);
        parcel.writeString(employeeId);
        parcel.writeString(retirementYear);
        parcel.writeString(officeAddress);
        parcel.writeString(pinCode);
        parcel.writeString(locality);
        parcel.writeString(subLocality);
        parcel.writeString(houseNo);
        parcel.writeString(village);
        parcel.writeString(khasraNo);
        parcel.writeString(societyName);
        parcel.writeByte((byte) (jjrColony ? 1 : 0));
        parcel.writeString(propertyType);
        parcel.writeString(areaType);
        parcel.writeString(floorCount);
        parcel.writeString(plotArea);
        parcel.writeString(builtUpArea);
        parcel.writeString(connectionType);
        parcel.writeString(zroLocation);
        parcel.writeString(modeOfPayment);
        parcel.writeString(childCount);
        parcel.writeString(adultCount);
        parcel.writeString(proofOfIdentity);
        parcel.writeString(proofOfProperty);
        parcel.writeString(proofOfResidence);
        parcel.writeString(bankName);
        parcel.writeString(bankBranch);
        parcel.writeString(ifscCode);
        parcel.writeString(bankAccountNo);
    }
}
