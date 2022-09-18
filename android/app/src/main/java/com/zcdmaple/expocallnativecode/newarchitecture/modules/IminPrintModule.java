package com.zcdmaple.expocallnativecode.newarchitecture.modules;

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
    public void iminPrint(String type) {
        Log.d("iminPrint",type);
        mIminPrintUtils.printText(type);
        mIminPrintUtils.printAndFeedPaper(10);
        mIminPrintUtils.printText("--------------------------------------");

        mIminPrintUtils.printAndFeedPaper(100);
    }


    @ReactMethod
    public void iminPrintStatus(com.facebook.react.bridge.Callback callback) {

        Log.d("iminPrintStatus===","callback");
     int status = 0;
    //针对S1， //0：打印机正常 1：打印机未连接或未上电 3：打印头打开 7：纸尽  8：纸将尽  99：其它错误
      mIminPrintUtils.getPrinterStatus(IminPrintUtils.PrintConnectType.SPI, new Callback() {
            @Override
            public void callback(int status) {
                Log.d("XGH", " print SPI status:" + status +"  PrintUtils.getPrintStatus==  ");
                if (status == -1 && PrintUtils.getPrintStatus() == -1){
                    // Toast.makeText(TestPrintActivity.this, " " + status, Toast.LENGTH_SHORT).show();
                    status = PrintUtils.getPrintStatus();
                    callback.invoke(status);
                }else {

                    //Toast.makeText(TestPrintActivity.this, String.valueOf(status), Toast.LENGTH_SHORT).show();
                    status = PrintUtils.getPrintStatus();
                    callback.invoke(status);
                }

            }

        });

        Log.d("iminPrint====status",status+"");



    }
}
