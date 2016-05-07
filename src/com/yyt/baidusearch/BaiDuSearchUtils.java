package com.yyt.baidusearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.util.Log;

public class BaiDuSearchUtils {
	private String TAG = "BaiDuSearchUtils";
	private String encode = "utf-8";

	public URL SearchKey(String key) {
		URL u = null;
		try {
			key = URLEncoder.encode(key, encode);

			u = new URL("http://baike.baidu.com/item/" + key);
			URLConnection conn = u.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), encode));
			String str = reader.readLine();
			Log.d(TAG, "str1：" + str);
			while (str != null) {
				Log.d(TAG, "str2：" + str);
				str = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
}
