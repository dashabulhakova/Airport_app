import org.apache.log4j.Logger;
import services.BagService;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        BagService bagService = new BagService();
        //bagService.getBagFromXML("src/main/resources/xsd/bags.xsd", "src/main/resources/xml/bags.xml");

        bagService.parseDOM("src/main/resources/xsd/insurances.xsd", "src/main/resources/xml/insurances.xml");


    }
}