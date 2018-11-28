package com.bean.soundsystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/27 17:10
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlankDisc implements CompactDisc {

    private String title ;
    private String artist;
    private List<String> tracks;   // 磁道列表

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
}
