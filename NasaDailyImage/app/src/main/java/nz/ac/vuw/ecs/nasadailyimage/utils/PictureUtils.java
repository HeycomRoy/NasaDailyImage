package nz.ac.vuw.ecs.nasadailyimage.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.ScriptGroup;
import android.text.StaticLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yiming on 11/08/16.
 */
public class PictureUtils {
    public static Bitmap getBitmapFromURL(String src) {
        //##Missing##
        // Add implementation for this function to obtain a bitmap from the given image url.
        // Hints:

        try {
            // 1. Define URL
            URL theURL = new URL(src);
            // 2. Make HttpURLConnection
            try {
                HttpURLConnection huc = (HttpURLConnection) theURL.openConnection();
                // 3. set connection and InputStream
                InputStream inputStream = huc.getInputStream();
                // 4. Use BitmapFactory.decodeStream to get the bitmap, then return.
                return BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
