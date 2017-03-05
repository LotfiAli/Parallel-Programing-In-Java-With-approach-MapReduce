package utility;

/**
 * Created by alotfi on 2/28/2017.
 */
public class PcManager {

    public static int getCountCpu() {
        return Runtime.getRuntime().availableProcessors();
    }
}
