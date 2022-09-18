package com.uniweb.app.newarchitecture.modules;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.imin.printerlib.Callback;
import com.imin.printerlib.IminPrintUtils;
import com.imin.printerlib.print.PrintUtils;

public class IminPrintModule extends ReactContextBaseJavaModule {
    private IminPrintUtils mIminPrintUtils;

    public IminPrintModule(ReactApplicationContext context){
        super(context);
        if (mIminPrintUtils==null){
            mIminPrintUtils = IminPrintUtils.getInstance(context.getApplicationContext());
            mIminPrintUtils.initPrinter(IminPrintUtils.PrintConnectType.SPI);
        }
    }
    @NonNull
    @Override
    public String getName() {
        return "IminPrintModule";
    }

    @ReactMethod
    public void iminPrint(String acquireType, String storeName,
                          String dateString,String transactionId,String channelName,
                          String refNumber ,String total,
                          String signature,String endOne, String endTwo,String endThree,
                          String endFour ) {
        Log.d("iminPrint",acquireType);

//        String acquireType = "ALIPAY_INSTORE\n";
//        String storeName = "Sulwhasoo Westgate\n";
//        String dateString = "Data(日期): 03/08/2022 10:31:06\n";

//        String transactionId = "ffb9a16d9b154cd4a342fdf034d7ab04\n";
//        String channelName = "Channel(支付渠道): ALIPAY_INSTORE\n";
//        String refNumber = "Ref(参考号): 2022080222001464031406473286\n";
//        String tradeNumber = "TradeNum: 1653926400000\n";
//        String total = "TOTAL SGD(新币): 0.01\n";
//        String signature = "Signature(签名) :\n";

//        String endOne = "ACKNOWLEDGE SATISFACTORY\n";
//        String endTwo = "RECEIPT OF RELATIVE\n";
//        String endThree = "GOODS/SERVICES\n";
//        String endFour = "***CUSTOMER COPY***\n";

        String line = "================";



        mIminPrintUtils.printText(acquireType);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(storeName);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(dateString);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(transactionId);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(channelName);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(refNumber);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(total);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(signature);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(line);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(endOne);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(endTwo);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(endThree);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText(endFour);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printAndFeedPaper(50);
        mIminPrintUtils.printAndFeedPaper(100);




        mIminPrintUtils.printText("--------------------------------------");

        mIminPrintUtils.printAndFeedPaper(100);




    }


    @ReactMethod
    public void iminPrintStatus() {
     int status = 0;
    //针对S1， //0：打印机正常 1：打印机未连接或未上电 3：打印头打开 7：纸尽  8：纸将尽  99：其它错误
      mIminPrintUtils.getPrinterStatus(IminPrintUtils.PrintConnectType.SPI, new Callback() {
            @Override
            public void callback(int status) {
                Log.d("XGH", " print SPI status:" + status +"  PrintUtils.getPrintStatus==  "+ PrintUtils.getPrintStatus());
                if (status == -1 && PrintUtils.getPrintStatus() == -1){
                    // Toast.makeText(TestPrintActivity.this, " " + status, Toast.LENGTH_SHORT).show();
                    status = PrintUtils.getPrintStatus();
                }else {

                    //Toast.makeText(TestPrintActivity.this, String.valueOf(status), Toast.LENGTH_SHORT).show();
                    status = PrintUtils.getPrintStatus();
                }

            }

        });

        Log.d("iminPrint====status",status+"");

    }
}
