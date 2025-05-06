package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csvdataset {
    @Deprecated
    @DataProvider(name = "itemdataset")
    public Object[][] getCsvData() throws IOException {
        String filepath = "./src/test/resources/item.csv";
        List<Object[]> data = new ArrayList<>();

        try (CSVParser csvParser = new CSVParser(new FileReader(filepath), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord csvRecord : csvParser) {
                String itemname = csvRecord.get("itemname");
                String amount = csvRecord.get("amount");
                String purchasedate = csvRecord.get("purchasedate");
                String months = csvRecord.get("month");
                String remarks = csvRecord.get("remark");

                data.add(new Object[]{itemname, amount, purchasedate, months, remarks});
            }
        }

        return data.toArray(new Object[0][]);
    }

}
