package com.bean.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 19:37
 * @Description:
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* com.bean.soundsystem.CompactDisc.playTrack(int ))"+
                "&& args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    public void countTrack(int trackNumber){
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber,currentCount+1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
