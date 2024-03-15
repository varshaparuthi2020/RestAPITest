package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String  path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);
        int rownum = xl.getRowCount("Sheet1");
        int colCount = xl.getCellCount("Sheet1",1);
        String apidata[][] = new String[rownum][colCount];

        for(int i =1; i<= rownum; i++)
        {
            for(int j= 0;j<colCount ;j++)
            {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        return apidata;

    }


    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {

       String path =  System.getProperty("user.dir")+"//testdata//UserData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);
        int rownum = xl.getRowCount("Sheet1");
        String apidata[] = new String[rownum];
        for (int i =1 ;i<= rownum; i++){

            apidata[i-1]= xl.getCellData("Sheet1",i,1);

        }
        return apidata;
    }

    @DataProvider(name = "StoreData")
    public Object[][] getStoreData() throws IOException {
        String  path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";

        ExcelUtility xl = new ExcelUtility(path);
        int rowCount = xl.getRowCount("Sheet2");
        int colCount = xl.getCellCount("Sheet2",1);
       String storeData[][] = new String[rowCount][colCount];

       for (int i = 1; i<= rowCount ;i++){
           for( int j =0; j< colCount ;j++){
               storeData[i-1][j]= xl.getCellData("Sheet2",i,j);

           }
        }
        //System.out.println(storeData);
       return storeData;


    }


    @DataProvider(name ="OrderId")
    public String[] getId() throws IOException {

        String path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);
        int rownum = xl.getRowCount("Sheet2");
        String[] apiData = new String[rownum];
        for(int i=0;i<=rownum;i++){
            apiData[i]  = xl.getCellData("Sheet2",i,1);


        }
        return apiData;
    }




    @DataProvider(name="CreateStoreData")
    public Object[][] EndtoEndStoreUseCase
            (){
        return new Object[][]{

                {"11" ,"91","8","2023-12-30T12:32:29.277Z","placed","true"}
        };


    }


    @DataProvider(name="CreatePetData")
    public Object[][] createPetData() throws IOException {

       String path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
       ExcelUtility ex = new ExcelUtility(path);
       int rowCount =ex.getRowCount("Sheet3");
       int colCount = ex.getCellCount("Sheet3",1);
       String apidata[][] = new String[rowCount][colCount];
       for(int i =1;i<=rowCount;i++){
           for(int j =0;j<colCount;j++){
               apidata[i-1][j]= ex.getCellData("Sheet3",i,j);
           }
       }
       return apidata;
    }


    @DataProvider(name = "UpdatePetStoreData")
    public Object[][] updatePetData() throws IOException {

        String path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
      ExcelUtility xl = new ExcelUtility(path);
      int rowCount = xl.getRowCount("Sheet3");
      int colCount = xl.getCellCount("Sheet3",1);
      String apiData[][] = new String[rowCount][colCount];

        for(int i =1;i<=rowCount;i++){
            for(int j =0;j<colCount;j++){
                apiData[i-1][j]= xl.getCellData("Sheet3",i,j);
            }
        }
       return apiData;
    }
}

