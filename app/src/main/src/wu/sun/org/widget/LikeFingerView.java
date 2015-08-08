package wu.sun.org.widget;

import wu.sun.org.likefingerdemo.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jianshunsun on 15-8-8.
 */
public class LikeFingerView extends RelativeLayout implements View.OnClickListener {

	private ImageView mImageView;
	private TextView mTextView;
	private boolean mIsLiked = false;
	private int mNumber = 0;
	private OnLikeChangedListener mListener;
	
	public interface OnLikeChangedListener {
		void onChanged(boolean isLiked);
	}
	
    public LikeFingerView(Context context) {
        this(context, null, 0);
    }

    public LikeFingerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LikeFingerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.widget_like_finger_view, this);
        initViews();
    }
    
    private void initViews() {
    	mImageView = (ImageView) findViewById(R.id.image_view);
    	mTextView = (TextView) findViewById(R.id.number);
    	mImageView.setSelected(mIsLiked);
    	mTextView.setText(mNumber + "");
    	this.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View view) {
    	mIsLiked = !mIsLiked;
		mImageView.setSelected(mIsLiked);
		if (mIsLiked) {
			mNumber++;
			Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.like_finger_up);  
	        mImageView.startAnimation(anim); 
		} else {
			mNumber--;
			Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.like_finger_down);  
	        mImageView.startAnimation(anim); 
		}
		mTextView.setText(mNumber + "");
		if (mListener != null) {
			mListener.onChanged(mIsLiked);
		}
	}
    
    public void setOnLikeChangedListener(OnLikeChangedListener listener) {
    	mListener = listener;
    }
}
