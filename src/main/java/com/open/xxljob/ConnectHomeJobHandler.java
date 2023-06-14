package com.open.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: liwang
 * Date:     2023/6/13 15:05
 * desc
 */
@JobHandler(value = "x'x'x'x")
@Service
@Slf4j
public class ConnectHomeJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        return null;
    }
}
