package com.carlosquispe.tiendageek1145;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class OficinasActivity extends YouTubeBaseActivity {
    String api_key = "AIzaSyDr54GXOLxDxdq7eKRwN2szwPoliKJPcYw";
    YouTubePlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leerVideo();
    }

    private void leerVideo() {
        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer);
        ytPlayer.initialize(api_key,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                        player = youTubePlayer;
                        mostrarVideo();
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    }
                });
    }

    private void mostrarVideo() {
        player.loadVideo("iN95xTqopeQ");
        player.play();
    }
}