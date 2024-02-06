package by.acd;

import by.acd.service.DataService;
import by.acd.service.TableService;
import by.acd.utils.Constants;
import by.acd.utils.PropertiesUtils;

public class App {

    public static void main(String[] args) {
        var table = DataService.read(PropertiesUtils.get(Constants.READ_FILE));
        TableService.sort(table);
        DataService.write(PropertiesUtils.get(Constants.WRITE_FILE), table);
    }

}
