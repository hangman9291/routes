package com.andy.routes.model;

public class Location
{
    //region Constant Variables
    private static final String className = "Location";
    //endregion

    //region Variables
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    //endregion

    //region Constructor
    public Location() {}

    public Location(String name, String streetAddress, String city, String state, String zipCode)
    {
        this.name          = name;
        this.streetAddress = streetAddress;
        this.city          = city;
        this.state         = state;
        this.zipCode       = zipCode;
    }
    //endregion

    //region Getters
    public String getName()
    {
        return name;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getZipCode()
    {
        return zipCode;
    }
    //endregion

    //region Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    //endregion

    @Override
    public String toString()
    {
        return streetAddress + " " + city + ", " + state + " " + zipCode;
    }
}
