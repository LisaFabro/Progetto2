public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Warehouse.listaArticoli();
        Warehouse.searchDeviceBrand("HP");
        Warehouse.searchDeviceType(TypesDevice.NOTEBOOK);
    }
}