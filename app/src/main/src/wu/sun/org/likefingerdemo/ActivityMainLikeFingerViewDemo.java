package wu.sun.org.likefingerdemo;

import wu.sun.org.widget.LikeFingerView;
import wu.sun.org.widget.LikeFingerView.OnLikeChangedListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class ActivityMainLikeFingerViewDemo extends Activity {

	private LikeFingerView mLikeFingerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_like_finger_view_demo);
        
        mLikeFingerView = (LikeFingerView) findViewById(R.id.like_finger);
        mLikeFingerView.setOnLikeChangedListener(new OnLikeChangedListener() {
			
			@Override
			public void onChanged(boolean isLiked) {
				Toast.makeText(ActivityMainLikeFingerViewDemo.this, "isLiked=" + isLiked, Toast.LENGTH_SHORT).show();
			}
		});
    }
}
