package org.wjw.rollback;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SWGawain on 2017/5/8.
 */
@Component
public class Rollback {

    public Rollback(){
    }

    public Rollback(int count) {
        this.count = count;
    }

    private int count = 0 ;


    public final void add(){
        count ++ ;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void errAdd(){
        count ++ ;
        throw new RuntimeException();
    }

    public int get(){
        return count ;
    }
}
