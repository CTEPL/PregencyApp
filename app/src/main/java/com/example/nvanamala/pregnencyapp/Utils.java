package com.example.nvanamala.pregnencyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Utils {

	/**
	 * Check whether the Internet connection is present or not. <uses-permission
	 * android:name="android.permission.ACCESS_NETWORK_STATE" />
	 */
	public static boolean checkInternetConnection(Activity _activity) {
		ConnectivityManager conMgr = (ConnectivityManager) _activity
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conMgr.getActiveNetworkInfo() != null
				&& conMgr.getActiveNetworkInfo().isAvailable()
				&& conMgr.getActiveNetworkInfo().isConnected())
			return true;
		else
			return false;
	}
	
	/**
	 * Send mail for the given mail address.
	 */
	public static void sendEMail(Activity _activity, String emailId, String subject, String body, Uri attachmentUri) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		if (subject != null)
			intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		if (body != null)
			intent.putExtra(Intent.EXTRA_TEXT, body);
		if (emailId != null)
			intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailId});
		if (attachmentUri != null)
			intent.putExtra(Intent.EXTRA_STREAM, attachmentUri);
		_activity.startActivity(Intent.createChooser(intent, "Send email via..."));
	}
	
	/**
     * Show an alert dialog and navigate back to previous screen if goBack is true
     * 
     * @param _activity - Instance of the activity
     * @param title - Title of the alert
     * @param alertMsg - Message of the alert
     * @param goBack - Flag to move back on destroy of alert
     */
    public static void showAlert(final Activity _activity,String title, String alertMsg,final boolean goBack){
        if(_activity == null || _activity.isFinishing())
            return;
        AlertDialog.Builder alert = new AlertDialog.Builder(_activity);
        alert.setTitle(title);
        alert.setCancelable(false);
        alert.setMessage(alertMsg);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(goBack)
                    _activity.finish();
            }
        });
        alert.show();
    }

    /**
     * Show an alert dialog and navigate back to previous screen if goBack is true
     *
     * @param _activity - Instance of the activity
     * @param title - Title of the alert
     * @param alertMsg - Message of the alert
     * @param goBack - Flag to move back on destroy of alert
     */
    public static void showAlert(final Activity _activity,String title, String alertMsg,final boolean goBack, DialogInterface.OnClickListener okClickListener){
        if(_activity == null || _activity.isFinishing())
            return;
        AlertDialog.Builder alert = new AlertDialog.Builder(_activity);
        alert.setTitle(title);
        alert.setCancelable(false);
        alert.setMessage(alertMsg);
        if(okClickListener != null){
            alert.setPositiveButton("Ok", okClickListener);

        }else{
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(goBack)
                        _activity.finish();
                }
            });
        }
        alert.show();
    }
    



    /**
     * Convert the response InputStream in to String response
     * @param is response-stream
     * @return xml string
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            is.close();
        } catch(OutOfMemoryError om){
            om.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * Convert the response InputStream in to String response
     * @param is response-stream
     * @return xml string
     */
    public static String convertInputStreamToString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            is.close();
        } catch(OutOfMemoryError om){
            om.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * Save string value from SharedPreference for the given key
     */
    public static void saveStringInSP(Context context,String key, String value){
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    
    /**
     * Save boolean value from SharedPreference for the given key
     */
    public static void saveBooleanInSP(Context context,String key, boolean value){
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    
    
    /**
     * Retrieve boolean value from SharedPreference for the given key
     */
    public static boolean getBooleanFromSP(Context context,String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    
    

    /**
     * Delete value from SharedPreference for the given key
     */
    public static void deleteFromSP(Context context,String key){
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * Retrieve string value from SharedPreference for the given key
     */
    public static String getStringFromSP(Context context,String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }
    
    public static void watchYoutubeVideo(Context context, String id){
		try{
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
			context.startActivity(intent);                 
		}catch (ActivityNotFoundException ex){
			Intent intent=new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://www.youtube.com/watch?v="+id));
			context.startActivity(intent);
		}
	}
    
    public static void showToast(String msg, Context ctx) {
		Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
	}

}
