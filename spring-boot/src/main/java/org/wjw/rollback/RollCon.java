package org.wjw.rollback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SWGawain on 2017/5/8.
 */
@RestController
@RequestMapping("/rollback")
public class RollCon {

    @Autowired
    Rollback rollback;

    @RequestMapping("/add")
    public String add(){
        rollback.add();
        return rollback.get()+"";
    }

    @RequestMapping("/errAdd")
    public String errAdd(){
        try {
            rollback.errAdd();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rollback.get()+"";
    }
}
