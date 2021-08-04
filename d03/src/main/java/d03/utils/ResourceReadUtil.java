package d03.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j(topic = "d03.ResourceReadUtil")
public abstract class ResourceReadUtil {
    public static void read(String name) {
        try (InputStream in = ResourceReadUtil.class.getResourceAsStream(name)) {
            long start = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug("开始读取资源 - {}", name);
            }
            byte[] buf = new byte[256];
            int n;
            do {
                n = in.read(buf);
            } while (n != -1);
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled()) {
                log.debug("结束读取文件 - {} - 总计花费时间 - {}毫秒", name, end - start);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("读取文件异常", e);
        }
    }
}
