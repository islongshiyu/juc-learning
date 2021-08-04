package d03;

import d03.utils.ResourceReadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "d03.SynchronousReadFile")
public class SynchronousReadFile {
    public static void main(String[] args) {
        ResourceReadUtil.read(Constants.ULTRA_MAN_MP4_RES_PATH);

        if(log.isDebugEnabled()){
            log.debug("开始做其他事情...");
        }
    }
}
