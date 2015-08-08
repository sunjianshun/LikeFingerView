package wu.sun.org.upviewdemo;

import wu.sun.org.widget.UpView;
import wu.sun.org.widget.UpView.OnLikeChangedListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class ActivityMainUpViewDemo extends Activity {

	private UpView mUpView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main_up_view_demo);
        
        mUpView = (UpView) findViewById(R.id.like_view);
        mUpView.setOnLikeChangedListener(new OnLikeChangedListener() {
			
			@Override
			public void onChanged(boolean isLiked) {
				Toast.makeText(ActivityMainUpViewDemo.this, "isLiked=" + isLiked, Toast.LENGTH_SHORT).show();
			}
		});
    }
}
