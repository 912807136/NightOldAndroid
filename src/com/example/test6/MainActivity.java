package com.example.test6;

import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				final View textView1 = findViewById(R.id.textView1);
				ValueAnimator animator = ValueAnimator.ofInt(0, textView1.getHeight());
				animator.addUpdateListener(new AnimatorUpdateListener() {

					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						int height = (Integer) animation.getAnimatedValue();
						LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
								height);
						textView1.setLayoutParams(params);
					}
				});
				animator.setDuration(1000);
				animator.start();
			}
		}, 100);

		ListView listView = (ListView) findViewById(R.id.listView1);
		String[] strs = { "text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9", "text10",
				"text11", };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,
				strs);
		listView.setAdapter(adapter);
	}

}
