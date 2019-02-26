package com.bean.soundsystem;


import java.util.List;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 17:10
 * @Description:
 */
public class BlankDisc implements CompactDisc {

    private String title ;
    private String artist;
    private List<String> tracks;   // 磁道列表

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    // public  BlankDisc(String title, String artist, List<String> tracks){
    //     this.title = title;
    //     this.artist = artist;
    //     this.tracks = tracks;
    // }
    @Override
    public void play() {
        System.out.println("Playing " + title + " by "+ artist);
        for (String track: tracks ) {
            System.out.println( "-Track " + track);
        }
    }

    @Override
    public void playTrack(int n) {

    }
}
