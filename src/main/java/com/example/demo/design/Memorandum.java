package com.example.demo.design;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Memorandum 备忘录模式
 *
 * @author zhbin
 * @date 2020-06-03
 */
@Data
public class Memorandum {
    private String memo;

    //保存备忘
    public memoran save(String memo){
        return new memoran(memo);
    }

    //取回备忘
    public void restore(memoran memoran){
        this.memo = memoran.memo;
    }

    @Getter
    public static class memoran{
        private final String memo;

        memoran(String memo) {
            this.memo = memo;
        }
    }
}
