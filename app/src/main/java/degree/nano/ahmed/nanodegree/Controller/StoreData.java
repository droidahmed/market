package degree.nano.ahmed.nanodegree.Controller;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sand on 17/01/17.
 */
public class StoreData {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String DATABASE_NAME = "nano.degree";


    public StoreData(Context context)
    {
        prefs = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }
    public void setUserId(String userId)
    {
        editor.putString("userId", userId);
        editor.commit();
    }

    public String getUserId()
    {
        return prefs.getString("userId","0");
    }


}
