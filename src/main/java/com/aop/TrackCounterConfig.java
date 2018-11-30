package com.aop;

import com.bean.soundsystem.BlankDisc;
import com.bean.soundsystem.CompactDisc;
import com.bean.soundsystem.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/30 10:32
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers(){
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper`s Lonely Hears Clud Band");
        cd.setArtist("The Beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt .");
        tracks.add("With a Little .");
        tracks.add("Lucy in the .");
        tracks.add("Getting Better .");
        tracks.add("Fixing a Hole .");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter(){
       return new TrackCounter();
    }














}
