   package com.jether.wirentiuserapp.helper;

public class Constants {



    public static final class DATABASE{
        public static final String DB_NAME="properties";
        public static final int DB_VERSION=1;

        public static final String TABLE_NAME="property";



        public static final String DROP_QUERY="DROP TABLE IF EXIST" + TABLE_NAME;

        public static final String GET_PROPERTY_QUERY="SELECT * FROM" + TABLE_NAME;


        public static final String PROPERTY_ID="ID";
        public static final String USER_ID="UserID";
        public static final String PROPERTY_TITLE="PropertyTitle";
        public static final String PROPERTY_TYPE="Type";
        public static final String PROPERTY_DESC="PropertDescription";
        public static final String PROPERTY_STATUS="Status";
        public static final String PROPERTY_LOCATION="Location";
        public static final String PROPERTY_IMAGE="FeaturedImage";
        public static final String PROPERTY_ADDRESS="Address";
        public static final String PROPERTY_PRICE="RentorsalePrice";
        public static final String PROPERTY_BED="Bedroom";
        public static final String PROPERTY_BATH="Bathrooms";
        public static final String PROPERTY_FLOORS="Floors";
        public static final String PROPERTY_GARAGE="Garages";
        public static final String PROPERTY_AREA="Area";
        public static final String PROPERTY_SIZE="Size";
        public static final String PROPERTY_UNIQUE_ID="PropertyID";
        public static final String PROPERTY_COUNTRY="Country";
        public static final String PROPERTY_CITY="City";
        public static final String PROPERTY_STATE="State";
        public static final String PROPERTY_ZIP="ZipCode";
        public static final String PROPERTY_DATE="ListingDate";



        public static final String CREATE_TABLE_QUERY="CREATE TABLE" +TABLE_NAME +""+
                "("+PROPERTY_ID+ " INTEGER PRIMARY KEY not null ," +
                USER_ID +"TEXT not null," +
                PROPERTY_TITLE+ "TEXT not null," +
                PROPERTY_DESC+"TEXT not null," +
                PROPERTY_TYPE +"TEXT not null," +
                PROPERTY_STATUS+" TEXT not null," +
                PROPERTY_LOCATION+ "TEXT not null," +
                PROPERTY_IMAGE+" blob not null," +
                PROPERTY_ADDRESS +"TEXT not null," +
                PROPERTY_PRICE+ "TEXT not null," +
                PROPERTY_BED +"TEXT not null," +
                PROPERTY_BATH+ "TEXT not null," +
                PROPERTY_FLOORS +"TEXT not null," +
                PROPERTY_GARAGE +"TEXT not null," +
                PROPERTY_AREA +"TEXT not null," +
                PROPERTY_SIZE+ "TEXT not null," +
                PROPERTY_UNIQUE_ID+" TEXT not null," +
                PROPERTY_COUNTRY+ "TEXT not null," +
                PROPERTY_CITY +"TEXT not null," +
                PROPERTY_STATE +"TEXT not null," +
                PROPERTY_ZIP+ "TEXT not null," +
                PROPERTY_DATE +"TEXT not null)" ;
           }


}
