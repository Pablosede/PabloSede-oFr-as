package es.riberadeltajo.sharemybike;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class BikesContent {
    //List of all the bikes to be listed in the RecyclerView
    public static List<Bike> ITEMS = new ArrayList<Bike>();
    public static String selectedDate; //Store the selected date


    public static void loadBikesFromJSON(Context c) {

        String json = null;
        try {
            InputStream is =
                    c.getAssets().open("bikeList.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);
            JSONArray bikeList = jsonObject.getJSONArray("bike_list");

            for (int i = 0; i < bikeList.length(); i++) {
                JSONObject jsonBikes = bikeList.getJSONObject(i);
                String owner = jsonBikes.getString("owner");
                String description = jsonBikes.getString("description");
                String city=jsonBikes.getString("city");
                String location=jsonBikes.getString("location");
                String email=jsonBikes.getString("email");
                Bitmap photo=null;

                try {
                    photo= BitmapFactory.decodeStream(
                            c.getAssets().open("images/"+
                                    jsonBikes.getString("image")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ITEMS.add(new BikesContent.Bike(
                        photo,owner,description,city,location,email));
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

    }


    public static class Bike {
        private Bitmap photo;
        private String owner;
        private String description;
        private String city;
        private String location;
        private String email;
        //Setters and getters...
        public Bike(Bitmap photo, String owner, String description,
                    String city, String location, String email) {
            this.photo = photo;
            this.owner = owner;
            this.description = description;
            this.city = city;
            this.location = location;
            this.email= email;
        }
        @Override
        public String toString() {
            return owner+" "+description;
        }
    }
}
