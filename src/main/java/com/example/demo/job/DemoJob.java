package com.example.demo.job;

import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;

/**
 * @author zhbin
 * @date 2019-08-21
 */
public class DemoJob extends AbstractSaturnJavaJob {

    @Override
    public SaturnJobReturn handleJavaJob(final String jobName, final Integer shardItem, final String shardParam, final SaturnJobExecutionContext context) {
        // todo  xxx
        // 返回一个SaturnJobReturn对象，默认返回码是200表示正常的返回
        return new SaturnJobReturn("我是分片"+shardItem+"的处理结果");
    }
}
