package liophan.fensterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.malmstein.fenster.controller.FensterPlayerControllerVisibilityListener;
import com.malmstein.fenster.controller.SimpleMediaFensterPlayerController;
import com.malmstein.fenster.view.FensterVideoView;

public class MainActivity extends AppCompatActivity {

    private FensterVideoView mFensterVideoView;
    private SimpleMediaFensterPlayerController mMediaFensterPlayerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFensterVideoView = (FensterVideoView) findViewById(R.id.play_video_texture);
        mMediaFensterPlayerController = (SimpleMediaFensterPlayerController) findViewById(R.id.play_video_controller);

        mFensterVideoView.setMediaController(mMediaFensterPlayerController);
        mFensterVideoView.setOnPlayStateListener(mMediaFensterPlayerController);

//        mFensterVideoView.setVideo("https://stacck.s3.amazonaws.com/uploads/uploads/000/009/990/original/open-uri20170215-19627-sm18cb?1487147744");
        mFensterVideoView.setVideo("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        mFensterVideoView.start();

        mMediaFensterPlayerController.setVisibilityListener(new FensterPlayerControllerVisibilityListener() {
            @Override
            public void onControlsVisibilityChange(boolean value) {
                Log.e("LIO", "onControlsVisibilityChange " + value);
            }
        });

        mFensterVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaFensterPlayerController.isShowing()) {
                    mMediaFensterPlayerController.show();
                } else {
                    mMediaFensterPlayerController.hide();
                }
            }
        });
    }
}
