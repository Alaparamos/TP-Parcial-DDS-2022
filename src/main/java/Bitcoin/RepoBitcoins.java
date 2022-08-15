package Bitcoin;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class RepoBitcoins {

    private ArrayList<Bitcoin> bitcoins;
    private static RepoBitcoins instance = null;

    public static RepoBitcoins getInstance(){
        if(instance == null){
            instance = new RepoBitcoins();
        }
        return instance;
    }

    public ArrayList<Bitcoin> getBitcoins() { return bitcoins; }
    public void setBitcoins(ArrayList<Bitcoin> bitcoins) { this.bitcoins = bitcoins; }

    @Scheduled(cron = "0 0 0 * * ?")
    public void actualizarBitcoins() throws IOException {
        this.setBitcoins(
                (ArrayList<Bitcoin>) LlamarApi.getInstance().conseguirBitcoins()
        );
    }

}
