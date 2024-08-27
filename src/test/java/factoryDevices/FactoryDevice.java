package factoryDevices;

public class FactoryDevice {

    public static IDevices make(String deviceType){
        IDevices device;
        switch (deviceType.toLowerCase()){
            case "android":
                device = new Android();
                break;
            default:
                device = new Android();
                break;
        }
        return device;
    }


}
