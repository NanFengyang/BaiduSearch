package com.yyt.baidusearch;

import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BaiduActivity extends Activity implements OnClickListener {
	private WebView webview;
	private Button btn_search;
	private TextView tv_show;
	private EditText ed_input;
	private BaiDuSearchUtils mBaiDuSearchUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baidu);
		init();
	}

	private void init() {
		webview = (WebView) findViewById(R.id.webview);
		btn_search = (Button) findViewById(R.id.search);
		tv_show = (TextView) findViewById(R.id.show);
		ed_input = (EditText) findViewById(R.id.input);
		btn_search.setOnClickListener(this);
		mBaiDuSearchUtils = new BaiDuSearchUtils();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String text = ed_input.getText().toString();
		if (!TextUtils.isEmpty(text)) {
			URL url = mBaiDuSearchUtils.SearchKey(text);
			webview.loadUrl(url.toString());
			tv_show.setText(url.toString());
		}
	}

}
