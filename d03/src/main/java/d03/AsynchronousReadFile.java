package d03;

import d03.utils.ResourceReadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d03.AsynchronousReadFile")
public class AsynchronousReadFile {
    public static void main(String[] args) {
        new Thread(() -> ResourceReadUtil.read(Constants.ULTRA_MAN_MP4_RES_PATH)).start();

        if (log.isDebugEnabled()) {
            log.debug("开始做其他事情...");
        }
    }
}
