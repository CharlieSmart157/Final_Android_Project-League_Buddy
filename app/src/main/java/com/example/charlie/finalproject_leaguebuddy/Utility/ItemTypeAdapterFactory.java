package com.example.charlie.finalproject_leaguebuddy.Utility;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 01/07/2016.
 */
public class ItemTypeAdapterFactory implements TypeAdapterFactory {

    String name;

    public ItemTypeAdapterFactory(String name) {
        this.name = name;
    }

    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> type) {

        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {

            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }
            @Override
            public T read(JsonReader in) throws IOException {

                List<T>list  = new ArrayList<T>();
                JsonElement jsonElement = elementAdapter.read(in);
                JsonArray jsonArray = new JsonArray();
                if (jsonElement.isJsonObject()) {
                    Log.d("OBJ_CHECK","TRUE");
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has(name) && jsonObject.get(name).isJsonObject())
                    {
                        jsonElement = jsonObject.get(name);

                        Log.d("JSON_ASSIGN", "OBJECT");
                    }
                    else
                    if(jsonObject.has(name)&& jsonObject.get(name).isJsonArray())
                    {
                        jsonElement = jsonObject.get(name).getAsJsonArray().get(0);
                      //  list.add(jsonElement.getAsJsonArray());
                        Log.d("JSON_ASSIGN", "LIST:"+jsonElement);


                    }
                }

                Log.d("Debugerino", delegate.fromJsonTree(jsonElement)+"" );
                return delegate.fromJsonTree(jsonElement);
            }
        }.nullSafe();
    }
}