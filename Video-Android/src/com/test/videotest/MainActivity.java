package com.test.videotest;

import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Thumbnails;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    VideoView videoView = (VideoView)findViewById(R.id.your_video_view);
	    MediaController mc = new MediaController(this);
	    mc.setAnchorView(videoView);
	    videoView.setMediaController(mc);
	    
        String str = "http://www.med.uio.no/imb/english/research/groups/neural-development/videos/boulland-2011-celltrans/video-1.mp4";
	    Uri uri = Uri.parse(str);
	    
	    videoView.setVideoURI(uri);
	    videoView.setZOrderOnTop(true);
	    videoView.requestFocus();
	    videoView.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
